package beans;

import dominio.Departamento;
import security.Seguranca;
import dominio.Dispositivo;
import dominio.Pessoa;
import dominio.TipoDispositivo;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import repository.DispositivoRepository;
import service.DepartamentoService;
import service.DispositivoService;
import service.PessoaService;
import util.FacesUtil;
import static util.FacesUtil.redirecionarPara;

/**
 *
 * @author rosivaldo
 */
@Named
@ViewScoped
public class DispositivoBean implements Serializable {

    @Inject
    private DispositivoService dispositivoService;
    @Inject
    private DepartamentoService departamentoService;
    @Inject
    private PessoaService pessoaService;
    @Inject
    private DispositivoRepository dispositivoRep;
    
    private Pessoa usuarioLogado = new Pessoa();
    private final Seguranca seguranca = new Seguranca();
    private Dispositivo dispositivo;
    private List<Dispositivo> dispositivos;
    private List<Pessoa> responsaveis;
    private List<Departamento> departamentos;

    public DispositivoBean() {
        dispositivo = new Dispositivo();
        dispositivos = new ArrayList();
        responsaveis = new ArrayList();
        departamentos = new ArrayList();
        usuarioLogado = seguranca.getUsuario();
    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void saindo() {
    }
    
    public void onRowSelect(SelectEvent event) throws IOException {
        dispositivo = (Dispositivo) event.getObject();
        redirecionarPara("/dispositivo/" + dispositivo.getId() + "/edicao");
    }
    
    public void verificaUsuarioAdm() throws IOException {
        if(!seguranca.isAdministrador()){
            FacesUtil.redirecionarPara("/erro");
        }
    }

    public void excluirDispositivo(Dispositivo dispositivo) {
        dispositivoService.remover(dispositivo);
    }
    

    public void desativarDispositivo() {
        dispositivoService.desativar(dispositivo);
        FacesUtil.addInfoMessage("Dispositivo desativado com sucesso!");
    }

    public void inicializarDispositivos() throws IOException {
        if (!FacesUtil.isPostback()) {
            dispositivos = dispositivoService.listarTodos();
        }
    }

    public void inicializarDepartamentos() {
        if (!FacesUtil.isPostback()) {
            //System.out.println(dispositivo.getDescricao());
            departamentos = departamentoService.listarTodos();
        }
    }

    public void inicializarResponsaveis() {
        responsaveis = pessoaService.buscaPessoaPeloDepartamento(dispositivo.getDepartamento());
    }

    public void salvarDispositivo() {
        if (dispositivo.getId() != null) {
            atualizarDispositivo();
        } else {
            cadastrarDispositivo();
        }
    }

    public void cadastrarDispositivo() {

        try {
            dispositivo = dispositivoService.cadastrar(dispositivo);
            FacesUtil.addInfoMessage("Informações salvas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtil.addErrorMessage("Erro ao salvar informações!");
        }
    }

    public void atualizarDispositivo() {
        try {
            dispositivo = dispositivoService.atualizar(dispositivo);
            FacesUtil.addInfoMessage("Informações salvas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtil.addErrorMessage("Erro ao salvar informações!");
        }
    }
    
    
    
    /**
     * @return a data atual
     * @throws java.io.IOException
     */
    public String contexto() throws IOException {
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath());
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }
    
    /**
     * @return a data atual
     */
    public Date hoje() {
        return new Date();
    }

    /**
     * @return the generos
     */
    public TipoDispositivo[] getTiposDispositivo() {
        return TipoDispositivo.values();
    }

    /**
     * @return the dispositivo
     */
    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    /**
     * @param dispositivo the dispositivo to set
     */
    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    /**
     * @return the dispositivos
     */
    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    /**
     * @param dispositivos the dispositivos to set
     */
    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    /**
     * @return the dispositivoService
     */
    public DispositivoService getDispositivoRep() {
        return dispositivoService;
    }

    /**
     * @param dispositivoService the dispositivoService to set
     */
    public void setDispositivoRep(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    /**
     * @return the responsaveis
     */
    public List<Pessoa> getResponsaveis() {
        return responsaveis;
    }

    /**
     * @param responsaveis the responsaveis to set
     */
    public void setResponsaveis(List<Pessoa> responsaveis) {
        this.responsaveis = responsaveis;
    }

    /**
     * @return the departamentos
     */
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    /**
     * @param departamentos the departamentos to set
     */
    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

}
