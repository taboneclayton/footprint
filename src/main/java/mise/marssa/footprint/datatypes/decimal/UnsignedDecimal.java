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
package mise.marssa.footprint.datatypes.decimal;

import java.math.MathContext;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

import mise.marssa.footprint.datatypes.TypeFactory;
import mise.marssa.footprint.exceptions.OutOfRange;
import mise.marssa.footprint.logger.MMarker;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * @author Alan Grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:29
 */
@XmlType(name = "UnsignedDecimal", factoryClass = TypeFactory.class, factoryMethod = "getUnsignedDecimalInstance")
@Entity
public class UnsignedDecimal extends MDecimal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643170038537925526L;

	private static Logger logger = (Logger) LoggerFactory
			.getLogger("UnsignedFloat");

	public UnsignedDecimal(double value) throws OutOfRange {
		super(value);
		if (value < 0)
			logger.debug(MMarker.EXCEPTION, "Value received is out of range",
					new OutOfRange());
	}
	public UnsignedDecimal(double value, MathContext mc) throws OutOfRange {
		super(value,mc);
		if (value < 0)
			logger.debug(MMarker.EXCEPTION, "Value received is out of range",
					new OutOfRange());
	}
}
