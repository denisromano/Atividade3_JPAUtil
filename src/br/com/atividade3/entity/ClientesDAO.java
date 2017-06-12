package br.com.atividade3.entity;

import java.util.List;

import javax.persistence.EntityManager;

public class ClientesDAO {
	private final GenericDao<Clientes> dao;

	public ClientesDAO(Class<Clientes> Cliente) {
		this.dao = em;
	}

	public void adicionar(Clientes t) {
		dao.adicionar(t);
	}

	public List<Clientes> listar() {
		return dao.listar();
	}
	
	public void atualizar(Clientes t){
		dao.atualizar(t);
	}
	public void remover(Clientes t){
		dao.remover(t);		
	}
	public Clientes buscar(int id){
		return dao.buscar(id);
	}

}
