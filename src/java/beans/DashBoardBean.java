
package beans;

import dominio.Pessoa;
import dominio.TipoDispositivo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import security.Seguranca;
import service.DepartamentoService;
import service.DispositivoService;
import service.PessoaService;

/**
 *
 * @author rosivaldo.adm
 */
@Named
@ViewScoped
public class DashBoardBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Seguranca seguranca;
    @Inject
    private DispositivoService dispositivoService;
    @Inject
    private DepartamentoService departamentoService;
    @Inject
    private PessoaService pessoaService;
    
    private Integer numeroComputadores;
    private Integer numeroDispositivos;
    private Integer numeroDepartamentoes;
    private Integer numeroPessoas;
    
    private List<Pessoa> proximosPessoas;
    private TipoDispositivo[] tiposDispositivos = TipoDispositivo.values();
    
    
    public DashBoardBean(){
        tiposDispositivos = TipoDispositivo.values();
        proximosPessoas = new ArrayList();
    }
    
    @PostConstruct
    public void init() {
    }
    
    public void inicializarDashADM(){
        numeroDispositivos = dispositivoService.numeroTotalDeDispositivos();
        numeroDepartamentoes = departamentoService.numeroTotalDeDepartamentos();
        numeroPessoas = pessoaService.numeroTotalDePessoas();
    }
    
    public String getNumeroTotalTipoDispositivo(TipoDispositivo tipo){
        return dispositivoService.numeroTotalTipoDispositivo(tipo).toString();
    }
    
    /**
     * @return the numeroDispositivos
     */
    public Integer getNumeroDispositivos() {
        return numeroDispositivos;
    }

    /**
     * @param numeroDispositivos the numeroDispositivos to set
     */
    public void setNumeroDispositivos(Integer numeroDispositivos) {
        this.numeroDispositivos = numeroDispositivos;
    }

    /**
     * @return the numeroDepartamentoes
     */
    public Integer getNumeroDepartamentoes() {
        return numeroDepartamentoes;
    }

    /**
     * @param numeroDepartamentoes the numeroDepartamentoes to set
     */
    public void setNumeroDepartamentoes(Integer numeroDepartamentoes) {
        this.numeroDepartamentoes = numeroDepartamentoes;
    }

    /**
     * @return the numeroPessoas
     */
    public Integer getNumeroPessoas() {
        return numeroPessoas;
    }

    /**
     * @param numeroPessoas the numeroPessoas to set
     */
    public void setNumeroPessoas(Integer numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

    /**
     * @return the proximosPessoas
     */
    public List<Pessoa> getProximosPessoas() {
        return proximosPessoas;
    }

    /**
     * @param proximosPessoas the proximosPessoas to set
     */
    public void setProximosPessoas(List<Pessoa> proximosPessoas) {
        this.proximosPessoas = proximosPessoas;
    }

    /**
     * @return the tiposDispositivos
     */
    public TipoDispositivo[] getTiposDispositivos() {
        return tiposDispositivos;
    }

    /**
     * @param tiposDispositivos the tiposDispositivos to set
     */
    public void setTiposDispositivos(TipoDispositivo[] tiposDispositivos) {
        this.tiposDispositivos = tiposDispositivos;
    }


    
    
    
}
