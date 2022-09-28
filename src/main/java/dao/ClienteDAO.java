package dao;
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
	

}
