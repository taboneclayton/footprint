package mise.marssa.footprint.data_types.composite_datatypes;

import flexjson.JSONSerializer;
import mise.marssa.footprint.data_types.MString;
import mise.marssa.footprint.data_types.float_datatypes.DegreesFloat;
import mise.marssa.footprint.data_types.float_datatypes.MFloat;
import mise.marssa.footprint.data_types.integer_datatypes.DegreesInteger;
import mise.marssa.footprint.data_types.integer_datatypes.MInteger;

/**
 * @author Alan Grech
 * @version 1.0
 * @created 08-Jul-2011 09:53:29
 */
public abstract class APosition {

	// TODO Remove one of the internal representations
	protected DegreesInteger degrees;
	protected MInteger minutes;
	protected MFloat seconds;
	protected DegreesFloat dms;

	public APosition(DegreesInteger degrees, MInteger minutes, MFloat seconds) {
		this.degrees = degrees;
		this.minutes = minutes;
		this.seconds = seconds;

		// Do conversion
		if (degrees.getValue() > 0) {
			float convertedValue = (degrees.getValue() + (((minutes.getValue() * 60) + (seconds
					.getValue())) / 3600));
			this.dms = new DegreesFloat(convertedValue);
		} else if (degrees.getValue() < 0) {
			float convertedValue = -(degrees.getValue() + (((minutes.getValue() * 60) + (seconds
					.getValue())) / 3600));
			this.dms = new DegreesFloat(-convertedValue);
		}

	}

	public APosition(DegreesFloat degrees) {
		float degFloat = degrees.getValue();
		this.dms = degrees;
		this.degrees = new DegreesInteger((int) java.lang.Math.floor(degFloat));

		float minFloat = 60 * java.lang.Math.abs(degFloat
				- this.degrees.getValue());
		this.minutes = new MInteger((int) minFloat);

		float secFloat = 60 * (minFloat - this.minutes.getValue());
		if (secFloat == 60) {
			this.minutes = new MInteger(this.minutes.getValue() + 1);
			secFloat = 0;
		}
		this.seconds = new MFloat(secFloat);
		if (this.minutes.getValue() == 60) {
			this.degrees = new DegreesInteger(this.degrees.getValue() + 1);
			this.minutes = new MInteger(0);
		}
	}

	public void finalize() throws Throwable {

	}

	public DegreesInteger getDegrees() {
		return degrees;
	}

	public MInteger getMinutes() {
		return minutes;
	}

	public MFloat getSeconds() {
		return seconds;
	}

	public MFloat getDMS() {
		return dms;
	}

	public MString toJSON() {
		MString JSON = new MString(new JSONSerializer().exclude("value")
				.deepSerialize(this));
		return JSON;
	}
}