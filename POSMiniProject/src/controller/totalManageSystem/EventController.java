package controller.totalManageSystem;

import java.util.ArrayList;

import model.dao.totalManageSystem.Event;
import model.vo.totalManageSystem.EventGroup;
import model.vo.totalManageSystem.ManufactureGroup;
import model.vo.totalManageSystem.Product;
import model.vo.totalManageSystem.ProductGroup;

public class EventController {
	Event dao = new Event();

	public ArrayList<EventGroup> selectEventGroup() {
		// TODO Auto-generated method stub
		return dao.selectEventGroup();
	}
	public void addEvent(EventGroup event) {
		// TODO Auto-generated method stub
		dao.addEventGroup(event);
	}
	public ArrayList<EventGroup> selectEventOnName(String searchName){
		return dao.selectEventOnName(searchName);
	}

	public EventGroup selectEventOnNames(String searchName){
		
		return dao.selectEventOnNames(searchName);
	}



	public void deleteEventGroup(String name) {
		// TODO Auto-generated method stub
		dao.deleteEventGroup(name);
	}

	public void modifyEventGroup(EventGroup eg) {
		// TODO Auto-generated method stub
		dao.modifyEventGroup(eg);
	}


}
