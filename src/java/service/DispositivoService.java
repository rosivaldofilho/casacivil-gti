package service;

import dominio.Dispositivo;
import dominio.Pessoa;
import dominio.TipoDispositivo;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import repository.DispositivoRepository;
import util.FacesUtil;

/**
 *
 * @author rosivaldo.adm
 */
public class DispositivoService implements Serializable {

    @Inject
    private DispositivoRepository dispositivoRep;

    @Transactional
    public Dispositivo cadastrar(Dispositivo dispositivo){
        dispositivo.setDataCadastro(new Date());
        return dispositivoRep.guardar(dispositivo);
    }

    @Transactional
    public Dispositivo atualizar(Dispositivo dispositivo) {
        return dispositivoRep.guardar(dispositivo);
    }

    @Transactional
    public void remover(Dispositivo dispositivo) {
        dispositivoRep.remover(dispositivo);
    }

    @Transactional
    public Dispositivo desativar(Dispositivo dispositivo) {
        dispositivo.setAtivo(false);
        return dispositivoRep.guardar(dispositivo);
    }

    @Transactional
    public List<Dispositivo> listarTodos() {
        return dispositivoRep.listAllAtivos();
    }

    @Transactional
    public List<Dispositivo> completaNome(String query) {
        return dispositivoRep.completaNome(query);
    }

    @Transactional
    public Integer numeroTotalDeDispositivos() {
        return dispositivoRep.getNumeroTotalDeDispositivosAtivos();
    }
    
    @Transactional
    public Integer numeroTotalTipoDispositivo(TipoDispositivo tipo) {
        return dispositivoRep.numeroTotalTipoDispositivo(tipo);
    }
    
    @Transactional
    public List<Dispositivo> buscaDispositivoPeloResponsavel(Pessoa responsavel) throws NoResultException {
        return dispositivoRep.getDispositivobyResponsavel(responsavel);
    }

    public void retornaParaInfoDispositivo(Dispositivo dispositivo) throws IOException {
        FacesUtil.redirecionarPara("/dispositivo/informacao.xhtml?dispositivo=" + dispositivo.getId());
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
