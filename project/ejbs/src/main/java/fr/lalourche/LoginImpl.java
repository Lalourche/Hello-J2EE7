/**
 * 
 */
package fr.lalourche;

import javax.ejb.EJB;

/**
 * @author Lalourche
 *
 */
public class LoginImpl implements Login
{

  @EJB
  private Greeter greeter;
  
  private String name;
  
  /* (non-Javadoc)
   * @see fr.lalourche.Login#enterName(java.lang.String)
   */
  public void enterName(String string)
  {
    this.name = string;
  }

  /* (non-Javadoc)
   * @see fr.lalourche.Login#getName()
   */
  public Object getName()
  {
    return name;
  }

}
