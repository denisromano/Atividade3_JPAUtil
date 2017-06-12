package br.com.atividade3.entity;

import java.util.List;

import javax.persistence.EntityManager;

public class PedidosDAO {

	private final GenericDao<Pedidos> dao;

	public PedidosDAO(EntityManager em) {
		dao = new GenericDao<Pedidos>(em, Pedidos.class);
	}

	public void adicionar(Pedidos t) {
		dao.adicionar(t);
	}

	public List<Pedidos> listar() {
		return dao.listar();
	}
	
	public void atualizar(Pedidos t){
		dao.atualizar(t);
	}
	public void remover(Pedidos t){
		dao.remover(t);		
	}
	public Pedidos buscar(int id){
		return dao.buscar(id);
	}	
	
}
