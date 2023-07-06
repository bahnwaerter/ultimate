package de.uni_freiburg.informatik.ultimate.witnessparser;

import java.io.File;
import java.io.FileNotFoundException;

import com.amihaiemil.eoyaml.Yaml;

public class YAMLWitnessParser {

	public YAMLWitnessParser() throws FileNotFoundException {
		Yaml.createYamlInput(new File("/home/katie/witness.yml"));
		Yaml.createYamlInput("-bla\n- blub");
		// TODO Auto-generated constructor stub
	}
}
