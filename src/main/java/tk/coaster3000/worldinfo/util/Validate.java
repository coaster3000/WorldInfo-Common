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
package tk.coaster3000.worldinfo.util;

import java.util.Collection;

public class Validate {
	public static void notNull(Object object) {
		notNull(object, "Object may not be null.");
	}

    public static void notNullOrEmpty(Object object) {
        notNull(object);
    }

	public static void notNull(Object object, String message) {
		if (object == null) throw new IllegalArgumentException(message);
	}

    public static void notNullOrEmpty(Object[] objects) {
        notNullOrEmpty(objects, "Object must not be null or empty.");
    }

    public static void notNullOrEmpty(Object[] objects, String message) {
        notNull(objects);
        if (objects.length == 0) throw new IllegalArgumentException(message);
    }

    public static void notNullOrEmpty(Collection<?> objects) {
        notNullOrEmpty(objects, "Collection may not be null or empty!");
    }

    public static void notNullOrEmpty(Collection<?> objects, String message) {
        notNull(objects);
        if (objects.size() == 0) throw new IllegalArgumentException(message);
    }

    public static void notNullOrEmpty(String object) {
        notNullOrEmpty(object, "String may not be null or empty!");
    }

    public static void notNullOrEmpty(String object, String message) {
        notNull(object);
        if (object.length() == 0) throw new IllegalArgumentException(message);
    }
}
