package spittr.data;

import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component("repository")
public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
}
