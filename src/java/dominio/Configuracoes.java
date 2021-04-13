package dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * ex: AIO, Lexmark, etc...
 *
 * @author Rosivaldo Souza
 */
@Entity
public class Configuracoes implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100, nullable = false)
    private boolean habilitarRemocaoUsuarios;

    @Column(length = 100, nullable = false)
    private boolean habilitarRemocaoDepartamentos;

    @Column(length = 100, nullable = false)
    private boolean habilitarRemocaoDispositivos;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the habilitarRemocaoUsuarios
     */
    public boolean isHabilitarRemocaoUsuarios() {
        return habilitarRemocaoUsuarios;
    }

    /**
     * @param habilitarRemocaoUsuarios the habilitarRemocaoUsuarios to set
     */
    public void setHabilitarRemocaoUsuarios(boolean habilitarRemocaoUsuarios) {
        this.habilitarRemocaoUsuarios = habilitarRemocaoUsuarios;
    }

    /**
     * @return the habilitarRemocaoDepartamentos
     */
    public boolean isHabilitarRemocaoDepartamentos() {
        return habilitarRemocaoDepartamentos;
    }

    /**
     * @param habilitarRemocaoDepartamentos the habilitarRemocaoDepartamentos to set
     */
    public void setHabilitarRemocaoDepartamentos(boolean habilitarRemocaoDepartamentos) {
        this.habilitarRemocaoDepartamentos = habilitarRemocaoDepartamentos;
    }

    /**
     * @return the habilitarRemocaoDispositivos
     */
    public boolean isHabilitarRemocaoDispositivos() {
        return habilitarRemocaoDispositivos;
    }

    /**
     * @param habilitarRemocaoDispositivos the habilitarRemocaoDispositivos to set
     */
    public void setHabilitarRemocaoDispositivos(boolean habilitarRemocaoDispositivos) {
        this.habilitarRemocaoDispositivos = habilitarRemocaoDispositivos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Configuracoes other = (Configuracoes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
