package de.uni_freiburg.informatik.ultimate.witnessparser.yaml;

public class LoopInvariantEntry extends WitnessEntry {
	
	/**
	 * Witness entry name of the YAML witness format.
	 */
	public static final String NAME = "loop_invariant";
	
	private final String mRequirement;
	private final String mFormat;
	private final String mType;
	private final Location mLocation;
	
	public LoopInvariantEntry() {
		this(null, null, null, null);
	}
	
	public LoopInvariantEntry(String requirement, String format, String type,
			Location location) {
		super(NAME);
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
