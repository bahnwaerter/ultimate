package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Output {

	@SerializedName("time")
	final Date mTime;

	@SerializedName("ultimate")
	final Content mUltimate;

	public Output(final Date time, final Content ultimate) {
		mTime = time;
		mUltimate = ultimate;
	}

	public Date getTimestamp() {
		return mTime;
	}

	public Content getUltimate() {
		return mUltimate;
	}
}
