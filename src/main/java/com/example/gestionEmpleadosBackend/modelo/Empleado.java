package com.example.gestionEmpleadosBackend.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Anotacion @Entity para que se pueda mapear en una DB
public class Empleado implements Serializable {
	// Se hace Serializable para que no haya problemas cuando se guarde en DB,
	// Se hace Serializable para que no haya problemas en ser consultado desde
	// FrontEnd

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Para que la llave se autogenere en los registros de la Tabla
	@Column(nullable = false, updatable = false) // No puede estar vacia, No puede actualizarse
	private Long id;

	@Column(nullable = false, updatable = false) // No puede estar vacia, No puede actualizarse
	private String empleadoCode;
	
	private String name;
	private String email;
	private String cargo;
	private String phone;
	private String sexo;
	private String imageUrl;
		
	public Empleado() {
	}

	public Empleado(Long id, String name, String email, String cargo, String phone, String imageUrl,
			String empleadoCode, String sexo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cargo = cargo;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.empleadoCode = empleadoCode;
		this.sexo = sexo;
	}



	// TO-DO Usar lombok para definir setters and getters automaticamente

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEmpleadoCode() {
		return empleadoCode;
	}

	public void setEmpleadoCode(String empleadoCode) {
		this.empleadoCode = empleadoCode;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Empleado {" + this.getId() + "/" + this.getName() + "/" + this.getEmail() + "/" + this.getCargo() + "/"
				+ this.getPhone() + "/" + this.getImageUrl() + this.getSexo() + "}";
	}

}
