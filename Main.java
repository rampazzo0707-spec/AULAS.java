import java.util.ArrayList;
import java.util.InputMismatchException;
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
            System.out.println("6. Remover Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            }catch(InputMismatchException e ){
                System.out.println("Digite apenas numeros inteiros");
                
                scanner.nextLine();
                opcao = -1;

            }
            

            switch (opcao) {
                case 1:
                        System.out.println("-----Cadastro de Usuário-----");
                        System.out.print("Digite o nome do usuário: ");
                        String nome = scanner.nextLine();
                        if(usuarioExistente(usuarios,nome)){
                        System.out.println("Erro ao cadastrar usuario: usuario ja cadastrado");
                        break;
                        }

                        boolean usuarioCriadocomSucesso = false;
                        while(!usuarioCriadocomSucesso){
                            try{
                                System.out.print("Digite o CPF do usuário: ");
                                String cpf = scanner.nextLine();


                                 Usuario.validarFormatoCPF(cpf); 



                                if(usuarioExistenteCpf(usuarios,cpf)){
                                    System.out.println("Erro ao cadastrar usuario: CPF ja cadastrado");
                                    System.out.println("Tente novamente.");
                                    continue;
                                    
                                }
                                 

                                System.out.print("Digite o email do usuário: ");
                                String email = scanner.nextLine();


                                cadastrarUsuario(usuarios, nome, cpf, email);
                                usuarioCriadocomSucesso = true;
                                System.out.println("Usuário cadastrado com sucesso!");}
                            
                            
                                catch (IllegalArgumentException e) {
                                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                                System.out.println("Tente novamente.");
                            }
                        }
                        
                        
                    
                  
                    break;

                case 2:
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("-----Lista de Usuários-----");
                        listarUsuarios(usuarios);
                    }

                    break;

                case 3:
                    if(usuarios.isEmpty()){
                        System.out.println("Nenhum usuário cadastrado. Cadastre um usuário antes de criar uma tarefa.");
                        break;
                        
                    }
                        
                        System.out.println("-----Cadastro de Tarefa-----");
                        System.out.print("Digite o título da tarefa: ");
                        String titulo = scanner.nextLine();
                        
                        
                        if(tarefaExistente(tarefa, titulo)){
                        System.out.println("Tarefa ja cadastrada");
                        break;
                    }



                        System.out.print("Digite a descrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Digite o nome do responsável pela tarefa: ");
                        Usuario responsavel = null;
                        boolean usuarioEncontrado = false;
                        while(!usuarioEncontrado){
                            String nomeResponsavel = scanner.nextLine();
                            responsavel = buscarUsuario(usuarios, nomeResponsavel);
                            if(responsavel != null){
                                usuarioEncontrado = true;
                        }
                        else{
                            System.out.println("Usuário não encontrado. Deseja tentar novamente? ");
                            System.out.println("1.Tentar novamente");
                            System.out.println("2.Cancelar cadastro de tarefa");
                            int opcaoErro = scanner.nextInt();
                            scanner.nextLine();

                            if(opcaoErro == 2){
                                System.out.println("Cadastro de tarefa cancelado.");
                                break;
                            }
                           else{
                                System.out.println("Digite o nome do responsável pela tarefa: ");
                            }
                           
                            
                        }
                       
                    }
                    if(responsavel != null){
                        cadastrarTarefa(tarefa, titulo, descricao, responsavel);
                        System.out.println("Tarefa cadastrada com sucesso!");
                    }

                    break;

                case 4:
                    
                    if(tarefa.isEmpty()){
                        System.out.println("Nenhuma tarefa encontrada.");
                        break;
                    }
                    else{
                        System.out.println("-----Lista de Tarefas-----");
                        listarTarefas(tarefa);
                    }
                    

                    break;

                case 5:
                    System.out.println("-----Concluir Tarefa-----");
                    if(tarefa.isEmpty()){
                        System.out.println("Tarefa nao pode ser encontrada.");
                
                    }   
                    
                        System.out.println("Digite o título da tarefa que deseja concluir: ");
                        String tituloTarefa = scanner.nextLine();
                        boolean sucesso = concluirTarefa(tarefa, tituloTarefa);
                        if(sucesso){
                            System.out.println("Tarefa concluída com sucesso!");
                        }else{
                            System.out.println("Tarfa nao pode ser concluida");
                        }
                
                    
                    


                    break;

                    case 6:
                    System.out.println("-----Remover Usuário-----");
                    if(usuarios.isEmpty()){
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    }
                    System.out.print("Digite o nome do usuário que deseja remover: ");
                    String nomeUsuarioRemover = scanner.nextLine();

                    boolean removido = removerUsuarioporNome(usuarios, nomeUsuarioRemover);
                    if (removido) {
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    System.out.println("Ate logo! :)");

                    break;

                
            }
        }

        scanner.close();
    }

    // -----------------------------------------------------Metodos para Usuário---------------------------------------------------------------------

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


    public static Usuario buscarUsuario(ArrayList<Usuario> usuarios, String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().trim().equalsIgnoreCase(nome.trim())) {
                return u;
            }
        }
        return null;
    }

    public static void atualizarUsuario(ArrayList<Usuario> lista, int posicao, String novoNome,
            String novoEmail) {
        Usuario usuario = lista.get(posicao);
        usuario.setNome(novoNome);
        usuario.setEmail(novoEmail);
    }
    public static boolean removerUsuarioporNome(ArrayList<Usuario> usuarios, String nome){
        Usuario u =  buscarUsuario(usuarios, nome);
        if(u != null){
            usuarios.remove(u);
            return true;
        }
        return false;
    }
    public static boolean usuarioExistente(ArrayList<Usuario> usuarios, String nome) {

        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return true; // Usuário já existe
            }
        }
        return false; // Usuário não existe
    }

    public static boolean usuarioExistenteCpf(ArrayList<Usuario> usuarios, String cpf) {
        String cpfLimpo = cpf.replaceAll("[^0-9]","");
        for (Usuario u : usuarios) {
            if (cpfLimpo.equals(u.getCpf())) {
                return true; // Usuário já existe
            }
        }
        return false; // Usuário não existe
    }

    

    // ------------------------------------------------------------------Metodos para Tarefa---------------------------------------------------
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
    public static boolean concluirTarefa(ArrayList<Tarefa> tarefas, String titulo) {
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                t.setConcluida(true);
                return true; // Tarefa concluída com sucesso
            }
        }
        return false; // Tarefa não encontrada
    }
    
    public static boolean tarefaExistente(ArrayList<Tarefa> tarefas, String titulo) {
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
              return true; // Tarefa já existe
            }
        }
        return false; // Tarefa não existe
    }


}
