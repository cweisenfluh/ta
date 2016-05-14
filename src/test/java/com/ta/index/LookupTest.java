package com.ta.index;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.ta.model.HotelBookingEntry;

public class LookupTest {
	
	private static List<HotelBookingEntry> hbeList = new ArrayList<HotelBookingEntry>(); 
	private static HotelBookingLookup hotelLookup = new HotelBookingLookup();	
	
	
	
	static {
		hbeList.add(new HotelBookingEntry("ritz", (1<<0xF) | 1000, 5000, new Date().getTime(), 2));
		hbeList.add(new HotelBookingEntry("joes motel", (1<<0xF) | 1000, 5000, new Date().getTime(), 1));
		hbeList.add(new HotelBookingEntry("4 seasons", (1<<0xF) | 1000, 5000, new Date().getTime(), 2));
		
		hbeList.add(new HotelBookingEntry("stanford park", (1<<0xF) | 2000, 5001, new Date().getTime(), 3));
		
		hbeList.add(new HotelBookingEntry("rosewood", (1<<0xE) | 1004, 5002, new Date().getTime(), 4));
		hbeList.add(new HotelBookingEntry("beachwood", (1<<0xE) |1004, 5002, new Date().getTime(), 5));
		
		hbeList.add(new HotelBookingEntry("hilton", (1<<0xE) | 1006, 5002, new Date().getTime(), 6));
		hbeList.add(new HotelBookingEntry("marriot", (1<<0xE) | 1006, 5002, new Date().getTime(), 7));
	}
	

	@Test
	public void hotelVicinityLookupTest() {
		for (HotelBookingEntry hbe : hbeList) {
			hotelLookup.updateHotelSet(hbe.getCompanyId(), hbe.getLocationId(), hbe);
		}
		

			// this could be much more elegant, but this is an example
		Set<HotelBookingEntry> hbeListReturned = hotelLookup.getHotelSet( (1<<0xF) | 1000, 5000);
		assertTrue(hbeListReturned.size() == 3);
		
		// retrieve
	}

}
