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

import static javax.measure.unit.SI.KILOMETRE;

import java.math.MathContext;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;


import org.hibernate.annotations.ForeignKey;
import org.marssa.footprint.datatypes.TypeFactory;
import org.marssa.footprint.exceptions.OutOfRange;

/**
 * Kilometres
 * 
 * @author Lifebook
 * @version 1.0
 * @updated 08-Jul-2011 15:00:20
 */
@XmlType(name = "KM", factoryClass = TypeFactory.class, factoryMethod = "getKMInstance")
@Entity
@ForeignKey(name = "FK_KM_MDecimal")
public class KM extends ADistance {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1716282958949178181L;

	public KM(double value) throws OutOfRange {
		super(value, KILOMETRE);
	}
	public KM(double value, MathContext mc) throws OutOfRange {
		super(value, KILOMETRE, mc);
	}
}
