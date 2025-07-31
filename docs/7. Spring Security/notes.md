# Spring Security

# Authorization vs Authentication

- 
    
    ![image.png](/images/Spring%20Security/image.png)
    
    Identities are the users or admin who would access your application/resource
    

# Important Security Principles

- 
    
    ![image.png](/images/Spring%20Security/image%201.png)
    
    ![image.png](/images/Spring%20Security/image%202.png)
    

# How Does Spring Security Works?

- 
    
    ![image.png](/images/Spring%20Security/image%203.png)
    

- Basic Spring Security Configuration:
    
    ![image.png](/images/Spring%20Security/image%204.png)
    

# Form Based Authentication

- 
    
    ![image.png](/images/Spring%20Security/image%205.png)
    

# Basic Authentication

- 
    
    ![image.png](/images/Spring%20Security/image%206.png)
    

# CSRF

- CSRF: Cross-Site Request Forgery
- Spring Security allows the GetMapping to different sites, but the PostMapping or the update request is blocked by Spring Security. All the put or post request would require a CSRF token to complete their tasks.
    
    ![image.png](/images/Spring%20Security/image%207.png)
    
- To get the csrf token we can make a GET request method over a url like /csrf-token  which would give us an attribute back with the name “_csrf”
    
    ![image.png](/images/Spring%20Security/image%208.png)
    
    ![image.png](/images/Spring%20Security/image%209.png)
    
- If you have a stateless rest api, then you would have to disable csrf
- Similar to Synchronizer token pattern, we have SameSite cookie as well which would help us protect from CSRF. In it we basically set Set-Cookie to strict so that, the cookie is not shared to anyother website than the one it was created in.
- To set the cookie to strict, we have to add this in our [application.properties](http://application.properties)
    
    ```xml
    server.servlet.session.cookie.same-site=strict
    ```
    

## How to Disable CSRF

- If we go to eclipse and press ctrl+shift+t and type SBW, then we would go to SpringBootWebSecurityConfiguration class, and inside it is a method SecurityFilterChainConfiguration. This method is responsible for the basic spring security configuration, and hence we need to change it since it enables csrf.
    
    ![image.png](/images/Spring%20Security/image%2010.png)
    
    ```java
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
    	http.formLogin(withDefaults());
    	http.httpBasic(withDefaults());
    	return http.build();
    }
    ```
    
- To change the default configuration we would first need to create a Configuration class using @Configuration
    
    ![image.png](/images/Spring%20Security/image%2011.png)
    

- Now, we want to disable session, and it can be done like this
    
    ![image.png](/images/Spring%20Security/image%2012.png)
    
    ```java
    http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    ```
    

- Now, we can easily disable csrf like this
    
    ![image.png](/images/Spring%20Security/image%2013.png)
    
    ```java
    http.csrf().disable();
    ```
    

- Now we can perform POST Requests even if we don’t add the csrf token
    
    ![image.png](/images/Spring%20Security/image%2014.png)
    

# CORS

- CORS: Cross-Origin Request Sharing
    
    ![image.png](/images/Spring%20Security/image%2015.png)
    
- If we want to enable the Global CORS, then we can add the above mentioned code in any configuration class.

# Storing User Credentials

- When we want to make the username and password to access the webapp static we add them in application.properties. But it does not allow us to share it with anyother component or module. This is called In-Memory, it is okay to use them in development but not in production.
- The other way is to store credentials using a Database
- Another way is LDAP: Lightweight Directory Access Protocol

## Storing Multiple User Credentials InMemory

- 
    
    ![image.png](/images/Spring%20Security/image%2016.png)
    
- The {noop} is used to tell that the password passed is not encrypted and should be used as it is.
- It is a good practice to make an Enum of all the roles you need in your application, and then use them to assign the roles.

## Storing User Credentials Using Database/JDBC

- We would be using JDBC alongside H2 which is an in-memory database. But it can be replaced with MySQL very easily.
- 
    
    ![image.png](/images/Spring%20Security/image%2017.png)
    

- Here we have created a method dataSource, which is used to execute the script Default_User_Schema_DDL_Location just as when the h2 is executed. By default JDBC gives us 2 tables, 1. Users and 2. Authorities. Initially they both are empty.
- To populate the 2 default tables we have made another method userDetailsService and this time we have passed an object of DataSource as parameter. Now we would create a JdbcUserDetailsManager, and create the 2 users and they would be used to populate the tables.
    
    ![image.png](/images/Spring%20Security/image%2018.png)
    
- One thing to notice here is that the passwords are stored in un-encrypted way.

## Encoding vs Hashing vs Encryption

- 
    
    ![image.png](/images/Spring%20Security/image%2019.png)
    

- Hashing is used for storing passwords.

## Storing Bcrypt Encoded Passwords

- We can just create a method which returns an object of BCryptPasswordEncoder, and the encode it using the method passwordEncoder() when we create the use like this
    
    ![image.png](/images/Spring%20Security/image%2020.png)
    
- And now if we check our database then the passwords are in the encoded form
    
    ![image.png](/images/Spring%20Security/image%2021.png)
    
- 
    
    ![image.png](/images/Spring%20Security/image%2022.png)
    

# JWT

- 
    
    ![image.png](/images/Spring%20Security/image%2023.png)
    

- 
    
    ![image.png](/images/Spring%20Security/image%2024.png)
    

- Symmetric Key Encryption
    
    ![image.png](/images/Spring%20Security/image%2025.png)
    

- Asymmetric Key Encryption
    
    ![image.png](/images/Spring%20Security/image%2026.png)
    

- JWT Flow:
    
    ![image.png](/images/Spring%20Security/image%2027.png)
    

## JWT Security Configuration

- 
    
    ![image.png](/images/Spring%20Security/image%2028.png)
    

- First we would need to download OAuth2 dependency. In gradle:
    
    ```xml
    implementation 'org.springframework.boot:spring-boot-starter-oauth2-resource-server'
    ```
    

- Now we would need to make a JwtSecurityConfiguration bean, which would have the same features as that of basic authentication configuration class atleast.
- Then we would need to enable OAuth2 in this configuration as well, for that we would need to go to the class OAuth2ResourceServerConfigurer, and copy the qualified name for jwt() method from it
    
    ![image.png](/images/Spring%20Security/image%2029.png)
    

- We have to make a method reference of this method in our JwtSecurityConfiguration, inside the FilterChain Method
    
    ![image.png](/images/Spring%20Security/image%2030.png)
    
    If you launch your application right now it would show an error, because OAuth2 needs a JwtDecoder, and we haven’t created one yet.
    

### Creating JwtDecoder

- The decoder is used to decode our encrypted message, and for that we need a RSA Key Object to encode the message.

### Creating A Key Pair

- To make a RSA Key Object we would need to have a key pair.
- Openssl is a tool which can be used to make the public and private RSA Keys. But here we would create keys using code.
- We would use the class KeyPairGenerator which is provided by Spring Security, and in it we would use the method generateKeyPair()
    
    ![image.png](/images/Spring%20Security/image%2031.png)
    
    ```java
    @Bean
    public KeyPair keyPair() {
    	try {			
    		var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    		keyPairGenerator.initialize(2048);		//This is used to define the key size. The higher the size, the more the security
    		return keyPairGenerator.generateKeyPair();
    	}catch(Exception ex) {
    		throw new RuntimeException(ex);
    	}
    }
    ```
    

- After generating key pair, we need to create a RSA Key Object using these pair

### Creating RSA Key Object

- We would be using RSAKey class to create the Key Object
- 
    
    ![image.png](/images/Spring%20Security/image%2032.png)
    
    ```java
    @Bean
    public RSAKey rsaKey(KeyPair keyPair) {
    	return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())	//This specifies that we are using the public KeyPair to build
    					 .privateKey(keyPair.getPrivate())				//We also need to pass the private of the keypair
    					 .keyID(UUID.randomUUID().toString())			//This generates a random ID for our key 
    					 .build();
    }
    ```
    
- Now, we need to create a JWKSource (Json Web Key Source)

### Creating JWKSource

- We can create a JWKSet for multiple RSA Keys as well, but for now since we have one RSA key we would create with one.
- Once we have a JWKSet we can create a JWKSource using that set.
- 
    
    ![image.png](/images/Spring%20Security/image%2033.png)
    
    ```java
    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
    	var jwkSet = new JWKSet(rsaKey); 
    	return (jwkSelector, context) -> jwkSelector.select(jwkSet);	//This is the lambda function which overrides the get() method in JWKSource
    }
    ```
    
- Now we can finally create a RSA Public Key for decoding.

### Creating RSA Public Key

- We would be using NimbusJwtDecoder for this
    
    ![image.png](/images/Spring%20Security/image%2034.png)
    
    ```java
    @Bean
    public JwtDecoder decoder(RSAKey rsaKey) throws JOSEException {
    	return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
    }
    ```
    

- And now, since we have create a JwtDecoder, our application would start back again which was showing an error due to the absence of JwtDecoder for OAuth2

### The JwtSecurityConfiguration Code

- This is the complete JwtSecurityConfiguration code since it is not changed much in any of the application, it is benificial to store it at a place.
- 
    
    ```java
    package com.in28minutes.learn_spring_security.jwt;
    
    import static org.springframework.security.config.Customizer.withDefaults;
    
    import java.security.KeyPair;
    import java.security.KeyPairGenerator;
    import java.security.interfaces.RSAPublicKey;
    import java.util.UUID;
    
    import javax.sql.DataSource;
    
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
    import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.oauth2.jwt.JwtDecoder;
    import org.springframework.security.oauth2.jwt.JwtEncoder;
    import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
    import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
    import org.springframework.security.provisioning.JdbcUserDetailsManager;
    import org.springframework.security.web.SecurityFilterChain;
    
    import com.nimbusds.jose.JOSEException;
    import com.nimbusds.jose.jwk.JWKSet;
    import com.nimbusds.jose.jwk.RSAKey;
    import com.nimbusds.jose.jwk.source.JWKSource;
    import com.nimbusds.jose.proc.SecurityContext;
    
    @Configuration
    public class JwtSecurityConfiguraiton {
    	
    	@Bean
    	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
    		
    		http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    		
    		//http.formLogin(withDefaults());
    		http.httpBasic(withDefaults());
    		
    		http.csrf().disable();
    		
    		http.headers().frameOptions().sameOrigin();
    		
    		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    		
    		
    		return http.build();
    	}
    	 
    	
    	@Bean
    	public DataSource dataSource() {
    		return new EmbeddedDatabaseBuilder()
    				.setType(EmbeddedDatabaseType.H2)
    				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
    				.build();
    	}
    	
    	@Bean 
    	public UserDetailsService userDetailsService(DataSource dataSource) {
    		
    		var user = User.withUsername("abhiraj")
    				.password("dummy").passwordEncoder(str -> customPasswordEncoder().encode(str))
    				.roles("USER").build();
    		
    		var admin = User.withUsername("admin")
    				.password("dummy").passwordEncoder(str -> customPasswordEncoder().encode(str))
    				.roles("ADMIN").build();
    		
    		var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    		
    		jdbcUserDetailsManager.createUser(user);
    		jdbcUserDetailsManager.createUser(admin);
    		
    		return jdbcUserDetailsManager;
    	}
    	
    	@Bean
    	public BCryptPasswordEncoder customPasswordEncoder() {
    		return new BCryptPasswordEncoder();
    	}
    	
    	@Bean
    	public KeyPair keyPair() {
    		try {			
    			var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    			keyPairGenerator.initialize(2048);		
    			return keyPairGenerator.generateKeyPair();
    		}catch(Exception ex) {
    			throw new RuntimeException(ex);
    		}
    	}
    	
    	@Bean
    	public RSAKey rsaKey(KeyPair keyPair) {
    		return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())	
    						 .privateKey(keyPair.getPrivate())				
    						 .keyID(UUID.randomUUID().toString())			
    						 .build();
    	}
    	
    	@Bean
    	public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
    		var jwkSet = new JWKSet(rsaKey); 
    		return (jwkSelector, context) -> jwkSelector.select(jwkSet);	
    	}
    	
    	@Bean
    	public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
    		return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
    	}
    	
    	@Bean
    	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
    		return new NimbusJwtEncoder(jwkSource);
    	}
    	
    }
    
    ```
    

## JWT Resource

- As we saw in the high level flow of JWT:
    1. The first step is to create a JWT
    2. The second step is to Pass it in header
    3. The third step is to verify the JWT
- In security configuration, we have focused on the third step which is the verification of the JWT. The JWT Resource is used to create a JWT which would be sent in the header for the verification.
- We want to create an encoder, a resource which would have user credentials which would be passed to the encoder, and finally send a JWT Token back.
- The JWT Encoder is created in the JwtSecurityConfiguration only.

### Creating JWT Encoder

- Creating a JWT Encoder is very similary to creating a decoder.
- The NimbusJwtEncoder has a constructor which takes JWKSource as the parameter, and we have already create a JWKSource
    
    ![Screenshot 2025-07-31 122229.png](/images/Spring%20Security/Screenshot_2025-07-31_122229.png)
    
    ```java
    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
    	return new NimbusJwtEncoder(jwkSource);
    }
    ```
    

### Code for JwtResource

```java
package com.in28minutes.learn_spring_security.jwt;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationResource {

	private JwtEncoder jwtEncoder;
	
	JwtAuthenticationResource(JwtEncoder jwtEncoder){
		this.jwtEncoder = jwtEncoder;
	}
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(Authentication authentication) {
		return new JwtResponse(createToken(authentication));
	}

	private String createToken(Authentication authentication) {
		
		var claims = JwtClaimsSet.builder()
					.issuer("self")
					.issuedAt(Instant.now())
					.expiresAt(Instant.now().plusSeconds(60 * 15))
					.subject(authentication.getName())
					.claim("scope", createScope(authentication))
					.build();
		
		return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}

	private String createScope(Authentication authentication) {
		return authentication.getAuthorities().stream()
				.map(a -> a.getAuthority())
				.collect(Collectors.joining(" "));
	}
	
}

record JwtResponse(String token) {}
```

# Spring Security Authentication

- 
    
    ![image.png](/images/Spring%20Security/image%2035.png)