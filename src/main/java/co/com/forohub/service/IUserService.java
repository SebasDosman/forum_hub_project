package co.com.forohub.service;

import co.com.forohub.dto.user.CreateUserRequest;
import co.com.forohub.dto.user.UserRequest;
import co.com.forohub.dto.user.UserResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IUserService {
    Slice<UserResponse> findAll(Pageable pageable);
    UserResponse findById(Long id);
    UserResponse update(UserRequest userRequest);
    void delete(Long id);
}
