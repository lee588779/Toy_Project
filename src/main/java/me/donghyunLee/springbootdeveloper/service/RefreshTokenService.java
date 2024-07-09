package me.donghyunLee.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.donghyunLee.springbootdeveloper.domain.RefreshToken;
import me.donghyunLee.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalAccessException("Unexpected token"));
    }
}
