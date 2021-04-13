package dominio;

/**
 *
 * @author rosivaldo.adm
 */
public enum Situacao {
    
    NORMAL("Normal"),
    LOCADO("Locado"),
    EMPRESTADO("Emprestado"),
    CEDIDO("Cedido"),
    MANUTENCAO("Em Manutenção");

    /**
     * Fotos, Slide, Propaganda
     */
    public String descricao;

    private Situacao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
}
