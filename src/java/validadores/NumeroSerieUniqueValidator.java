package validadores;

import dao.DaoFactory;
import dominio.Dispositivo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author rosivaldo.adm
 */
@FacesValidator("numeroSerieUniqueValidator")
public class NumeroSerieUniqueValidator implements Validator {

    @Inject
    private EntityManager em;

    private DaoFactory dao;

    @PostConstruct
    public void init() {
        this.dao = new DaoFactory(em);
    }

    @Override
    public void validate(FacesContext context, UIComponent componente, Object value) throws ValidatorException {

        if (value != null && value.toString().trim().length() > 0) {
            List<Dispositivo> patrimonios = dao.getDispositivoDao().jpqlLike(value.toString(), "numeroSerie");
            if (!patrimonios.isEmpty()) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Número de Série já Cadastrado.", "Número de Série já utilizado em outro cadastro");
                throw new ValidatorException(msg);
            }
        }
    }

}
