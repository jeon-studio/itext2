/*
 * $Id: Logo.java 3838 2009-04-07 18:34:15Z mstorer $
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */
package jeon;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.*;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Draws the iText logo.
 */
public class InsertPdfFormXObjectTest{

	/**
	 * Draws the iText logo.
	 */
	 @Test
	public void main() throws Exception {
	 	
	 	File outputFile = PdfTestBase.getOutputFile( "_formxobject.pdf" );

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2: creation of the writer
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream( outputFile ) );

		// step 3: we open the document
		document.open();

		// step 4:
		BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252,
				BaseFont.NOT_EMBEDDED);
		PdfContentByte cb = writer.getDirectContent();


		 PdfReader reader = new PdfReader(PdfTestBase.RESOURCES_DIR +"ChapterSection.pdf");
		 PdfImportedPage template = writer.getImportedPage( reader, 1 );
		

		cb.addTemplate(template, 0, 1, -1, 0, 500, 200);
		cb.addTemplate(template, 0, 0 );
		cb.sanityCheck();

		// step 5: we close the document
		document.close();


		 Document document2 = new Document( );
		 PdfWriter writer2 = PdfWriter.getInstance( document2, PdfTestBase.getOutputStream( "_formxobject2.pdf" ) );
		 document2.open();
		 PdfContentByte contentByte = writer2.getDirectContent();
		 PdfReader reader2 = new PdfReader( outputFile.getAbsolutePath( ) );
		 PdfImportedPage template2 = writer2.getImportedPage( reader2, 1 );
		 
		 contentByte.addTemplate( template2, 0, 0 );
		 document2.close();
	}
	
	@Test
	public void caseAd() throws Exception {

		// step 1: creation of a document-object
		Document document = new Document();

		// step 2: creation of the writer
		PdfWriter writer = PdfWriter.getInstance(document,	PdfTestBase.getOutputStream("_formxobject-ad.pdf"));

		// step 3: we open the document
		document.open();

		// step 4:
		BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252,
				BaseFont.NOT_EMBEDDED);
		PdfContentByte cb = writer.getDirectContent();


		PdfReader reader = new PdfReader(PdfTestBase.RESOURCES_DIR +"jeon/fill-and-stroke-test.pdf");
		PdfImportedPage template = writer.getImportedPage( reader, 1 );

		PdfStream stream = template.getFormXObject( PdfStream.DEFAULT_COMPRESSION );

//		cb.addTemplate(template, 0, 1, -1, 0, 500, 200);
		cb.addTemplate(template, 0, 0);
		cb.sanityCheck();

		// step 5: we close the document
		document.close();
	}
}