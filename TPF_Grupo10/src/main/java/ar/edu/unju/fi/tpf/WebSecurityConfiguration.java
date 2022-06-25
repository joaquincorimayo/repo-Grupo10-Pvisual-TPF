package ar.edu.unju.fi.tpf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ar.edu.unju.fi.tpf.service.imp.LoginUsuarioServiceImp;

@Configuration
public class WebSecurityConfiguration {

	@Autowired
	LoginUsuarioServiceImp userDetailsService;

	@Autowired
	private AutenticacionSuccessHandler autenticacion;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/webjars/**" };

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
				.antMatchers("/inicio").permitAll()
				.antMatchers("/nuevo-registro").permitAll()
				.antMatchers("/nuevo-registro/tipo-registro").permitAll()
				.antMatchers("/ciudadano/guardar").permitAll()
				.antMatchers("/empleador/guardar").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers(resources).permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.successHandler(autenticacion).failureUrl("/login?error=true")
				.usernameParameter("usname")
				.passwordParameter("uspass")
				.and()
				.logout().permitAll();
		http.headers().frameOptions().sameOrigin();
		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}