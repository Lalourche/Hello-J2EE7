/**
 * 
 */
package fr.lalourche;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

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
public class GreeterShall
{

  @Inject
  Greeter greeter;
  
  @Deployment
  public static JavaArchive createDeployment()
  {
      return ShrinkWrap.create(JavaArchive.class)
          .addClass(Greeter.class)
          .addClass(GreeterImpl.class)
          .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }
  
  /**
   * The greeter shall say hello to anyone.
   */
  @Test
  public final void greetAnyName()
  {
    String result = greeter.createGreeting("World");
    assertEquals("Hello World !", result);
  }
  
  /**
   * The Greeter shall print out onto a stream.
   */
  @Test
  public final void greetOnAStream()
  {
    OutputStream out = new ByteArrayOutputStream();
    
    greeter.greet(out, "World");
    assertEquals("Hello World !", out.toString());
  }

}
