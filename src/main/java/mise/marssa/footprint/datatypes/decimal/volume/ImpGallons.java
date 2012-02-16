
package mise.marssa.footprint.datatypes.decimal.volume;

import javax.xml.bind.annotation.XmlType;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import mise.marssa.footprint.datatypes.TypeFactory;
import mise.marssa.footprint.exceptions.OutOfRange;
import mise.marssa.footprint.logger.MMarker;

@XmlType(name = "ImpGallons", factoryClass = TypeFactory.class, factoryMethod = "getImpGallonsInstance")
public class ImpGallons extends AVolume {
	private static Logger ImpGallons = (Logger) LoggerFactory.getLogger("ImpGallons");

	public ImpGallons(float value) throws OutOfRange {
		super(value);
	}
	
	@Override
	public float getLiters() {
		ImpGallons.trace(MMarker.GETTER,"Converting from ImpGallons to Litres : {}",value *(float)4.54609188);
		return value *(float)4.54609188;
	}

	@Override
	public float getGallon() {
		ImpGallons.trace(MMarker.GETTER,"Converting from ImpGallons to Gallons : {}",value *(float)1.20095042);
		return value *(float)1.20095042;
	}

	@Override
	public float getImpGallon() {
		ImpGallons.trace(MMarker.GETTER,"Getting ImpGallons: {}",value);
		return value;
	}
}