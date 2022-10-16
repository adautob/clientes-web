package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.ClienteDAO;
import model.Cliente;

public class ControllerService {

	ClienteDAO clienteDAO = new ClienteDAO();

	public ControllerService() {
		super();
	}

	public List<Cliente> listaClientes() {
		return clienteDAO.SelecionarTodos();
	}

	public void removerCliente(int id) {
		clienteDAO.RemoverCliente(id);

	}

	public Cliente getCliente(int id) {
		return clienteDAO.getCliente(id);

	}

	public void adicionarCliente(Cliente c) {
		clienteDAO.AdicionarCliente(c);

	}

	public void atualizarCliente(Integer id, String nome, String email, String telefone) {
		Cliente cliente = new Cliente(id, nome, email, telefone);
		clienteDAO.AtualizarCliente(id, cliente);
	}

	public HttpServletRequest preencherEditarRequest(HttpServletRequest request) {
		Cliente cli = clienteDAO.getCliente(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("id", cli.getId());
		request.setAttribute("nome", cli.getNome());
		request.setAttribute("email", cli.getEmail());
		request.setAttribute("telefone", cli.getTelefone());

		return request;
	}

}
