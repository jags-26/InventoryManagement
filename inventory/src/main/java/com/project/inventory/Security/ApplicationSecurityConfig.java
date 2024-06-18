
  package com.project.inventory.Security;
  
  import org.springframework.context.annotation.Bean; import
  org.springframework.context.annotation.Configuration; import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.core.userdetails.User; import
  org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.crypto.password.PasswordEncoder; import
  org.springframework.security.provisioning.InMemoryUserDetailsManager; import
  org.springframework.security.web.SecurityFilterChain;
  
  @Configuration public class ApplicationSecurityConfig {
  
  private final PasswordEncoder passwordEncoder;
  
  public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
  this.passwordEncoder = passwordEncoder; }
  
  @Bean public UserDetailsService userDetailsService() { UserDetails admin =
  User.builder() .username("ADMIN")
  .password(passwordEncoder.encode("test123")) .roles("ADMIN") .build();
  
  return new InMemoryUserDetailsManager(admin); }
  
  @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
  throws Exception { http .authorizeRequests(authorize -> authorize
  .anyRequest().authenticated() ) .formLogin(login -> login
  .defaultSuccessUrl("/", true) ) .logout(logout -> logout
  .clearAuthentication(true) );
  
  return http.build(); }
  
  
  }
 