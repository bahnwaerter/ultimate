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

package de.uni_freiburg.informatik.ultimate.resultprinter.preferences;

import de.uni_freiburg.informatik.ultimate.core.lib.preferences.UltimatePreferenceInitializer;
import de.uni_freiburg.informatik.ultimate.core.model.preferences.BaseUltimatePreferenceItem;
import de.uni_freiburg.informatik.ultimate.core.model.preferences.PreferenceType;
import de.uni_freiburg.informatik.ultimate.core.model.preferences.UltimatePreferenceItem;
import de.uni_freiburg.informatik.ultimate.core.model.preferences.UltimatePreferenceItem.IUltimatePreferenceItemValidator;
import de.uni_freiburg.informatik.ultimate.core.model.preferences.UltimatePreferenceItemGroup;
import de.uni_freiburg.informatik.ultimate.core.preferences.RcpPreferenceProvider;
import de.uni_freiburg.informatik.ultimate.resultprinter.Activator;

/**
 * Preference initializer for the result printer plug-in.
 *
 * @author Manuel Bentele (bentele@informatik.uni-freiburg.de)
 */
public class PreferenceInitializer extends UltimatePreferenceInitializer {

	/**
	 * Label of the write beside input file preference option.
	 */
	public static final String LABEL_RESULT_FILE_BESIDE_INPUT_FILE = "Write result output besides input file";

	/**
	 * Default value of the write beside input file preference option.
	 */
	private static final boolean VALUE_RESULT_FILE_BESIDE_INPUT_FILE = true;

	/**
	 * Label of the JSON file preference option.
	 */
	public static final String LABEL_GENERATE_JSON_FILE = "Generate JSON file";

	/**
	 * Default value of the JSON file preference option.
	 */
	private static final boolean VALUE_GENERATE_JSON_FILE = true;

	/**
	 * Label of the YAML file preference option.
	 */
	public static final String LABEL_GENERATE_YAML_FILE = "Generate YAML file";

	/**
	 * Default value of the YAML file preference option.
	 */
	private static final boolean VALUE_GENERATE_YAML_FILE = false;

	/**
	 * Label of the SARIF file preference option.
	 */
	public static final String LABEL_GENERATE_SARIF_FILE = "Generate SARIF file";

	/**
	 * Default value of the SARIF file preference option.
	 */
	private static final boolean VALUE_GENERATE_SARIF_FILE = false;

	/**
	 * Creates a new preference initializer for the result printer plug-in.
	 */
	public PreferenceInitializer() {
		super(Activator.PLUGIN_ID, Activator.PLUGIN_NAME);
	}

	@Override
	protected BaseUltimatePreferenceItem[] initDefaultPreferences() {
		return new BaseUltimatePreferenceItem[] {

				new UltimatePreferenceItem<>(LABEL_RESULT_FILE_BESIDE_INPUT_FILE, VALUE_RESULT_FILE_BESIDE_INPUT_FILE,
						"Write result output as \"<inputfilename>-result.{json,yaml,sarif}\" in the same directory "
								+ "as the input file",
						PreferenceType.Boolean),

				new UltimatePreferenceItemGroup("Output file formats",
						new UltimatePreferenceItem<>(LABEL_GENERATE_JSON_FILE, VALUE_GENERATE_JSON_FILE,
								"Output the results in JSON file format", PreferenceType.Boolean,
								new FileFormatEnabledValidator()),
						new UltimatePreferenceItem<>(LABEL_GENERATE_YAML_FILE, VALUE_GENERATE_YAML_FILE,
								"Output the results in YAML file format", PreferenceType.Boolean,
								new FileFormatNotSupportedValidator()),
						new UltimatePreferenceItem<>(LABEL_GENERATE_SARIF_FILE, VALUE_GENERATE_SARIF_FILE,
								"Output the results in SARIF file format", PreferenceType.Boolean,
								new FileFormatNotSupportedValidator())) };
	}

	/**
	 * Preference validator that checks that at least one result output file format is enabled.
	 */
	private static final class FileFormatEnabledValidator implements IUltimatePreferenceItemValidator<Boolean> {

		/**
		 * Checks that at least one value from a list of values is true.
		 *
		 * @param values
		 *            list of values to be checked.
		 * @return {@code true} if at least one value from the list is true, otherwise {@code false}.
		 */
		private static boolean checkAtLeastOneTrue(final boolean... values) {
			for (final boolean value : values) {
				if (value) {
					// Report an error if one value is true.
					return true;
				}
			}

			// Report an error if all values are false.
			return false;
		}

		@Override
		public boolean isValid(final Boolean value) {
			final RcpPreferenceProvider rpp = new RcpPreferenceProvider(Activator.PLUGIN_ID);
			return checkAtLeastOneTrue(rpp.getBoolean(LABEL_GENERATE_JSON_FILE),
					rpp.getBoolean(LABEL_GENERATE_YAML_FILE), rpp.getBoolean(LABEL_GENERATE_SARIF_FILE));
		}

		@Override
		public String getInvalidValueErrorMessage(final Boolean value) {
			return "There must be at least one output file format for the results enabled";
		}
	}

	/**
	 * Preference validator that reports an error if a result output file format is enabled but not implemented.
	 */
	private static final class FileFormatNotSupportedValidator implements IUltimatePreferenceItemValidator<Boolean> {

		@Override
		public boolean isValid(final Boolean value) {
			if (value) {
				// Report an error if result output file format is enabled.
				return false;
			}

			// Do not report any error if result output file format is disabled.
			return true;
		}

		@Override
		public String getInvalidValueErrorMessage(final Boolean value) {
			return "Output file format for results is not implemented yet";
		}
	}
}
