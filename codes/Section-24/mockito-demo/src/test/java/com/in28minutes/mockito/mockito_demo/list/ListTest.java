package com.in28minutes.mockito.mockito_demo.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void simpleTest() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
	}
	
	@Test
	void multipleReturns() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(1).thenReturn(2);
		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());		//This would be true since the last return was 2 
	}
	
	@Test
	void specificParameters() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("SomeString");
		assertEquals("SomeString", listMock.get(0));
		assertEquals(null, listMock.get(1));		//For string mockito returns null if the method is called more than the number of thenReturn
	}
	
	@Test
	void genericParameters() {				//For generic paramters we can use the any methods in Mockito 
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString");
		assertEquals("SomeOtherString", listMock.get(0));
		assertEquals("SomeOtherString", listMock.get(0));
	}

}
