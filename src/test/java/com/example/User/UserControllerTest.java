package com.example.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.User.Model.User;
import com.example.User.Repository.UserRepository;
import com.example.User.Service.UserServicesImps;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServicesImps userServicesImps;

	@Before(value = "before test")
	public void setUp() throws Exception {
		
	}

	// UserServiceTest.java
	//test find all User
	@Test
	public void findAllUserTest() {
		// PREPARATION
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = "2007-12-03";
		LocalDate date = LocalDate.parse(dateString, dateFormat);
		User user1 = new User(999, "111", "nguyen", "van C", "married", date, "test salutation", "test marialStatus",
				"test address", "test country");
		User user2 = new User(222, "222", "nguyen", "van C", "married", date, "test salutation", "test marialStatus",
				"test address", "test country");
		List<User> lstUser = new ArrayList<User>();
		lstUser.add(user1);
		lstUser.add(user2);
		when(userRepository.findAll()).thenReturn(lstUser);

		// ACTION
		List<User> lstUserTest = userServicesImps.findAllUser();

		// ASSERTION
		assertEquals("test country", lstUserTest.get(0).getCountry());
		assertEquals(2, lstUserTest.size());
	}

	//test create User
	@Test
	public void createUserTest() {
		// PREPARATION
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = "2007-12-03";
		LocalDate date = LocalDate.parse(dateString, dateFormat);
		User user1 = new User(999, "111", "nguyen", "van C", "married", date, "test salutation", "test marialStatus",
				"test address", "test country");
		User user2 = new User(222, "222", "nguyen", "van C", "married", date, "test salutation", "test marialStatus",
				"test address", "test country");
		userServicesImps.saveUser(user1);
		userServicesImps.saveUser(user2);
		verify(userRepository).save(user1);
		verify(userRepository).save(user2);
	}

	//test findById user
	@Test
	public void getUserByIdTest() {
//		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String dateString = "2007-12-03";
//		LocalDate date = LocalDate.parse(dateString, dateFormat);
//		User user1 = new User(1, "111", "nguyen", "van C", "married", date, "test salutation", "test marialStatus",
//				"test address", "test country");
//		User user = userRepository.findById(user1.getClientNumber()).get();
//		when(user).thenReturn(user1);
//		
//		User userTest = userServicesImps.findByUserId((long) 1).get();
//		assertEquals("nguyen", userTest.getFirstName());
	}

	@After(value = "after test")
	public void downTear() {
		userRepository.deleteAll();
	}
}
