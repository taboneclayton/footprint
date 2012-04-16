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
package mise.marssa.footprint.interfaces.navigation;

import javax.xml.bind.annotation.XmlType;

import mise.marssa.footprint.datatypes.decimal.DegreesFloat;
import mise.marssa.footprint.datatypes.decimal.speed.ASpeed;
import mise.marssa.footprint.exceptions.OutOfRange;
import mise.marssa.footprint.interfaces.IQuantity;

/**
 * @author Warren Zahra
 * 
 */
public interface ISpeedSensor {
	public ASpeed getSpeedKnots() throws OutOfRange;

	public DegreesFloat getDegreesMagnetic() throws OutOfRange;

	public DegreesFloat getDegreesTrue() throws OutOfRange;
	
	@XmlType(name="SpeedSensorQuantities")
	public enum CompassQuantity implements IQuantity {
		SPEED_KNOTS, MAGNETIC_NORTH, TRUE_NORTH;
	}

}
