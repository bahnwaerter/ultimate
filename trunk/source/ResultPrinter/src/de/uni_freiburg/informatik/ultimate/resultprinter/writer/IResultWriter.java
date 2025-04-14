package de.uni_freiburg.informatik.ultimate.resultprinter.writer;

import java.io.IOException;
import java.io.Writer;

public interface IResultWriter {

	String formatResults(final Object results);

	default void writeResults(final Object results, final Writer writer) throws IOException {
		writer.write(formatResults(results));
	}
}
