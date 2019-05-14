package rs.cubes.FullWebApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
public class UserQueries {
	/*
	 * metoda za pretrazivanje email adrese u bazi. ako postoji email metoda vraca true, u suprotnom false. i kod koriscenja dalje 
	 * u aplikacijiuslov kod pretrazivanja treba da bude ==FALSE !
	 */
	public static boolean usernameExists(EntityManager em,String email) {
		String q = "select u from User u where u.email = :email";
		TypedQuery<User> query = em.createQuery(q,User.class);
		query.setParameter("email", email);
		List<User> result = query.getResultList();
		if(result.size()==0) {return false;} // ako je lista prazna onda znaci da ne postoji trazeni email u bazi.
		return true;
	}
}
