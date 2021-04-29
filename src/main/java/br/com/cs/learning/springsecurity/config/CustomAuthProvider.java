package br.com.cs.learning.springsecurity.config;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println(authentication);

		// CUSTOM AUTH METHOD
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();

		if (userName.equals("Carlos") && password.equals("123")) {
			System.out.println("Authenticated!!!!!");
			return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
		}

		throw new BadCredentialsException("Invalid username or password");
	}

	// SAYS THAT THIS SUPPORT USER/PASSWORD AUTH
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
