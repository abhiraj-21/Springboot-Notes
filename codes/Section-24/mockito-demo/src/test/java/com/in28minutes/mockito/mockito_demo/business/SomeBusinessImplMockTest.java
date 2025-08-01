package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

	@Mock		//Makes the object as a Mock of the class we want to mock
	private DataService dataServiceMock;
	
	
	@InjectMocks		//Auto injects the mock which are needed for the class 
	private SomeBusinessImpl businessImpl;
	
	@Test
	void findTheGreatestFromAllData_basicScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,10,5}); 
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}
	
	@Test
	void findTheGreatesFromAllData_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(35, result);
	}

	@Test
	void findTheGreatestFromAllData_EmptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(Integer.MIN_VALUE, result);
	}
	
}