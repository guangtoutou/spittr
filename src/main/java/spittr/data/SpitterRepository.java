package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {
	public Spitter findByUsername(String username);
}
