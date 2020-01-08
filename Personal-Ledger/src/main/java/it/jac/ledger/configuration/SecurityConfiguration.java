package it.jac.ledger.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration  
@EnableWebSecurity  
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {  
    @Override  
    public void configure(HttpSecurity http) throws Exception {  
        http  
            .authorizeRequests()
            .antMatchers( "/*.css").permitAll()  
            .antMatchers( "/*.TTF").permitAll()  
            .antMatchers( "/*.jpg").permitAll() 
            .antMatchers( "/register").permitAll()
            .anyRequest().authenticated()  
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login-error")  
            .permitAll().and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and().csrf().disable();
            
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new CustomAuthenticationProvider());
    }
}