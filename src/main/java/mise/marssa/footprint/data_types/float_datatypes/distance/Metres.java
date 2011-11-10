package mise.marssa.footprint.data_types.float_datatypes.distance;

import mise.marssa.footprint.exceptions.OutOfRange;

/**
 * Metres is the SI Unit
 * 
 * @author Lifebook
 * @version 1.0
 * @updated 08-Jul-2011 15:00:22
 */
public class Metres extends ADistance {

	public Metres(float value) throws OutOfRange {
		super(value);
	}

	@Override
	public float getKM() {
		return value / 1000;
	}

	@Override
	public float getMetres() {
		return value;
	}

	@Override
	public float getMiles() {
		return value * (float) 0.000621371192;
	}

	@Override
	public float getNM() {
		return value * (float) 0.000539956803;
	}

	@Override
	public float getFathoms() {
		return value * (float) 0.546806649;
	}
}