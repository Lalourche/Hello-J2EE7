/**
 * 
 */
package fr.lalourche;

import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * @author Lalourche
 *
 */
@Stateful
public class LoginBean implements Login
{

  @EJB
  private Greeter greeter;
  
  private String name;
  
  /* (non-Javadoc)
   * @see fr.lalourche.Login#enterName(java.lang.String)
   */
  public String enterName(String name)
  {
    this.name = name;
    return greeter.createGreeting(name);
  }

  /* (non-Javadoc)
   * @see fr.lalourche.Login#getName()
   */
  public Object getName()
  {
    return name;
  }

}
