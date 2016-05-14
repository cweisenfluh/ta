package com.ta.index;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ta.model.HotelBookingEntry;


// suppose this could extend some sort of generic lookup class
public class HotelBookingLookup implements IHotelLookup<HotelBookingEntry> {

		// number of bits used to determine the partition
	private static int PARTITION_BITS = 2;
	 
	private static int PARTITION_COUNT = (1<<PARTITION_BITS);
	private static int PARTITION_SHIFT = 0xE;
	
		// bits 15/14
	private static int PARTITION_MASK = 0xC000;
	
		// simple partitioning scheme that uses top bits of id
		// to determine which partition.
	private static List<ILookupCache<HotelBookingEntry>> hotelCacheList = null;
		
	public HotelBookingLookup() {
		super();
			
		if (hotelCacheList == null) {
			hotelCacheList = new ArrayList<ILookupCache<HotelBookingEntry>>();
			
			for (int i = 0;  i < PARTITION_COUNT; ++i) {
				ILookupCache<HotelBookingEntry> cache = new HotelBookingCache();
				hotelCacheList.add(i, cache);
			}
		}
	}

	@Override
	public Set<HotelBookingEntry> getHotelSet(int companyId, int locationId) {
		if (hotelCacheList == null) {
			// error
		}
				
		Set<HotelBookingEntry> set = getCacheEntries(companyId, locationId);
		
		if (set == null) {
			// this means we have a new hotel for a company
		}
		
		return set;
	}

	public Set<HotelBookingEntry> getCacheEntries(int companyId, int locationId) {
		ILookupCache<HotelBookingEntry> cache = getCache(companyId);
		
		long index = getIndex(companyId, locationId);
		
		return cache.retrieveValue(index);
		
	}
	
	public ILookupCache<HotelBookingEntry> getCache(int companyId) {
		// take top two bits.  dont really need mask
		int partition = getPartition(companyId);

		return  hotelCacheList.get(partition);		
	}
	
	public int getPartition(int id) {
		// take top two bits.  dont really need mask
		return (id & PARTITION_MASK) >> PARTITION_SHIFT;
		
	}
	
	public long getIndex(int companyId, int locationId) {
		return companyId << 16 | locationId;
	}


	@Override
	public Set<HotelBookingEntry> updateHotelSet(int companyId, int locationId, HotelBookingEntry hotel) {
		
		// just add the most recent use to the start of the list
		// could get creative with this:  there is a count and
		// a timestamp
		
		Set<HotelBookingEntry> set = getCacheEntries( companyId,  locationId) ;
		
		if (set == null) {
			set = new HashSet<HotelBookingEntry>();
		}
		
		set.add(hotel);
		
		long index = getIndex(companyId, locationId);

		ILookupCache<HotelBookingEntry> cache = getCache(companyId);

		cache.updateValue(index, set);
		
		return set;
	}

}
