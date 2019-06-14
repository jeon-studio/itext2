/*
 * $Id: AddWatermarkPageNumbers.java 3373 2008-05-12 16:21:24Z xlv $
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

import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfTestBase;
import org.junit.Test;

public class InsertContentStreamTest{
	@Test
    public  void main() throws Exception {
            PdfReader reader = new PdfReader(PdfTestBase.RESOURCES_DIR +"jeon/simple.pdf");
            int n = reader.getNumberOfPages();
            PdfStamper stamp = new PdfStamper(reader,PdfTestBase.getOutputStream("_insert_content_stream_1.pdf"));
            // adding content to each page
            PdfContentByte under;
            PdfContentByte over;
            Image img = Image.getInstance(PdfTestBase.RESOURCES_DIR +"watermark.jpg");
            under = stamp.getUnderContent(1);
            under.addImage(img);
//            PdfReader reader2 = new PdfReader(PdfTestBase.RESOURCES_DIR +"SimpleAnnotations1.pdf");
//            under = stamp.getUnderContent(1);
//            under.addTemplate(stamp.getImportedPage(reader2, 3), 1, 0, 0, 1, 0, 0);
            stamp.close();
    }
}