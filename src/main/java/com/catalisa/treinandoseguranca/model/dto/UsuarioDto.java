package com.catalisa.treinandoseguranca.model.dto;

import com.catalisa.treinandoseguranca.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long codigo;
    private String nome;
    private String login;
    private String senha;

    public UsuarioDto(UsuarioModel usuarioModel) {
        this.codigo = usuarioModel.getCodigo();
        this.nome = usuarioModel.getNome();
        this.login = usuarioModel.getLogin();
        this.senha = usuarioModel.getSenha();
    }

    public static List<UsuarioDto> convert(List<UsuarioModel> usuarioModels) {
        return usuarioModels.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }
}
