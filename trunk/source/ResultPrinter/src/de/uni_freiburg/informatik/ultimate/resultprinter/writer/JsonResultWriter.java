package de.uni_freiburg.informatik.ultimate.resultprinter.writer;

import java.io.IOException;
import java.io.Writer;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Result writer for the JSON output format.
 *
 * @author Manuel Bentele (bentele@informatik.uni-freiburg.de)
 */
public class JsonResultWriter extends AbstractResultWriter {

	/**
	 * JSON serialization instance.
	 */
	private static final Gson WRITER = Builder().create();

	/**
	 * Return builder to create the YAML serialization instance.
	 *
	 * @return Builder for the YAML serialization instance.
	 */
	private static final GsonBuilder Builder() {
		return new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
	}

	@Override
	public String formatResults(final Object results) {
		return WRITER.toJson(results);
	}

	@Override
	public void writeResults(final Object results, final Writer writer) throws IOException {
		WRITER.toJson(results, writer);
	}
}
