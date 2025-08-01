package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	MyMath myMath = new MyMath();

	@Test
	void calculateSum_EmptyArray() {
		assertEquals(0, myMath.calculateSum(new int[] {}));
	}

	@Test
	void calculateSum_ThreeMemberArray() {
		assertEquals(6, myMath.calculateSum(new int[] { 1, 2, 3 }));
	}

}
