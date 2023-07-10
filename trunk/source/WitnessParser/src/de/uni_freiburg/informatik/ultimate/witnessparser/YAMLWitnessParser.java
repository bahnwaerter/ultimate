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

public class YAMLWitnessParser {

	// Create constructor to make Witness Parser
	
	public YAMLWitnessParser() throws FileNotFoundException {
		Yaml.createYamlInput(new File("/home/katie/witness.yml"));
		Yaml.createYamlInput("-bla\n- blub");
		// TODO Auto-generated constructor stub
	}
	
	/*InputStream inputStream = this.getClass()
			.getClassLoader()
			.getResourceAsStream("/home/katie/witness.yml");
	Map<String, Object> attributes = yaml.load(inputStream);
	System.out.println(attributes);
	*/

	if (yamlfile.contains("location invariant")) {
		String requirement;
		String format;
		String type;
		Location location;
		
		new LocationInvariant(requirement, format, type,location);
	}
	 
	// Overall Todo list:
	// Read in the file
	// Decide which kind of invariant it is
	// Apply the correct class to the file and read it in to ultimate
	
	
}
