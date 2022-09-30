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


@WebServlet(urlPatterns = {"/Controller", "/delete"})
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
