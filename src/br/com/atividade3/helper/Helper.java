package br.com.atividade3.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.atividade3.entity.Clientes;
import br.com.atividade3.entity.Pedidos;

public class Helper {

	private EntityManager em;

	public Helper(EntityManager em) {
		this.em = em;
	}

	// método salvar objeto
	public Clientes incluirCliente(Clientes cliente) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			System.out.println("Cliente Gravado com Sucesso!");
		} catch (Exception e) {
			throw e;
		}
		return cliente;
	}

	public void incluirPedido(Pedidos pedido) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(pedido);
			em.getTransaction().commit();
			System.out.println("Pedido Gravado com Sucesso!");
		} catch (Exception e) {
			throw e;
		}
	}

	// método retornar um único objeto
	public Clientes buscarCliente(int idCliente) throws Exception {
		TypedQuery<Clientes> typedQuery = em
				.createQuery("SELECT c " + 
							"FROM Clientes c " + 
							"WHERE c.id=:idCliente", Clientes.class);
		typedQuery.setParameter("idCliente", idCliente);

		return typedQuery.getSingleResult();
	}
	public Pedidos buscarPedido(int idPedido) throws Exception {
		TypedQuery<Pedidos> typedQuery = em
				.createQuery("SELECT p " + 
							"FROM Pedidos p " + 
							"WHERE p.id=:idPedido", Pedidos.class);
		typedQuery.setParameter("idPedido", idPedido);
		
		return typedQuery.getSingleResult();
	}

	// método retornar lista objetos
	public List<Pedidos> listarPedidosCliente(int idCliente) throws Exception {
		TypedQuery<Pedidos> typedQuery = em
				.createQuery("SELECT p " + 
							"FROM Pedidos p " + 
							"WHERE p.cliente.id=:idCliente", Pedidos.class);
		typedQuery.setParameter("idCliente", idCliente);
		
		return typedQuery.getResultList();
	}
	
	// método retornar lista com todos objetos
	public List<Clientes> listarClientes() throws Exception {
		TypedQuery<Clientes> typedQuery = em.createNamedQuery("Clientes.findAll", Clientes.class);
		
		return typedQuery.getResultList();
	}

}
