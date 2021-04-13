package repository;

import dao.DaoFactory;
import dominio.Departamento;
import dominio.Permissao;
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
public class DepartamentoRepository implements Serializable {

    @Inject
    private EntityManager em;

    private DaoFactory dao;

    @PostConstruct
    public void init() {
        this.dao = new DaoFactory(em);
    }

    public Departamento guardar(Departamento departamento) {
        return em.merge(departamento);
    }

    public void remover(Departamento departamento) {
        dao.getDepartamentoDao().del(departamento);
    }

    public List<Departamento> listAll() {
        return dao.getDepartamentoDao().listAll();
    }

    public List<Departamento> listAllAtivos() {
        return dao.getDepartamentoDao().listAllAtivos();
    }

    public Departamento getDepartamentoById(Integer id) {
        return dao.getDepartamentoDao().findById(id);
    }

    public List<Departamento> completaNome(String query) {
        return dao.getDepartamentoDao().jpqlLike(query, "nome");
    }

    public Integer getNumeroTotalDeDepartamentosAtivos() {
        String jpql = "select COUNT(a) from Departamento a WHERE a.ativo=TRUE";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        return Integer.valueOf(query.getSingleResult().toString());
    }

}
