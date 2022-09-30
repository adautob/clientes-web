package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import dao.ClienteDAO;
import model.Cliente;


@WebServlet(urlPatterns = {"/Controller", "/delete", "/select", "/update", "/insert"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Cliente cliente = new Cliente();
	
	ClienteDAO clienteDAO = new ClienteDAO();

    public Controller() {
        super();
		Banco.inicia();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		if (action.equals("/Controller")) {
			clientes(request, response);
		} else if (action.equals("/select")) {
			listarCliente(request, response);
		} else if (action.equals("/update")) {
			editarCliente(request, response);
		} else if (action.equals("/insert")) {
			adicionarCliente(request, response);
		} else if (action.equals("/delete")){
			removerCliente(request, response);
		}
	}
	
	protected void clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Cliente> lista = Banco.clientes;
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
		
	}
	
	protected void removerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		clienteDAO.RemoverCliente(id);	
		response.sendRedirect("Controller");
	}
	
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente = clienteDAO.getCliente(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("id", cliente.getId());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("telefone", cliente.getTelefone());
		RequestDispatcher rd = request.getRequestDispatcher("/editar.jsp");
		rd.forward(request, response);
		
	}
	
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTelefone(request.getParameter("telefone"));
		clienteDAO.AtualizarCliente(cliente.getId(), cliente);
		response.sendRedirect("Controller");
	}
	
	protected void adicionarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setId(0);
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTelefone(request.getParameter("telefone"));
		clienteDAO.AdicionarCliente(cliente);
		response.sendRedirect("Controller");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
