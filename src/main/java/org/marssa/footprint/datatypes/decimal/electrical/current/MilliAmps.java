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
package org.marssa.footprint.datatypes.decimal.electrical.current;

import static javax.measure.unit.SI.AMPERE;
import static javax.measure.unit.SI.MILLI;

import java.math.MathContext;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;


import org.hibernate.annotations.ForeignKey;
import org.marssa.footprint.datatypes.TypeFactory;
import org.marssa.footprint.exceptions.OutOfRange;

/**
 * @author Alan Grech
 * 
 */
@XmlType(name = "MilliAmps", factoryClass = TypeFactory.class, factoryMethod = "getMilliAmpsInstance")
@Entity
@ForeignKey(name = "FK_MilliAmps_MDecimal")
public class MilliAmps extends ACurrent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8965172127884811534L;

	public MilliAmps(double value) {
		super(value, MILLI(AMPERE));
	}

	public MilliAmps(double value, MathContext mc) throws OutOfRange {
		super(value,  MILLI(AMPERE), mc);
	}
}
