package br.com.atividade3.aplication;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.atividade3.entity.Clientes;
import br.com.atividade3.entity.GenericDao;
import br.com.atividade3.entity.JpaUtil;
import br.com.atividade3.entity.Pedidos;
import br.com.atividade3.helper.Helper;

public class Main {
	public static void main(String[] args) {
		//declarando os manipuladores		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atividade2");
		
		
		EntityManager em = JpaUtil.getEntityManager();
		//Helper dao = new Helper(em);
		
		
		try {
			// inserindo cliente
			Clientes cliente = new Clientes();
			cliente.setNome("teste");
			cliente.setEmail("teste@teste.com");
			//salvar
			cliente = dao.incluirCliente(cliente);
			
			

			// inserindo pedidos do cliente
			for (int i = 1; i <= 3; i++) {
				Pedidos pedido = new Pedidos();
				pedido.setData(new Date());
				pedido.setDescricao("Pedido" + i);
				pedido.setValor(i * 100.00);
				
				pedido.setCliente(cliente);
				dao.incluirPedido(pedido);
			}
			
			// busca cliente cliente
			Clientes clienteTeste = null;
			clienteTeste = dao.buscarCliente(cliente.getId());

			// listando os pedidos do cliente			
			System.out.println("Lista Pedidos do " + clienteTeste.getNome() + 
												" ID: "+ clienteTeste.getId());
			List<Pedidos> pedidosCliente = dao.listarPedidosCliente(clienteTeste.getId());
			for (Pedidos pedidos : pedidosCliente) {
				System.out.println(pedidos.getId() + 
									" " + pedidos.getDescricao() + 
									" R$ " + pedidos.getValor());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
	}
}
