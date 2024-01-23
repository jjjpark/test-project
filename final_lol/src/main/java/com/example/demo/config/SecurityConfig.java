//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//
//@Configuration
////@EnableWebSecurity // 시큐리티6 활성화 및 웹보안설정 부트3.0이상에서 생략가능
//@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
////환경설정 클래스를 정의하면 시큐리티 로그인창이 안나타남
////메소드 레벨의 보안을 구성하고 @PreAuthorize, @PostAuthorize, @Secured 등의
////어노테이션을 사용하여 메소드에 대한 접근 제어를 지원
//public class SecurityConfig {
//	@Autowired
//	private AccessDeniedHandler accessDeniedHandler;
//	 
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		//csrf,cors 보안
//		//http.csrf().disable().cors().disable(); //부트 2.X 버전 방식
//		http.csrf(csrf -> csrf.disable());
//		//http.cors(cors -> cors.disable());
//		http.formLogin(form -> form.loginPage("/user/loginfrm").loginProcessingUrl("/login").defaultSuccessUrl("/user/profile")
//				.defaultSuccessUrl("/")
////				.failureUrl("/user/login/error")
//				.usernameParameter("id") //기본값은 username
//				.passwordParameter("pw") //기본값은 password
//				// .successHandler((authenticationSuccessHandler())
//				//.failureHandler(authenticationFailureHandler)
//				//.permitAll() //생략하는 이유: 모든 사용자의 접근을 허용 하지만
//				//authorizeHttpRequests("허용할 url...")를 정의해야됨
//		);
//		
//		http.logout(logout -> logout.logoutUrl("/user/logout").logoutSuccessUrl("/"));
//		http.exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler));
//		return http.build();		
//	}
//	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
