package parkersInvoice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Set;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.TextField;

import java.sql.*;
import javax.swing.*;

/**
 * Servlet implementation class FedEx
 */
public class FedEx extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** DB login info */
	
	public class ConnectDatabase {

		   Connection dbConnection = null;
		   ResultSet rs = null;
		   PreparedStatement ps = null;
		   String dbName = "portdb";
		   String userName = "Fedex"; 
		   String password = "kG!8oo97";
		   String url ="jdbc:jtds:sqlserver://cs-panelserver2.cybershsarks.net";

		   public Connection getConnection() throws ClassNotFoundException, SQLException {
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      dbConnection = DriverManager.getConnection(dbName,userName,password);
		      return dbConnection;
		   }
		   
			private void HoldFile() {
				
				String sql = "SELECT * from holdFile";
				try {
					ps = dbConnection.prepareStatement(sql);
					rs = ps.executeQuery(sql);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}
	
		protected void doPost(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
			response.setContentType("application/pdf");
			
			try {
				InputStream is = getServletContext().getResourceAsStream("parkersInvoice3.pdf");
				PdfReader reader = new PdfReader(is, null);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PdfStamper stamper = new PdfStamper(reader, baos);
				AcroFields fields = stamper.getAcroFields();
				fields.setFieldProperty("personal.password", "clrfflags", TextField.PASSWORD, null);
				Set<String> parameters = fields.getFields().keySet();
				
				for (String parameter : parameters){
					fields.setField(parameter, request.getParameter(parameter));
					
				}
				stamper.setFormFlattening(true);
				stamper.close();
				OutputStream os = response.getOutputStream();
				baos.writeTo(os);
				os.flush();
		
			} catch (DocumentException e) {
				throw new IOException(e.getMessage());
			}
			
		}
				
				
				
			
				
				
				
				
				

			
			
			
			
			
}
	

