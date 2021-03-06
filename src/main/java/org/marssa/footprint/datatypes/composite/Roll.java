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
package org.marssa.footprint.datatypes.composite;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.marssa.footprint.datatypes.MString;
import org.marssa.footprint.datatypes.TypeFactory;
import org.marssa.footprint.datatypes.decimal.DegreesDecimal;

import flexjson.JSONSerializer;

/**
 * @author Alan Grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:29
 */
@XmlType(name = "Roll", factoryClass = TypeFactory.class, factoryMethod = "getRollInstance")
public class Roll {

	private DegreesDecimal Roll;

	public Roll(DegreesDecimal roll) {
		this.Roll = roll;
	}

	public void finalize() throws Throwable {

	}

	@XmlElement
	public DegreesDecimal getRoll() {
		return Roll;
	}

	public java.lang.String toString() {
		return "";
	}

	public MString toJSON() {
		MString JSON = new MString(new JSONSerializer().deepSerialize(this));
		return JSON;
	}
}
