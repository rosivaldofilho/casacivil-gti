package dominio;

/**
 *
 * @author rosivaldo.adm
 */
public enum TipoDispositivo {

    
    COMPUTADOR("Computador"),
    IMPRESSORA("Impressora"),
    SCANNER("Scanner"),
    MONITOR("Monitor"),
    SMARTPHONE("Smartphone"),
    HD("HD"),
    OUTRO("Outro");

    /**
     * Fotos, Slide, Propaganda
     */
    public String descricao;
    
    private TipoDispositivo(String descricao){
        this.descricao = descricao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
 
}
