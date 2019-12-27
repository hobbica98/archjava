package it.liviu.ledger.configuration;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
	private static Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        log.info("username: {}", username);
        log.info("password: {}", password);
        
        if (checkUsernamePassword(username, password)) {
  
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
              username, password, new ArrayList<>());
        } else {
            return null;
        }
    }
 
    private boolean checkUsernamePassword(String username, String password) {
    	
		// TODO Implementare controllando validità username e password
    	
		return username.equalsIgnoreCase("test");
	}

	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}