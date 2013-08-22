/**
 * 
 */
package fr.lalourche;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Lalourche
 *
 */
@RunWith(Arquillian.class)
public class LoginShall
{

  @EJB
  Login login;
  
  @Deployment
  public static JavaArchive createDeployment()
  {
      return ShrinkWrap.create(JavaArchive.class)
          .addPackage(Greeter.class.getPackage());
  }
  
  /**
   * The login allows to input user name.
   */
  @Test
  public final void getUserName()
  {
    login.enterName("MyName");
    assertEquals("MyName", login.getName());
  }
  
  /**
   * The login allows to greet user.
   */
  @Test
  public final void greetUser()
  {
    assertEquals("Hello MyName !", login.enterName("MyName"));
  }

}
