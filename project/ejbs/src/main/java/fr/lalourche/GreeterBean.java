/**
 * 
 */
package fr.lalourche;

import java.io.IOException;
import java.io.OutputStream;

import javax.ejb.Stateless;

/**
 * @author Lalourche
 *
 */
@Stateless
public class GreeterBean implements Greeter
{

  public String createGreeting(String name) {
    return "Hello " + name + " !";
  }

  /**
   * @param out the output stream
   * @param name
   */
  public void greet(OutputStream out, String name)
  {
    String s = createGreeting(name);
    try
    {
      out.write(s.getBytes());
      out.flush();
      out.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
