package com.rest_api.fs14backend.SecurityConfig;


import com.rest_api.fs14backend.filters.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

  @Autowired
  private JwtFilter jwtFilter;

  @Bean
  public AuthenticationManager authenticationManager(
    AuthenticationConfiguration authenticationConfiguration
  ) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .cors()
      .and()
      .csrf()
      .disable()
      .authorizeHttpRequests()
      .requestMatchers("/api/v1/signup", "/api/v1/signin")
      .permitAll()
      .and()
      .authorizeHttpRequests()
      .requestMatchers(HttpMethod.GET, "/api/v1/todos/")
      .permitAll()
      .requestMatchers("/api/v1/users").hasRole("ADMIN")
      .requestMatchers("/hello").hasRole("ADMIN")
      .anyRequest()
      .authenticated()
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      // Add JWT token filter
      .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}

//  @Bean
//  public CorsFilter corsFilter() {
//    CorsConfiguration corsConfiguration = new CorsConfiguration();
//    corsConfiguration.setAllowCredentials(true);
//    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "myDomaibn.com"));
//    corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//      "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
//      "Access-Control-Request-Method", "Access-Control-Allow-Origin", " Access-Control-Allow-Credentials"));
//    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//    return new CorsFilter(urlBasedCorsConfigurationSource);
//  }