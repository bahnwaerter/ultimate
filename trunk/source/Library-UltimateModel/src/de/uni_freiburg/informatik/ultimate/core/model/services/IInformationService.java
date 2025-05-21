/*
 * Copyright (C) 2025 Manuel Bentele (bentele@informatik.uni-freiburg.de)
 *
 * This file is part of the ULTIMATE Core.
 *
 * The ULTIMATE Core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ULTIMATE Core is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the ULTIMATE Core. If not, see <http://www.gnu.org/licenses/>.
 *
 * Additional permission under GNU GPL version 3 section 7:
 * If you modify the ULTIMATE Core, or any covered work, by linking
 * or combining it with Eclipse RCP (or a modified version of Eclipse RCP),
 * containing parts covered by the terms of the Eclipse Public License, the
 * licensors of the ULTIMATE Core grant you additional permission
 * to convey the resulting work.
 */

package de.uni_freiburg.informatik.ultimate.core.model.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Service to provide immutable information about the core implementation.
 *
 * @author Manuel Bentele (bentele@informatik.uni-freiburg.de)
 */
public interface IInformationService {

	/**
	 * Returns the version of the core implementation.
	 *
	 * @return A string that describes the current version of Ultimate in the form major.minor.revision-githash[-m],
	 *         e.g., 0.1.20-dc65081-m. The "-m" signals that the working copy from which the binary was build contained
	 *         local changes.
	 */
	String getCoreVersion();

	/**
	 * Returns current settings of preferences from each framework plug-in.
	 *
	 * @return Current settings of preferences from each plug-in.
	 */
	Map<String, List<Entry<String, Object>>> getAllPreferencesPerPlugin();

	/**
	 * Returns current settings of preferences from all framework plug-ins.
	 *
	 * @return Current settings of all preferences.
	 */
	default List<Entry<String, Object>> getAllPreferences() {
		return getAllPreferencesPerPlugin().values().stream().flatMap(List::stream).collect(Collectors.toList());
	}

	/**
	 * Returns current settings of preferences from each framework plug-in that differ from their defaults.
	 *
	 * @return Current settings of preferences from each plug-in that differ from their defaults.
	 */
	Map<String, List<Entry<String, Object>>> getDiffPreferencesPerPlugin();

	/**
	 * Returns current settings of preferences from all framework plug-ins that differ from their defaults.
	 *
	 * @return Current settings of all preferences that differ from their defaults.
	 */
	default List<Entry<String, Object>> getDiffPreferences() {
		return getDiffPreferencesPerPlugin().values().stream().flatMap(List::stream).collect(Collectors.toList());
	}

	/**
	 * Returns all registered framework plug-ins.
	 *
	 * @return All registered framework plug-ins.
	 */
	Map<String, String> getAllRegisteredPlugins();

	/**
	 * Returns the names of all registered framework plug-ins.
	 *
	 * @return Names of all registered framework plug-ins.
	 */
	default List<String> getAllRegisteredPluginNames() {
		return getAllRegisteredPlugins().entrySet().stream().map(Entry::getKey).collect(Collectors.toList());
	}

	/**
	 * Returns the IDs of all registered framework plug-ins.
	 *
	 * @return IDs of all registered plug-ins.
	 */
	default List<String> getAllRegisteredPluginIDs() {
		return getAllRegisteredPlugins().entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
	}

	/**
	 * Returns all plug-ins that are executed in active toolchains.
	 *
	 * @return All active toolchain plug-ins.
	 */
	Map<String, String> getAllToolchainPlugins();

	/**
	 * Returns the IDs of plug-ins that are executed in active toolchains.
	 *
	 * @return IDs of all active toolchain plug-ins.
	 */
	default List<String> getAllToolchainPluginIDs() {
		return getAllToolchainPlugins().entrySet().stream().map(Entry::getKey).collect(Collectors.toList());
	}

	/**
	 * Returns the names of plug-ins that are executed in active toolchains.
	 *
	 * @return Names of all active toolchain plug-ins.
	 */
	default List<String> getAllToolchainPluginNames() {
		return getAllToolchainPlugins().entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
	}

}
