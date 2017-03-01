package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component
public class TxtSpittleRepository implements SpittleRepository {

	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < 20; i++) {
			Spittle spittle = new Spittle(Integer.toString(i), new Date(), new Double(i), new Double(i));
			spittles.add(spittle);
		}
		return spittles;
	}
	
	public TxtSpittleRepository(){

	}

}
