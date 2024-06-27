package fatec.alertamulher.controller;

import fatec.alertamulher.model.UsuarioDto;
import fatec.alertamulher.model.UsuarioForm;
import fatec.alertamulher.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody @Validated UsuarioForm usuarioForm) {
        UsuarioDto usuarioDto = service.criarUsuario(usuarioForm);
        return ResponseEntity.ok().body(usuarioDto);
    }

    @GetMapping
    public String iniciarCadastro(Model model) {
        model.addAttribute("content", "cadastro");
        return "main";
    }
}
