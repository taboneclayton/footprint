/**
 * Copyright 2012 MARSEC-XL International Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.marssa.footprint.datatypes.composite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.marssa.footprint.datatypes.MString;
import org.marssa.footprint.datatypes.TypeFactory;
import org.marssa.footprint.datatypes.decimal.DegreesDecimal;
import org.marssa.footprint.datatypes.decimal.MDecimal;
import org.marssa.footprint.datatypes.integer.DegreesInteger;
import org.marssa.footprint.datatypes.integer.MInteger;
import org.marssa.footprint.logger.MMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flexjson.JSONSerializer;

/**
 * @author Alan Grech
 * @author Warren Zahra
 * @author Clayton Tabone
 * @version 1.0
 * @created 08-Jul-2011 09:53:29
 */
@XmlType(name = "APosition", factoryClass = TypeFactory.class, factoryMethod = "getAPositionInstance")
@Entity
public abstract class APosition {
	protected APosition() {
	}

	private static Logger logger = LoggerFactory.getLogger(APosition.class
			.getName());
	// TODO Remove one of the internal representations
	protected DegreesInteger deg;
	protected MInteger min;
	protected MDecimal sec;
	protected DegreesDecimal dms;

	@SuppressWarnings("unused")
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	public APosition(DegreesInteger degrees, MInteger minutes, MDecimal seconds) {
		this.deg = degrees;
		this.min = minutes;
		this.sec = seconds;
		Object[] aPosition = { degrees, minutes, seconds };
		logger.trace(
				MMarker.CONSTRUCTOR,
				"Constructor created with  Degrees:\"{}\", Minutes:\"{}\",Seconds:\"{}\" ",
				aPosition);
		// Do conversion
		if (degrees.intValue() > 0) {
			double convertedValue = (degrees.intValue() + (((minutes.intValue() * 60) + (seconds
					.doubleValue())) / 3600));
			this.dms = new DegreesDecimal(convertedValue);
		} else if (degrees.intValue() < 0) {
			double convertedValue = -(degrees.intValue() + (((minutes
					.intValue() * 60) + (seconds.doubleValue())) / 3600));
			this.dms = new DegreesDecimal(-convertedValue);
		}
	}

	public APosition(DegreesDecimal degrees) {
		logger.trace(MMarker.CONSTRUCTOR,
				"Constructor created with  Degrees:\"{}f\".", degrees);

		double degFloat = degrees.doubleValue();
		this.dms = degrees;
		this.deg = new DegreesInteger((int) java.lang.Math.floor(degFloat));

		double minFloat = 60 * java.lang.Math.abs(degFloat
				- this.deg.intValue());
		this.min = new MInteger((int) minFloat);

		double secFloat = 60 * (minFloat - this.min.intValue());
		if (secFloat == 60) {
			this.min = new MInteger(this.min.intValue() + 1);
			secFloat = 0;
		}

		this.sec = new MDecimal(secFloat);
		if (this.min.intValue() == 60) {
			this.deg = new DegreesInteger(this.deg.intValue() + 1);
			this.min = new MInteger(0);
		}
	}

	@Override
	public void finalize() throws Throwable {

	}

	@ManyToOne
	@Cascade({ CascadeType.SAVE_UPDATE })
	public DegreesInteger getDegrees() {
		logger.trace(MMarker.GETTER, "Getting Degrees: {}", deg);
		return deg;
	}

	public void setDegrees(DegreesInteger degrees) {
		this.deg = degrees;
	}

	@ManyToOne
	@Cascade({ CascadeType.SAVE_UPDATE })
	public MInteger getMinutes() {
		logger.trace(MMarker.GETTER, "Getting Minutes: {}", min);
		return min;
	}

	public void setMinutes(MInteger minutes) {
		this.min = minutes;
	}

	@ManyToOne
	@Cascade({ CascadeType.SAVE_UPDATE })
	public MDecimal getSeconds() {
		logger.trace(MMarker.GETTER, "Getting Seconds: {}", sec);
		return sec;
	}

	public void setSeconds(MDecimal seconds) {
		this.sec = seconds;
	}

	@ManyToOne
	@Cascade({ CascadeType.SAVE_UPDATE })
	public DegreesDecimal getDMS() {
		logger.trace(MMarker.GETTER, "Getting DMS: {}", dms);
		return dms;
	}

	public void setDMS(DegreesDecimal dms) {
		this.dms = dms;
	}

	public MString toJSON() {
		logger.trace(MMarker.JSONSERIALIZATION, "Getting JSON serialization");
		MString JSON = new MString(new JSONSerializer().deepSerialize(this));
		return JSON;
	}

	@Override
	public String toString() {
		return "[" + deg + "\u00b0, " + min + "', " + sec + "\"]";
	}
}
