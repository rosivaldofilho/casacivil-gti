package dominio;



import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.Email;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)//estrategia de junção para herança
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 255, nullable = false)
    private String nome="";
    
    @Column(name="usuario_windows", length = 255, nullable = true)
    private String usuarioWindows="";

    @Column(name="cargo_funcao", length = 255, nullable = true)
    private String cargoFuncao;

    @Email
    @Column(length = 255, nullable = true, unique = false)
    private String email;

    @Column(length = 255, nullable = true)
    private String foto = "";
    
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "departamento_id", nullable = true)
    private Departamento departamento;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    private Usuario usuario;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    private Date dataCadastro;
    
    @Column(nullable = false)
    private boolean ativo = true;

    public Integer getId() {
        return id;
    }

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
     * @return the cargoFuncao
     */
    public String getCargoFuncao() {
        return cargoFuncao;
    }

    /**
     * @param cargoFuncao the cargoFuncao to set
     */
    public void setCargoFuncao(String cargoFuncao) {
        this.cargoFuncao = cargoFuncao;
    }

    /**
     * @return the usuarioWindows
     */
    public String getUsuarioWindows() {
        return usuarioWindows;
    }

    /**
     * @param usuarioWindows the usuarioWindows to set
     */
    public void setUsuarioWindows(String usuarioWindows) {
        this.usuarioWindows = usuarioWindows;
    }

}
