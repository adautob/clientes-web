package dao;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAO {
	
	public ClienteDAO() {
		
	}
	
	public void AdicionarCliente(Cliente cliente) {
		Banco.clientes.add(cliente);
		
	}
	
	public boolean RemoverCliente(Cliente cliente) {
		return Banco.clientes.remove(cliente);
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
