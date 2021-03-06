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

import static javax.measure.unit.NonSI.MILE;

import java.math.MathContext;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;


import org.hibernate.annotations.ForeignKey;
import org.marssa.footprint.datatypes.TypeFactory;
import org.marssa.footprint.exceptions.OutOfRange;

/**
 * @author Alan Grech.grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:29
 */
@XmlType(name = "Miles", factoryClass = TypeFactory.class, factoryMethod = "getMilesInstance")
@Entity
@ForeignKey(name = "FK_Miles_MDecimal")
public class Miles extends ADistance {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6577413341481435469L;

	public Miles(double value, MathContext mc) throws OutOfRange {
		super(value, MILE, mc);
	}
	public Miles(double value) throws OutOfRange {
		super(value, MILE);
	}
	
}
