package com.greejoy.action;

import com.greejoy.model.Resp;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.Orientation;
import org.apache.pdfbox.printing.PDFPageable;

import javax.print.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

@Path("/pdf")
public class PdfPrintAction {

    /**
     * @param printerName 打印机名包含字串 192.168.10.8
     * @param dpfPath     pdf 文件路径
     * @return 消息json
     */
    @Path("/print")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Resp GoPtPdf(@FormParam("printerName") String printerName, @FormParam("pdfPath") String dpfPath) throws Exception {
        PDDocument document = null;
        Resp resp;
        try {
            document = PDDocument.load(new File(dpfPath));
            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setJobName(new File(dpfPath).getName());

            PrintService[] printService = PrinterJob.lookupPrintServices();// 获得本台电脑连接的所有打印机

            boolean flag = true;
            for (PrintService service : printService) {
                if (service.getName().contains(printerName)) {
                    printJob.setPrintService(service);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                resp = new Resp(-1, "找不到该打印机");
                return resp;
            }
            printJob.setPageable(new PDFPageable(document, Orientation.AUTO, false, 0));
            printJob.print();

            resp = new Resp(0, "success");
        } catch (Exception e) {
            resp = new Resp(-1, e.getMessage());
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resp;
    }
}