/**
 * 
 */
package fr.lalourche;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
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
          .addClass(Login.class)
          .addClass(LoginBean.class)
          .addClass(Greeter.class)
          .addClass(GreeterBean.class)
          .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
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

}
