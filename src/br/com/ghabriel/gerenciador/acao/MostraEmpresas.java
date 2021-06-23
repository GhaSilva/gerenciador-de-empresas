package br.com.ghabriel.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ghabriel.gerenciador.modelo.Banco;
import br.com.ghabriel.gerenciador.modelo.Empresa;

public class MostraEmpresas implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
		
		System.out.println("Mostrando dados das empresas");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		System.out.println(empresa.getNome());
		
		
		request.setAttribute("empresa", empresa);
		return "forward:formAlteraEmpresa.jsp";
		

	}

}
