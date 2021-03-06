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
package org.marssa.footprint.interfaces.navigation;

import javax.xml.bind.annotation.XmlType;

import org.marssa.footprint.datatypes.composite.Attitude;
import org.marssa.footprint.datatypes.decimal.DegreesDecimal;
import org.marssa.footprint.datatypes.decimal.MDecimal;
import org.marssa.footprint.interfaces.IQuantity;

/**
 * @author Alan Grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:24
 */
public interface ICompass {

	/**
	 * Compass returns Roll & Pitch
	 */
	public Attitude getAttitude();

	public DegreesDecimal getDeviation();

	public DegreesDecimal getHeading();

	public DegreesDecimal getMagneticHeading();

	public MDecimal getRateOfTurn();

	public DegreesDecimal getTrueHeading();

	/**
	 * Difference between True North & Magnetic North
	 */
	public DegreesDecimal getVariation();

	@XmlType(name = "CompassQuantities")
	public enum CompassQuantity implements IQuantity {
		ATTITUDE, DEVIATION, HEADING, MAGNETIC_HEADING, RATE_OF_TURN, TRUE_HEADING;
	}

}
