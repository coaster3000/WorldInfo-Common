/**
 * This file is part of WorldInfo, licensed under the MIT License (MIT).
 *
 * Copyright (c) WorldInfo
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tk.coaster3000.worldinfo.common.config;

import java.io.File;

public abstract class Settings {

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Default Settings
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	static final boolean defSaveOnChange = true;
	static final Mode defPrimaryMode = Mode.File;
	static final boolean defUidEnabled = true;
	static final boolean defNameEnabled = true;
	static final boolean defFileEnabled = true;

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// Setting Fields
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	protected boolean saveOnChange = defSaveOnChange;
	protected Mode primaryMode = Mode.File;
	protected boolean uidEnabled = defUidEnabled;
	protected boolean nameEnabled = defNameEnabled;
	protected boolean fileEnabled = defFileEnabled;

	protected File configFile;	  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	 //Constructors	 //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Settings(File configFile) {
		this.configFile = configFile;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Instanced methods
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public final boolean isSavingOnChange() {
		return saveOnChange;
	}

	public final Mode getPrimaryMode() {
		return primaryMode;
	}

	public final void setPrimaryMode(Mode mode) {
		this.primaryMode = mode;
		if (isSavingOnChange())	save();
	}

	public final boolean isUidEnabled() {
		return uidEnabled;
	}

	public final void setUidEnabled(boolean enabled) {
		this.uidEnabled = enabled;
		if (isSavingOnChange())	save();
	}

	public final boolean isNameEnabled() {
		return nameEnabled;
	}

	public final void setNameEnabled(boolean enabled) {
		this.nameEnabled = enabled;
		if (isSavingOnChange())	save();
	}

	public final boolean isFileEnabled() {
		return fileEnabled;
	}

	public final void setFileEnabled(boolean enabled) {
		this.fileEnabled = enabled;
		if (isSavingOnChange())	save();
	}

	public abstract void save();

	public abstract void load();

	public final void setSaveOnChange(boolean saveOnChange) {
		this.saveOnChange = saveOnChange;
		save();
	}
}
