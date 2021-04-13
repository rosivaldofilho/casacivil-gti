package conversores;

import dao.DaoFactory;
import dominio.Dispositivo;
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
@FacesConverter("dispositivoConverter")
public final class DispositivoConverter implements Converter {

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
                Dispositivo dispositivo = dao.getDispositivoDao().findById(Integer.valueOf(value));
                return dispositivo;
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Identificador de dispositivo inválido."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Dispositivo) object).getId());
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
