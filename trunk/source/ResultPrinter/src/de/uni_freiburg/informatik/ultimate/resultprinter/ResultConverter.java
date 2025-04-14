package de.uni_freiburg.informatik.ultimate.resultprinter;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.uni_freiburg.informatik.ultimate.core.lib.results.IResultWithCheck;
import de.uni_freiburg.informatik.ultimate.core.lib.results.StatisticsResult;
import de.uni_freiburg.informatik.ultimate.core.model.models.ILocation;
import de.uni_freiburg.informatik.ultimate.core.model.results.IFailedAnalysisResult;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResult;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResultWithFiniteTrace;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResultWithInfiniteLassoTrace;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResultWithLocation;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResultWithSeverity;
import de.uni_freiburg.informatik.ultimate.core.model.results.ITimeoutResult;
import de.uni_freiburg.informatik.ultimate.resultprinter.format.Results;

public class ResultConverter {

	public static Results transform(final Map<String, List<IResult>> results) {
		// converts IResults to Results

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
				if (result instanceof IResultWithSeverity) {
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
