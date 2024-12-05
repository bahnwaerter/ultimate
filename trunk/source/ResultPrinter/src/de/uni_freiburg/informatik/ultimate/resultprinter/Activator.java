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

import org.eclipse.core.runtime.Plugin;

/**
 * The result printer activator class to control the plug-in life cycle.
 *
 * @author Manuel Bentele (bentele@informatik.uni-freiburg.de)
 */
public class Activator extends Plugin {

	/**
	 * The result printer plug-in ID.
	 */
	public static final String PLUGIN_ID = ResultPrinter.class.getPackage().getName();

	/**
	 * The result printer plug-in name.
	 */
	public static final String PLUGIN_NAME = "Result Printer";
}
