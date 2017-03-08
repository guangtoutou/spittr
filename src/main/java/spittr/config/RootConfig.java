package spittr.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import spittr.data.JdbcSpittleRepository;
import spittr.data.SpittleRepository;

@Configuration
@ComponentScan(basePackages = { "spittr" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {
	@Bean
	public DataSource setSQLDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://www.niningning.com:3306/spittr");
		ds.setUsername("guangtoutou");
		ds.setPassword("Justdoit123");
		return ds;
	}



	@Bean
	public JdbcTemplate setJdbcOperations(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
