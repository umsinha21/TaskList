package uma.javabrains.tasklist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/TaskServletpath")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String connection="jdbc:sqlserver://localhost;integratedSecurity=true";
		
		try
		{
		String taskdata=request.getParameter("task");
		Connection conn=null;
		Statement state=null;
		conn=DriverManager.getConnection(connection);
	    
		state=conn.createStatement();
		String sql="insert into tasklist_table(id,task_details) values('1','"+taskdata+"')";
		
		state.executeQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("error in jdbc connection");
		}
	}

}
