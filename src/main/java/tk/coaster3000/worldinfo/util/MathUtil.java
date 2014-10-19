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

import tk.coaster3000.worldinfo.vectors.Vector2;
import tk.coaster3000.worldinfo.vectors.Vector3;

public class MathUtil {
	public static double volume(double length, double width, double height) {
		return length * width * height;
	}

	public static double area(double length, double width) {
		return length * width;
	}

	public static double euclideanDistance(Vector2 vector, Vector2 vector2) {
		return java.lang.Math.sqrt(java.lang.Math.pow(vector.getX().doubleValue() - vector2.getX().doubleValue(), 2)
				+ java.lang.Math.pow(vector.getY().doubleValue() - vector2.getY().doubleValue(), 2));
	}

	public static double euclideanDistance(Vector3 vector, Vector3 vector2) {
		return java.lang.Math.sqrt(java.lang.Math.pow(vector.getX().doubleValue() - vector2.getX().doubleValue(), 2)
				+ java.lang.Math.pow(vector.getY().doubleValue() - vector2.getY().doubleValue(), 2)
				+ java.lang.Math.pow(vector.getZ().doubleValue() - vector2.getZ().doubleValue(), 2));
	}

	public static double manhattanDistance(Vector2 vector, Vector2 vector2) {
		return toPositive(vector.getX().doubleValue() - vector2.getX().doubleValue()) + toPositive(
				vector.getY().doubleValue() - vector2.getY().doubleValue());
	}

	public static double manhattanDistance(Vector3 vector, Vector3 vector2) {
		return toPositive(vector.getX().doubleValue() - vector2.getX().doubleValue()) + toPositive(
				vector.getY().doubleValue() - vector2.getY().doubleValue()) + toPositive(
				vector.getZ().doubleValue() - vector2.getZ().doubleValue());
	}

	public static int toPositive(int number) {
		return number < 0 ? number * -1 : number;
	}

	public static double toPositive(double number) {
		return number < 0 ? number * -1 : number;
	}

	public static float toPositive(float number) {
		return number < 0 ? number * -1 : number;
	}

	public static long toPositive(long number) {
		return number < 0 ? number * -1 : number;
	}
}
