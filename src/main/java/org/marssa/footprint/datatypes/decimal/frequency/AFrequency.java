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
package org.marssa.footprint.datatypes.decimal.frequency;

import static javax.measure.unit.SI.HERTZ;
import static javax.measure.unit.SI.KILO;

import java.math.MathContext;

import javax.measure.quantity.Frequency;
import javax.measure.unit.Unit;
import javax.xml.bind.annotation.XmlType;

import org.marssa.footprint.datatypes.TypeFactory;
import org.marssa.footprint.datatypes.decimal.MDecimal;
import org.marssa.footprint.datatypes.decimal.UnsignedDecimal;
import org.marssa.footprint.exceptions.OutOfRange;
import org.marssa.footprint.logger.MMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Alan Grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:23
 */
@XmlType(name = "AFrequency", factoryClass = TypeFactory.class, factoryMethod = "getAFrequencyInstance")
public abstract class AFrequency extends UnsignedDecimal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8282804797176048249L;

	private static Logger logger = LoggerFactory.getLogger(AFrequency.class
			.getName());

	private final Unit<Frequency> currentUnit;

	protected AFrequency(double value, Unit<Frequency> unit) throws OutOfRange {
		super(value);
		this.currentUnit = unit;
	}

	protected AFrequency(double value, Unit<Frequency> unit, MathContext mc)
			throws OutOfRange {
		super(value, mc);
		this.currentUnit = unit;
	}

	/**
	 * Hz is the SI unit
	 */
	public MDecimal getHz() {
		MDecimal result = new MDecimal(currentUnit.getConverterTo(HERTZ)
				.convert(doubleValue()));
		logger.trace(MMarker.GETTER, "Converting from {} to Hertz : {}",
				currentUnit, result);
		return result;
	}

	public MDecimal getKHz() {
		MDecimal result = new MDecimal(currentUnit.getConverterTo(KILO(HERTZ))
				.convert(doubleValue()));
		logger.trace(MMarker.GETTER, "Converting from {} to Kilo Hertz : {}",
				currentUnit, result);
		return result;

	}

}
