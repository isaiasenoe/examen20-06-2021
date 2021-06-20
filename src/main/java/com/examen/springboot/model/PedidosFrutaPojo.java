package com.examen.springboot.model;
/*
 * Isaías Cortés
*/

public class PedidosFrutaPojo {
	private Long id;
	private int clave;
	private String nombre;
	private int estatus;
	private String fechaModificacion;
		
	public PedidosFrutaPojo(Long id, int clave, String nombre, int estatus, String fechaModificacion) {
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
		this.estatus = estatus;
		this.fechaModificacion = fechaModificacion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	

}