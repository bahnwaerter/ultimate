package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Results extends Entry {

	public static final String NAME = "results";

	@SerializedName("results")
	final Map<String, List<Result>> mResults;

	public Results(final Map<String, List<Result>> results) {
		super(NAME);
		mResults = results;
	}

	public Map<String, List<Result>> getResults() {
		return mResults;
	}
}
