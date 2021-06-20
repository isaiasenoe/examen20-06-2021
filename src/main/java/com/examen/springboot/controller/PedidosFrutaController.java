package com.examen.springboot.controller;

/*
 * Isaías Cortés
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.springboot.model.PedidosFruta;
import com.examen.springboot.model.PedidosFrutaPojo;
import com.examen.springboot.service.PedidosFrutaService;

@RestController
@RequestMapping("/api/pedidosfruta")
public class PedidosFrutaController {

	@Autowired
	private PedidosFrutaService pedidosFrutaService;
	
	PedidosFruta pedidoInsert = null;


	public PedidosFrutaController(PedidosFrutaService pedidosFrutaService) {
		super();
		this.pedidosFrutaService = pedidosFrutaService;
	}

	@GetMapping("/listafrutas")
	public ResponseEntity<?> listarPediosFruta() {
		return ResponseEntity.ok().body(pedidosFrutaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(Long id) {
		PedidosFruta pedidosFruta = pedidosFrutaService.findById(id);
		if (pedidosFruta == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok().body(pedidosFruta);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearPedido(@RequestBody PedidosFruta pedidosFruta){
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidosFrutaService.save(pedidosFruta));
	}
	
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizar(@RequestBody PedidosFruta pedidosFruta, @PathVariable Long id) {
		PedidosFruta pedidoActual = this.pedidosFrutaService.findById(id);
		if (pedidoActual == null) {
			return ResponseEntity.noContent().build();
		}
		pedidoActual.setNombre(pedidosFruta.getNombre());
		pedidoActual.setClave(pedidosFruta.getClave());
		pedidoActual.setEstatus(pedidosFruta.getEstatus());
		pedidoActual.setFechaModificacion(pedidosFruta.getFechaModificacion());
		pedidosFrutaService.save(pedidoActual);
		return new ResponseEntity( HttpStatus.OK); //respuesta para que sepa si hay error o no el cliente sabe perfectamente cuando hay un error
	}

}
