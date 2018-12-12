package parkersInvoice;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Servlet implementation class Hello
 */
public class TestDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/pdf");
		
		try {
			
			Document document = new Document();
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("Hello World"));
			document.add(new Paragraph(new Date().toString()));
			document.close();
			
		} catch (DocumentException de) {
			throw new IOException(de.getMessage());
		}
	}
}
			
		
