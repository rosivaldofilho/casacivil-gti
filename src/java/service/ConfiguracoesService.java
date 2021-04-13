package service;

import dominio.Configuracoes;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Inject;
import javax.transaction.Transactional;
import repository.ConfiguracoesRepository;
import util.FacesUtil;

/**
 *
 * @author rosivaldo.adm
 */
public class ConfiguracoesService implements Serializable {

    @Inject
    private ConfiguracoesRepository configuracoesRep;

    @Transactional
    public Configuracoes atualizar(Configuracoes configuracoes) {
        return configuracoesRep.guardar(configuracoes);
    }
    
    @Transactional
    public Configuracoes BuscarConfiguracoesPorId(Integer configuracoesID) {
        return configuracoesRep.getConfiguracoesById(configuracoesID);
    }

    public void retornaParaInfoConfiguracoes(Configuracoes configuracoes) throws IOException {
        FacesUtil.redirecionarPara("/configuracoes/informacao.xhtml?configuracoes=" + configuracoes.getId());
    }

    public void retornaParaInicio() throws IOException {
        FacesUtil.redirecionarPara("/");
    }

}
