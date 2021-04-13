package beans;

import security.Seguranca;
import dominio.Departamento;
import dominio.Pessoa;
import dominio.Piso;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import repository.DepartamentoRepository;
import service.DepartamentoService;
import service.PessoaService;
import util.FacesUtil;
import static util.FacesUtil.redirecionarPara;

/**
 *
 * @author rosivaldo
 */
@Named
@ViewScoped
public class DepartamentoBean implements Serializable {

    @Inject
    private DepartamentoService departamentoService;
    @Inject
    private PessoaService pessoaService;
    @Inject
    private DepartamentoRepository departamentoRep;

    private Pessoa usuarioLogado = new Pessoa();
    private final Seguranca seguranca = new Seguranca();

    private Departamento departamento;

    private List<Departamento> departamentos;

    private List<Pessoa> funcionarios;

    public DepartamentoBean() {
        funcionarios = new ArrayList();
        departamento = new Departamento();
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
        departamento = (Departamento) event.getObject();
        redirecionarPara("/departamento/" + departamento.getId());
    }

    public void excluirDepartamento(Departamento departamento) {
        departamentoService.remover(departamento);
    }

    public void desativarDepartamento() {
        departamentoService.desativar(departamento);
        FacesUtil.addInfoMessage("Departamento desativado com sucesso!");
    }

    public void inicializarDepartamentos() throws IOException {
        if (!FacesUtil.isPostback()) {
            departamentos = departamentoService.listarTodos();
        }
    }

    public void inicializarFuncionariosPorDepartamento() {
        if (!FacesUtil.isPostback()) {
            if (departamento.getId() != null) {
                funcionarios = pessoaService.buscaPessoaPeloDepartamento(departamento);
            }
        }
    }

    public void salvarDepartamento() {
        if (departamento.getId() != null) {
            atualizarDepartamento();
        } else {
            cadastrarDepartamento();
        }
    }

    public void cadastrarDepartamento() {

        try {
            departamento = departamentoService.cadastrar(departamento);
            FacesUtil.addInfoMessage("Informações salvas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtil.addErrorMessage("Erro ao salvar informações!");
        }
    }

    public void atualizarDepartamento() {
        try {
            departamento = departamentoService.atualizar(departamento);
            FacesUtil.addInfoMessage("Informações salvas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtil.addErrorMessage("Erro ao salvar informações!");
        }
    }

    /**
     * @return the generos
     */
    public Piso[] getPisos() {
        return Piso.values();
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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

    /**
     * @return the departamentoService
     */
    public DepartamentoService getDepartamentoRep() {
        return departamentoService;
    }

    /**
     * @param departamentoService the departamentoService to set
     */
    public void setDepartamentoRep(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    /**
     * @return the funcionarios
     */
    public List<Pessoa> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(List<Pessoa> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
