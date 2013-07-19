package br.ufg.inf.fs.controller;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import javax.xml.rpc.*;
import javax.xml.bind.JAXBException;

public class LoginController {
	private String login;
	private String senha;

	public LoginController(String login, String senha) throws NoSuchAlgorithmException {
		this.login = login;
		this.senha = senha;
		
	}

	public int logar() throws ServiceException, NoSuchAlgorithmException, RemoteException {
		String local = "http://localhost:8080/axis/Servico.jws";

		// Criando e configurando o serviço
		Call call = (Call) new Service().createCall();
		// Configurando o endereço.
		call.setTargetEndpointAddress(local);
		// Marcando o método a ser chamado.
		call.setOperationName("logar");

		// Parâmetros da função soma.
		Object[] param = new Object[] { login, hash(senha)};
		// Retorno da Função
		Integer ret = (Integer) call.invoke(param);

		return ret;
	}

	public String hash(String senha) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		String crypto = hash.toString(16);
		return crypto;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
