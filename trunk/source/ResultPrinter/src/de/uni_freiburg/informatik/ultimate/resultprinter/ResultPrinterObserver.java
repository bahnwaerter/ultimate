/*
 * Copyright (C) 2024 Manuel Bentele (bentele@informatik.uni-freiburg.de)
 *
 * This file is part of the ULTIMATE ResultPrinter plug-in.
 *
 * The ULTIMATE ResultPrinter plug-in is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ULTIMATE ResultPrinter plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the ULTIMATE ResultPrinter plug-in. If not, see <http://www.gnu.org/licenses/>.
 *
 * Additional permission under GNU GPL version 3 section 7:
 * If you modify the ULTIMATE ResultPrinter plug-in, or any covered work, by linking
 * or combining it with Eclipse RCP (or a modified version of Eclipse RCP),
 * containing parts covered by the terms of the Eclipse Public License, the
 * licensors of the ULTIMATE ResultPrinter plug-in grant you additional permission
 * to convey the resulting work.
 */

package de.uni_freiburg.informatik.ultimate.resultprinter;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.uni_freiburg.informatik.ultimate.core.lib.observers.BaseObserver;
import de.uni_freiburg.informatik.ultimate.core.model.models.IElement;
import de.uni_freiburg.informatik.ultimate.core.model.preferences.IPreferenceProvider;
import de.uni_freiburg.informatik.ultimate.core.model.results.IResult;
import de.uni_freiburg.informatik.ultimate.core.model.services.ILogger;
import de.uni_freiburg.informatik.ultimate.core.model.services.IResultService;

/**
 * Observer of the result printer to output the results if requested.
 *
 * @author Manuel Bentele (bentele@informatik.uni-freiburg.de)
 */
public class ResultPrinterObserver extends BaseObserver {

	/**
	 * Logger instance of the result printer plug-in to log messages.
	 */
	private final ILogger mLogger;

	/**
	 * Preference provider that offers access to all preferences.
	 */
	private final IPreferenceProvider mPrefProvider;

	/**
	 * Result service that offers all results of a toolchain's execution.
	 */
	private final IResultService mResultService;

	/**
	 * Creates a new result printer observer to print the results if requested.
	 *
	 * @param logger        Logger service.
	 * @param prefProvider  Preference provider.
	 * @param resultService Result service.
	 */
	public ResultPrinterObserver(final ILogger logger, final IPreferenceProvider prefProvider,
			final IResultService resultService) {
		mLogger = logger;
		mPrefProvider = prefProvider;
		mResultService = resultService;
	}

	@Override
	public boolean process(final IElement root) throws Throwable {
		final Map<String, List<IResult>> results = mResultService.getResults();

		for (final Entry<String, List<IResult>> result : results.entrySet()) {
			mLogger.info("RESULT Plugin: " + result.getKey());
			final List<IResult> res = result.getValue();
			for (final IResult r : res) {
				mLogger.info("RESULT         " + r);
			}
		}

		mLogger.info(ResultConverter.dump(mPrefProvider, results));

//		final Gson gson = new Gson();
//		for (final Entry<String, List<IResult>> result : results.entrySet()) {
//			mLogger.info("RESULT Plugin: " + result.getKey());
//			final List<IResult> res = result.getValue();
//			for (final IResult r : res) {
//
//				mLogger.info("RESULT         " + gson.toJson(r));
//			}
//		}

		return false;
	}
}
