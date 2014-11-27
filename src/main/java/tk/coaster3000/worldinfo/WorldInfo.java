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

import tk.coaster3000.worldinfo.common.config.SettingsProvider;
import tk.coaster3000.worldinfo.common.data.ICommonPacket;
import tk.coaster3000.worldinfo.common.data.ICommonPlayer;
import tk.coaster3000.worldinfo.common.data.ICommonWorld;

public abstract class WorldInfo<
		REQ_PLAYER_TYPE, REQ_PACKET_TYPE, REQ_WORLD_TYPE,
		RET_PLAYER extends ICommonPlayer<RET_WORLD>,
		RET_PACKET extends ICommonPacket,
		RET_WORLD extends ICommonWorld<RET_PLAYER>> {
	public static final String PLUGIN_CHANNEL = "world_info";

	public final void loadSettings() {
		getSettings().load();
	}

	public abstract SettingsProvider getSettings();

	public final void saveSettings() {
		getSettings().save();
	}

	public abstract RET_PACKET wrapPacket(REQ_PACKET_TYPE packet);

	public abstract RET_PLAYER wrapPlayer(REQ_PLAYER_TYPE player);

	public abstract RET_WORLD wrapWorld(REQ_WORLD_TYPE world);
}
