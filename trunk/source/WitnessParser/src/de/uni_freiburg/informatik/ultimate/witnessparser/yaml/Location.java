package de.uni_freiburg.informatik.ultimate.witnessparser.yaml;

public class Location {
	private final String mName; 
	private final int mLine;
	private final int mColumn;
	private final String mFileName;
	private final String mUuid;
	
	public Location(String name, int line, int column, String fileName, String uuid) {
		super();
		mName = name;
		mLine = line;
		mColumn = column;
		mFileName = fileName;
		mUuid = uuid;
	}

	public String getName() {
		return mName;
	}
	public int getLine() {
		return mLine;
	}
	public int getColumn() {
		return mColumn;
	}
	public String getFileName() {
		return mFileName;
	}
	public String getUuid() {
		return mUuid;
	}
	
}


 