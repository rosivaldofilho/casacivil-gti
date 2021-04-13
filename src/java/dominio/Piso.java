package dominio;

/**
 *
 * @author rosivaldo.adm
 */
public enum Piso {

    
    TERREO("Térreo"),
    PRIMEIRO("Primeiro Piso"),
    SEGUNDO("Segundo Piso");


    public String descricao;
    
    private Piso(String descricao){
        this.descricao = descricao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
 
}
