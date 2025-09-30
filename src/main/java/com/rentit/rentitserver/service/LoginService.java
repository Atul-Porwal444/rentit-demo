package com.rentit.rentitserver.service;

import com.rentit.rentitserver.payload.LoginRequest;
import com.rentit.rentitserver.payload.LoginResponse;
import com.rentit.rentitserver.repository.UserRepository;
import com.rentit.rentitserver.util.JWTUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

//    public ResponseEntity<?> login(LoginRequest loginRequest) {
//        try {
//            if(userRepository.existsByEmail(loginRequest.getEmail()) && userRepository.findByEmail(loginRequest.getEmail()).get().getPassword().equals(loginRequest.getPassword())) {
//                return ResponseEntity.ok(new LoginResponse("success","Login successful! Here is your JWT token!"));
//            }
//            return new ResponseEntity<>(new LoginResponse("error","Invalid username or password!"), HttpStatus.UNAUTHORIZED);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new LoginResponse("error","Something went wrong on the server!"));
//        }
//    }

    public ResponseEntity<?> secureLogin(LoginRequest loginRequest, HttpServletResponse response, CsrfToken csrfToken) {

        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()

                    )
            );

            if(authenticate.isAuthenticated()) {
                String token = jwtUtil.generateToken(loginRequest.getEmail());
                Cookie jwtCookie = new Cookie("JWT", token);
                jwtCookie.setHttpOnly(true);
                jwtCookie.setSecure(false);
                jwtCookie.setMaxAge(86400);
                jwtCookie.setPath("/");
                response.addCookie(jwtCookie);
                return ResponseEntity.ok(new LoginResponse("success", csrfToken.getToken(),"Login successful!"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new  LoginResponse("error", "","Invalid username or password!"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new  LoginResponse("error", "","Invalid username or password!"));

    }
}
