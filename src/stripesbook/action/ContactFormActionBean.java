package stripesbook.action;

import java.util.*;
import stripesbook.model.Contact;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.*;

public class ContactFormActionBean extends ContactBaseActionBean {
	private static final String FORM = "/WEB-INF/jsp/contact_form.jsp";
	
	@DefaultHandler
	public Resolution form() {
		return new ForwardResolution(FORM);
	}
	
	public Resolution save() {
		Contact contact = getContact();
		getContactDao().save(contact);
		getContext().getMessages().add(new SimpleMessage("{0} has been saved.", contact));
		return new RedirectResolution(ContactListActionBean.class);
	}
	
	@DontValidate
	public Resolution cancel() {
		getContext().getMessages().add(new SimpleMessage("Action cancelled."));
		return new RedirectResolution(ContactListActionBean.class);
	}

	@Override
	public void setContact(Contact contact) {
		super.setContact(contact);
	}
	
	@ValidateNestedProperties({
		@Validate(field="firstName", maxlength=25),
		@Validate(field="lastName",  minlength=2, maxlength=40),
        @Validate(field="email", required=true, on="save",
            converter=EmailTypeConverter.class),
        @Validate(field="birthDate", expression="${this < today}")
	})
	
	@ValidationMethod(on="save")
	public void validateEmailUnique(ValidationErrors errors) {
        String email = getContact().getEmail();
        Contact other = getContactDao().findByEmail(email);
        if (other != null && !other.equals(getContact())) {
            errors.add("contact.email", new SimpleError(
                "{1} is already used by {2}.", other));
        }
    }
	
	public Date getToday() {
        return new Date();
    }
}
