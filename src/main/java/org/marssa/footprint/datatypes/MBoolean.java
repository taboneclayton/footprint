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
package org.marssa.footprint.datatypes;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.marssa.footprint.logger.MMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flexjson.JSON;
import flexjson.JSONSerializer;

/**
 * @author Alan Grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:24
 */
@XmlType(name = "MBoolean", factoryClass = TypeFactory.class, factoryMethod = "getMBooleanInstance")
public class MBoolean {
	private static Logger MBoolean = LoggerFactory.getLogger("MBoolean");

	private boolean value;

	public MBoolean(boolean value) {
		MBoolean.trace(MMarker.CONSTRUCTOR,
				"Constructor created with Value:\"{}\".", value);
		this.value = value;
	}

	public void setValue(boolean newValue) {
		MBoolean.trace(MMarker.SETTER, "Setting MBoolean value to \"{}\".",
				newValue);
		this.value = newValue;
	}

	public void toggleValue() {
		this.value = !value;
		MBoolean.trace(MMarker.SETTER, "Value toggled to \"{}\".", value);
	}

	@JSON
	@XmlValue
	public boolean getValue() {
		MBoolean.trace(MMarker.GETTER, "Getting value: \"{}\"", value);
		return value;
	}

	@Override
	public String toString() {
		MBoolean.trace(MMarker.GETTER, "Getting value as a String: \"{}\"",
				value);
		return Boolean.toString(value);
	}

	public MString toJSON() {
		return new MString(new JSONSerializer().deepSerialize(this));
	}
}
