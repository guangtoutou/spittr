package spittr.test;

import org.dom4j.DocumentException;
import org.junit.Test;

import spittr.Spitter;
import spittr.data.XMLSpitterRepository;

public class XMLSpitterRepositoryTest {
	@Test
	public void testFindByUsername() throws DocumentException {
		XMLSpitterRepository xmlSpitterRepository = new XMLSpitterRepository();
		xmlSpitterRepository.findByUsername("dinkar");
	}

	@Test
	public void testAddSpitter() throws DocumentException {
		Spitter spitter = new Spitter("James", "Ni", "guangtoutou", "123");
		XMLSpitterRepository xmlSpitterRepository = new XMLSpitterRepository();
		xmlSpitterRepository.addSpitter(spitter);
	}
}
