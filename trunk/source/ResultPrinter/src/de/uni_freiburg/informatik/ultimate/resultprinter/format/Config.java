package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.annotations.SerializedName;

public class Config {

	@SerializedName("toolchain")
	private final List<String> mToolchainPlugins;

	@SerializedName("settings")
	private final Map<String, List<Entry<String, Object>>> mSettings;

	public Config(final List<String> toolchainPlugins, final Map<String, List<Entry<String, Object>>> settings) {
		mToolchainPlugins = toolchainPlugins;
		mSettings = settings;
	}

	public List<String> getToolchain() {
		return mToolchainPlugins;
	}

	public Map<String, List<Entry<String, Object>>> getSettings() {
		return mSettings;
	}
}
