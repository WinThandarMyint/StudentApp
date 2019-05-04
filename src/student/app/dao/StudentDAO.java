/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import student.app.database.Database;
import student.app.model.Students;

/**
 *
 * @author Win Thandar
 */
public class StudentDAO {
   
    public int saveStudent(Students student) throws SQLException{
        Connection conn = Database.getInstance().getConnection();
        String name=student.getName();
        String email=student.getEmail();
        String gender=student.getGender();
        Date dob=student.getDob();
        String sql="insert into students (name,email,gender,dob) values (?,?,?,?);";
        PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, gender);
        stmt.setDate(4, dob);
        
        return stmt.executeUpdate();
        
    
    }
    
    public List<Students> getStudent() throws SQLException{
        Connection conn = Database.getInstance().getConnection();
        String sql= "select * from students;" ;
        Statement stmt= conn.createStatement();
        ResultSet result=stmt.executeQuery(sql);
        List<Students> sdList=new ArrayList<>();
        while (result.next()){
        int id=result.getInt("id");
        String name=result.getString("name");
        String email=result.getString("email");
        String gender=result.getString("gender");
        Date dob=result.getDate("dob");
        Students student=new Students(id,name,email,gender,dob);
        sdList.add(student);
        }
    return sdList;}
    
    public Students getStudentById(int id) throws SQLException{
    Connection conn = Database.getInstance().getConnection();
    Students student=null;
	String sql="select * from students where id=?;";
	PreparedStatement stmt=conn.prepareStatement(sql);
	stmt.setInt(1, id);
	ResultSet result=stmt.executeQuery();
	if(result.next()) {
		String name=result.getString("name");
		String email=result.getString("email");
                String gender=result.getString("gender");
                Date dob=result.getDate("dob");
		student=new Students(id,name,email,gender,dob);
		}
	return student;
    }
    
    public int updateStudent(Students student) throws SQLException{
    Connection conn = Database.getInstance().getConnection();
    String sql="update students set name=?,email=? where id=?;";
	int id=student.getId();
	String name=student.getName();
	String email=student.getEmail();
		
	PreparedStatement stmt=conn.prepareStatement(sql);
	stmt.setString(1,name);
	stmt.setString(2,email);
	stmt.setInt(3,id);
	return stmt.executeUpdate();
    }
    
    public int deleteStudent(int id) throws SQLException{
    Connection conn = Database.getInstance().getConnection();
    String sql="delete from Students where id=?;";
    PreparedStatement stmt=conn.prepareStatement(sql);
    stmt.setInt(1,id);
    return stmt.executeUpdate();
    }
    
}
