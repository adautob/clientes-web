package dao;

import java.util.ArrayList;

import model.Cliente;



public class Banco {
	
	public static ArrayList<Cliente> clientes;
	
	public Banco() {
		
	}
	
	public static void inicia() {
		clientes = new ArrayList<Cliente>();
		
		Cliente c1 = new Cliente(1, "Maria", "maria@email.com", "4839844385");
		clientes.add(c1);
		
	}

}
