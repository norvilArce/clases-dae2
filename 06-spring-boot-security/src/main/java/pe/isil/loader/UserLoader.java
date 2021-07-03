package pe.isil.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.isil.model.User;
import pe.isil.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class UserLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        List<User> users = new ArrayList<>(
                Arrays.asList(
                        new User("jose", passwordEncoder.encode("123456")),
                        new User("franco", passwordEncoder.encode("abc123"))
                )
        );
        userRepository.saveAll(users);
    }
}
