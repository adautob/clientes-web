package dao;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAO {
	
	
	public ClienteDAO() {
		
	}
	
	public void AdicionarCliente(Cliente c) {
		
		// código para incrementar o ID, pois este não será fornecido pelo usuário
		int idMaior = 0;
		for (Cliente cli : SelecionarTodos()) {
			if (cli.getId() > idMaior) idMaior = cli.getId();
		}

		c.setId(++idMaior);
		Banco.clientes.add(c);
		
	}
	
	public void RemoverCliente(int id) {
		for (int i = 0; i < Banco.clientes.size(); i++) {
			if (Banco.clientes.get(i).getId()==id)
				Banco.clientes.remove(i);
		}
		
		
	}
	
	public ArrayList<Cliente> SelecionarTodos(){
		return Banco.clientes;	
	}
	
	public Cliente getCliente(int index) {
		Cliente cliente = new Cliente();
		for (int i = 0; i < Banco.clientes.size(); i++) {
			if (Banco.clientes.get(i).getId()==index)
				cliente = Banco.clientes.get(i);
		}
		return cliente;
	}
	
	public void AtualizarCliente(int id, Cliente cliente) {
		for (int i = 0; i < Banco.clientes.size(); i++) {
			if (Banco.clientes.get(i).getId()==id)
				Banco.clientes.set(i, cliente);
		}
	}

}
