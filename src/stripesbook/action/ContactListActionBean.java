package stripesbook.action;

import java.util.*;

import net.sourceforge.stripes.action.*;
import stripesbook.model.Contact;
import stripesbook.dao.ContactDao;
import stripesbook.dao.mock.MockContactDao;

public class ContactListActionBean extends BaseActionBean {
	private static final String LIST = "/WEB-INF/jsp/contact_list.jsp";
	private static final String VIEW = "/WEB-INF/jsp/contact_view.jsp";
	
	private ContactDao contactDao = MockContactDao.getInstance();
	private Integer contactId;
	
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	@DefaultHandler
	public Resolution list() {
		return new ForwardResolution(LIST);
	}
	
	public Resolution view() {
		return new ForwardResolution(VIEW);
	}
	
	public Resolution delete() {
		Contact deleted = contactDao.read(contactId);
		contactDao.delete(contactId);
		getContext().getMessages().add(new SimpleMessage("Deleted {0}.", deleted));
		return new RedirectResolution(getClass());
	}
	
	public List<Contact> getContacts() {
		return contactDao.read();
	}
	
	public Contact getContact() {
		return contactDao.read(contactId);
	}
}
