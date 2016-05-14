package com.ta.index;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ta.model.HotelBookingEntry;

/*
 * hi Ari-  a few thoughts;
 * 
 * obviously an overly simplified example of a cache implementation
 * the main idea is that this implementation can change independently
 * of all the stuff upstream.
 * 
 * a bit of a cheat on the synchronization stuff, but the point is it
 * is considered
 * 
 * would want to add many checks and logging
 * 
 */
public class HotelBookingCache implements ILookupCache<HotelBookingEntry> {
	private Map<Long, Set<HotelBookingEntry>> cache = null;
	
	public HotelBookingCache() {
		super();
		initCache();
	}
	
	@Override
	public void initCache() {	
		if (cache == null) {
			cache = Collections.synchronizedMap( new LinkedHashMap<Long, Set<HotelBookingEntry>>());
		}
	}

	@Override
	public void repopulate() {
		
	}

	@Override
	public Set<HotelBookingEntry> retrieveValue(long index) {
		return cache.get(index);
	}
	
	@Override
	public Set<Long> getAllIndexes() {
		return (Set<Long>) cache.keySet();
	}

	@Override
	public Set<HotelBookingEntry> updateValue(long index, Set<HotelBookingEntry> value) {
		
		return cache.put(new Long(index), value);
	}

}
