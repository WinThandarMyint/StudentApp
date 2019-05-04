/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;


import java.sql.Date;
import java.sql.SQLException;
import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import student.app.dao.StudentDAO;
import student.app.database.Database;
import student.app.model.Students;

/**
 *
 * @author Win Thandar
 */
public class TestStudent {
    
    public TestStudent() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @TestStudent. For example:
//    private final Database db=new Database();
     @Test
     public void ConnTest() throws SQLException {
    
     Assert.assertEquals(true, Database.getInstance().connect());
     }
     
     
	//@Test
	public void testSave() throws SQLException {
                Date date=new Date(System.currentTimeMillis());
                Students sd=new Students("Mg Mg","mgmg@gmai.com","Male",date);
                StudentDAO stdao=new StudentDAO();
		assertEquals(1,stdao.saveStudent(sd));
	}
	
	//@Test
	public void testGetSd() throws SQLException{
            StudentDAO stdao=new StudentDAO();
		assertEquals(1,stdao.getStudent().size());
	}
	
	@Test
	public void testGetById() throws SQLException {
            StudentDAO stdao=new StudentDAO();
		assertEquals("Aung",stdao.getStudentById(1).getName());
	}
	
	@Test
	public void testUpdateSd() throws SQLException {
            StudentDAO stdao=new StudentDAO();
		Students sd=stdao.getStudentById(1);
		sd.setName("Aung");
		sd.setEmail("aung@http.com");
		assertEquals(1,stdao.updateStudent(sd));
	}
	
	@Test
	public void testDeleteSd() throws SQLException {
            StudentDAO stdao=new StudentDAO();
		assertEquals(1,stdao.deleteStudent(7));
	}
}
