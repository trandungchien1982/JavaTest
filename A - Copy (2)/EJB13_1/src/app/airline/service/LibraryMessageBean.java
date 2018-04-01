package app.airline.service;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: LibraryMessageBean
 */
@MessageDriven(name = "BookMessageHandler", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "/queue/BookQueue")
})
public class LibraryMessageBean implements MessageListener {

	@Resource
	private MessageDrivenContext mdctx;
	
	/**
	 * Default constructor.
	 */
	public LibraryMessageBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		// TODO Auto-generated method stub

	}

}
