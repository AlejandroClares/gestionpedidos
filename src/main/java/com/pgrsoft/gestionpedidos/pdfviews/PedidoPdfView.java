package com.pgrsoft.gestionpedidos.pdfviews;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.pgrsoft.gestionpedidos.backend.presentation.model.LineaPedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;

@Component("pedidoView")
public class PedidoPdfView extends  AbstractView {

	private SimpleDateFormat sdfF = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
	
	private DecimalFormat formatoImporte = new DecimalFormat("0.00");
	private DecimalFormat formatoCodigo = new DecimalFormat("000000");
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//response.setHeader("?");
		
		PedidoVO pedido = (PedidoVO) model.get("pedido");
		
		PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
		PdfDocument pdf = new PdfDocument(pdfWriter);
		Document document = new Document(pdf);
		
		// Creating an ImageData object 
		String imageFile = "classpath:pollos_hermanos_logo.png"; 
		ImageData data = ImageDataFactory.create(imageFile);
	    
		// Creating an Image object 
		Image img = new Image(data);
		img.setWidth(110);
		img.setHeight(110);
		img.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		
		// Adding image to the document 
		//document.add(img);
		
		//header de pedido
	    Table cabecera = new Table(new float[]{300f,20f});
		
	    Cell col1 = new Cell();
	    Cell col2 = new Cell();
	    
	    col1.add(new Paragraph("Pollo LoKo, S.L."));
	    col1.add(new Paragraph("B-46228951"));
	    col1.add(new Paragraph("Avda Industria, 240 Edificio A"));
	    col1.add(new Paragraph("Santa Perpetua de Mogoda - 08020 - Barcelona"));
	    col1.add(new Paragraph(" "));
	    col1.add(new Paragraph("Telf. +34 932205050"));
	    col1.add(new Paragraph("Email admin@polloloko.com"));
	    
	    col2.add(img);
	    
	    col1.setBorder(Border.NO_BORDER);
	    col2.setBorder(Border.NO_BORDER);
	    
	    col1.setFontSize(10f);
	  
	    cabecera.addCell(col1);
	    cabecera.addCell(col2);
		
	    cabecera.setWidth(UnitValue.createPercentValue(100));
	    cabecera.setMarginBottom(35);
	    
	    document.add(cabecera);
		
		//title
		Paragraph title = new Paragraph("Hoja de Pedido ");
		title.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
	    title.setFontSize(18f);
	    title.setMarginBottom(30f);
	    document.add(title);
	    
	    //header de pedido
	    Table headerTable = new Table(new float[]{20f,20f});
	    
	    Cell lh11 = new Cell().add("Código de Pedido");
	    Cell lh12 = new Cell().add(String.valueOf(pedido.getId()));
	    
	    Cell lh21 = new Cell().add("Fecha");
	    Cell lh22 = new Cell().add(sdfF.format(pedido.getFecha()));
	    
	    Cell lh31 = new Cell().add("Hora");
	    Cell lh32 = new Cell().add(sdfH.format(pedido.getFecha()));
	    
	    Cell lh41 = new Cell().add("Camarero");
	    Cell lh42 = new Cell().add(pedido.getCamarero().getNombre());
	    
	    Cell lh51 = new Cell().add("Mesa");
	    Cell lh52 = new Cell().add(String.valueOf(pedido.getMesa()));
	    
	    lh11.setBorder(Border.NO_BORDER);
	    lh12.setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
	    lh21.setBorder(Border.NO_BORDER);
	    lh22.setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
	    lh31.setBorder(Border.NO_BORDER);
	    lh32.setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
	    lh41.setBorder(Border.NO_BORDER);
	    lh42.setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
	    lh51.setBorder(Border.NO_BORDER);
	    lh52.setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
	   
	    headerTable.addCell(lh11);
	    headerTable.addCell(lh12);
	    headerTable.addCell(lh21);
	    headerTable.addCell(lh22);
	    headerTable.addCell(lh31);
	    headerTable.addCell(lh32);
	    headerTable.addCell(lh41);
	    headerTable.addCell(lh42);
	    headerTable.addCell(lh51);
	    headerTable.addCell(lh52);
	    
	    headerTable.setMarginBottom(30f);
	    
	    document.add(headerTable);
	    
	    Table table = new Table(new float[]{5f,40f,5f,5f,5f});
	    table
	    	.setWidth(UnitValue.createPercentValue(100))
	    	.setTextAlignment(TextAlignment.CENTER);
	    	
	    Cell h1 = new Cell().add(new Paragraph("Código"));
	    Cell h2 = new Cell().add(new Paragraph("Producto"));
	    Cell h4 = new Cell().add(new Paragraph("Cantidad"));
	    Cell h5 = new Cell().add(new Paragraph("Precio"));
	    Cell h6 = new Cell().add(new Paragraph("Total"));
	    
	    h1.setFontColor(Color.WHITE);
	    h2.setFontColor(Color.WHITE);
	    h4.setFontColor(Color.WHITE);
	    h5.setFontColor(Color.WHITE);
	    h6.setFontColor(Color.WHITE);
	    
	    h1.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    h2.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    h4.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    h5.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    h6.setBackgroundColor(Color.BLACK).setTextAlignment(TextAlignment.CENTER);
	    
	    table.addHeaderCell(h1);
	    table.addHeaderCell(h2);
	    table.addHeaderCell(h4);
	    table.addHeaderCell(h5);
	    table.addHeaderCell(h6);
	   
	    for(LineaPedidoVO lp: pedido.getLineasPedido()) {
	    	Cell cCodigo = new Cell().add(new Paragraph(formatoCodigo.format(lp.getProducto().getCodigo())));
	    	Cell cProducto = new Cell().add(new Paragraph(lp.getProducto().getNombre()));
	    	Cell cCantidad = new Cell().add(new Paragraph(String.valueOf(lp.getCantidad())));
	    	Cell cPrecio = new Cell().add(new Paragraph(formatoImporte.format(lp.getPrecio()) + " €"));
	    	Cell cTotal = new Cell().add(new Paragraph(formatoImporte.format(lp.getCantidad() * lp.getPrecio()) + " €"));
	    	
	    	cCodigo.setTextAlignment(TextAlignment.CENTER);
	    	cProducto.setTextAlignment(TextAlignment.LEFT);
	    	
	    	table.addCell(cCodigo);
	    	table.addCell(cProducto);
	    	table.addCell(cCantidad).setTextAlignment(TextAlignment.RIGHT);
	    	table.addCell(cPrecio).setTextAlignment(TextAlignment.RIGHT);
	    	table.addCell(cTotal).setTextAlignment(TextAlignment.RIGHT);
	    
	    }
	    
	    document.add(table);
	    document.close();
	 	
	}
	
}