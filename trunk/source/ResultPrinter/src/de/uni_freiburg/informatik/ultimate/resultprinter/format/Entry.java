package de.uni_freiburg.informatik.ultimate.resultprinter.format;

import java.util.Objects;

/**
 * Represents a generic result entry in the result output format.
 *
 * @author Manuel Bentele
 */
public abstract class Entry {

	private final String mName;

	public Entry(final String name) {
		mName = Objects.requireNonNull(name);
	}

	public String getName() {
		return mName;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}
}
