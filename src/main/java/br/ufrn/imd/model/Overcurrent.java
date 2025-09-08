package br.ufrn.imd.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Overcurrent implements Protection {
	private boolean start;
	private boolean trip;
	private boolean enable;
	private boolean block;

	private double pickup;
	private double accumulatedTime;
	private long startTime;
	private long finishTime;
	private long startOnTimeStamp;
	private long startOffTimeStamp;
	private long tripOnTimeStamp;
	private long tripOffTimeStamp;
	private ConvertDate convDate;
	private String elementTimeCharacteristic;
	private ElementTimeCharacteristic timeCharacteristic;
	private String elementName;
	private double elementTime;

	private double magI;

	@Override
	public boolean start() {
		if (enable && pickup > 0 && magI >= pickup && !block()) {
			if (timeCharacteristic instanceof IEC eC) {
				eC.setTd(elementTime);
				eC.setM(magI / pickup);
			}
			if (!start) {
				start = true;
				startTime = System.currentTimeMillis();
				startOnTimeStamp = startTime;
				System.out.println("Event: " + elementName + " -> " + "Start (" + start + ") - "
						+ convDate.convertTimeMillisToString(startOnTimeStamp));
			}
			if (start) {
				finishTime = System.currentTimeMillis();
				if (finishTime >= startTime) {
					accumulatedTime += (finishTime - startTime) / (timeCharacteristic.timeToOperate() * 10);
				}
				if (!trip && ((timeCharacteristic.timeToOperate() == 0) || (accumulatedTime >= 100))) {
					trip();
				}
				if (!trip && (accumulatedTime >= 100)) {
					trip();
				}
				startTime = finishTime;
			} else {
				start = false;
				startTime = 0;
				finishTime = 0;
				accumulatedTime = 0;
				trip();
			}
		} else {
			if (start) {
				start = false;
				startOffTimeStamp = System.currentTimeMillis();
				System.out.println("Event: " + elementName + " -> " + "Start (" + start + ") - "
						+ convDate.convertTimeMillisToString(startOffTimeStamp));
			}
			startTime = 0;
			finishTime = 0;
			accumulatedTime = 0;
			trip();
		}
		return start;
	}

	@Override
	public boolean trip() {
		if (enable && start && !block) {
			if (!trip) {
				trip = true;
				tripOnTimeStamp = System.currentTimeMillis();
				System.out.println("Event: " + elementName + " -> " + "Trip (" + trip + ") - "
						+ convDate.convertTimeMillisToString(tripOnTimeStamp));
			}
		} else {
			if (trip) {
				trip = false;
				tripOffTimeStamp = System.currentTimeMillis();
				System.out.println("Event: " + elementName + " -> " + "Trip (" + trip + ") - "
						+ convDate.convertTimeMillisToString(tripOffTimeStamp));
			}
		}
		return trip;
	}

	@Override
	public boolean enable() {
		return enable;

	}

	@Override
	public boolean block() {
		return block;

	}

	// Set o tipo de característica temporal
	public void setElementTimeCharacteristic(String elementTimeCharacteristic) {
		this.elementTimeCharacteristic = elementTimeCharacteristic;
		if (elementTimeCharacteristic.equals("IECNI")) {
			timeCharacteristic = new IECNI();
		} else if (elementTimeCharacteristic.equals("IECVI")) {
			timeCharacteristic = new IECVI();
		} else if (elementTimeCharacteristic.equals("IECEI")) {
			timeCharacteristic = new IECEI();
		} else if (elementTimeCharacteristic.equals("IECLTI")) {
			timeCharacteristic = new IECLTI();
		} else if (elementTimeCharacteristic.equals("IECDT")) {
			timeCharacteristic = new IECDT();
		}
	}

}
