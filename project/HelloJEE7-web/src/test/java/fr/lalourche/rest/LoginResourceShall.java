/**
 * 
 */
package fr.lalourche.rest;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.lalourche.Greeter;
import fr.lalourche.HelloWorld;


/**
 * @author Lalourche
 *
 */
@RunWith(Arquillian.class)
public class LoginResourceShall
{
  @ArquillianResource 
  URL baseUrl;
  
  @Deployment
  public static Archive<?> createDeployment()
  {
    return ShrinkWrap.create(WebArchive.class, "test.war")
        .addClass(HelloWorld.class)
        .addClass(LoginResource.class)
        .addPackage(Greeter.class.getPackage());
  }
  
  /**
   * The login allows to input user name with url as : /login/userName.
   * @throws MalformedURLException 
   */
  @Test
  @RunAsClient
  public final void allowUserNameInput() throws MalformedURLException
  {
    // GET http://localhost:8080/login/userName
    Client client = ClientBuilder.newClient();
    WebTarget loginTarget = client.target(new URL(baseUrl, "login/userName").toExternalForm());

    // We're expecting a String back
    String response = loginTarget.request(MediaType.TEXT_PLAIN).get(String.class);

    assertEquals("Hello userName !", response);
    
    client.close();
  }

}
