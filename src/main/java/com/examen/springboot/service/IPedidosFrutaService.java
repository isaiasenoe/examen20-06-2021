package com.examen.springboot.service;
/*
 * Isaías Cortés
*/
import java.util.List;

import com.examen.springboot.model.PedidosFruta;

public interface IPedidosFrutaService {
	
	List<PedidosFruta> findAll();

	PedidosFruta findById(Long id);

	PedidosFruta save(PedidosFruta pedidosFruta);

	void deleteById(Long id);

}
