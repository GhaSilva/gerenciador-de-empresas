package br.com.ghabriel.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ghabriel.gerenciador.acao.Acao;


@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//		if(acaoProtegida && usuarioNaoLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
			
		String nomeDaClasse = "br.com.ghabriel.gerenciador.acao."+ paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao)classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward") ) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		//paramAcao.executa(request,response);
		
//		String nome = null;
//		if(paramAcao.equals("ListaEmpresas")) {
//	
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request,response);
//			
//			
//		} else if(paramAcao.equals("RemoveEmpresas")) {
//			
//			RemoveEmpresas acao = new RemoveEmpresas();
//			nome = acao.executa(request,response);	
//			
//		}else if(paramAcao.equals("MostraEmpresas")) {
//			
//			MostraEmpresas acao = new MostraEmpresas();
//			nome = acao.executa(request,response);
//			
//		}else if(paramAcao.equals("AlteraEmpresas")) {
//			
//			AlteraEmpresas acao = new AlteraEmpresas();
//			nome = acao.executa(request,response);
//			
//			
//		} else if(paramAcao.equals("NovaEmpresas")) {
//			
//			NovaEmpresas acao = new NovaEmpresas();
//			nome = acao.executa(request,response);
//		} else if(paramAcao.equals("NovaEmpresaForm")) {
//			
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request,response);
//		}
//		
		
		
	}
}
