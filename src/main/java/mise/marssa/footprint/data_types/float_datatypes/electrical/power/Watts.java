/**
 * 
 */
package mise.marssa.footprint.data_types.float_datatypes.electrical.power;


/**
 * @author Warren Zahra
 *
 */
public class Watts extends APower {

	public Watts(float value) {
		super(value);
	}

	@Override
	public float getWatts() {
		return value;
	}

	@Override
	public float getKWatts() {
		return (value/1000);
	}

	@Override
	public float getMWatts() {
		return (value/1000000);
	}

}