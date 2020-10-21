package pelasEArte.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;

public class Impressao {

	public static void imprimir() throws PrintException, IOException {
	
		// Impressoras
		PrintService[] listaImpresoras = PrintServiceLookup.lookupPrintServices(null, null);
		PrintService impressoraPadrao = PrintServiceLookup.lookupDefaultPrintService();
		
		InputStream fileInputStream = new FileInputStream("C:\\Users\\guilh\\teste.txt ");
		
		DocFlavor tipoDeArquivo = DocFlavor.INPUT_STREAM.AUTOSENSE;
		HashDocAttributeSet hashDocAttributeSet = new HashDocAttributeSet();
		Doc doc = new SimpleDoc(fileInputStream, tipoDeArquivo, hashDocAttributeSet);
		HashPrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
		PrintService servico = ServiceUI.printDialog(null, 300, 200, listaImpresoras, impressoraPadrao, tipoDeArquivo, printRequestAttributeSet);

		//Manda imprimir
		if (servico != null) {
			System.out.println(doc.getPrintData().toString());
			DocPrintJob docPrintJob = servico.createPrintJob();
			docPrintJob.addPrintJobListener(new LoggerPrintJobListener());
			docPrintJob.print(doc, null);
		}
	}
}
