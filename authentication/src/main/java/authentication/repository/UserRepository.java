package authentication.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import authentication.domain.Users;


@Repository
public class UserRepository{

    public UserRepository(){
        
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    final String INSERT_QUERY = "insert into users (username, password, remember_token, created_dt, updated_dt) values (?, ?, ?, ?, ?)";
    final String DELETE_QUERY = "delete from users where id = ?";
    final String SELECT_QUERY = "select from users where id= ?";

    //fetch ALl users
    public List<String> list(){

        List<String> userNames= new ArrayList<>();
        userNames.addAll(jdbcTemplate.queryForList("select username from users;", String.class));
        return userNames;
    }

    //save users
    public void add(Users users){

        users.setUserName("Sukanya");
        users.setPassword("Sukanya");
        users.setRememberToken("Sukanya");
        users.setCreatedAt(null);
        users.setUpdatedAt(null);

        jdbcTemplate.update(INSERT_QUERY, users.getUsername(), users.getPassword(), users.getRememberToken(), users.getCreatedAt(), users.getUpdatedAt());
      
      
    }
  
    //delete Users
    public void delete(int id){

        int status = jdbcTemplate.update(DELETE_QUERY, id);
        if(status != 0){
          System.out.println("Employee data deleted for ID " + id);
        }else{
          System.out.println("No Employee found with ID " + id);
        }
    }

    public String get(int id) {
         List<Map<String, Object>> status = jdbcTemplate.queryForList(SELECT_QUERY,id);
        if(status != null){
          
        }else{
          
        }
        return null;
    }

    
    
}
