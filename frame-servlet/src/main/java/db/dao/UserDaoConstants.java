package db.dao;

public interface UserDaoConstants {
    String SAVE_QUERY = "INSERT INTO user(email, password) VALUES (?,?)";
}
