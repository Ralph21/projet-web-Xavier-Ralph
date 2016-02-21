package com.miage.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.miage.domain.Users;

public class UsersMapper  implements RowMapper<Users> {

	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();
		users.setIdUtilisateur(rs.getInt("id_utilisateur"));
		users.setAge(rs.getInt("age"));
		users.setEmail(rs.getString("email"));
		users.setEnabled(rs.getInt("enabled"));
		users.setFirstName(rs.getString("first_name"));
		users.setLastName(rs.getString("last_name"));
		users.setPassword(rs.getString("password"));
		users.setUsername(rs.getString("username"));
		return users;
	}
}
