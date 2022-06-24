package controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet({ "/Controller", "/main", "/inserir","/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans javaBeans = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getServletPath());
		if (request.getServletPath().equals("/main")) {
			funcionarios(request, response);

		} else if (request.getServletPath().equals("/inserir")) {
			novoContato(request, response);

		} else if(request.getServletPath().equals("/delete")){
			delete(request,response);
			
			
		}else {
			response.sendRedirect("index.html");
		}

	}

	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		javaBeans.setNome(nome);
		javaBeans.setCpf(cpf);
		javaBeans.setTelefone(telefone);
		javaBeans.setEmail(email);

		dao.inserirFuncionario(javaBeans);
		response.sendRedirect("index.html");

	}

	
	protected void funcionarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<JavaBeans> lista = dao.recuperaFuncionario();
		
		
		request.setAttribute("funcionarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
		
	}
		
	
		
		

	


	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("idfunc");
		javaBeans.setIdfunc(Integer.parseInt(id));
		dao.deletar(javaBeans);
		response.sendRedirect("index.html");

		
		
		
	}
	
	
	
	
	
	
	
	
}
