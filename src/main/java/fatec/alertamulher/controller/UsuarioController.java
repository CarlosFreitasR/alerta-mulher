package fatec.alertamulher.controller;

import fatec.alertamulher.model.UsuarioDto;
import fatec.alertamulher.model.UsuarioForm;
import fatec.alertamulher.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody @Validated UsuarioForm usuarioForm) {
        UsuarioDto usuarioDto = service.criarUsuario(usuarioForm);
        return ResponseEntity.ok().body(usuarioDto);
    }

    @GetMapping("/home/{pk}")
    public String mostrarUsuarios(@PathVariable Long pk) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNomeUsuario("teste");
        return "/inicio";
    }
}
