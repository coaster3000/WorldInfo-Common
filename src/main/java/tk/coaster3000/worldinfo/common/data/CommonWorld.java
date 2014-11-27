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
package tk.coaster3000.worldinfo.common.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public abstract class CommonWorld<PLAYER extends ICommonPlayer<? extends ICommonWorld<PLAYER>>> implements ICommonWorld<PLAYER> {

	protected UUID uid;
	protected String name;
	protected String customName;

	/**
	 * Only implement if needed.
	 */
	protected CommonWorld() {

	}

	public void load() {
		File uidFile = getUidFile();
		if (uidFile.exists()) {
			DataInputStream dis = null;
			try {
				dis = new DataInputStream(new FileInputStream(uidFile));
				uid = new UUID(dis.readLong(), dis.readLong());
				return;
			} catch (IOException ex) {
				handleException(ex);
			} finally {
				if (dis != null) {
					try {
						dis.close();
					} catch (IOException ex) {
						// NOOP
					}
				}
			}
		}
		uid = UUID.randomUUID();
		saveUid();
	}

	protected void saveUid() {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(getUidFile()));
			dos.writeLong(uid.getMostSignificantBits());
			dos.writeLong(uid.getLeastSignificantBits());
		} catch (IOException ex) {
			handleException(ex);
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException ex) {
					// NOOP
				}
			}
		}
	}

	@Override
	public abstract PLAYER[] getPlayers();

	@Override
	public abstract boolean hasPlayer(PLAYER player);

	protected abstract void handleException(Exception exception);

	public void save() {
		saveUid();
	}

	public CommonWorld(UUID uid, String name) {
		this.uid = uid;
		this.name = name;
	}

	public final UUID getUID() {
		return uid;
	}

	abstract File getUidFile();

	public final String getName() {
		return name;
	}

	public final String getCustomName() {
		return customName;
	}
}