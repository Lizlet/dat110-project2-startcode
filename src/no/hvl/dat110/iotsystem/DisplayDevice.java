package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.MessageType;
import no.hvl.dat110.messages.PublishMsg;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// COMPLETED - START
				
		// create a client object and use it to
		
		// - connect to the broker
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker
		
		// COMPLETED - END
		
		//====================================================================
		
		Client client = new Client("User A", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();
		client.createTopic(Common.TEMPTOPIC);
		client.subscribe(Common.TEMPTOPIC);
		
		for (int i=0; i<COUNT; i++) {
			Message msg = client.receive();
			
			if (msg.getType() == MessageType.PUBLISH) {
				PublishMsg pblMsg = (PublishMsg) msg;
				System.out.println(String.format("DISPLAY: %s", pblMsg.getMessage()));
			}
		}
		
		client.unsubscribe(Common.TEMPTOPIC);
		client.disconnect();
		
		//====================================================================
		
		System.out.println("Display stopping ... ");
	}
}
