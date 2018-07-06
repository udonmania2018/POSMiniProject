package model.vo;

import java.io.Serializable;
import java.util.Date;

public class EventGroup implements Serializable{

	private String EventCode;
	private String EventName;
	private String EventDate;
	private String EventType;
	public EventGroup(String eventCode, String eventName, String eventDate, String eventType) {
		super();
		EventCode = eventCode;
		EventName = eventName;
		EventDate = eventDate;
		EventType = eventType;
	}
	public String getEventCode() {
		return EventCode;
	}
	public String getEventName() {
		return EventName;
	}
	public String getEventDate() {
		return EventDate;
	}
	public String getEventType() {
		return EventType;
	}
	public void setEventCode(String eventCode) {
		EventCode = eventCode;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}
	public void setEventType(String eventType) {
		EventType = eventType;
	}
	
	
}
