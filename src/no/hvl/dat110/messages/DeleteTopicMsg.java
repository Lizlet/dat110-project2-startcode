package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	// message sent from client to create topic on the broker

	// COMPLETED:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text
	
	//====================================================================
	
	private String topic;
	
	public DeleteTopicMsg(String user, String topic) {
		super(MessageType.DELETETOPIC, user);
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
