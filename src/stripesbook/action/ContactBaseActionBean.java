package stripesbook.action;

import stripesbook.model.Contact;
import stripesbook.dao.ContactDao;
import stripesbook.dao.mock.MockContactDao;

public abstract class ContactBaseActionBean extends BaseActionBean {
	private ContactDao contactDao = MockContactDao.getInstance();
	private Integer contactId;
	private Contact contact;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Contact getContact() {
		if (contactId != null)
			return contactDao.read(contactId);
		
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	protected ContactDao getContactDao() {
		return contactDao;
	}
}
