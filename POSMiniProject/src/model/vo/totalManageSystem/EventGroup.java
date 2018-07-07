package model.vo.totalManageSystem;

import java.io.Serializable;
import java.util.Date;

public class EventGroup implements Serializable{

   
   private String eventName;
   private boolean eventType;
   private String eventContent;
   private Date eventTearm;
   private String eventTarget;
   private String eventImagePath;
   public EventGroup(String eventName, boolean eventType, String eventContent, Date eventTearm,
         String eventTarget, String eventImagePath) {
      super();
      this.eventName = eventName;
      this.eventType = eventType;
      this.eventContent = eventContent;
      this.eventTearm = eventTearm;
      this.eventTarget = eventTarget;
      this.eventImagePath = eventImagePath;
   }
   public String getEventName() {
      return eventName;
   }
   public boolean isEventType() {
      return eventType;
   }
   public String getEventContent() {
      return eventContent;
   }
   public Date getEventTearm() {
      return eventTearm;
   }
   public String getEventTarget() {
      return eventTarget;
   }
   public String getEventImagePath() {
      return eventImagePath;
   }
   public void setEventName(String eventName) {
      this.eventName = eventName;
   }
   public void setEventType(boolean eventType) {
      this.eventType = eventType;
   }
   public void setEventContent(String eventContent) {
      this.eventContent = eventContent;
   }
   public void setEventTearm(Date eventTearm) {
      this.eventTearm = eventTearm;
   }
   public void setEventTarget(String eventTarget) {
      this.eventTarget = eventTarget;
   }
   public void setEventImagePath(String eventImagePath) {
      this.eventImagePath = eventImagePath;
   }
   @Override
   public String toString() {
      return "EventGroup [eventName=" + eventName + ", eventType=" + eventType
            + ", eventContent=" + eventContent + ", eventTearm=" + eventTearm + ", eventTarget=" + eventTarget
            + ", eventImagePath=" + eventImagePath + "]";
   }
   
   
   
   
}