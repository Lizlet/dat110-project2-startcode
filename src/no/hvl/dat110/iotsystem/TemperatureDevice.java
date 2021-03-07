package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.Logger;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// COMPLETED - start

		// create a client object and use it to

		// - connect to the broker
		// - publish the temperature(s)
		// - disconnect from the broker

		// COMPLETED - end
		
		//====================================================================
		
		Client client = new Client("User B", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();
		
		for (int i=0; i<COUNT; i++) {
			int temperature = sn.read();
			Logger.log("Temperature Client: Reading - " + temperature);
			client.publish(Common.TEMPTOPIC, Integer.toString(temperature));
		}
		
		client.disconnect();
		
		//====================================================================

		System.out.println("Temperature device stopping ... ");
	}
}
