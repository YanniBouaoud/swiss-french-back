package fr.yanni.swissfrench;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import fr.yanni.swissfrench.core.domain.Appart;
import fr.yanni.swissfrench.core.domain.Car;
import fr.yanni.swissfrench.core.domain.DevisBati;
import fr.yanni.swissfrench.core.domain.DevisCar;
import fr.yanni.swissfrench.core.domain.DevisCarLine;
import fr.yanni.swissfrench.core.dto.AppartDTO;
import fr.yanni.swissfrench.core.dto.CarDTO;
import fr.yanni.swissfrench.core.dto.DevisBatiDTO;
import fr.yanni.swissfrench.core.dto.DevisCarDTO;
import fr.yanni.swissfrench.core.dto.mapper.AppartMapper;
import fr.yanni.swissfrench.core.dto.mapper.CarMapper;
import fr.yanni.swissfrench.core.dto.mapper.DevisBatiMapper;
import fr.yanni.swissfrench.core.dto.mapper.DevisCarMapper;
import fr.yanni.swissfrench.security.models.Role;
import fr.yanni.swissfrench.security.models.RoleName;
import fr.yanni.swissfrench.security.models.User;
import fr.yanni.swissfrench.security.service.impl.UserDetailsServiceImpl;
import fr.yanni.swissfrench.security.utils.UserMapper;
import fr.yanni.swissfrench.security.utils.UserPrincipal;

@SpringBootTest
class SwissFrenchApplicationTests {

	/** Test Car Mapper **/

	@Test
	void testDtoToEntity() {
		// Création d'un objet CarDTO
		CarDTO dto = new CarDTO();
		dto.setId((short) 2);
		dto.setName("BMW i8");
		dto.setDescription("Hybrid sports car");
		dto.setPrice(149999.99);
		dto.setImage("bmw_i8.jpg");

		// Conversion de CarDTO à Car
		Car entity = CarMapper.dtoToEntity(dto);

		// Vérification des résultats
		assertNotNull(entity);
		assertEquals((short) 2, entity.getId());
		assertEquals("BMW i8", entity.getName());
		assertEquals("Hybrid sports car", entity.getDescription());
		assertEquals("bmw_i8.jpg", entity.getImage());
	}

	@Test
	void testCarsToDtos() {
		// Création d'une liste de Car
		Car car1 = new Car();
		car1.setId((short) 1);
		car1.setName("Tesla Model 3");
		car1.setDescription("Affordable electric car");
		car1.setPrice(49999.99);
		car1.setImage("tesla_model_3.jpg");

		Car car2 = new Car();
		car2.setId((short) 2);
		car2.setName("Audi e-tron");
		car2.setDescription("Luxury electric SUV");
		car2.setPrice(89999.99);
		car2.setImage("audi_e_tron.jpg");

		List<Car> cars = Arrays.asList(car1, car2);

		// Conversion de la liste de Car à une liste de CarDTO
		List<CarDTO> dtos = CarMapper.carsToDtos(cars);

		// Vérification des résultats
		assertNotNull(dtos);
		assertEquals(2, dtos.size());

		CarDTO dto1 = dtos.get(0);
		assertEquals((short) 1, dto1.getId());
		assertEquals("Tesla Model 3", dto1.getName());
		assertEquals("Affordable electric car", dto1.getDescription());
		assertEquals(49999.99, dto1.getPrice(), 0.001);
		assertEquals("tesla_model_3.jpg", dto1.getImage());

		CarDTO dto2 = dtos.get(1);
		assertEquals((short) 2, dto2.getId());
		assertEquals("Audi e-tron", dto2.getName());
		assertEquals("Luxury electric SUV", dto2.getDescription());
		assertEquals(89999.99, dto2.getPrice(), 0.001);
		assertEquals("audi_e_tron.jpg", dto2.getImage());
	}

	/** Test Appart Mapper **/

	private static UserDetailsServiceImpl userServiceMock;

	@BeforeAll
	static void setUp() {
		userServiceMock = Mockito.mock(UserDetailsServiceImpl.class);
		new AppartMapper(userServiceMock);
	}

	@Test
	void testAppartToDto() {
		// Création d'un objet Appart
		Appart appart = new Appart();
		appart.setUsrid((short) 1);
		appart.setPrice((long) 1000.0);
		appart.setAdresse("123 Rue de la Paix");
		appart.setImage("image.jpg");
		appart.setDescription("Beau appartement");

		// Conversion de Appart à AppartDTO
		AppartDTO dto = AppartMapper.appartToDto(appart);

		// Vérification des résultats
		assertNotNull(dto);
		assertEquals((short) 1, dto.getUsr_id());
		assertEquals(1000.0, dto.getPrice(), 0.001);
		assertEquals("123 Rue de la Paix", dto.getAdresse());
		assertEquals("image.jpg", dto.getImage());
		assertEquals("Beau appartement", dto.getDescription());
	}

	@Test
	void testAppartsToDtos() {
		// Création d'une liste de Appart
		Appart appart1 = new Appart();
		appart1.setUsrid((short) 1);
		appart1.setPrice((long) 1000.0);
		appart1.setAdresse("123 Rue de la Paix");
		appart1.setImage("image.jpg");
		appart1.setDescription("Beau appartement");

		Appart appart2 = new Appart();
		appart2.setUsrid((short) 2);
		appart2.setPrice((long) 1500.0);
		appart2.setAdresse("789 Boulevard Saint-Germain");
		appart2.setImage("image3.jpg");
		appart2.setDescription("Charmant appartement");

		List<Appart> apparts = Arrays.asList(appart1, appart2);

		// Conversion de la liste de Appart à une liste de AppartDTO
		List<AppartDTO> dtos = AppartMapper.appartsToDtos(apparts);

		// Vérification des résultats
		assertNotNull(dtos);
		assertEquals(2, dtos.size());

		AppartDTO dto1 = dtos.get(0);
		assertEquals((short) 1, dto1.getUsr_id());
		assertEquals(1000.0, dto1.getPrice(), 0.001);
		assertEquals("123 Rue de la Paix", dto1.getAdresse());
		assertEquals("image.jpg", dto1.getImage());
		assertEquals("Beau appartement", dto1.getDescription());

		AppartDTO dto2 = dtos.get(1);
		assertEquals((short) 2, dto2.getUsr_id());
		assertEquals(1500.0, dto2.getPrice(), 0.001);
		assertEquals("789 Boulevard Saint-Germain", dto2.getAdresse());
		assertEquals("image3.jpg", dto2.getImage());
		assertEquals("Charmant appartement", dto2.getDescription());
	}

	/** Test DevisBati Mapper **/

	private DevisBatiMapper devisBatiMapper;
	private UserDetailsServiceImpl userServiceMock1;

	@BeforeEach
	void setUp1() {
		userServiceMock = Mockito.mock(UserDetailsServiceImpl.class);
		devisBatiMapper = new DevisBatiMapper(userServiceMock1);
		devisBatiMapper.userService = userServiceMock;
	}

	@Test
	void testDevisBatiToDto() {
		// Création d'un objet DevisBati
		DevisBati devisBati = new DevisBati();
		devisBati.setUsrid((short) 1);
		devisBati.setBudget((long) 5000);
		devisBati.setDelais("30 jours");
		devisBati.setDescription("Rénovation de la cuisine");

		// Conversion de DevisBati à DevisBatiDTO
		DevisBatiDTO dto = devisBatiMapper.devisbatiToDto(devisBati);

		// Vérification des résultats
		assertNotNull(dto);
		assertEquals((short) 1, dto.getUsr_id());
		assertEquals(5000, dto.getBudget());
		assertEquals("30 jours", dto.getDelais());
		assertEquals("Rénovation de la cuisine", dto.getDescription());
	}

	@Test
	void testDtoToEntity1() {
		// Mocking SecurityContextHolder
		UserDetails userDetails = Mockito.mock(UserDetails.class);
		Mockito.when(userDetails.getUsername()).thenReturn("testUser");
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Mocking UserService
		Mockito.when(userServiceMock.getUserIdByUsername("testUser")).thenReturn(1L);

		// Création d'un objet DevisBatiDTO
		DevisBatiDTO dto = new DevisBatiDTO();
		dto.setBudget((long) 7000);
		dto.setDelais("45 jours");
		dto.setDescription("Peinture de la maison");

		// Conversion de DevisBatiDTO à DevisBati
		DevisBati entity = devisBatiMapper.dtoToEntity(dto);

		// Vérification des résultats
		assertNotNull(entity);
		assertEquals(7000, entity.getBudget());
		assertEquals("45 jours", entity.getDelais());
		assertEquals("Peinture de la maison", entity.getDescription());
		assertEquals((short) 1, entity.getUsrid(), 1);
	}

	/** Test DevisCar Mapper **/

	private DevisCarMapper devisCarMapper;
	private UserDetailsServiceImpl userServiceMock11;

	@BeforeEach
	void setUp11() {
		userServiceMock = Mockito.mock(UserDetailsServiceImpl.class);
		devisCarMapper = new DevisCarMapper();
		devisCarMapper.userService = userServiceMock11;
	}

	@Test
	void testDeviscarToDto() {
		// Création d'un objet DevisCar
		DevisCar devisCar = new DevisCar();
		devisCar.setUsrid((short) 1);
		List<DevisCarLine> devisCarLines = new ArrayList<>();
		DevisCarLine line1 = new DevisCarLine();
		line1.setCarid((short) 1);
		line1.setCommentaire("Bon état général");
		line1.setDevisCar(devisCar);
		devisCarLines.add(line1);
		devisCar.setDevisCarLines(devisCarLines);

		// Conversion de DevisCar à DevisCarDTO
		DevisCarDTO dto = devisCarMapper.deviscarToDto(devisCar);

		// Vérification des résultats
		assertNotNull(dto);
		assertEquals((short) 1, dto.getUsr_id());
		assertNotNull(dto.getDevisCarLines());
		assertEquals(1, dto.getDevisCarLines().size());
		assertEquals(1, dto.getDevisCarLines().get(0).getCar_id(), 0.001);
		assertEquals("Bon état général", dto.getDevisCarLines().get(0).getCommentaire());
	}

	/** Test User Mapper **/

	@Test
	void testUserToPrincipal() {
		// Création d'un utilisateur avec des rôles
		User user = new User();
		user.setUsername("testuser");
		user.setPassword("password");
		Role role1 = new Role();
		role1.setName(RoleName.ADMIN);
		Role role2 = new Role();
		role2.setName(RoleName.USER);
		Set<Role> roles = new HashSet<>(Arrays.asList(role1, role2));
		user.setRoles(roles);

		// Appel de la méthode à tester
		UserPrincipal userPrincipal = UserMapper.userToPrincipal(user);

		// Vérification des résultats
		assertEquals("testuser", userPrincipal.getUsername());
		assertEquals("password", userPrincipal.getPassword());

		// Vérification des autorités
		Collection<? extends GrantedAuthority> authoritiesCollection = userPrincipal.getAuthorities();
		assertNotNull(authoritiesCollection);

		// Convertir les autorités en une liste de SimpleGrantedAuthority
		List<SimpleGrantedAuthority> authoritiesList = authoritiesCollection.stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());

		assertNotNull(authoritiesList);
		assertEquals(2, authoritiesList.size());
		assertTrue(authoritiesList.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
		assertTrue(authoritiesList.contains(new SimpleGrantedAuthority("ROLE_USER")));
	}
}
