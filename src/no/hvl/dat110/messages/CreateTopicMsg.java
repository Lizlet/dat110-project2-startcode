package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	
	// message sent from client to create topic on the broker
	
	// COMPLETED: 
	// Implement object variables - a topic is required
	
	// Constructor, get/set-methods, and toString method
    // as described in the project text	
	
	// NOTE: Did not include set-methods as it seemed out of place.
	
	//====================================================================
	
	private String topicString;
	
	public CreateTopicMsg(String userString, String topicString) {
		super(MessageType.CREATETOPIC, userString);
		this.topicString = topicString;
	}
	
	public String getTopic() {
		return this.topicString;
	}
	
	public String toString() {
		return String.format("Message [type=%s, user=%s, topic=%s]", this.getType(), this.getUser(), this.topicString);
	}
	
	//====================================================================
}
