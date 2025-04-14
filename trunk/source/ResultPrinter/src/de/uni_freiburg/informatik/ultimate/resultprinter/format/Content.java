package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * <code>
 * ultimate: {
 *   version: 0.3.0,
 *   time: 2025-01-17 10:18
 *   config: {
 *     toolchain: [
 *       de.uni_freiburg.informatik.ultimate.traceabstraction,
 *       de.uni_freiburg.informatik.ultimate.resultprinter
 *     ],
 *     settings: [
 *       DIV_BY_ZERO=ASSERTandASSUME
 *     ]
 *   },
 *   input: {
 *     files: [
 *       /home/arch/test/main.c
 *     ]
 *   },
 *   results: [
 *     de.uni_freiburg.informatik.ultimate.resultprinter: [
 *       {
 *         type: statistics
 *         numTraces:
 *
 *     ]
 *   ]
 * }
 * </code>
 */
public class Content {

	// TODO: Root element must be called "ultimate"
	// @SerializedName("ultimate")
	// final String tool = "ultimate";

	@SerializedName("version")
	final String mVersion;

	@SerializedName("time")
	final Date mTime;

	@SerializedName(Config.NAME)
	final Config mConfig;

	@SerializedName(Input.NAME)
	final Input mInput;

	@SerializedName(Results.NAME)
	final Results mResults;

	public Content(final String version, final Date time, final Config config, final Input input,
			final Results results) {
		mVersion = version;
		mTime = time;
		mConfig = config;
		mInput = input;
		mResults = results;
	}

	public String getVersion() {
		return mVersion;
	}

	public Config getConfig() {
		return mConfig;
	}

	public Input getInput() {
		return mInput;
	}

	public Results getResults() {
		return mResults;
	}
}
