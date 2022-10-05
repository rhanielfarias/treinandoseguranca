package com.catalisa.treinandoseguranca.service;

import com.catalisa.treinandoseguranca.model.UsuarioModel;
import com.catalisa.treinandoseguranca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarId(Long codigo) {
        return usuarioRepository.findById(codigo);
    }

    public UsuarioModel cadastrar(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alterar(UsuarioModel usuario, Long codigo) {
        usuario.getCodigo();
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long codigo) {
        usuarioRepository.deleteById(codigo);
    }


}