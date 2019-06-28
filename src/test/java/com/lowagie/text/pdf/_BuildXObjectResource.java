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
package com.lowagie.text.pdf;

import org.junit.Test;

public class _BuildXObjectResource{
	@Test
    public static void main() throws Exception {
            
            PdfReader reader = new PdfReader(PdfTestBase.RESOURCES_DIR +"jeon/x-d.pdf");
            PdfStamper stamp = new PdfStamper(reader,PdfTestBase.getOutputStream("_xobjectbuild.pdf"));
            PdfReader reader2 = new PdfReader(PdfTestBase.RESOURCES_DIR +"ChapterSection.pdf");
            PdfImportedPage importedPage = stamp.getImportedPage( reader2, 1 );

            PdfWriter writer = stamp.getWriter();

            PdfName name = new PdfName( "dxo1" );

            name = writer.addDirectTemplateSimple( importedPage, name );
            PdfContentByte under = stamp.getUnderContent(1);
            //            name = under.getPageResources().addXObject( name, importedPage.getIndirectReference() );
//            under.getPageResources().addXObjectWithNoTranslate( name, importedPage.getIndirectReference() );
            under.getPageResources().xObjectDictionary.put( name, importedPage.getIndirectReference() );

            //            under.addTemplate(stamp.getImportedPage(reader2, 1), 1, 0, 0, 1, 0, 0);
            stamp.close();
    }
}