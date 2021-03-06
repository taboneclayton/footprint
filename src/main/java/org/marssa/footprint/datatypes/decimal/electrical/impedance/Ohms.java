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
package org.marssa.footprint.datatypes.decimal.electrical.impedance;

import static javax.measure.unit.SI.OHM;

import java.math.MathContext;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;


import org.hibernate.annotations.ForeignKey;
import org.marssa.footprint.exceptions.OutOfRange;

/**
 * @author Warren Zahra
 * 
 */
@XmlType(name = "Ohms")
@Entity
@ForeignKey(name = "FK_Ohms_MDecimal")
public class Ohms extends AImpedance {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6931184410205642153L;

	private Ohms() {
		super(0.0, OHM);
	}

	public Ohms(double value) {
		super(value, OHM);
	}

	public Ohms(double value, MathContext mc) throws OutOfRange {
		super(value, OHM, mc);
	}
}
