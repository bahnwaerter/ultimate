package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Input {

	@SerializedName("files")
	private final List<String> mFiles;

	public Input(final List<String> files) {
		mFiles = files;
	}

	public List<String> getFiles() {
		return mFiles;
	}
}
