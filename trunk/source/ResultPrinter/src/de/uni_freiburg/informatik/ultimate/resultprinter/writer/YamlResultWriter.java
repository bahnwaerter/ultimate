package de.uni_freiburg.informatik.ultimate.resultprinter.writer;

import java.io.IOException;
import java.io.Writer;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

/**
 * Result writer for the YAML output format.
 *
 * @author Manuel Bentele (bentele@informatik.uni-freiburg.de)
 */
public class YamlResultWriter extends AbstractResultWriter {

	/**
	 * YAML serialization instance.
	 */
	private static final Yaml WRITER = new Yaml(getOptions());

	/**
	 * Return configuration options to create the YAML serialization instance.
	 *
	 * @return Configuration options for the YAML serialization instance.
	 */
	private static final DumperOptions getOptions() {
		final DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		options.setPrettyFlow(true);
		options.setSplitLines(false);
		options.setIndent(2);
		return options;
	}

	@Override
	public String formatResults(final Object results) {
		return WRITER.dump(results);
	}

	@Override
	public void writeResults(final Object results, final Writer writer) throws IOException {
		WRITER.dump(results, writer);
	}
}
