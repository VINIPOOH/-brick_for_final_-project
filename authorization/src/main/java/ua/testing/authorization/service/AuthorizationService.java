package ua.testing.authorization.service;


import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.testing.authorization.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("There is no user with login: " + email));

    }
}
