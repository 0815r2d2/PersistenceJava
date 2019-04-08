package at.fhv.team5.sportsfreund.persistencejava;

import at.fhv.team5.sportsfreund.persistencejava.entities.Actor;
import at.fhv.team5.sportsfreund.persistencejava.entities.Film;
import at.fhv.team5.sportsfreund.persistencejava.entities.Genre;
import at.fhv.team5.sportsfreund.persistencejava.entities.Language;
import at.fhv.team5.sportsfreund.persistencejava.facade.Facade;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Facade facade = new Facade();

		Genre horror = new Genre("Horror");
		Genre fant = new Genre("Fantasy");
		Genre ac = new Genre("Action");
		facade.saveEntity(horror);
		facade.saveEntity(fant);
		facade.saveEntity(ac);

		Language germ = new Language("Deutsch");
		Language eng = new Language("Englisch");
		Language sp = new Language("Spanisch");
		facade.saveEntity(germ);
		facade.saveEntity(eng);
		facade.saveEntity(sp);

		Actor act1 = new Actor("Orlando", "Bloom");
		Actor act2 = new Actor("Ian", "McKellen");
		Actor act3 = new Actor("Viggo", "Mortensen");
		facade.saveEntity(act1);
		facade.saveEntity(act2);
		facade.saveEntity(act3);

		Film hdr = new Film("Herr der Ringe", germ, fant);

		hdr.getActors().add(act1);
		hdr.getActors().add(act2);
		hdr.getActors().add(act3);

		facade.saveEntity(hdr);
		assert(true);
	}
}
