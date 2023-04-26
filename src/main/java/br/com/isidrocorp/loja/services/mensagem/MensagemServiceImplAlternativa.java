package br.com.isidrocorp.loja.services.mensagem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("alternativa")
public class MensagemServiceImplAlternativa implements IMensagemService {

	@Override
	public String gerarMensagem() {
		return "Olá! Este é o teste de gerar uma mensagem.";
	}

	
}
