package br.com.utiauto.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.utiauto.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	
	// Configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	// Configurações de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/**").permitAll()
		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.antMatchers(HttpMethod.GET, "/auth").permitAll()
		.antMatchers(HttpMethod.GET, "/actuator").permitAll()
		.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
		.antMatchers(HttpMethod.GET, "/topicos").permitAll()
		.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
		.antMatchers(HttpMethod.GET, "/servicos").permitAll()
		.antMatchers(HttpMethod.GET, "/servicos/**").permitAll()
		.antMatchers(HttpMethod.GET, "/usuario").permitAll()
		.antMatchers(HttpMethod.GET, "/chamado").permitAll()
		.antMatchers(HttpMethod.GET, "/chamado/**").permitAll()
		.antMatchers(HttpMethod.POST, "/chamado").permitAll()
		.antMatchers(HttpMethod.POST, "/chamado/**").permitAll()
		.antMatchers(HttpMethod.POST, "/usuario").permitAll()
		.antMatchers(HttpMethod.PUT, "/usuario").permitAll()
		.antMatchers(HttpMethod.PUT, "/usuario/**").permitAll()
		.antMatchers(HttpMethod.POST, "/usuario/**").permitAll()
		.antMatchers(HttpMethod.GET, "/usuario/*").permitAll()
		.antMatchers(HttpMethod.GET, "/topicos/**").permitAll()
		.antMatchers(HttpMethod.GET, "/topicos").permitAll()
		.antMatchers(HttpMethod.POST, "/topicos/**").permitAll()
		.antMatchers(HttpMethod.POST, "/topicos").permitAll()
		.antMatchers(HttpMethod.PUT, "/topicos").permitAll()
		.antMatchers(HttpMethod.PUT, "/topicos/**").permitAll()
		.antMatchers(HttpMethod.GET, "/login/*").permitAll()
		.antMatchers(HttpMethod.GET, "/login").permitAll()
		
		.antMatchers(HttpMethod.GET, "/automovel").permitAll()
		.antMatchers(HttpMethod.GET, "/automovel/**").permitAll()
		.antMatchers(HttpMethod.PUT, "/automovel").permitAll()
		.antMatchers(HttpMethod.PUT, "/automovel/**").permitAll()
	
		
		
		
		.antMatchers(HttpMethod.GET, "/prestadorservico/*").permitAll()
		.antMatchers(HttpMethod.GET, "/prestadorservico").permitAll()
		
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
		
	}

	// Configurações de recursos estáticos(js, css, imagens, etc.)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configurations/**", "/swagger-resources/**", "/h2-console/**");
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("teste123"));
	}
	*/
}
