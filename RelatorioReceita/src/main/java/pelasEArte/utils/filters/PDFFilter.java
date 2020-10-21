package pelasEArte.utils.filters;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PDFFilter extends FileFilter {

	@Override
	public boolean accept(File pdf) {
		if (pdf.isDirectory()) {
			return false;			
		}
		
		String s = pdf.getName().toLowerCase();
		return s.endsWith(".pdf");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "*.pdf, *.PDF";
	}

}
