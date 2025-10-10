package com.example.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.AuthRequest;
import com.example.Util.JwtUtil;

@RestController
public class AuthController {
	@Autowired
	JwtUtil jw;
	
    @Autowired
    private final AuthenticationManager authenticationManager;

    AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

	@PostMapping("/authenticate")
	public String GenerateToken(@RequestBody AuthRequest ar)
	{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(ar.getUsername(), ar.getPassword()));
		return jw.generateToken(ar.getUsername());
	}

}
