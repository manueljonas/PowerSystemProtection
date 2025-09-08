package br.ufrn.imd.PowerSystemProtection;

import br.ufrn.imd.model.Bay;
import br.ufrn.imd.model.Device;
import br.ufrn.imd.model.Overcurrent;
import br.ufrn.imd.model.PowerSystem;

public class Main {

	public static void main(String[] args) {
		System.out.println("Power System Protection Application Started");
		System.out.println();

		// Testando a classe PowerSystem
		PowerSystem ps = new PowerSystem(1, "X-Substation A", "X-123 Power St, City, Country");
		ps.setId(0);
		ps.setName("Substation A");
		ps.setLocation("123 Power St, City, Country");
		System.out.println("Power System Created: " + ps.getName() + ", Location: " + ps.getLocation());
		System.out.println(ps.toString());
		System.out.println();

		// Testando a classe Bay
		Bay bay = new Bay(1, "X-02T1");
		bay.setId(0);
		bay.setName("02T1");
		System.out.println("Bay Created: " + bay.getName() + ", Bay ID: " + bay.getId());
		System.out.println(bay.toString());
		System.out.println();

		// Testando a classe Device
		Device device = new Device(1, "X-87T1", "X-Differential Protection of Transformer",
				"X-Schweitzer Engineering Laboratories", "X-SEL-487E", "X-SN123456");
		device.setId(0);
		device.setName("87T1");
		device.setType("Differential Protection of Transformer");
		device.setBrand("Schweitzer Engineering Laboratories");
		device.setModel("SEL-487E");
		device.setSerialNumber("SN123456");
		System.out.println("Device Created: " + device.getName() + ", Type: " + device.getType());
		System.out.println("Brand: " + device.getBrand() + ", Model: " + device.getModel() + ", Serial Number: "
				+ device.getSerialNumber());
		System.out.println(device.toString());
		System.out.println();

		// Testando a classe Overcurrent
		Overcurrent oc = new Overcurrent();
		oc.setElementName("50/51 OC Relay");
		oc.setEnable(true);
		oc.setPickup(2.0); // Pickup de corrente em Amperes
		oc.setMagI(25.0); // Medição de corrente em Amperes
		oc.setElementTime(0.2); // Time dial setting em segundos
		oc.setElementTimeCharacteristic("IECNI");
		oc.setConvDate(new br.ufrn.imd.model.ConvertDate());
		while (!oc.isTrip()) {
			oc.start();
			try {
				Thread.sleep(1); // Simulando um pequeno delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Overcurrent Protection Element: " + oc.getElementName());
		System.out.println("Status: Start = " + oc.isStart() + ", Trip = " + oc.isTrip());
		System.out.println();

		System.out.println("Application Finished");
	}

}
