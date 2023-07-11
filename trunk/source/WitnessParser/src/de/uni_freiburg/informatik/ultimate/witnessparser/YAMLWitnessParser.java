package de.uni_freiburg.informatik.ultimate.witnessparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.amihaiemil.eoyaml.Node;
import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlInput;
import com.amihaiemil.eoyaml.YamlNode;
import com.amihaiemil.eoyaml.YamlSequence;
import com.amihaiemil.eoyaml.exceptions.YamlReadingException;

import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.Location;
import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.LocationInvariant;
import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.LoopInvariant;

public class YAMLWitnessParser {
	
	public YAMLWitnessParser(final YamlInput witnessInput) {
		try {
			final YamlSequence witnessEntries = witnessInput.readYamlStream().asSequence();
			parseWitnessEntries(witnessEntries);
		} catch (YamlReadingException | ClassCastException | IOException e) {
			e.printStackTrace();
		}
	}

	public static YAMLWitnessParser fromString(final String input) {
		final YamlInput witnessInput = Yaml.createYamlInput(input);
		return new YAMLWitnessParser(witnessInput);
	}

	public static YAMLWitnessParser fromFile(final File input) throws FileNotFoundException {
		final YamlInput witnessInput = Yaml.createYamlInput(input);
		return new YAMLWitnessParser(witnessInput);
	}

	public void parseWitnessEntries(final YamlSequence witnessEntries) {
		for (final YamlNode witnessEntry : witnessEntries) {
			parseWitnessEntry(witnessEntry);
		}
	}

	private void parseWitnessEntry(final YamlNode entry) {
		
		assert(entry.type() == Node.MAPPING);

		final  String entry_type_value = entry.asMapping().string("entry_type");
		
		if (entry_type_value == "location_invariant") { 
			String mRequirement;
			String mFormat;
			String mType;
			Location mLocation;

			new LocationInvariant(mRequirement, mFormat, mType, mLocation);
		}

		if (entry_type_value == "loop_invariant") {
			String mRequirement;
			String mFormat;
			String mType;
			Location mLocation;

			new LoopInvariant(mRequirement, mFormat, mType, mLocation);
		}

		else if (entry_type_value == "location") {
			String mName;
			int mLine;
			int mColumn;
			String mFileName;
			String mUuid;

			new Location(mName, mLine, mColumn, mFileName, mUuid);
		}
	}
}
