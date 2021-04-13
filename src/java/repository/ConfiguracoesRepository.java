package repository;

import dao.DaoFactory;
import dominio.Configuracoes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author rosivaldo.adm
 */
public class ConfiguracoesRepository implements Serializable {

    @Inject
    private EntityManager em;

    private DaoFactory dao;

    @PostConstruct
    public void init() {
        this.dao = new DaoFactory(em);
    }

    public Configuracoes guardar(Configuracoes configuracoes) {
        return em.merge(configuracoes);
    }

    public List<Configuracoes> listAll() {
        return dao.getConfiguracoesDao().listAll();
    }

    public Configuracoes getConfiguracoesById(Integer id) {
        return dao.getConfiguracoesDao().findById(id);
    }

}
