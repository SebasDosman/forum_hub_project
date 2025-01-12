package co.com.forohub.application.service;

import co.com.forohub.domain.entities.User;

public interface ITokenService {
    String generateToken(User user) throws Exception;
    String getSubject(String token) throws Exception;
    Long getExpirationTime(String token) throws Exception;
}
