package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// message sent from client to unsubscribe on a topic 

	// COMPLETED:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text
	
	//====================================================================

	private String topic;
	
	public UnsubscribeMsg(String user, String topic) {
		super(MessageType.UNSUBSCRIBE, user);
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
