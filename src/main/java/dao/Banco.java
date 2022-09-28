package dao;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;



public class Banco {
	
	private static List<Cliente> lista_cliente = new ArrayList<Cliente>();
	

	public static List<Cliente> getLista_cliente() {
		Cliente c3 = new Cliente(3, "Paulo", "email@email.com", "3435454");
		lista_cliente.add(c3);
		return lista_cliente;
	}

	
	

	
	
}
