package dao;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAO {
	
	public ClienteDAO() {
		
	}
	
	public void AdicionarCliente(Cliente cliente) {
		Banco.clientes.add(cliente);
		
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
		return Banco.clientes.get(index);
	}
	
	public void AtualizarCliente(int index, Cliente cliente) {
		Banco.clientes.set(index, cliente);
	}

}
