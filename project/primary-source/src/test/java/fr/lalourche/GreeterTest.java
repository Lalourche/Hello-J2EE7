/**
 * 
 */
package fr.lalourche;

import static org.junit.Assert.*;

import javax.inject.Inject;

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
public class GreeterTest
{

  @Inject
  Greeter greeter;
  
  @Deployment
  public static JavaArchive createDeployment()
  {
      return ShrinkWrap.create(JavaArchive.class)
          .addClass(Greeter.class)
          .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }
  
  /**
   * Test method for {@link fr.lalourche.Greeter#createGreeting(java.lang.String)}.
   */
  @Test
  public final void testCreateGreeting()
  {
    String result = greeter.createGreeting("World");
    assertEquals("Hello World !", result);
  }

}
