package com.unla.Grupo18.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo18.entities.Usuario;
import com.unla.Grupo18.repositories.IUsuarioRepository;
import com.unla.Grupo18.services.IUsuarioService;


@Service("usuarioService")
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscar(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void eliminar(long id) {
		usuarioRepository.deleteById(id);
	}
}
