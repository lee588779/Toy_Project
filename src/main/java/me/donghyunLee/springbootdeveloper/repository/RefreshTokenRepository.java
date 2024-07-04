package me.donghyunLee.springbootdeveloper.repository;

import me.donghyunLee.springbootdeveloper.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {
    Optional<RefreshToken>findByUserId(Long UserId);
    Optional<RefreshToken>RefreshToken(String refreshToken);
}
