package com.ta.index;

import java.util.Set;

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
	public Set<T> retrieveValue(long index);
	public Set<Long> getAllIndexes();
	Set<T> updateValue(long index, Set<T> value);
}
