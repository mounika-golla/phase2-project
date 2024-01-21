package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class userDAO {
private Connection connection;
public userDAO() {
// Initialize the database connection
connection = DBConnection.getConnection();
}
public void registerUser(userdetails user) {
try {
String query = "INSERT INTO userdetails (name, email,password) VALUES (?, ?, ?)";
PreparedStatement statement = 
connection.prepareStatement(query);
statement.setString(1, user.getName());
statement.setString(2, user.getEmail());
statement.setString(3, user.getPassword());
statement.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
}
public boolean loginUser(String email, String password) {
try {
String query = "SELECT * FROM userdetails WHERE email=?AND password=?";
PreparedStatement statement = 
connection.prepareStatement(query);
statement.setString(1, email);
statement.setString(2, password);
ResultSet resultSet = statement.executeQuery();
return resultSet.next();
} catch (SQLException e) {
e.printStackTrace();
}
return false;
}
public userdetails getUserByEmail(String email) {
try {
String query = "SELECT * FROM userdetails WHERE email=?";
PreparedStatement statement = 
connection.prepareStatement(query);
statement.setString(1, email);
ResultSet resultSet = statement.executeQuery();
if (resultSet.next()) {
userdetails user = new userdetails();
user.setName(resultSet.getString("name"));
user.setEmail(resultSet.getString("email"));
user.setPassword(resultSet.getString("password"));
return user;
}
} catch (SQLException e) {
e.printStackTrace();
}
return null;
}
}

