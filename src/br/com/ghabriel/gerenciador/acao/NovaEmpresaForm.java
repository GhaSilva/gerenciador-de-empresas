package br.com.ghabriel.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ghabriel.gerenciador.modelo.Banco;

public class NovaEmpresaForm implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:formNovaEmpresa.jsp";
		
		
	}

}
