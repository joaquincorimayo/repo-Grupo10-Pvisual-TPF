package ar.edu.unju.fi.tpf;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpf.service.imp.LoginUsuarioServiceImp;

@Component
public class AutenticacionSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	LoginUsuarioServiceImp userDetailsService;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		boolean empleador = false;
		boolean ciudadano = false;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("CIUDADANO")) {
				ciudadano = true;
				break;
			} else {
				empleador = true;
				break;
			}
		}

		if (ciudadano) {
			redirectStrategy.sendRedirect(request, response, "/ciudadano/inicio");
		} else {
			if (empleador) {
				redirectStrategy.sendRedirect(request, response, "/empleador/inicio");
			} else {
				throw new IllegalStateException();
			}
		}
	}
}
