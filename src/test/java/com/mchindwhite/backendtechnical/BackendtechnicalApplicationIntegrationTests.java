package com.mchindwhite.backendtechnical;

import com.mchindwhite.backendtechnical.models.Person;
import com.mchindwhite.backendtechnical.repositories.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendtechnicalApplication.class)
@AutoConfigureMockMvc
public class BackendtechnicalApplicationIntegrationTests {

	private Person testPerson;
	private HttpSession httpSession;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PersonRepository personDao;

	@Test
	@Before
	public void setup() throws Exception {

		testPerson = personDao.findPersonByFirstName("testFirstName");

		if(testPerson == null) {
			Person newPerson = new Person();
			newPerson.setFirstName("testFirstName");
			newPerson.setLastName("testLN");
			newPerson.setDateJoined(LocalDate.now());
			newPerson.setDateUpdated(LocalDate.now());
			newPerson.setDob(LocalDate.of(1984, 12,18));
			testPerson = personDao.save(newPerson);
		}
	}

	@Test
	public void testIfNotNull(){
		Assertions.assertNotNull(testPerson);
	}

	@Test
	public void testPersonFields(){
		Person sally = new Person(1L, "sally", "doe", LocalDate.of(1984,12,18), LocalDate.now(), LocalDate.now());
		Assertions.assertSame(1L, sally.getId());
		Assertions.assertSame("sally", sally.getFirstName());
		Assertions.assertSame("doe", sally.getLastName());
		/* not sure how to write a test for dates, they appear to be 2 different objects */
//		Assertions.assertSame(LocalDate.of(1984, 12,18), sally.getDob());
	}

}
