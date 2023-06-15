package net.figueiredo.java.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.figueiredo.java.demoapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}