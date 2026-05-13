package kr.hnu.ice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;
    private PreparedStatement pstat;

    private static final String URL = "jdbc:mariadb://localhost:3306/mywebdb2";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void close() {
        try {
            if (pstat != null) {
                pstat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        String sql = "select id, name, univ, birthdate, email from student1 order by id";

        try {
            connect();
            pstat = conn.prepareStatement(sql);

            try (ResultSet rs = pstat.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("univ"),
                            rs.getString("birthdate"),
                            rs.getString("email"));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("학생 목록을 불러오지 못했습니다: " + e.getMessage(), e);
        } finally {
            close();
        }

        return students;
    }

    public Student insert(int id, String name, String univ, String birthdate, String email) {
        Student student = new Student(id, name, univ, birthdate, email);
        String sql = "insert into student1(id, name, univ, birthdate, email) values (?, ?, ?, ?, ?)";

        try {
            connect();
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, student.getId());
            pstat.setString(2, student.getName());
            pstat.setString(3, student.getUniv());
            pstat.setString(4, student.getBirthdate());
            pstat.setString(5, student.getEmail());
            pstat.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("학생 정보를 추가하지 못했습니다: " + e.getMessage(), e);
        } finally {
            close();
        }

        return student;
    }

    public Student getById(int id) {
        String sql = "select id, name, univ, birthdate, email from student1 where id = ?";

        try {
            connect();
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, id);

            try (ResultSet rs = pstat.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("univ"),
                            rs.getString("birthdate"),
                            rs.getString("email"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("학생 정보를 불러오지 못했습니다: " + e.getMessage(), e);
        } finally {
            close();
        }

        return null;
    }

    public void update(int id, String name, String univ, String birthdate, String email) {
        String sql = "update student1 set name = ?, univ = ?, birthdate = ?, email = ? where id = ?";

        try {
            connect();
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, name);
            pstat.setString(2, univ);
            pstat.setString(3, birthdate);
            pstat.setString(4, email);
            pstat.setInt(5, id);
            pstat.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("학생 정보를 수정하지 못했습니다: " + e.getMessage(), e);
        } finally {
            close();
        }
    }

    public void delete(int id) {
        String sql = "delete from student1 where id = ?";

        try {
            connect();
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, id);
            pstat.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("학생 정보를 삭제하지 못했습니다: " + e.getMessage(), e);
        } finally {
            close();
        }
    }
}
