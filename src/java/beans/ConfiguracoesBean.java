package beans;

import dominio.Configuracoes;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import service.ConfiguracoesService;
import util.FacesUtil;

/**
 *
 * @author rosivaldo.adm
 */
@Named
@ViewScoped
public class ConfiguracoesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ConfiguracoesService configuracoesService;

    private Configuracoes configuracoes;

    public ConfiguracoesBean() {
        configuracoes = new Configuracoes();
    }

    @PostConstruct
    public void init() {
        configuracoes = configuracoesService.BuscarConfiguracoesPorId(1);
    }

    public void atualizarConfiguracoes() {
        try {
            configuracoesService.atualizar(configuracoes);
            FacesUtil.addInfoMessage("Configurações atualizadas com sucesso!");
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao tentar atualizar configurações!");
        }
    }
    
    

    /**
     * @return the configuracoes
     */
    public Configuracoes getConfiguracoes() {
        return configuracoes;
    }

    /**
     * @param configuracoes the configuracoes to set
     */
    public void setConfiguracoes(Configuracoes configuracoes) {
        this.configuracoes = configuracoes;
    }

}
