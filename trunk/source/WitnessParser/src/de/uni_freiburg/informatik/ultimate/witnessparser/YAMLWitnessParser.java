package de.uni_freiburg.informatik.ultimate.witnessparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.amihaiemil.eoyaml.Yaml;

import de.uni_freiburg.informatik.ultimate.core.model.models.ModelType;
import de.uni_freiburg.informatik.ultimate.core.model.services.ILogger;
import de.uni_freiburg.informatik.ultimate.core.model.services.IUltimateServiceProvider;
import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.Location;
import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.LocationInvariant;
import de.uni_freiburg.informatik.ultimate.witnessparser.yaml.LoopInvariant;

public class YAMLWitnessParser {
	
	public YAMLWitnessParser() throws FileNotFoundException {
		Yaml.createYamlInput(new File("/home/katie/witness.yml"));
		Yaml.createYamlInput("-bla\n- blub");
		// TODO Auto-generated constructor stub
	}

	if (home/katie/witness.yml.contains("location invariant")) { //wrong if statement for this -- want to write: if YML file has this...
		String mRequirement;
		String mFormat;
		String mType;
		Location mLocation;
		
		new LocationInvariant(mRequirement, mFormat, mType, mLocation);
	}
	
	if (home/katie/witness.yml.contains("loop invariant")) {
		String mRequirement;
		String mFormat;
		String mType;
		Location mLocation;
		
		new LoopInvariant(mRequirement, mFormat, mType, mLocation);
	}
	
	if (home/katie/witness.yml.contains("location")) {
		String mName; 
		int mLine;
		int mColumn;
		String mFileName;
		String mUuid;
		
		new Location(mName, mLine, mColumn, mFileName, mUuid);
	}
	// Overall Todo list:
	// Read in the file
	// Decide which kind of invariant it is
	// Apply the correct class to the file and read it in to ultimate
	
	
 } 
}
