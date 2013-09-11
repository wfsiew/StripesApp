package stripesbook.action;

import java.util.*;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.ajax.JavaScriptResolution;
import model.Person;

public class HelloActionBean implements ActionBean {
	private ActionBeanContext ctx;
	private Date date;
	
	private static final String VIEW = "/WEB-INF/jsp/hello.jsp";

	public Date getDate() {
		return date;
	}

	@Override
	public ActionBeanContext getContext() {
		return ctx;
	}

	@Override
	public void setContext(ActionBeanContext ctx) {
		this.ctx = ctx;
	}

	@DefaultHandler
	public Resolution currentDate() {
		date = new Date();
		return new ForwardResolution(VIEW);
	}

	public Resolution randomDate() {
		long max = System.currentTimeMillis();
		long random = new Random().nextLong() % max;
		date = new Date(random);
		return new ForwardResolution(VIEW);
	}
	
	public Resolution data() {
		Person p = new Person();
		p.setName("Ben");
		p.setAge(5);
		
		return new JavaScriptResolution(p);
	}
}
