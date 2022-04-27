package com.example.gestionEmpleadosBackend.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionEmpleadosBackend.modelo.Empleado;
import com.example.gestionEmpleadosBackend.repo.IEmpleadoRepo;

@Service // Esta clase alojara diferentes servicios para ser consumidos
public class EmpleadoServicio {

	@Autowired // Evitar que toque inicializar con new.
	private IEmpleadoRepo iempleadoRepo; // Usara el Repositorio IEmpleado para usar sus Servicios heredados de
											// JpaRepository

	// Un servicio debe minimo contener:

	public Empleado addEmpleado(Empleado empleado) {
		empleado.setEmpleadoCode(UUID.randomUUID().toString()); // Establece el Codigo del empleado
		empleado.setImageUrl(this.setEmpleadoImage(empleado));
		return this.iempleadoRepo.save(empleado);
	}

	private String setEmpleadoImage(Empleado empleado) {

		String[] imageNamesM = { "avatar1.png", "avatar2.png", "avatar4.png", "avatar5.png", "avatar6.png",
				"avatar7.png" };
		String[] imageNamesF = { "avatar3.png", "avatar8.png" };

		String webUrl1 = "https://www.bootdey.com/app/webroot/img/Content/avatar/";
		String webUrl2 = "https://www.freeiconspng.com/uploads/person-icon-145444--bryan-le-photography-7.png";

		System.out.println(empleado.getSexo());

		switch (empleado.getSexo()) {
		case "masculino":
			return webUrl1 + imageNamesM[new Random().nextInt(6)];
		case "femenino":
			return webUrl1 + imageNamesF[new Random().nextInt(2)];
		default:
			return webUrl2;
		}

//		if (empleado.getSexo() == "masculino") {
//			return webUrl1 + imageNamesM[new Random().nextInt(6)];
//		} else if (empleado.getSexo() == "femenino") {
//			return webUrl1 + imageNamesF[new Random().nextInt(2)];
//		} else {
//			return webUrl2;
//		}

	}

	public List<Empleado> findAllEmpleados() {// Listar todos los registros de la tabla empleado
		return this.iempleadoRepo.findAll();
	}

	public Empleado updateEmpleado(Empleado empleado) {// Actualizar registro Empleado
		empleado.setImageUrl(this.setEmpleadoImage(empleado));
		return this.iempleadoRepo.save(empleado);
	}

	public void deleteByIdEmpleado(Long id) {
		this.iempleadoRepo.deleteById(id); // Eliminara el registro de la tabla por medio de la ID de ese registro
	}

	public Empleado findByIdEmpleado(Long id) {
		return this.iempleadoRepo.findById(id).get(); // Es necesario agregar .get() para que devuelva el empleado por
														// Id
	}

}
