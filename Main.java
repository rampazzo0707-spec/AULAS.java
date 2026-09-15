import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<Tarefa> tarefa = new ArrayList<Tarefa>();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Cadastrar Tarefa");
            System.out.println("4. Listar Tarefas");
            System.out.println("5. Concluir Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("-----Cadastro de Usuário-----");
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do usuário: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String email = scanner.nextLine();
                    cadastrarUsuario(usuarios, nome, cpf, email);

                    System.out.println("Usuário cadastrado com sucesso!");

                    break;

                case 2:
                    System.out.println("-----Lista de Usuários-----");
                    listarUsuarios(usuarios);

                    break;

                case 3:
                    System.out.println("-----Cadastro de Tarefa-----");
                    System.out.println("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o nome do responsável pela tarefa: ");
                    String nomeResponsavel = scanner.nextLine();
                    Usuario responsavel = buscarUsuario(usuarios, nomeResponsavel);
                    System.out.println("Responsável encontrado: " + responsavel.getNome());
                    cadastrarTarefa(tarefa, titulo, descricao, responsavel);
                    System.out.println("Tarefa cadastrada com sucesso!"); 

                    break;

                case 4:
                    System.out.println("-----Lista de Tarefas-----");
                    listarTarefas(tarefa);

                    break;

                case 5:

                    break;

                case 0:
                    System.out.println("Saindo do programa...");

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    // Metodos para Usuário

    public static void cadastrarUsuario(ArrayList<Usuario> usuarios, String nome, String cpf, String email) {
        usuarios.add(new Usuario(nome, cpf, email));
    }

    public static void listarUsuarios(ArrayList<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        System.out.println("-----Lista de Usuários-----");
        for (Usuario u : usuarios) {
            u.apresentarUsuario();

        }
    }

    public static void removerUsuario(ArrayList<Usuario> usuarios, int posicao) {
        usuarios.remove(posicao);
    }

    public static Usuario buscarUsuario(ArrayList<Usuario> usuarios, String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return u;
            }
        }
        return null;
    }

    public static void atualizarUsuario(ArrayList<Usuario> lista, int posicao, String novoNome, String novoCPF,
            String novoEmail) {
        Usuario usuario = lista.get(posicao);
        usuario.setNome(novoNome);
        usuario.setCPF(novoCPF);
        usuario.setEmail(novoEmail);
    }

    // Metodos para Tarefa
    public static void cadastrarTarefa(ArrayList<Tarefa> tarefas, String titulo, String descricao,
            Usuario responsavel) {
        tarefas.add(new Tarefa(titulo, descricao, responsavel));
    }

    public static void listarTarefas(ArrayList<Tarefa> tarefas) {
        for (Tarefa t : tarefas) {
            t.apresentarTarefa();
            System.out.println("---------------------");
        }
    }

}
