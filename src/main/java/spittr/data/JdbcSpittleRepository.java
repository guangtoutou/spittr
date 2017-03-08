package spittr.data;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.jdbc.core.RowMapper;
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

		String sql = "SELECT spittle.*, spitter.id, spitter.fullname FROM spittle LEFT JOIN spitter ON spittle.spitter=spitter.id WHERE spittle.id < ? ORDER BY spittle.postedTime desc";
		List<Spittle> spittleList = jdbcOperations.query(sql, new String[] { String.valueOf(max) },
				new RowMapper<Spittle>() {
					public Spittle mapRow(ResultSet rs, int rowNum) {
						Spittle spittle = new Spittle();
						Spitter spitter = new Spitter();
						try {
							spittle.setId(Long.parseLong(rs.getString("id")));
							spittle.setMessage(rs.getString("message"));
							spittle.setTime(rs.getTimestamp("postedTime"));
							spitter.setFullName(rs.getString("fullName"));
							spittle.setSpitter(spitter);

						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return spittle;

					}
				});
		return spittleList;

	}

	public Spitter findSpitter(long id) {
		String sql = "select * from spitter where id = ?";
		Spitter spitter = jdbcOperations.queryForObject(sql, new String[] { String.valueOf(id) },
				new BeanPropertyRowMapper<Spitter>(Spitter.class));
		return spitter;
	}

}
