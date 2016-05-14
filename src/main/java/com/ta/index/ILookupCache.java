package com.ta.index;

import java.util.List;
import java.util.Set;

import com.ta.model.HotelBookingEntry;

/*
 * There may be many caches on different servers 
 * thus this could be implemented as a service - 
 * likely leveraging something like memcache
 * 
 * this is a simple example of how this could be approached
 */

public interface ILookupCache<T> {
	public void initCache();
	public void repopulate();
	public Set<HotelBookingEntry> retrieveValue(long index);
	public Set<Long> getAllIndexes();
	Set<HotelBookingEntry> updateValue(long index, Set<T> value);
}
