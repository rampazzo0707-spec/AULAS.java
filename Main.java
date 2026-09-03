import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
       ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();


       usuarios.add(new Usuarios(
        "Erick", 
       "CPF do Erick",
       "Email do Erick"));
       usuarios.add(new Usuarios(
        "Luiza",
       "CPF da Luiza",
       "Email da Luiza"));
       usuarios.add(new Usuarios(
        "Joao",
       "CPF do Joao",
       "Email do Joao"));
       usuarios.add(new Usuarios(
        "Jon Doe",
       "CPF do Jon Doe",
       "Email do Jon Doe"));

    System.out.println("Número de usuários cadastrados: " + usuarios.size());
       apresentarUsuario(usuarios);
     
        }
    public static void apresentarUsuario(ArrayList<Usuarios> usuarios) {
        for (Usuarios usuario : usuarios) {
            usuario.apresentarUsuario();
            
            
        }
        System.out.println("Removendo o usuário na posição Jon Doe...");
        usuarios.remove(3);
        System.out.println("Número de usuários cadastrados Atualizado: " + usuarios.size());
    }
    
    
}
