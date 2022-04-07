package com.example.gestionEmpleadosBackend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionEmpleadosBackend.modelo.Empleado;
import com.example.gestionEmpleadosBackend.service.EmpleadoServicio;

@RestController //Establecer que es una API REST
@RequestMapping("empleado") //Establecer que al servicio se entrara por http://localhost:8080/empleado
public class Controlador {
	
	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	@GetMapping("lista")
	public ResponseEntity<List<Empleado>> getAllEmpleados(){
		List<Empleado> empleados = this.empleadoServicio.findAllEmpleados();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	@GetMapping("find/{id}")
	public ResponseEntity<Empleado> getEmpleado( @PathVariable("id") Long id){
		Empleado empleado = this.empleadoServicio.findByIdEmpleado(id);
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<Empleado> addEmpleado( @RequestBody Empleado empleado){
		Empleado newEmpleado = this.empleadoServicio.addEmpleado(empleado);
		return new ResponseEntity<>(newEmpleado, HttpStatus.CREATED);
	}
	
	@PutMapping("update")
	public ResponseEntity<Empleado> updateEmpleado( @RequestBody Empleado empleado){
		Empleado updateEmpleado = this.empleadoServicio.addEmpleado(empleado);
		return new ResponseEntity<>(updateEmpleado, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteEmpleado( @PathVariable("id") Long id){
		this.empleadoServicio.deleteByIdEmpleado(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
