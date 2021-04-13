package repository;

import dao.DaoFactory;
import dominio.Dispositivo;
import dominio.Pessoa;
import dominio.TipoDispositivo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author rosivaldo.adm
 */
public class DispositivoRepository implements Serializable {

    @Inject
    private EntityManager em;

    private DaoFactory dao;

    @PostConstruct
    public void init() {
        this.dao = new DaoFactory(em);
    }

    public Dispositivo guardar(Dispositivo dispositivo) {
        return em.merge(dispositivo);
    }

    public void remover(Dispositivo dispositivo) {
        dao.getDispositivoDao().del(dispositivo);
    }

    public List<Dispositivo> listAll() {
        return dao.getDispositivoDao().listAll();
    }

    public List<Dispositivo> listAllAtivos() {
        return dao.getDispositivoDao().listAllAtivos();
    }

    public Dispositivo getDispositivoById(Integer id) {
        return dao.getDispositivoDao().findById(id);
    }

    public List<Dispositivo> completaNome(String query) {
        return dao.getDispositivoDao().jpqlLike(query, "nome");
    }
    
    public List<Dispositivo> getDispositivoByDepartamento(Integer departamentoId) {
        return dao.getDispositivoDao().jpqlEqualsID(departamentoId, "departamento.id");
    }
    
    public List<Dispositivo> getDispositivobyResponsavel(Pessoa responsavel) {
        String jpql = "select d from Dispositivo d where d.responsavel = :responsavel";
        Query query = em.createQuery(jpql, Dispositivo.class);
        query.setParameter("responsavel", responsavel);
        return query.getResultList();
    }

    public Integer getNumeroTotalDeDispositivosAtivos() {
        String jpql = "select COUNT(d) from Dispositivo d WHERE d.ativo=TRUE";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        return Integer.valueOf(query.getSingleResult().toString());
    }

    public Integer numeroTotalTipoDispositivo(TipoDispositivo tipo) {
        String jpql = "select COUNT(d) from Dispositivo d WHERE d.tipo = :tipo AND d.ativo=TRUE";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class).setParameter("tipo", tipo);
        return Integer.valueOf(query.getSingleResult().toString());
    }

}
