package com.ta.model;

public class HotelBookingEntry {
	private String name;
	private int locationId;
	private int companyId;
	private long lastUsedTimestamp;
	private int count;
	
	public HotelBookingEntry(String name, int companyId, int locationId, long timestamp, int count) {
		super();
		this.name = name;
		this.companyId = companyId;
		this.locationId = locationId;
		this.lastUsedTimestamp = timestamp;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public long getLastUsedTimestamp() {
		return lastUsedTimestamp;
	}

	public void setLastUsedTimestamp(long lastUsedTimestamp) {
		this.lastUsedTimestamp = lastUsedTimestamp;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}	
}
