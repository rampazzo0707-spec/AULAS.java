public class Usuario {
    private String nome;
    private final String cpf;
    private String email;

    public Usuario(String nome, String cpf, String email) {
        if(!eCPFValido(cpf)){
            throw new IllegalArgumentException("CPF inválido");
        }
        
        setNome(nome);
        this.cpf = (cpf != null) ? cpf.replaceAll("[^0-9]",""): "";
        setEmail(email);
    }





    // Metodo para Validacao de Email
    public static boolean eEmailValido(String email){
        if (email == null|| email.isBlank()){
            return false;
        }
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.trim().matches(regex);
        
    }
    


 

    // Metodo para Validacao de CPF
    public static void validarFormatoCPF(String cpf) {
        if (!eCPFValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }
    
    private static boolean eCPFValido(String cpf) {
        if (cpf == null) return false;
        
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        if (cpfLimpo.length() != 11) return false;


        
        if (cpfLimpo.matches("(\\d)\\1{10}")) return false;



        // Calculo de verficação do primeiro digito
        int soma =0;
        for(int i=0;i<9;i++){
            int num = Character.getNumericValue(cpfLimpo.charAt(i));
            soma += num * (10 - i);
        }
        int primeiroDigitoCalculado = (soma * 10) % 11;
        if (primeiroDigitoCalculado ==10 || primeiroDigitoCalculado == 11){
            primeiroDigitoCalculado = 0;
        }
        int primeiroDigitoInformado = Character.getNumericValue(cpfLimpo.charAt(9));
        if(primeiroDigitoCalculado != primeiroDigitoInformado){
            return false;
        }

        // Calculo de verificacao do segundo digito
        soma=0;
        for(int i=0;i<10;i++){
            int num = Character.getNumericValue(cpfLimpo.charAt(i));
            soma += num * (11 - i);
        }
        int segundoDigitoCalculado = (soma * 10) % 11;
        if(segundoDigitoCalculado == 10 || segundoDigitoCalculado == 11){
            segundoDigitoCalculado = 0;
        }
        if(segundoDigitoCalculado != Character.getNumericValue(cpfLimpo.charAt(10))){
            return false;
        }
        
       
      
        return true; 
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})","$1.$2.$3-$4");
    }

    public String getEmail() {
        return email;
    }

    
    

public void setNome(String nome) {
    if(nome == null|| nome.isBlank()){
        throw new IllegalArgumentException("Porfavor prencha o campo");
    }
        this.nome = nome.trim();
    }

    public void setEmail(String email) {
        if(!eEmailValido(email)){
           throw new IllegalArgumentException("Email Invalido");
        }

        this.email = email;
    }

public void apresentarUsuario() {
    String cpfExibicao = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})","$1.$2.$3-$4");
        System.out.println("---------------------");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + getCPF);
        System.out.println("Email: " + email);
        System.out.println("---------------------");
    
    }
}
