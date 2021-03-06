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
/**
 * 
 */
package org.marssa.footprint.datatypes.decimal.electrical.voltage;

import static javax.measure.unit.SI.MILLI;
import static javax.measure.unit.SI.VOLT;

import java.math.MathContext;

import javax.measure.quantity.ElectricPotential;
import javax.measure.unit.Unit;
import javax.xml.bind.annotation.XmlType;

import org.marssa.footprint.datatypes.TypeFactory;
import org.marssa.footprint.datatypes.decimal.MDecimal;
import org.marssa.footprint.exceptions.OutOfRange;
import org.marssa.footprint.logger.MMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lifebook
 * 
 */
@XmlType(name = "AVoltage", factoryClass = TypeFactory.class, factoryMethod = "getAVoltageInstance")
public abstract class AVoltage extends MDecimal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8379610960475509245L;

	private static Logger logger = LoggerFactory.getLogger(AVoltage.class
			.getName());

	private final Unit<ElectricPotential> currentUnit;

	protected AVoltage(double value, Unit<ElectricPotential> unit) {
		super(value);
		this.currentUnit = unit;
	}

	protected AVoltage(double value, Unit<ElectricPotential> unit,
			MathContext mc) throws OutOfRange {
		super(value, mc);
		this.currentUnit = unit;
	}

	public MDecimal getVolts() {
		MDecimal result = new MDecimal(currentUnit.getConverterTo(VOLT)
				.convert(doubleValue()));
		logger.trace(MMarker.GETTER, "Converting from {} to Volts : {}",
				currentUnit, result);
		return result;
	}

	public MDecimal getMilliVolts() {
		MDecimal result = new MDecimal(currentUnit.getConverterTo(MILLI(VOLT))
				.convert(doubleValue()));
		logger.trace(MMarker.GETTER, "Converting from {} to milli Volts : {}",
				currentUnit, result);
		return result;
	}

}
