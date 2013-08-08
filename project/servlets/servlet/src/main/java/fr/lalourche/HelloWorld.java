/**
 * 
 */
package fr.lalourche;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.lalourche.rest.LoginRest;

/**
 * @author Lalourche
 *
 */
@ApplicationPath("/*")
public class HelloWorld extends Application
{
  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> s = new HashSet<Class<?>>();
    s.add(LoginRest.class);
    return s;
  }
}