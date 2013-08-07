/**
 * 
 */
package fr.lalourche;

import java.io.OutputStream;

/**
 * @author Lalourche
 *
 */
public interface Greeter
{
  public String createGreeting(String name);
  
  public void greet(OutputStream out, String name);
}
