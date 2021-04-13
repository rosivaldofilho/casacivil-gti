package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Rosivaldo Souza
 */
@Entity
public class Departamento implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 255, nullable = false)
    private String nome;
    
    @Column(length = 30, nullable = true)
    private String sigla;
    
    @Enumerated(EnumType.STRING)
    private Piso piso;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    private Date dataCadastro;
    
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "departamento_id", nullable = true)
    private List<Ramal> ramais = new ArrayList<>();

    private Boolean ativo = true;
    

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the ramais
     */
    public List<Ramal> getRamais() {
        return ramais;
    }

    /**
     * @param ramais the ramais to set
     */
    public void setRamais(List<Ramal> ramais) {
        this.ramais = ramais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", nome=" + nome + '}';
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the piso
     */
    public Piso getPiso() {
        return piso;
    }

    /**
     * @param piso the piso to set
     */
    public void setPiso(Piso piso) {
        this.piso = piso;
    }

}
