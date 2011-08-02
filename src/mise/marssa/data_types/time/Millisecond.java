/**
 * 
 */
package mise.marssa.data_types.time;

/**
 * @author Lifebook
 *
 */
public class Millisecond extends ATime{

	public Millisecond(long time) {
		super(time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getMilliseconds() {
		// TODO Auto-generated method stub
		return time;
	}

	@Override
	public long getSeconds() {
		// TODO Auto-generated method stub
		return time / 1000;
	}

	@Override
	public long getMinutes() {
		// TODO Auto-generated method stub
		return time / (1000*60);
	}

	@Override
	public long getHour() {
		// TODO Auto-generated method stub
		return time / (1000*60*60);
	}

}
