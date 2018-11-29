package com.javaee.bruno.service;

import java.util.ArrayList;
import java.util.List;

import com.javaee.bruno.objects.Cliente;
import com.javaee.bruno.objects.Endereco;

public class ClienteService {
	
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private Integer actalId = 1;
	
	public ClienteService() {
		Cliente cliente = new Cliente();
		cliente.setId((long)1);
		cliente.setNome("Bruno Vilas Boas");
		Endereco endereco = new Endereco();
		endereco.setEndereco("Rua ivaí, 1111");
		endereco.setBairro("Lourdes");
		endereco.setCep("32.150.034");;
		endereco.setUf("MG");
		endereco.setCidade("Belo Horizonte");
		cliente.setEndereco(endereco);
		cliente.setEmail("brunoordoni@gmail.com");
		listaCliente.add(cliente);
	}
	
	public List<Cliente> retornaTodos() {
		return listaCliente;
	}

	public Cliente retornaPorId(Integer id) {
		for(Cliente cliente : listaCliente) {
			if(cliente.getId().equals(id)) {
				return cliente;
			}
		}
		return null;
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		
		cliente.setId((long) actalId);

		listaCliente.add(cliente);
		
		return cliente;
	}

}
