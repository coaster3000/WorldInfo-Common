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
package tk.coaster3000.worldinfo.vectors;

public interface Vector3<T extends Number, R extends Vector3> {

    public R add(T addition);

    public R add(T x, T y, T z);

    public R add(Vector3 vector);

    public R div(T numerator);

    public R div(T x, T y, T z);

    public R div(Vector3 vector);

    public double euclideanDistance(Vector3 vector);

    public T getX();

    public T getY();

    public T getZ();

    public double manhattanDistance(Vector3 vector);

    public R mul(T factor);

    public R mul(T x, T y, T z);

    public R mul(Vector3 vector);

    public R set(Vector3 values);

    public R setX(T x);

    public R setY(T y);

    public R setZ(T z);

    public R sub(T subtrahend);

    public R sub(T x, T y, T z);

    public R sub(Vector3 vector);

    public double vol(Vector3 vector);

    public R zero();
}