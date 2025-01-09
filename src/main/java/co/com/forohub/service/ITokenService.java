package co.com.forohub.service;

import co.com.forohub.domain.User;

public interface ITokenService {
    String generateToken(User user) throws Exception;
    String getSubject(String token) throws Exception;
}
