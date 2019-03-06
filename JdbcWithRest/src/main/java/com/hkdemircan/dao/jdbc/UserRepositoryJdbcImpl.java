//package com.hkdemircan.dao.jdbc;
//
//import com.hkdemircan.dao.UserRepository;
//import com.hkdemircan.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.support.DataAccessUtils;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class UserRepositoryJdbcImpl implements UserRepository {
//    private static final String SELECT_USERS = "select * from Persons";
//    private static final String SELECT_USER_ID = "select * from Persons where id = ?";
//    private static final String INSERT_USER = "insert into Persons (firstName,lastName) values(?,?)";
//    private static final String DELETE_USER = "delete from Persons where id = ?";
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    private RowMapper<User> rowMapper = new RowMapper<User>() {
//        @Override
//        public User mapRow(ResultSet resultSet, int i) throws SQLException {
//            User user = new User();
//            user.setId(resultSet.getLong("id"));
//            user.setFirstName(resultSet.getString("firstName"));
//            user.setLastName(resultSet.getString("lastName"));
//            return user;
//        }
//    };
//
//    @Override
//    public List<User> findAll() {
//        return jdbcTemplate.query(SELECT_USERS,rowMapper);
//    }
//
//    @Override
//    public User findById(Long id) {
//        return DataAccessUtils.singleResult(jdbcTemplate.query(SELECT_USER_ID,rowMapper, id));
//    }
//
//    @Override
//    public void create(User user) {
//        jdbcTemplate.update(INSERT_USER,new Object[]{user.getFirstName(), user.getLastName()});
//    }
//
//    @Override
//    public User update(User user) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//        jdbcTemplate.update(DELETE_USER, new Object[]{id});
//    }
//}
