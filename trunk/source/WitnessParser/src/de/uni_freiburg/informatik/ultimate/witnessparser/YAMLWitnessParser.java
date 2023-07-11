package de.uni_freiburg.informatik.ultimate.witnessparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.amihaiemil.eoyaml.Node;
import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlInput;
import com.amihaiemil.eoyaml.YamlMapping;
import com.amihaiemil.eoyaml.YamlNode;

import de.uni_freiburg.informatik.ultimate.core.model.models.ModelType;
import de.uni_freiburg.informatik.ultimate.core.model.services.ILogger;
import de.uni_freiburg.informatik.ultimate.core.model.services.IUltimateServiceProvider;
import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.Location;
import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.LocationInvariant;
import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.LoopInvariant;

public class YAMLWitnessParser {
	private YamlMapping mWitnessContentMapping;
	// how to take file as an expression.. use contains to find invariants or something else?
	public YAMLWitnessParser() throws FileNotFoundException {
		
		//Yaml.createYamlInput("-bla\n- blub"); // Current placeholder in case of test
		
		// initializes witnessContent, which is a file holding all of the YAML file 
		YamlInput witnessContent = Yaml.createYamlInput(new File("/home/katie/sv-witnesses/trex04.invariant_witness.yml"));
		try {
			mWitnessContentMapping = witnessContent.readYamlMapping();
		} catch (IOException e) { //use try/catch in order to ensure that it is read
			e.printStackTrace();
		}
		
	}
	
	public void parseWitnessEntries() {
		//this function parses all entries of the YAML file and saves one as a variable mSequence
		mWitnessContentMapping.witnessContent();  
		//mWitnessContentMapping.yamlSequence(null) // placeholder only used in case needed for testing
		String mSequence = mWitnessContentMapping.yamlSequence(0); //can't use integers

	}

	public void parseWitnessEntry(YamlNode entry) {
		
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
