package de.uni_freiburg.informatik.ultimate.resultprinter.yaml;

import java.io.IOException;
import java.io.Writer;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import de.uni_freiburg.informatik.ultimate.resultprinter.writer.AbstractResultWriter;

public class YamlResultWriter extends AbstractResultWriter {

	private static final Yaml WRITER = new Yaml(getOptions());

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
