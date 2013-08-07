/**
 * 
 */
package fr.lalourche;

import javax.ejb.Remote;

/**
 * @author Lalourche
 *
 */
@Remote
public interface Login
{

  /**
   * @param string
   */
  void enterName(String string);

  /**
   * @return
   */
  Object getName();

}
