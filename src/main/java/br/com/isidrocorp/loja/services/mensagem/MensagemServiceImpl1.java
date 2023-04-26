package br.com.isidrocorp.loja.services.mensagem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("principal")
public class MensagemServiceImpl1 implements IMensagemService {

	@Override
	public String gerarMensagem() {
		return "Bem-vindo(a) ao e-commerce!";
	}

}
