package parkersInvoice;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


public class TestItext {
	
	{
		 
	try {
		
		File file = new File("itext-test.pdf");
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.add(new Paragraph("Hello World!"));
		document.close();
		
	}catch (IOException e) {
		e.printStackTrace();
		} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
