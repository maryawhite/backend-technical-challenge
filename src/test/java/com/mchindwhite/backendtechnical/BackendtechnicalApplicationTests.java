package com.mchindwhite.backendtechnical;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchindwhite.backendtechnical.models.Person;
import com.mchindwhite.backendtechnical.repositories.PersonRepository;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest
class BackendtechnicalApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	PersonRepository personDao;

	@Test
	void contextLoads() throws Exception{

		//testing the PersonController findAll method
		Mockito.when(personDao.findAll()).thenReturn(
				Collections.emptyList()
		);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/api/person")
						.accept(MediaType.APPLICATION_JSON)
		).andReturn();

		System.out.println(mvcResult.getResponse());

		Mockito.verify(personDao).findAll();
	}
//
//	@Test
//	void registerNewPerson() throws Exception {
//		Person person = new Person();
//		person.setFirstName("Sally");
//		person.setLastName("Smith");
//		person.setDob(LocalDate.of(1984, 12, 18));
//		person.setDateJoined(LocalDate.of(2022, 2,24));
//		person.setDateUpdated(LocalDate.of(2022,2,24));
//
//		MvcResult mvcResult = mockMvc.perform(
//				MockMvcRequestBuilders.post("/api/person")
//						.accept(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Sally\", \"lastName\": \"Smith\", \"dob\": 1984-12-18, \"dateJoined\": 2022-2-24, \"dateUpdated\": 2022-2-24}")
//		).andReturn();
//
//		System.out.println("sout mvcResult.getResponse " + mvcResult.getResponse());
//
//		int status = mvcResult.getResponse().getStatus();
//		Assertions.assertEquals(201, status);
//
//		Mockito.verify(personDao).save(person);
//
//	}



}
