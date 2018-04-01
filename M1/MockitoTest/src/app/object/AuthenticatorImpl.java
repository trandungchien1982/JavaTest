package app.object;

public class AuthenticatorImpl implements AuthenticatorInterface {
	@Override
	public void foo() {
		// TODO Auto-generated method stub
		System.out.println("Show foo() information ...");
	}
	
	public boolean authenticateUser(String username, String password) {
		System.out.println("authenticateUser : " + true);
		return true;
	}
}
