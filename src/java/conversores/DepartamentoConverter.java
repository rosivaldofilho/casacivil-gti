package conversores;

import dao.DaoFactory;
import dominio.Departamento;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author rosivaldo.adm
 */
@FacesConverter("departamentoConverter")
public final class DepartamentoConverter implements Converter {

    @Inject
    private EntityManager em;

    private DaoFactory dao;

    @PostConstruct
    public void init() {
        this.dao = new DaoFactory(em);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                Departamento departamento = dao.getDepartamentoDao().findById(Integer.valueOf(value));
                return departamento;
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Identificador de departamento inválido."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Departamento) object).getId());
        } else {
            return null;
        }
    }

    /**
     * @return the dao
     */
    public DaoFactory getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(DaoFactory dao) {
        this.dao = dao;
    }

}
