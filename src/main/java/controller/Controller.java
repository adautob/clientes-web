package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Banco;
import model.Cliente;
import service.ControllerService;

@WebServlet(urlPatterns = { "/Controller", "/delete", "/select", "/update", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ControllerService controllerService = new ControllerService();

	public Controller() {

		Banco.inicia();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Verifica path recebido no request para redirecionar url
		String action = request.getServletPath();
		switch (action) {
		case "/Controller":
			clientes(request, response);
			break;
		case "/select":
			listarCliente(request, response);
			break;
		case "/update":
			editarCliente(request, response);
			break;
		case "/insert":
			adicionarCliente(request, response);
			break;
		case "/delete":
			removerCliente(request, response);
			break;
		}
	}

	// pega lista de cliente e manda na requisição
	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("clientes", controllerService.listaClientes());
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);

	}

	// utiliza o serviço para remover o cliente e redireciona para o /Controller
	protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		controllerService.removerCliente(id);
		response.sendRedirect("Controller");
	}

	// pega cliente e monta o request para exibir na tela de editar
	protected void listarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpServletRequest req = controllerService.preencherEditarRequest(request);
		
		RequestDispatcher rd = req.getRequestDispatcher("/editar.jsp");
		rd.forward(req, response);

	}

	// envia dados do request para o controllerService atualizar o cliente no banco
	// e redireciona para o /Controller
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		controllerService.atualizarCliente(id, nome, email, telefone);
		response.sendRedirect("Controller");
	}

	// chama o service para adicionar novo cliente no banco
	protected void adicionarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente c = new Cliente();
		c.setId(0);
		c.setNome(request.getParameter("nome"));
		c.setEmail(request.getParameter("email"));
		c.setTelefone(request.getParameter("telefone"));
		controllerService.adicionarCliente(c);
		response.sendRedirect("Controller");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
