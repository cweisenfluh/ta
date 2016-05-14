package com.ta.index;

import java.util.Set;

import com.ta.model.HotelBookingEntry;

public interface IHotelLookup<T> {
	public Set<T> updateHotelSet(int companyId, int locationId, T value);
	Set<HotelBookingEntry> getHotelSet(int companyId, int locationId);
}
