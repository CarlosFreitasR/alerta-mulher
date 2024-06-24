package fatec.alertamulher.service;

import fatec.alertamulher.model.Login;
import fatec.alertamulher.repository.AcessoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Base64;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AcessoService {
    private final AcessoRepository repository;

    public String login(Login login) {
        try {
            var random = SecureRandom.getInstanceStrong();
            String code = Base64.getEncoder().withoutPadding().encodeToString(random.toString().getBytes());
            login.setCode(code);
            login.setDataLogin(LocalDate.now());
            repository.save(login);
            return code;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
