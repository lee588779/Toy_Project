package me.donghyunLee.springbootdeveloper.repository;

import me.donghyunLee.springbootdeveloper.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Ref;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken>findByUserId(Long UserId);
    Optional<RefreshToken>findByRefreshToken(String refreshToken);
}
