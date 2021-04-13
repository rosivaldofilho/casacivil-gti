package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Dispositivo implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(length = 15, nullable = true, unique = false)
    private String enderecoRede;

    @Column(length = 255, nullable = true)
    private String patrimonio;
    
    @Column(length = 255, nullable = true)
    private String nomenclatura;

    @ManyToOne(optional = true)
    @JoinColumn(name="departamento_id", nullable = true)
    private Departamento departamento;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = true)
    private Modelo modelo;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = true)
    private Date dataEntrada = new Date();
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false, updatable=false)
    private Date dataCadastro = new Date();

    @Column(nullable = false)
    private Boolean ativo = true;

    @Column(length = 30, nullable = true, unique = false)
    private String numeroSerie;
    
    @ManyToOne(optional = true)
    @JoinColumn(name="responsavel_id", nullable = true)
    private Pessoa responsavel;
    
    @Enumerated(EnumType.STRING)
    private TipoDispositivo tipo;
    
    @Column(length = 10, nullable = true)
    private String pontoRede;
    
    @Column(length = 30, nullable = true)
    private String mac;
    
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the patrimonio
     */
    public String getPatrimonio() {
        return patrimonio;
    }

    /**
     * @param patrimonio the patrimonio to set
     */
    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
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
     * @return the numeroSerie
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * @param numeroSerie the numeroSerie to set
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * @return the responsavel
     */
    public Pessoa getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the tipo
     */
    public TipoDispositivo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoDispositivo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nomenclatura
     */
    public String getNomenclatura() {
        return nomenclatura;
    }

    /**
     * @param nomenclatura the nomenclatura to set
     */
    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    /**
     * @return the enderecoRede
     */
    public String getEnderecoRede() {
        return enderecoRede;
    }

    /**
     * @param enderecoRede the enderecoRede to set
     */
    public void setEnderecoRede(String enderecoRede) {
        this.enderecoRede = enderecoRede;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Dispositivo other = (Dispositivo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "id=" + id + ", descricao=" + descricao + '}';
    }

    /**
     * @return the pontoRede
     */
    public String getPontoRede() {
        return pontoRede;
    }

    /**
     * @param pontoRede the pontoRede to set
     */
    public void setPontoRede(String pontoRede) {
        this.pontoRede = pontoRede;
    }

    /**
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac the mac to set
     */
    public void setMac(String mac) {
        this.mac = mac;
    }


}
