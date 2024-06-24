package fatec.alertamulher.controller;

import fatec.alertamulher.model.UsuarioDto;
import fatec.alertamulher.model.UsuarioForm;
import fatec.alertamulher.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuario")
@RestController
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody @Validated UsuarioForm usuarioForm) {
        UsuarioDto usuarioDto = service.criarUsuario(usuarioForm);
        return ResponseEntity.ok().body(usuarioDto);
    }
}
