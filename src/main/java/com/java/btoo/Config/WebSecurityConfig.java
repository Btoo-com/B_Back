package com.java.btoo.Config;

import com.java.btoo.Provider.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class WebSecurityConfig {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll(); // 누구나 h2-console 접속 허용
        http
                .httpBasic().disable() // rest api 만을 고려하여 기본 설정은 해제하겠습니다.
                .csrf().disable() // csrf 보안 토큰 disable처리.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 역시 사용하지 않습니다.
                .and()
                .authorizeRequests() // 요청에 대한 사용권한 체크
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().permitAll() // 그외 나머지 요청은 누구나 접근 가능
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests(); // 권한요청 처리 설정 메서드

        // JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 전에 넣는다
    }
    @RequiredArgsConstructor
    public class JwtAuthenticationFilter extends GenericFilterBean {

        private final JwtTokenProvider jwtTokenProvider;

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException, IOException {
            // 헤더에서 JWT 를 받아옵니다.
            String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
            // 유효한 토큰인지 확인합니다.
            if (token != null && jwtTokenProvider.validateToken(token)) {
                // 토큰이 유효하면 토큰으로부터 유저 정보를 받아옵니다.
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                // SecurityContext 에 Authentication 객체를 저장합니다.
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("토큰 유효하다");
            }
            chain.doFilter(request, response);
        }
    }
}
