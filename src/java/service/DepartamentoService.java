package service;

import dominio.Departamento;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import repository.DepartamentoRepository;
import util.FacesUtil;

/**
 *
 * @author rosivaldo.adm
 */
public class DepartamentoService implements Serializable {

    @Inject
    private DepartamentoRepository departamentoRep;

    @Transactional
    public Departamento cadastrar(Departamento departamento){
        departamento.setDataCadastro(new Date());
        return departamentoRep.guardar(departamento);
    }

    @Transactional
    public Departamento atualizar(Departamento departamento) {
        return departamentoRep.guardar(departamento);
    }

    @Transactional
    public void remover(Departamento departamento) {
        departamentoRep.remover(departamento);
    }

    @Transactional
    public Departamento desativar(Departamento departamento) {
        departamento.setAtivo(false);
        return departamentoRep.guardar(departamento);
    }

    @Transactional
    public List<Departamento> listarTodos() {
        return departamentoRep.listAllAtivos();
    }

    @Transactional
    public List<Departamento> completaNome(String query) {
        return departamentoRep.completaNome(query);
    }

    @Transactional
    public Integer numeroTotalDeDepartamentos() {
        return departamentoRep.getNumeroTotalDeDepartamentosAtivos();
    }

    public void retornaParaInfoDepartamento(Departamento departamento) throws IOException {
        FacesUtil.redirecionarPara("/departamento/informacao.xhtml?departamento=" + departamento.getId());
    }

    public void retornaParaInicio() throws IOException {
        FacesUtil.redirecionarPara("/tonacorrida");
    }

    public void retornaParaLogin() throws IOException {
        FacesUtil.redirecionarPara(FacesUtil.getExternalContext().getRequestContextPath()+"/login.xhtml");
    }

    public void encaminharSucesso() throws IOException {
        FacesUtil.redirecionarPara("/site/success.xhtml");
    }

}
