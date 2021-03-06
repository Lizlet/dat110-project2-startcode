package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	public void addClientSession(String user, Connection connection) {

		// COMPLETED: add corresponding client session to the storage
		
		//====================================================================
		
		if (!clients.containsKey(user)) {
			ClientSession clientSession = new ClientSession(user, connection);
			clients.put(user, clientSession);
		} else {
			
			Logger.log("Broker Storage: Tried to add user \"" + user + "\", but user already exists.");
		}
			
		//====================================================================
	}

	public void removeClientSession(String user) {

		// COMPLETED: remove client session for user from the storage

		//====================================================================
		
		if (clients.containsKey(user)) {
			clients.remove(user);
		} else {
			Logger.log("Broker Storage: Tried to remove user \"" + user + "\", but user does not exist.");
		}
		
		//====================================================================
		
	}

	public void createTopic(String topic) {

		// COMPLETED: create topic in the storage
		
		//====================================================================
		
		if (!subscriptions.containsKey(topic)) {
			subscriptions.put(topic, new HashSet<>());
		} else {
			Logger.log("Broker Storage: Tried to add topic \"" + topic + "\", but topic already exists.");
		}
		
		//====================================================================
	}

	public void deleteTopic(String topic) {

		// COMPLETED: delete topic from the storage

		//====================================================================
		
		if (subscriptions.containsKey(topic)) {
			subscriptions.remove(topic);
		} else {
			Logger.log("Broker Storage: Tried to remove topic \"" + topic + "\", but topic does not exists.");
		}
		
		//====================================================================
		
	}

	public void addSubscriber(String user, String topic) {

		// COMPLETED: add the user as subscriber to the topic
		
		//====================================================================
		
		if (subscriptions.containsKey(topic)) {
			if (!subscriptions.get(topic).contains(user)) {
				subscriptions.get(topic).add(user);
			} else {
				Logger.log("User \"" + user + "\" tried to subscribe to topic \"" + topic + "\", but the user is already subscribed.");
			}
		} else {
			Logger.log("User \"" + user + "\" tried to subscribe to topic \"" + topic + "\", but the topic does not exist.");
		}
		
		//====================================================================
	}

	public void removeSubscriber(String user, String topic) {

		// COMPLETED: remove the user as subscriber to the topic

		//====================================================================
		
		if (subscriptions.containsKey(topic)) {
			if (subscriptions.get(topic).contains(user)) {
				subscriptions.get(topic).remove(user);
			} else {
				Logger.log("User \"" + user + "\" tried to unsubscribe from topic \"" + topic + "\", but the user is not subscribed.");
			}
		} else {
			Logger.log("User \"" + user + "\" tried to unsubscribe from topic \"" + topic + "\", but the topic does not exist.");
		}
		
		//====================================================================
	}
}
