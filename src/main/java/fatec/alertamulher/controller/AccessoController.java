package fatec.alertamulher.controller;

import fatec.alertamulher.model.Login;
import fatec.alertamulher.service.AcessoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccessoController {
    private final AcessoService service;

    @PostMapping
    public ResponseEntity<String> login(@Validated Login login) {
        String code = service.login(login);
        return ResponseEntity.ok(code);
    }
}
