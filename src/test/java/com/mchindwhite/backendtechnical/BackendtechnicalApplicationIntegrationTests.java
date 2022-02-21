package com.mchindwhite.backendtechnical;

import com.mchindwhite.backendtechnical.models.Person;
import com.mchindwhite.backendtechnical.repositories.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;

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
}
