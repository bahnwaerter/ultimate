package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import com.google.gson.annotations.SerializedName;

public class Result extends Entry {

	public static final String NAME = "result";

	@SerializedName("type")
	final String mType;

	public Result(final String type) {
		super(NAME);
		mType = type;
	}

	public String getType() {
		return mType;
	}
}
