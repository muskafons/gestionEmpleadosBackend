package com.example.gestionEmpleadosBackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionEmpleadosBackend.modelo.Empleado;
import com.example.gestionEmpleadosBackend.repo.IEmpleadoRepo;

@Service // Esta clase alojara diferentes servicios para ser consumidos
public class EmpleadoServicio {

	@Autowired //Evitar que toque inicializar con new.
	private IEmpleadoRepo iempleadoRepo; // Usara el Repositorio IEmpleado para usar sus Servicios heredados de
											// JpaRepository

	// Un servicio debe minimo contener:
	
	public Empleado addEmpleado(Empleado empleado) {
		empleado.setEmpleadoCode(UUID.randomUUID().toString()); // Establece el Codigo del empleado
		return this.iempleadoRepo.save(empleado);
	}

	public List<Empleado> findAllEmpleados() {// Listar todos los registros de la tabla empleado
		return this.iempleadoRepo.findAll();
	}

	public Empleado updateEmpleado(Empleado empleado) {// Actualizar registro Empleado
		return this.iempleadoRepo.save(empleado);
	}

	public void deleteByIdEmpleado(Long id) { 
		this.iempleadoRepo.deleteById(id); // Eliminara el registro de la tabla por medio de la ID de ese registro
	}

	public Empleado findByIdEmpleado(Long id) {
		return this.iempleadoRepo.findById(id).get(); // Es necesario agregar .get() para que devuelva el empleado por Id
	}
	
	

}
