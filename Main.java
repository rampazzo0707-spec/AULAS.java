import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
       ArrayList<Usuario> usuarios = new ArrayList<Usuario>();


       cadastrarUsuario(usuarios,
        "Erick", 
       "CPF do Erick",
       "Email do Erick");
      
      
       cadastrarUsuario(usuarios, 
        "Luiza", 
       "CPF da Luiza", 
       "Email da Luiza");
       
       
       cadastrarUsuario(usuarios, 
        "Joao", 
       "CPF do Joao", 
       "Email do Joao");
    

      
      
       cadastrarUsuario(usuarios,
        "Jon Doe",
       "CPF do Jon Doe",
       "Email do Jon Doe");

       System.out.println("Procurando usuário:");
       Usuario usuarioEncontrado = buscarUsuario(usuarios,"Joao");
       if(usuarioEncontrado != null){
        usuarioEncontrado.apresentarUsuario();
       } else {
        System.out.println("Usuário não encontrado.");
       }

       System.out.println("-----Removendo usuário-----");
       removerUsuario(usuarios,3);


         System.out.println("Lista de Usuários Atualizada:");
         listarUsuarios(usuarios);

;
     
        }
        public static void cadastrarUsuario(ArrayList<Usuario> usuarios, String nome, String cpf, String email) {
            usuarios.add(new Usuario(nome, cpf, email));
        }

        public static void listarUsuarios(ArrayList<Usuario> usuarios) {
            for (Usuario u : usuarios) {
                u.apresentarUsuario();
            
            }
        }
        public static void removerUsuario(ArrayList<Usuario>usuarios, int posicao){
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
        public static void atualizarUsuario(ArrayList<Usuario> lista, int posicao, String novoNome, String novoCPF, String novoEmail) {
            Usuario usuario = lista.get(posicao);
            usuario.setNome(novoNome);
            usuario.setCPF(novoCPF);
            usuario.setEmail(novoEmail);
        }

    
}


