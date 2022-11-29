package de.m_marvin.univec.impl;

import de.m_marvin.univec.api.IVector2;
import de.m_marvin.univec.api.IVector2Math;

/*
 * Implementation of a 3 dimensional double vector
 */
public class Vec2d implements IVector2Math<Double, Vec2d, IVector2<? extends Number>> {
	
	public double x;
	public double y;
	
	public Vec2d(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2d(IVector2<? extends Number> vec) {
		this.x = vec.x().doubleValue();
		this.y = vec.y().doubleValue();
	}
	
	@Override
	public Double x() {
		return x;
	}

	@Override
	public Double y() {
		return y;
	}

	@Override
	public void setX(Double x) {
		this.x = x;
	}

	@Override
	public void setY(Double y) {
		this.y = y;
	}

	@Override
	public Vec2d setI(Double x, Double y) {
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Vec2d setI(IVector2<? extends Number> vec) {
		this.x = (Double) vec.x();
		this.y = (Double) vec.y();
		return this;
	}

	@Override
	public Vec2d copy() {
		return new Vec2d(this.x, this.y);
	}

	@Override
	public Vec2d add(IVector2<? extends Number> vec) {
		return new Vec2d(this.x + (Double) vec.x(), this.y + (Double) vec.y());
	}

	@Override
	public Vec2d add(Double x, Double y) {
		return new Vec2d(this.x + x, this.y + y);
	}

	@Override
	public Vec2d sub(IVector2<? extends Number> vec) {
		return new Vec2d(this.x - (Double) vec.x(), this.y - (Double) vec.y());
	}

	@Override
	public Vec2d sub(Double x, Double y) {
		return new Vec2d(this.x - x, this.y - y);
	}

	@Override
	public Vec2d mul(IVector2<? extends Number> vec) {
		return new Vec2d(this.x * (Double) vec.x(), this.y * (Double) vec.y());
	}

	@Override
	public Vec2d mul(Double x, Double y) {
		return new Vec2d(this.x * x, this.y * y);
	}

	@Override
	public Vec2d mul(Double n) {
		return new Vec2d(this.x * n, this.y * n);
	}
	
	@Override
	public Vec2d div(IVector2<? extends Number> vec) {
		return new Vec2d(this.x / (Double) vec.x(), this.y / (Double) vec.y());
	}

	@Override
	public Vec2d div(Double x, Double y) {
		return new Vec2d(this.x / x, this.y / y);
	}
	
	@Override
	public Vec2d div(Double n) {
		return new Vec2d(this.x / n, this.y / n);
	}

	@Override
	public Vec2d module(Double m) {
		return new Vec2d(this.x % m, this.y % m);
	}

	@Override
	public Vec2d clamp(IVector2<? extends Number> min, IVector2<? extends Number> max) {
		return new Vec2d(
				Math.max((Double) min.x(), Math.min(this.x, (Double) max.x())),
				Math.max((Double) min.y(), Math.min(this.y, (Double) max.y()))
			);
	}
	
	@Override
	public Vec2d clamp(Double min, Double max) {
		return new Vec2d(
				Math.max((Double) min, Math.min(this.x, (Double) max)),
				Math.max((Double) min, Math.min(this.y, (Double) max))
			);
	}

	@Override
	public double angle(IVector2<? extends Number> vec) {
		return Math.atan2(this.y, this.x)-Math.atan2((Double) vec.y(), (Double) vec.x());
	}
	
	@Override
	public Double cross(IVector2<? extends Number> vec) {
		return this.x * (Double) vec.y() - this.y * (Double) vec.x();	
	}
	
	@Override
	public Double dot(IVector2<? extends Number> vec) {
		return this.x * (Double) vec.x() + this.y * (Double) vec.y();
	}
	
	@Override
	public Double length() {
		return (Double) Math.sqrt(this.lengthSqrt());
	}

	@Override
	public Double lengthSqrt() {
		return this.x * this.x + this.y * this.y;
	}
	
	@Override
	public Vec2d normalize() {
		double f = this.length();
		return this.div(f);
	}
	
	@Override
	public Vec2d lerp(IVector2<? extends Number> vec, Double delta) {
		double f = 1.0F - delta;
		return new Vec2d(
				this.x * f + (Double) vec.x() * delta,
				this.y * f + (Double) vec.y() * delta
			);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec2d) {
			return	((Vec2d) obj).x == x && 
					((Vec2d) obj).y == y;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result = result * 31 + Double.hashCode(this.x);
		result = result * 31 + Double.hashCode(this.y);
		return result;
	}
	
	@Override
	public String toString() {
		return "Vec2d[" + this.x + "," + this.y + "]";
	}
	
}
