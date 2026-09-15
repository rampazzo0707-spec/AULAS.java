public class Usuario {
    private String Nome;
    private String CPF;
    private String Email;

    public Usuario(String Nome, String CPF, String Email) {
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

    
    

public void setNome(String nome) {
        Nome = nome;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public void setEmail(String email) {
        Email = email;
    }

public void apresentarUsuario() {
        System.out.println("---------------------");
        System.out.println("Nome: " + Nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Email: " + Email);
        System.out.println("---------------------");
        
    }
}
