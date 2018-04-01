package app.test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import app.main.AuthenticatorApplication;
import app.object.AuthenticatorInterface;

public class AuthenticatorApplicationTest {
	
	@Test
    public void testAuthenticate() {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "JavaCodeGeeks";
        String password = "unsafePassword";
        
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        
        InOrder inOrder = Mockito.inOrder(authenticatorMock);
        //inOrder.verify(authenticatorMock).authenticateUser(username, password);
        
        //////////////////////verify(authenticatorMock).authenticateUser(username, password);
        
        System.out.println("00authenMock : " + authenticatorMock);
        System.out.println("11authenMock : " + authenticatorMock.getClass().getName());
        
        authenticator = new AuthenticatorApplication(authenticatorMock);
        
        //when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);        
        
        boolean actual = authenticator.authenticate(username, password);        
        assertFalse(actual);
    }
}
