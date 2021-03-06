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
package org.marssa.footprint.datatypes.decimal.distance;

import static javax.measure.unit.SI.METRE;

import java.math.MathContext;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;


import org.hibernate.annotations.ForeignKey;
import org.marssa.footprint.datatypes.TypeFactory;
import org.marssa.footprint.exceptions.OutOfRange;

/**
 * Meters is the SI Unit
 * 
 * @author Clayton Tabone
 * @version 1.0
 * @updated 08-Jul-2011 15:00:22
 */
@XmlType(name = "Metres", factoryClass = TypeFactory.class, factoryMethod = "getMetresInstance")
@Entity
@ForeignKey(name = "FK_Metres_MDecimal")
public class Metres extends ADistance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 665365156720252593L;

	public Metres(double value, MathContext mc) throws OutOfRange {
		super(value, METRE, mc);
	}

	public Metres(double value) throws OutOfRange {
		super(value, METRE);
	}


}
