package hello;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers("+
            "id SERIAL,first_name VARCHAR(255),last_name VARCHAR(255))");
        List<Object[]> splitUpNames = Arrays.asList("Yasin Gee","yuxu ge","sije Chou","mima Nan").stream()
            .map(name -> name.split(" "))
            .collect(Collectors.toList());
        
        splitUpNames.forEach(name -> log.info(String.format("inserting customer for %s %s", name[0],name[1])));

        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name,last_name) VALUES (?,?)", splitUpNames);

        jdbcTemplate.query("SELECT id,first_name,last_name FROM customers WHERE first_name = ?",new Object[]{"Yasin"},
            (rs,rowNum)->new Customer(rs.getLong("id"),rs.getString("first_name"),rs.getString("last_name"))
        ).forEach(
            c -> 
                log.info(c.toString())
        );

        
    }
}