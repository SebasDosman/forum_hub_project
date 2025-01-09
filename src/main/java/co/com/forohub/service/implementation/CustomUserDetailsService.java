package co.com.forohub.service.implementation;

import co.com.forohub.exceptions.NotFoundException;
import co.com.forohub.repository.UserRepository;
import co.com.forohub.utils.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        if (!userRepository.existsByEmail(email)) throw new NotFoundException(String.format(UserValidator.USER_NOT_FOUND, email));

        return userRepository.findByEmail(email);
    }
}
