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

import de.uni_freiburg.informatik.ultimate.core.model.IOutput;
import de.uni_freiburg.informatik.ultimate.core.model.models.ModelType;
import de.uni_freiburg.informatik.ultimate.core.model.observers.IObserver;
import de.uni_freiburg.informatik.ultimate.core.model.preferences.IPreferenceInitializer;
import de.uni_freiburg.informatik.ultimate.core.model.services.ILogger;
import de.uni_freiburg.informatik.ultimate.core.model.services.IResultService;
import de.uni_freiburg.informatik.ultimate.core.model.services.IUltimateServiceProvider;
import de.uni_freiburg.informatik.ultimate.resultprinter.preferences.PreferenceInitializer;

/**
 * Ultimate plug-in to output toolchain results into a file.
 *
 * @author Manuel Bentele (bentele@informatik.uni-freiburg.de)
 */
public class ResultPrinter implements IOutput {

	/**
	 * Service provider that offers all services.
	 */
	private IUltimateServiceProvider mServices;

	@Override
	public boolean isGuiRequired() {
		return false;
	}

	@Override
	public ModelQuery getModelQuery() {
		return ModelQuery.LAST;
	}

	@Override
	public List<String> getDesiredToolIds() {
		return null;
	}

	@Override
	public void setInputDefinition(final ModelType graphType) {
		// not required
	}

	@Override
	public List<IObserver> getObservers() {
		final ILogger logger = mServices.getLoggingService().getLogger(getPluginID());
		final IResultService resultService = mServices.getResultService();
		return List.of(new ResultPrinterObserver(logger, resultService));
	}

	@Override
	public void setServices(final IUltimateServiceProvider services) {
		mServices = services;
	}

	@Override
	public void init() {
		// not required
	}

	@Override
	public void finish() {
		// not required
	}

	@Override
	public String getPluginName() {
		return Activator.PLUGIN_NAME;
	}

	@Override
	public String getPluginID() {
		return Activator.PLUGIN_ID;
	}

	@Override
	public IPreferenceInitializer getPreferences() {
		return new PreferenceInitializer();
	}
}
