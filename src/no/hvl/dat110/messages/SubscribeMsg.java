package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// message sent from client to subscribe on a topic 

	// COMPLETED:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text
	
	//====================================================================
	
	private String topic;
	
	public SubscribeMsg(String user, String topic) {
		super(MessageType.SUBSCRIBE, user);
		this.topic = topic;
	}

	public String getTopic() {
		return this.topic;
	}
	
	public String toString() {
		return String.format("Message [type=%s, user=%s, topic=%s]", this.getType(), this.getUser(), this.topic);
	}
	
	//====================================================================
		
}
