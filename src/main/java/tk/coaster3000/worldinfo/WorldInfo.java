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
package tk.coaster3000.worldinfo;

import tk.coaster3000.worldinfo.common.config.Settings;
import tk.coaster3000.worldinfo.common.data.CommonPacket;
import tk.coaster3000.worldinfo.common.data.CommonPlayer;
import tk.coaster3000.worldinfo.common.data.CommonWorld;
import tk.coaster3000.worldinfo.util.Validate;

public abstract class WorldInfo<PlayerT, PacketT, WorldT> {
	protected Settings settings;

	public final void loadSettings() {
		Validate.notNull(settings);
		settings.load();
	}

	public Settings getSettings() {
		return this.settings;
	}

	public final void saveSettings() {
		Validate.notNull(settings);
		settings.save();
	}

	public abstract CommonPacket wrapPacket(PacketT packet);

	public abstract CommonPlayer<? extends CommonWorld> wrapPlayer(PlayerT player);

	public abstract CommonWorld wrapWorld(WorldT world);
}
