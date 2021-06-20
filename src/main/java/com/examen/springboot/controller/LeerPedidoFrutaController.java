package com.examen.springboot.controller;
/*
 * Isaías Cortés
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class LeerPedidoFrutaController {

	@Autowired
	private PedidosFrutaService pedidosFrutaService;
	
	PedidosFruta pedidoInsert = null;

	public LeerPedidoFrutaController(PedidosFrutaService pedidosFrutaService) {
		super();
		this.pedidosFrutaService = pedidosFrutaService;
	}

	@GetMapping
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
	
	@RequestMapping("/leer/pedidosfruta")
	public void insertarPedidoFruta() throws ParseException {
		String filePath = "archivocsv.csv";
		List<PedidosFrutaPojo> pedido = new ArrayList<>();
		try (Stream<String> streamfile = Files.lines(Paths.get(filePath))){
			pedido = streamfile.map(linea -> linea.split(",")).map(arreglo ->{
				PedidosFrutaPojo ped = new PedidosFrutaPojo(Long.parseLong(arreglo[0]), Integer.parseInt(arreglo[1]), arreglo[2], Integer.parseInt(arreglo[3]), arreglo[4]);
				return ped;
			}).collect(Collectors.toList());
			//pedido.forEach(x -> System.out.println(x.getId()+ " " +  x.getNombre()+ " " + x.getTotal() + " " + x.getFechaModificacion()));

			 crearPedido(pedido);

		} catch (IOException io) {
			System.err.println("error en la lectura de archivos" + io.getMessage() );
		}
	}
	
	@PostMapping
	public ResponseEntity<?> crearPedido(@RequestBody List<PedidosFrutaPojo> pedido) throws ParseException{
		Long count = 6l;
		for(PedidosFrutaPojo p : pedido) {
			count = count +1;
			pedidoInsert = new PedidosFruta();
			pedidoInsert.setId(p.getId());
			pedidoInsert.setNombre(p.getNombre());
			pedidoInsert.setClave(p.getClave());
			pedidoInsert.setEstatus(p.getEstatus());
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date fecha = formato.parse(p.getFechaModificacion());
			pedidoInsert.setFechaModificacion(fecha);
			pedidosFrutaService.save(pedidoInsert);
		}
		return listarPediosFruta();
	}
	
	
}
