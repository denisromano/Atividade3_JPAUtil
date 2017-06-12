package br.com.atividade3.entity;

import java.util.List;

public interface Dao<T> {
	void adicionar(T entidade);
	List<T> listar();
	void atualizar(T entidade);
	void remover(T entidade);
	T buscar(int id);
}
