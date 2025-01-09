package co.com.forohub.service.implementation;

import co.com.forohub.domain.User;
import co.com.forohub.dto.user.UserRequest;
import co.com.forohub.dto.user.UserResponse;
import co.com.forohub.exceptions.NotFoundException;
import co.com.forohub.mappers.UserMapper;
import co.com.forohub.repository.UserRepository;
import co.com.forohub.service.IUserService;
import co.com.forohub.utils.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Slice<UserResponse> findAll(Pageable pageable) {
        return UserMapper.toUserResponseSlice(userRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse findById(Long id) {
        if (!userRepository.existsById(id)) throw new NotFoundException(String.format(UserValidator.USER_NOT_FOUND, id));

        return UserMapper.toUserResponse(userRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public UserResponse update(UserRequest userRequest) {
        if (!userRepository.existsById(userRequest.getId())) throw new NotFoundException(String.format(UserValidator.USER_NOT_FOUND, userRequest.getId()));

        User user = userRepository.getReferenceById(userRequest.getId());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return UserMapper.toUserResponse(userRepository.save(UserMapper.toUser(userRequest, bCryptPasswordEncoder.encode(userRequest.getPassword()), user.getProfiles())));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) throw new NotFoundException(String.format(UserValidator.USER_NOT_FOUND, id));

        userRepository.deleteById(id);
    }
}