package br.com.mjoffice.Projeto.MJ.Office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjoffice.Projeto.MJ.Office.dto.UsuarioDTO;
import br.com.mjoffice.Projeto.MJ.Office.entity.UsuarioEntity;
import br.com.mjoffice.Projeto.MJ.Office.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> listarTodos(){
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
		
	}
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	
	public void excluir(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}
}
