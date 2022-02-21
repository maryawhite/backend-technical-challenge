package com.mchindwhite.backendtechnical;

import com.mchindwhite.backendtechnical.repositories.PersonRepository;
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

}
