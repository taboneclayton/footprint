package mise.marssa.footprint.data_types.float_datatypes.speed;

import mise.marssa.footprint.exceptions.OutOfRange;

public class MPH extends ASpeed{
	
	public MPH(float value) throws OutOfRange {
		super(value);
	}

	@Override
	public float getKPH() {
		return value *(float) 1.609;
	}

	@Override
	public float getMPH() {
		return value;
	}

	@Override
	public float getKnots() {
		return (value * (float)1.609) / ((float) 1.852);
	}

	/**
	 * get metres per second. m/s is the SI unit but knots is more widely used
	 * as a nautical term
	 */
	@Override
	public float getMPS() {
		return value * ((float) 1.609)*1000 / 3600;
	}
}
