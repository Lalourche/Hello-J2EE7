/**
 * 
 */
package fr.lalourche;

import java.io.OutputStream;

import javax.ejb.Local;

/**
 * @author Lalourche
 *
 */
@Local
public interface Greeter
{
  public String createGreeting(String name);
  
  public void greet(OutputStream out, String name);
}
