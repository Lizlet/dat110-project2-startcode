package no.hvl.dat110.messages;

public class PublishMsg extends Message {
	
	// message sent from client to create publish a message on a topic 

	// COMPLETED:
	// Implement object variables - a topic and a message is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text
	
	//====================================================================
	
	private String topic;
	private String message;
	
	public PublishMsg(String user, String topic, String message) {
		super(MessageType.PUBLISH, user);
		this.topic = topic;
		this.message = message;
	}
	
	public String getTopic() {
		return this.topic;
	}

	public String getMessage() {
		return this.message;
	}

	public String toString() {
		return String.format("Message [type=%s, user=%s, topic=%s, message=%s]", this.getType(), this.getUser(), this.topic, this.message);
	}
	
	//====================================================================
}
