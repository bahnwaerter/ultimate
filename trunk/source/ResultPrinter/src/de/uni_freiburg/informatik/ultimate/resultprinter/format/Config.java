package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Config extends Entry {

	public static final String NAME = "config";

	@SerializedName("toolchain")
	private final List<String> mToolchainPlugins;

	@SerializedName("settings")
	private final Map<String, String> mSettings;

	public Config(final List<String> toolchainPlugins, final Map<String, String> settings) {
		super(NAME);
		mToolchainPlugins = toolchainPlugins;
		mSettings = settings;
	}

	public List<String> getToolchain() {
		return mToolchainPlugins;
	}

	public Map<String, String> getSettings() {
		return mSettings;
	}
}
