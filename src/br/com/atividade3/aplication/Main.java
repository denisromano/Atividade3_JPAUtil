package br.com.atividade3.aplication;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import br.com.atividade3.entity.Clientes;
import br.com.atividade3.entity.Dao;
import br.com.atividade3.entity.GenericDao;
import br.com.atividade3.entity.Pedidos;

public class Main {
	public static void main(String[] args) {

		
		try {
			// inserindo cliente
			Clientes cliente = new Clientes();
			cliente.setNome("teste");
			cliente.setEmail("teste@teste.com");
			
			Dao<Clientes> clientesDao = new GenericDao<>(Clientes.class);
			//salvar
			clientesDao.adicionar(cliente);
			
			
			Dao<Pedidos> pedidosDao = new GenericDao<>(Pedidos.class);
			// inserindo pedidos do cliente
			for (int i = 1; i <= 3; i++) {
				Pedidos pedido = new Pedidos();
				pedido.setData(new Date());
				pedido.setDescricao("Pedido" + i);
				pedido.setValor(i * 100.00);
				
				pedido.setCliente(cliente);
				pedidosDao.adicionar(pedido);
								
			}
			System.out.println("Pedidos Inseridos");
			// busca cliente cliente
			List<Clientes> exibeClientes = new ArrayList<Clientes>();
			
			exibeClientes = clientesDao.listar();

	        for (Clientes listarcliente: exibeClientes) {
	        	System.out.println("Nome: " + listarcliente.getNome() + " - EMail: " + listarcliente.getEmail() );
	        }			

	        List<Pedidos> exibirPedidos = new ArrayList<Pedidos>();
			exibirPedidos = pedidosDao.listar();				
				            
	        for (Pedidos listapedido: exibirPedidos) {
	        	System.out.println("Descricao: " + listapedido.getDescricao() + " - Valor: " + listapedido.getValor() );
	        }
	        
	        Clientes clienteAtualiza = clientesDao.buscar(1);
	        clienteAtualiza.setNome("testeAtualizado2");
	        clienteAtualiza.setEmail("teste@teste3.com");
	        
	        clientesDao.atualizar(clienteAtualiza);
	        System.out.println("Cliente atualizado");

			for (int i = 1; i <= 3; i++) {	        
	        
	        Pedidos buscaPed = pedidosDao.buscar(i);
	        	        
	        buscaPed.setDescricao("Pedido " + buscaPed.getId() + " Atualizado");
	        
	        pedidosDao.atualizar(buscaPed);
	        System.out.println("Pedido " + buscaPed.getId() + " Atualizado");
	        
	        
			}
	        /*
	         * Remove usuario			
	         */
			Pedidos removPed = pedidosDao.buscar(3);
			System.out.println("Remover pedido 3");
			pedidosDao.remover(removPed);

			/*Clientes clienteTeste = null;
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
		    */
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			//em.close();
		}
	}
}
