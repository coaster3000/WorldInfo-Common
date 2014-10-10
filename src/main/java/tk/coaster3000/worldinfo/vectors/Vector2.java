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

public interface Vector2<T extends Number, R extends Vector2> {

    public R add(T addend);

    public R add(T xAddend, T yAddend);

    public R add(Vector2 vector);

    public double area(Vector2 vector);

    public R div(T numerator);

    public R div(T xNumerator, T yNumerator);

    public R div(Vector2 vector);

    public double euclideanDistance(Vector2 vector);

    public T getX();

    public T getY();

    public double manhattanDistance(Vector2 vector);

    public R mul(T factor);

    public R mul(T xFactor, T yFactor);

    public R mul(Vector2 vector);

    public R set(Vector2 vector);

    public R setX(T x);

    public R setY(T y);

    public R sub(T subtrahend);

    public R sub(T xSubtrahend, T ySubtrahend);

    public R sub(Vector2 vector);

    public R zero();
}