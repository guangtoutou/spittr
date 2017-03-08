package spittr.data;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;


import spittr.Spitter;
import spittr.Spittle;

@Repository
@Primary
public class JdbcSpittleRepository implements SpittleRepository {
	private JdbcOperations jdbcOperations;

	@Autowired
	public JdbcSpittleRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public List<Spittle> findSpittles(long max, int count) {

		String sql = "Select * from spittle where id < ? limit 20";
		List<Spittle> spittleList = new ArrayList<Spittle>();
		List<Map<String, Object>> result = jdbcOperations.queryForList(sql, max);
		for (Map iterator : result) {
			System.out.println(iterator.get("message").toString());
			Long id = Long.parseLong(iterator.get("id").toString());
			String message = iterator.get("message").toString();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date time = new Date();
			try {
				time = format.parse(iterator.get("postedTime").toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Spitter spitter = new Spitter(Long.parseLong(iterator.get("spitter").toString()), "", "", "", "", false);
			Spittle spittle = new Spittle(id, message, time, spitter);
			spittleList.add(spittle);
		}
		return spittleList;

	}

	public Spitter findSpitter(long id) {
		String sql = "select * from spitter where id = ?";
		Spitter spitter = jdbcOperations.queryForObject(sql, new String[] { String.valueOf(id) },
				new BeanPropertyRowMapper<Spitter>(Spitter.class));
		return spitter;
	}

}
