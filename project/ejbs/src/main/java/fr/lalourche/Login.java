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
   * @param name
   */
  String enterName(String name);

  /**
   * @return
   */
  Object getName();

}
