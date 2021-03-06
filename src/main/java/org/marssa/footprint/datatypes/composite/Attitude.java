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
import org.marssa.footprint.logger.MMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flexjson.JSONSerializer;

/**
 * @author Alan Grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:23
 */
@XmlType(name = "Attitude", factoryClass = TypeFactory.class, factoryMethod = "getAttitudeInstance")
public class Attitude {
	private static Logger Attitude = LoggerFactory.getLogger("Attitude");
	private final Pitch pitch;
	private final Roll roll;
	private final Yaw yaw;

	public Attitude(Pitch pitch, Roll roll, Yaw yaw) {
		this.pitch = pitch;
		this.roll = roll;
		this.yaw = yaw;
		Object[] attitude = { pitch.getPitch(), roll.getRoll(), yaw.getYaw() };
		Attitude.trace(
				MMarker.CONSTRUCTOR,
				"Constructor created with  Pitch:\"{}\", Roll:\"{}\", Yaw:\"{}\".",
				attitude);
	}

	@Override
	public void finalize() throws Throwable {

	}

	@XmlElement
	public Pitch getPitch() {
		Attitude.trace(MMarker.GETTER, "Getting Pitch: {}.", pitch.getPitch());
		return pitch;
	}

	@XmlElement
	public Roll getRoll() {
		Attitude.trace(MMarker.GETTER, "Getting Roll: {}.", roll.getRoll());
		return roll;
	}

	@XmlElement
	public Yaw getYaw() {
		Attitude.trace(MMarker.GETTER, "Getting Yaw: {}.", yaw.getYaw());
		return yaw;
	}

	@Override
	public java.lang.String toString() {
		Attitude.trace(MMarker.GETTER, "Getting attitude as a String.");
		return "[" + pitch.toString() + ", " + roll.toString() + ", "
				+ yaw.toString() + "]";
	}

	public MString toJSON() {
		return new MString(new JSONSerializer().deepSerialize(this));

	}
}
