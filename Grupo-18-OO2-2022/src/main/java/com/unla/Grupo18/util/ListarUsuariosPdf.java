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
import com.unla.Grupo18.entities.Usuario;
import com.unla.Grupo18.helpers.ViewRouteHelper;


@Component(ViewRouteHelper.USUARIO_LISTA)
public class ListarUsuariosPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		List<Usuario> lista = (List<Usuario>) model.get("lista");
		
		Font fuenteTitulo = FontFactory.getFont("Arial",20,Color.BLACK);
		Font fuenteTituloColumnas = FontFactory.getFont("Arial",12,Color.WHITE);
		Font fuenteDatos = FontFactory.getFont("Arial",11,Color.BLACK);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-45, -45, 40, 20);
		document.open();
		PdfPCell celda = null;

		PdfPTable tablaTitulo = new PdfPTable(1);
		
		celda =  new PdfPCell(new Phrase("LISTADO DE USUARIOS", fuenteTitulo));
		celda.setBorder(0);
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setPadding(15);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(15);
		
		PdfPTable tablaLista = new PdfPTable(7);
		tablaLista.setWidths(new float[] {2f, 2f, 3f, 2f, 3.5f, 3.5f, 2f});
		
		celda = new PdfPCell(new Phrase("Nombre", fuenteTituloColumnas));
		celda.setBackgroundColor(new  Color(145, 19, 22));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(6);
		tablaLista.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Apellido", fuenteTituloColumnas));
		celda.setBackgroundColor(new  Color(145, 19, 22));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(6);
		tablaLista.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Tipo de documento", fuenteTituloColumnas));
		celda.setBackgroundColor(new  Color(145, 19, 22));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(6);
		tablaLista.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Documento", fuenteTituloColumnas));
		celda.setBackgroundColor(new  Color(145, 19, 22));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(6);
		tablaLista.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Correo Electronico", fuenteTituloColumnas));
		celda.setBackgroundColor(new  Color(145, 19, 22));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(6);
		tablaLista.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nombre de Usuario", fuenteTituloColumnas));
		celda.setBackgroundColor(new  Color(145, 19, 22));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(6);
		tablaLista.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Perfil", fuenteTituloColumnas));
		celda.setBackgroundColor(new  Color(145, 19, 22));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(6);
		tablaLista.addCell(celda);

		
		for(Usuario usuario : lista) {
			celda = new PdfPCell(new Phrase(usuario.getNombre(), fuenteDatos));
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getApellido(), fuenteDatos));
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getTipoDocumento(), fuenteDatos));
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			Integer documento = usuario.getDocumento();
			celda = new PdfPCell(new Phrase(documento.toString(), fuenteDatos));
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getCorreoElectronico(), fuenteDatos));
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getNombreDeUsuario(), fuenteDatos));
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase(usuario.getPerfiles().getRol(), fuenteDatos));
			celda.setPadding(5);
			tablaLista.addCell(celda);
		}
	
	document.add(tablaTitulo);
	document.add(tablaLista);	
		
	}

}
