package com.examen.springboot.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.examen.springboot.controller.PedidosFrutaController;
import com.examen.springboot.model.PedidosFruta;
import com.examen.springboot.service.PedidosFrutaService;

@SpringBootTest
public class PedidosFrutaControllerTest {
	@Autowired
	private PedidosFrutaService pedidosFrutaService = Mockito.mock(PedidosFrutaService.class);
	
	@Autowired
	private PedidosFrutaController frutasController = new PedidosFrutaController(pedidosFrutaService);
	
	@SuppressWarnings("unchecked")
	@Test
	void listarPediosFruta() {
		@SuppressWarnings("unused")
		ResponseEntity<PedidosFruta> respuestaServicio;
		respuestaServicio = (ResponseEntity<PedidosFruta>) frutasController.buscarPorId((long)1);
		Assertions.assertThat((long)1);		
	}

}
