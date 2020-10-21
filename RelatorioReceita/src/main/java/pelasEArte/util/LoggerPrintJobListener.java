package pelasEArte.util;

import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;

public class LoggerPrintJobListener implements PrintJobListener {

    
    public void printDataTransferCompleted(PrintJobEvent pje) {
        System.out.println("Print data transfer completed ;) ");
    }

    public void printJobCompleted(PrintJobEvent pje) {
    	System.out.println("Print job completed =) ");
    }

    public void printJobFailed(PrintJobEvent pje) {
    	System.out.println("Print job failed =( ");
    }

    public void printJobCanceled(PrintJobEvent pje) {
    	System.out.println("Print job canceled :| ");
    }

    public void printJobNoMoreEvents(PrintJobEvent pje) {
    	System.out.println("No more events to the job ");
    }

    public void printJobRequiresAttention(PrintJobEvent pje) {
    	System.out.println("Print job requires attention :O ");
    }
}