package pelasEArte.controller;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import pelasEArte.utils.filters.PDFFilter;

public class SalvarComo extends JDialog {
	private static final long serialVersionUID = 2778659046882673860L;


	public String salvar() {
		String ext = "";
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.addChoosableFileFilter(new PDFFilter());
		int diretorio = chooser.showSaveDialog(null);
		
		if (diretorio == JFileChooser.APPROVE_OPTION) {
			ext = "";
			String extensao = chooser.getFileFilter().getDescription();
			
			if (extensao.equals("*.pdf, *.PDF")) {
				ext = ".pdf";
			}
		}
		System.out.println(chooser.getSelectedFile() + ext);
		return chooser.getSelectedFile() + ext;
	}
}
