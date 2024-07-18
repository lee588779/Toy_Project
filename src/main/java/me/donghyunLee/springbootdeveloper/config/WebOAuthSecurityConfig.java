package me.donghyunLee.springbootdeveloper.config;

import lombok.RequiredArgsConstructor;
import me.donghyunLee.springbootdeveloper.config.jwt.TokenProvider;
import me.donghyunLee.springbootdeveloper.config.oauth.OAuth2UserCustomService;
import me.donghyunLee.springbootdeveloper.repository.RefreshTokenRepository;
import me.donghyunLee.springbootdeveloper.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class WebOAuthSecurityConfig {
    private final OAuth2UserCustomService oAuth2UserCustomService;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserService userService;

    @Bean
    public webSecurityCustomizer configure(){
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console)
                .requestMatchers("/img/**", "/css/**", "/js/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
