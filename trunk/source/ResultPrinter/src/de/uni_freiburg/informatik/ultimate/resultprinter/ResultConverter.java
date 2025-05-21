package de.uni_freiburg.informatik.ultimate.resultprinter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import de.uni_freiburg.informatik.ultimate.core.coreplugin.UltimateCore;
import de.uni_freiburg.informatik.ultimate.core.lib.results.IResultWithCheck;
import de.uni_freiburg.informatik.ultimate.core.lib.results.StatisticsResult;
import de.uni_freiburg.informatik.ultimate.core.model.models.ILocation;
import de.uni_freiburg.informatik.ultimate.core.model.preferences.IPreferenceProvider;
import de.uni_freiburg.informatik.ultimate.core.model.results.IFailedAnalysisResult;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResult;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResultWithFiniteTrace;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResultWithInfiniteLassoTrace;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResultWithLocation;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResultWithSeverity;
import de.uni_freiburg.informatik.ultimate.core.model.results.ITimeoutResult;
import de.uni_freiburg.informatik.ultimate.resultprinter.format.Config;
import de.uni_freiburg.informatik.ultimate.resultprinter.format.Content;
import de.uni_freiburg.informatik.ultimate.resultprinter.format.Input;
import de.uni_freiburg.informatik.ultimate.resultprinter.format.Output;
import de.uni_freiburg.informatik.ultimate.resultprinter.format.Results;
import de.uni_freiburg.informatik.ultimate.resultprinter.writer.JsonResultWriter;

/**
 *
 * @author Manuel Bentele (
 */
public class ResultConverter {

	public static String dump(final IPreferenceProvider prefProvider, final Map<String, List<IResult>> results) {
		final JsonResultWriter writer = new JsonResultWriter();
		return writer.formatResults(ResultConverter.convert(prefProvider, results));
	}

	private static Output convert(final IPreferenceProvider prefProvider, final Map<String, List<IResult>> results) {

		final String version = UltimateCore.getInformationService().getCoreVersion();
		// toolchain plugins, settings

		// final Map<String, String> mp = UltimateCore.getInformationService().getAllPreferences().entrySet().stream()
		// .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));
		final Map<String, List<Entry<String, Object>>> mp = UltimateCore.getInformationService()
				.getDiffPreferencesPerPlugin().entrySet().stream().filter(e -> !e.getValue().isEmpty())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

		final Config config = new Config(Arrays.asList(UltimateCore.getPluginNames()), mp);
		// input files
		final Input input = new Input(new ArrayList<>());
		final Results resData = ResultConverter.transform(results);

		final Date time = Date.from(Instant.now());
		final Content content = new Content(version, config, input, resData);

		return new Output(time, content);
	}

	private static Results transform(final Map<String, List<IResult>> results) {

		for (final Entry<String, List<IResult>> entry : results.entrySet()) {
			final List<IResult> toolResults = entry.getValue();
			for (final IResult result : toolResults) {

				final String resPlugin = result.getPlugin();
				final String resShortDesc = result.getShortDescription();
				final String resLongDesc = result.getLongDescription();

				if (result instanceof IFailedAnalysisResult) {
					final IFailedAnalysisResult res = IFailedAnalysisResult.class.cast(result);
					// do nothing
				}

				if (result instanceof IResultWithCheck) {
					final IResultWithCheck res = IResultWithCheck.class.cast(result);
					res.getCheckedSpecification();
				}

				if (result instanceof IResultWithFiniteTrace) {
					final IResultWithFiniteTrace<?, ?> res = IResultWithFiniteTrace.class.cast(result);
					res.getFailurePath();
					res.getProgramExecution();
				}

				if (result instanceof IResultWithInfiniteLassoTrace) {
					final IResultWithInfiniteLassoTrace<?, ?> res = IResultWithInfiniteLassoTrace.class.cast(result);
					res.getLasso();
					res.getStem();
				}

				if (result instanceof IResultWithLocation) {
					final IResultWithLocation res = IResultWithLocation.class.cast(result);
					final ILocation loc = res.getLocation();
					loc.getAnnotationsAsMap();
					loc.getFileName();
					loc.getFunction();
					loc.getStartLine();
					loc.getEndLine();
					loc.getStartColumn();
					loc.getEndColumn();
				}

				if (result instanceof IResultWithSeverity) {
					final IResultWithSeverity res = IResultWithSeverity.class.cast(result);
					res.getSeverity();
				}

				if (result instanceof ITimeoutResult) {
					final ITimeoutResult res = ITimeoutResult.class.cast(result);
					// do nothing
				}

				// Do not handle classes here, only use methods defined by interfaces
				if (result instanceof StatisticsResult) {
					final StatisticsResult<?> res = StatisticsResult.class.cast(result);
					res.getStatistics();
				}
			}
		}

		return null;
	}
}
