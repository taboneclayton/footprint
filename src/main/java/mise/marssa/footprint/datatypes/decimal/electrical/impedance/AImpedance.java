/**
 * 
 */
package mise.marssa.footprint.datatypes.decimal.electrical.impedance;

import javax.xml.bind.annotation.XmlType;

import mise.marssa.footprint.datatypes.TypeFactory;
import mise.marssa.footprint.datatypes.decimal.MFloat;

/**
 * @author Warren Zahra
 *
 */
@XmlType(name = "AImpedance", factoryClass = TypeFactory.class, factoryMethod = "getAImpedanceInstance")
public abstract class AImpedance extends MFloat {
	public AImpedance (float value) {
		super(value);
	}
	
	abstract public float getOhms();
	abstract public float getKOhms();
	abstract public float getMOhms();

	@Override
	public String toString() {
		return "Impedance in " + this.getClass().getSimpleName() + " = " + value;
	}
}