package com.catalisa.treinandoseguranca.controller;

import com.catalisa.treinandoseguranca.model.UsuarioModel;
import com.catalisa.treinandoseguranca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/usuarios")
    public ResponseEntity<List<UsuarioModel>> buscarPorUsuario() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping(path = "/usuarios/{codigo}")
    public ResponseEntity<Optional<UsuarioModel>> buscarPorId(@PathVariable Long codigo) {
        return ResponseEntity.ok(usuarioService.buscarId(codigo));
    }

    @PostMapping(path = "/usuarios/create")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel) {
        UsuarioModel usuario = usuarioService.cadastrar(usuarioModel);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping(path = "/usuarios/{codigo}")
    public ResponseEntity<UsuarioModel> alterarUsuario(@RequestBody UsuarioModel usuarioModel, @PathVariable Long codigo) {
        return ResponseEntity.ok(usuarioService.alterar(usuarioModel, codigo));
    }

    @DeleteMapping(path = "/usuarios/{codigo}")
    public void deletarUsuario(@PathVariable Long codigo) {
        usuarioService.deletar(codigo);
    }
}
