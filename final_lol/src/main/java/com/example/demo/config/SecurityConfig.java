package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;


@Configuration
//@EnableWebSecurity // 시큐리티6 활성화 및 웹보안설정 부트3.0이상에서 생략가능
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
//환경설정 클래스를 정의하면 시큐리티 로그인창이 안나타남
//메소드 레벨의 보안을 구성하고 @PreAuthorize, @PostAuthorize, @Secured 등의
//어노테이션을 사용하여 메소드에 대한 접근 제어를 지원
public class SecurityConfig {
	@Autowired
	private AccessDeniedHandler accessDeniedHandler; // Sping Boot에 있는 시큐리티 인터페이스
	 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//csrf,cors 보안
		//http.csrf().disable().cors().disable(); //부트 2.X 버전 방식
		http.csrf(csrf -> csrf.disable());
		//http.cors(cors -> cors.disable());
		
		// 시큐리티 처음 실행할 떄 나오는 로그인창 대신 개발자가 설정한 url로 지정하면 그 url에 맞게 가게 해준다.
		// form -> form.loginPage("/user/loginfrm") : 람다식으로 로그인 페이지를 본인(개발자)이 지정한 url로 설정해서 그곳으로 가게 해준다.
		// loginProcessingUrl("/login") : 로그인 페이지에서 from태그로 post방식으로 보내야 시큐리티에서 로그인 여부를 확인 할 수 있다.
		// .defaultSuccessUrl("/") : 모든 로그인 여부를 확인하면 메인 페이지 url로 이동한다.
		// usernameParameter("id"), passwordParameter("pw") : .jsp에서 해당 파라미터(값)를 받을 때 기본값으로 받을 건지 name 속성으로 지정한 이름으로 설정한다.
		http.formLogin(form -> form.loginPage("/user/loginfrm").loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
//				.failureUrl("/user/login/error")
				.usernameParameter("id") //기본값은 username
				.passwordParameter("pw") //기본값은 password
				// .successHandler((authenticationSuccessHandler())
				//.failureHandler(authenticationFailureHandler)
				//.permitAll() //생략하는 이유: 모든 사용자의 접근을 허용 하지만
				//authorizeHttpRequests("허용할 url...")를 정의해야됨
		);
		// http.logout(logout -> logout.logoutUrl("/user/logout").logoutSuccessUrl("/")) : .jsp에서 로그아웃 이벤트가 발생하면 지정한 url로 와서 controller에 있는 url를 거쳐서 로그아웃이 되고
		//                                                                                  로그아웃이 성공하면 메인 url로 간다.
		http.logout(logout -> logout.logoutUrl("/user/logout").logoutSuccessUrl("/"));
		
		// accessDeniedHandler를 사용하여 액세스 거부(403 Forbidden)에 대한 처리를 구성하고 있다.
		http.exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler));
		return http.build();		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
