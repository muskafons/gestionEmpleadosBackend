package com.example.gestionEmpleadosBackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionEmpleadosBackend.modelo.Empleado;

public interface IEmpleadoRepo extends JpaRepository<Empleado, Long> {

}
