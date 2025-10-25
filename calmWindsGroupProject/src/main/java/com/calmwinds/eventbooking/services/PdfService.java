import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.File;
import java.io.IOException;

public class PdfService {

    public void generateConfirmationSlip(String filePath, String eventName, String userName, int numberOfTickets) {
        try {
            PdfWriter writer = new PdfWriter(new File(filePath));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Event Booking Confirmation")
                    .setFontSize(20)
                    .setFont(StandardFonts.HELVETICA_BOLD));

            document.add(new Paragraph("Event Name: " + eventName));
            document.add(new Paragraph("Attendee Name: " + userName));
            document.add(new Paragraph("Number of Tickets: " + numberOfTickets));

            Table table = new Table(2);
            table.addCell("Event Name");
            table.addCell(eventName);
            table.addCell("Attendee Name");
            table.addCell(userName);
            table.addCell("Number of Tickets");
            table.addCell(String.valueOf(numberOfTickets));

            document.add(table);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}