package com.catalisa.treinandoseguranca.service;

import com.catalisa.treinandoseguranca.model.UsuarioModel;
import com.catalisa.treinandoseguranca.model.dto.UsuarioDto;
import com.catalisa.treinandoseguranca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<UsuarioDto> buscarTodos() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return UsuarioDto.convert(usuarios);
    }

    public Optional<UsuarioModel> buscarId(Long codigo) {
        return usuarioRepository.findById(codigo);
    }

    public UsuarioModel cadastrar(UsuarioModel usuarioModel) {
        usuarioModel.setSenha(bCryptPasswordEncoder().encode(usuarioModel.getSenha()));
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