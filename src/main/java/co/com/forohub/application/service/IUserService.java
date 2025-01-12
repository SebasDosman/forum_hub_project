package co.com.forohub.application.service;

import co.com.forohub.domain.dto.user.UserRequest;
import co.com.forohub.domain.dto.user.UserResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IUserService {
    Slice<UserResponse> findAll(Pageable pageable);
    UserResponse findById(Long id);
    UserResponse update(UserRequest userRequest);
    void delete(Long id);
}
