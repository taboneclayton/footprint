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
package mise.marssa.footprint.datatypes.decimal.electrical.impedance;

import static javax.measure.unit.SI.MEGA;
import static javax.measure.unit.SI.OHM;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

import mise.marssa.footprint.datatypes.TypeFactory;

/**
 * @author Warren Zahra
 * 
 */
@XmlType(name = "MOhms", factoryClass = TypeFactory.class, factoryMethod = "getMOhmsInstance")
@Entity
public class MOhms extends AImpedance {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6238291269274880140L;

	public MOhms(double value) {
		super(value, MEGA(OHM));
	}
}
