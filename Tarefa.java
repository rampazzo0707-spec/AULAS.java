public class Tarefa {
    private String titulo;
    private String descricao;
    private boolean concluida;
    private Usuario responsavel; // Associação com a classe Usuario

    public Tarefa(String titulo, String descricao, Usuario responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.concluida = false;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
     public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
    

    public void apresentarTarefa() {
        String status = concluida ? "Sim" : "Não";
         String nomeResponsavel = (responsavel != null) ? responsavel.getNome() : "Sem responsável"; 
        System.out.println("|Título: " + titulo + " |Descrição: " + descricao + " |Concluída: " + status + " |Responsável: " + responsavel.getNome() + "|");
       

}

    
}



