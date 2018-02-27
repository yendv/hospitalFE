/**
 * 
 */
package fpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.model.GuesUser;

/**
 * @author YenDV
 *
 */	
public interface GuesUserRepository extends JpaRepository<GuesUser, Integer> {
}
