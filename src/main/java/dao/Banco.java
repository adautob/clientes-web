package dao;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;



public class Banco {
	
	public static ArrayList<Cliente> clientes;
	
	public Banco() {
		
	}
	
	public static void inicia() {
		clientes = new ArrayList<Cliente>();
		
		Cliente c1 = new Cliente(1, "Maria", "maria@email.com", "4839844385");
		Cliente c2 = new Cliente(2, "Adauto", "adauto@email.com", "991644475");
		Cliente c3 = new Cliente(3, "Amanda", "amanda@email.com", "991131049");
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		
	}

}
