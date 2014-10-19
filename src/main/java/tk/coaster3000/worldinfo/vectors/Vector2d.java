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

public class Vector2d implements Vector2<Double, Vector2d> {

    protected double x;
    protected double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2d add(Double addend) {
        this.x += addend;
        this.y += addend;
        return this;
    }

    @Override
    public Vector2d add(Double xAddend, Double yAddend) {
        this.x += xAddend;
        this.y += yAddend;
        return this;
    }

    @Override
    public Vector2d add(Vector2 vector) {
        return add(vector.getX().doubleValue(), vector.getY().doubleValue());
    }

    @Override
    public double area(Vector2 vector) {
        return 0;
    }

    @Override
    public Vector2d div(Double numerator) {
        return this;
    }

    @Override
    public Vector2d div(Double xNumerator, Double yNumerator) {
        return this;
    }

    @Override
    public Vector2d div(Vector2 vector) {
        return this;
    }

    @Override
    public double euclideanDistance(Vector2 vector) {
        return 0;
    }

    @Override
    public Double getX() {
        return this.x;
    }

    @Override
    public Double getY() {
        return this.y;
    }

    @Override
    public double manhattanDistance(Vector2 vector) {
        return 0;
    }

    @Override
    public Vector2d mul(Double factor) {
        return this;
    }

    @Override
    public Vector2d mul(Double xFactor, Double yFactor) {
        return this;
    }

    @Override
    public Vector2d mul(Vector2 vector) {
        return this;
    }

    @Override
    public Vector2d set(Vector2 vector) {
        return this;
    }

    @Override
    public Vector2d setX(Double x) {
        return this;
    }

    @Override
    public Vector2d setY(Double y) {
        return this;
    }

    @Override
    public Vector2d sub(Double subtrahend) {
        return this;
    }

    @Override
    public Vector2d sub(Double xSubtrahend, Double ySubtrahend) {
        return this;
    }

    @Override
    public Vector2d sub(Vector2 vector) {
        return this;
    }

    @Override
    public Vector2d zero() {
        return this;
    }
}
