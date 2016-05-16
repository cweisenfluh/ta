package com.ta.index;

import java.util.Set;

	// the thinking here is all things hotel that need to be looked up would go here
public interface IHotelLookup<T> {
	public Set<T> updateHotelSet(int companyId, int locationId, T value);
	Set<T> getHotelSet(int companyId, int locationId);
}
