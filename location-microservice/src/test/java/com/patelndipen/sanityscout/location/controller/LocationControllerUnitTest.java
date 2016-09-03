package com.patelndipen.sanityscout.location.controller;

import com.patelndipen.sanityscout.location.LocationApplication;
import com.patelndipen.sanityscout.location.domain.Location;
import com.patelndipen.sanityscout.location.service.LocationService;
import com.patelndipen.sanityscout.location.domain.LocationResponse;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LocationApplication.class)
public class LocationControllerUnitTest {

	@InjectMocks
	private LocationController locationController;

	@Mock
	private LocationService locationService;

	private MockMvc mockMvc;

	@Before
	public void beforeEachTest() {
		initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(locationController).build();
	}

	@Test
	public void LocationController_ShouldReturnLocationResponseJson() throws Exception {

		List<Location> locations = new ArrayList<Location>();
		locations.add((new Location("Library", "book.png")));
		locations.add((new Location("School", "education.png")));

		when(locationService.findByLocationType("study")).thenReturn(locations);

		List<String> li = new ArrayList<String>();
		li.add("Library");
				li.add("School");
		mockMvc.perform(get("/locations/study"))
//		.andExpect(jsonPath("$...locationName").value(Arrays.asList(locations.get(0).getLocationName(), locations.get(1).getLocationName())))
		.andExpect(jsonPath("$...locationName").isArray())
		.andExpect(status().isOk());

	}

}
