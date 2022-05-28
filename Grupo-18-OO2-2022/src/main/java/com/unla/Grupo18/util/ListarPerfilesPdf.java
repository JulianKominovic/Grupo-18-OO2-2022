package com.unla.Grupo18.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.Grupo18.entities.Perfiles;
import com.unla.Grupo18.helpers.ViewRouteHelper;


@Component(ViewRouteHelper.PERFIL_LISTA)
public class ListarPerfilesPdf extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			@SuppressWarnings("unchecked")
			List<Perfiles> lista = (List<Perfiles>) model.get("lista");
			
			Font fuenteTitulo = FontFactory.getFont("Arial",20,Color.BLACK);
			Font fuenteTituloColumnas = FontFactory.getFont("Arial",12,Color.WHITE);
			Font fuenteDatos = FontFactory.getFont("Arial",11,Color.BLACK);
			
			document.setPageSize(PageSize.LETTER.rotate());
			document.setMargins(-30, -30, 40, 20);
			document.open();
			
			PdfPTable tablaTitulo = new PdfPTable(1);
			PdfPCell celda = null;
						
			celda =  new PdfPCell(new Phrase("LISTADO DE PERFILES", fuenteTitulo));
			celda.setBorder(0);
			celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
			celda.setPadding(15);
			
			tablaTitulo.addCell(celda);
			tablaTitulo.setSpacingAfter(15);
			
			PdfPTable tablaLista = new PdfPTable(1);
			
			celda = new PdfPCell(new Phrase("ROL", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(145, 19, 22));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			for(Perfiles perfil : lista) {
				celda = new PdfPCell(new Phrase(perfil.getRol(), fuenteDatos));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setVerticalAlignment(Element.ALIGN_CENTER);
				celda.setPadding(5);
				tablaLista.addCell(celda);
			}
					
		document.add(tablaTitulo);
		document.add(tablaLista);	
			
	}

}