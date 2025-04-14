package de.uni_freiburg.informatik.ultimate.resultprinter.json;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.uni_freiburg.informatik.ultimate.resultprinter.writer.AbstractResultWriter;

public class JsonResultWriter extends AbstractResultWriter {

	public static final Gson WRITER = new GsonBuilder().setPrettyPrinting().enableComplexMapKeySerialization()
			.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setDateFormat(DateFormat.LONG, DateFormat.SHORT)
			.create();

	@Override
	public String formatResults(final Object results) {
		return WRITER.toJson(results);
	}

	@Override
	public void writeResults(final Object results, final Writer writer) throws IOException {
		WRITER.toJson(results, writer);
	}
}
