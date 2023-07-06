package de.uni_freiburg.informatik.ultimate.witnessparser.yaml;

public class LoopInvariant {
	private final String mRequirement;
	private final String mFormat;
	private final String mType;
	private final Location mLocation;
	
	public LoopInvariant(String requirement, String format, String type,
			de.uni_freiburg.informatik.ultimate.witnessparser.yaml.Location location) {
		super();
		mRequirement = requirement;
		mFormat = format;
		mType = type;
		mLocation = location;
	}
	
	public Location getLocation() {
		return mLocation;
	}
	
	public String getRequirement() {
		return mRequirement;
	}
	public String getType() {
		return mType;
	}
	public String getFormat() {
		return mFormat;
	}
}
