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
package org.marssa.footprint.datatypes.integer;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

import org.marssa.footprint.datatypes.TypeFactory;


/**
 * @author Alan Grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:24
 */
@XmlType(name = "DegreesInteger", factoryClass = TypeFactory.class, factoryMethod = "getDegreesIntegerInstance")
@Entity
public class DegreesInteger extends MInteger {

	/**
	 * 
	 */
	private static final long serialVersionUID = -679169479083287349L;

	public DegreesInteger(int value) {
		super(value);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	
	
}
