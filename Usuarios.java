public class Usuarios {
    private String Nome;
    private String CPF;
    private String Email;

    public Usuarios(String Nome, String CPF, String Email) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Email = Email;
    }

    public String getNome() {
        return Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return Email;
    }
    

public void apresentarUsuario() {
        System.out.println("Apresentando usuário:");
        System.out.println("---------------------");
        System.out.println("Nome: " + Nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Email: " + Email);
        System.out.println("---------------------");
        
    }
}
