package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Input extends Entry {

	public static final String NAME = "input";

	@SerializedName("files")
	private final List<String> mFiles;

	public Input(final List<String> files) {
		super(NAME);
		mFiles = files;
	}

	public List<String> getFiles() {
		return mFiles;
	}
}
