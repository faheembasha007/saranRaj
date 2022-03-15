
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/fetchAll")
public class FetchAll extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
 //String filter = request.getParameter("filter");
 final String DB_URL="jdbc:mysql://localhost:3306/usersdb?autoReconnect=true&useSSL=false";
 
 final String USER = "root";
 final String PASS = "Root@123";
 
 try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
    Statement stmt =conn.createStatement();
     System.out.println("Inside Try Catch");
    String sql;
    sql = "select * from student_details";
    
    ResultSet rs = stmt.executeQuery(sql);
    
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Fetch Result Data</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<table border = 1 width = 100% height = 50%>");
    out.println("<tr><th>Name Of The Student</th><th>Department_name from</th><th>DOB<th></tr>");
    
    while(rs.next()){
    String nameofstudent = rs.getString("First_name");
    String department_name = rs.getString("Department_name");
    Date dob = rs.getDate("DOB");
    System.out.println("Inside While");
    out.println("<tr><td>" + nameofstudent + "</td><td>" + department_name + "</td><td>" + dob + "</td></tr>");
    }
    out.println("</table>");
    out.println("</body></html>");
    
    rs.close();
    stmt.close();
    conn.close();
}catch(SQLException fb){
    fb.printStackTrace();
}catch(Exception e){
    e.printStackTrace();
}
    }
}

