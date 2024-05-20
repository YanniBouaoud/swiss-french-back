package fr.yanni.swissfrench.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.yanni.swissfrench.security.Dto.JwtResponse;
import fr.yanni.swissfrench.security.Dto.LoginRequest;
import fr.yanni.swissfrench.security.Dto.SignupRequest;
import fr.yanni.swissfrench.security.Dto.TokenRefreshRequest;
import fr.yanni.swissfrench.security.Dto.TokenRefreshResponse;
import fr.yanni.swissfrench.security.Dto.UserDto;
import fr.yanni.swissfrench.security.jwt.JwtProvider;
import fr.yanni.swissfrench.security.jwt.exception.TokenRefreshException;
import fr.yanni.swissfrench.security.models.RefreshToken;
import fr.yanni.swissfrench.security.models.User;
import fr.yanni.swissfrench.security.service.IRefreshTokenService;
import fr.yanni.swissfrench.security.service.impl.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 * Classe permettant de gérer la sécurité.
 *
 * @author yni
 *
 */

@RestController
@RequestMapping("/auth")
public final class AuthController {

	/** token header to use in JWT. */
	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;

	/** import authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** import jwtprovider. */
	@Autowired
	private JwtProvider tokenProvider;

	/** import refreshToken service. */
	@Autowired
	private IRefreshTokenService refreshTokenService;

	/** import user service. */
	@Autowired
	private UserDetailsServiceImpl userService;

	/**
	 *
	 *
	 * @param signUpRequest The request body containing user signup details.
	 * @return ResponseEntity containing JWT token, user information, and refresh
	 *         token upon successful registration. Returns a bad request response if
	 *         the username is already taken.
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody final SignupRequest signUpRequest) {
		if (userService.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body("Error: Username is already taken!");
		}

		String encodedPassword = new BCryptPasswordEncoder().encode(signUpRequest.getPassword());

		User user = new User();
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(encodedPassword);
		user.setFirstname(signUpRequest.getsetFirstname());
		user.setLastname(signUpRequest.getLastname());
		user.setAddress(signUpRequest.getAddress());

		userService.save(user);

		userService.addUserToRole(user.getId(), Long.valueOf(1));

		String jwt = tokenProvider.generateToken(signUpRequest.getUsername());

		refreshTokenService.deleteExpired();
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());

		return ResponseEntity.ok(new JwtResponse(tokenHeader + " " + jwt, tokenProvider.getExpiryDate(jwt),
				new UserDto(user), refreshToken.getToken()));
	}

	/**
	 *
	 * @param request a login + password couple
	 * @return a response with the jwt
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody final LoginRequest request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(request.getUsername());

		User user = userService.loadUserDetails(request.getUsername());

		refreshTokenService.deleteExpired();
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());

		return ResponseEntity.ok(new JwtResponse(tokenHeader + " " + jwt, tokenProvider.getExpiryDate(jwt),
				new UserDto(user), refreshToken.getToken()));
	}

	/**
	 * Get a new token. xx
	 * 
	 * @param request a valid refresh token
	 * @return a new token
	 */
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@Valid @RequestBody final TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken).map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser).map(user -> {
					String jwt = tokenProvider.generateToken(user.getUsername());
					RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());
					return ResponseEntity.ok(new TokenRefreshResponse(tokenHeader + " " + jwt,
							tokenProvider.getExpiryDate(jwt), refreshToken.getToken()));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}

	/**
	 *
	 * @param userDto a userDto containing at least a username and a list of
	 *                settings
	 * @param request the http request
	 * @return the updated user
	 */
	@PostMapping(value = "/updateSettings")
	public UserDto updateSettings(final @RequestBody UserDto userDto, final HttpServletRequest request) {
		User user = userService.loadUserDetails(userDto.getUsername());

		return new UserDto(userService.update(user));

	}
}
