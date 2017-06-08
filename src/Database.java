import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public Database() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void addStudent(String FirstName, String LastName, String Address, String City, String State, String ZIP, String Phone, String major, String deptID)
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql = "Insert into MCStudents(FirstName, LastName,Address,City,State,ZIP,Phone,deptID,major) values('"
				+FirstName+"','"+LastName+"','"+Address+"','"+City+"','"+State+"','"+ZIP+"','"+Phone+"','"+deptID+"','"+major+"')";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/MC_Info?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			 if(!stmt.execute(sql))
			 {
				 
				
				sql= "Select * from MCStudents where FirstName='"+FirstName+"' and LastName='"+LastName+"'";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				
				while(rs.next()){
					System.out.print(rs.getString(1) + "\t");
					System.out.print(rs.getString(2));
					System.out.println();
				}
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public String[] getStudent(int studentID)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from MCStudents where studentID='"+studentID+"'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/MC_Info?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String[] vals=new String[10];
				
				for(int i=0;i<vals.length;i++)
				{
					vals[i]=rs.getString(i+1);
					System.out.print(vals[i] + "\t");
				}
				System.out.println("");
				return vals;
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return null;
		
		
		
		
	}
	
	public boolean deleteStudent(int studentID) {
		Connection con = null;
		Statement stmt = null;
		
		String sql = "delete from MCStudents where studentID='"+studentID+"'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/MC_Info?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			
			stmt.execute(sql);
				
			return true;
			
		
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		finally 
		{	try 
			{
				
				stmt.close();
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	
	}
	
	public void updateStudent(String FirstName, String LastName, String Address, String City, String State, String ZIP, String Phone,String studentID, String deptID, String major)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "update MCStudents "
				+ "set FirstName ='"+FirstName+"',LastName ='"+LastName+"',Address='"+Address+"',City='"+City+"',State ='"+State+"',ZIP ='"+ZIP+"',Phone ='"+Phone+"',deptID ='"+ deptID+"',major ='"+major
						+ "' where studentID='"+studentID+"'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/MC_Info?"
                                + "user=root&password=password");
			stmt = con.createStatement();
			if(!stmt.execute(sql))
			 {
				 
				
				sql= "Select * from MCStudents where studentID='"+studentID+"'";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				
				
				ResultSetMetaData col=rs.getMetaData();
				for(int i=1;i<=col.getColumnCount();i++)
				{
					
					System.out.print(col.getColumnName(i) + "\t");
				}
				System.out.println();
				System.out.println();
				while(rs.next()){
					
					
					
					for(int i=1;i<=col.getColumnCount();i++)
					{
						
						System.out.print(rs.getString(i) + "\t");
					}
					System.out.println();
				}
			 }
		}
			catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
		
	}

}
	
