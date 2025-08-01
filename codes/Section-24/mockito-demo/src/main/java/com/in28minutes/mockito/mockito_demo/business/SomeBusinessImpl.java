package com.in28minutes.mockito.mockito_demo.business;

public class SomeBusinessImpl {
	
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int num : data) {
			greatestValue = Math.max(greatestValue, num);
		}
		return greatestValue;
	}
	
}


interface DataService{
	int[] retrieveAllData();
}