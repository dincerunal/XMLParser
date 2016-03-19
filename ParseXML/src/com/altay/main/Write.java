package com.altay.main;

import java.io.File;
import java.io.StringWriter;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author unal
 *
 */
public class Write {
	public Write(Vector vector) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			//Element root = document.createElement("languages");
			Element root = document.createElement("catalog");
			
			//root.setAttribute("cat", "it");
			root.setAttribute("book", "bk101");

			Element author = document.createElement("author");
			
			
			author.setAttribute("title", "XML Developer's Guide");
			
			Element genre = document.createElement("genre");

			Element publishDate = document.createElement("publish_date");
			publishDate.setTextContent(vector.get(0).toString());
			
			genre.appendChild(publishDate);
			
			author.appendChild(genre);
			root.appendChild(author);
			document.appendChild(root);

			// ------------------------------------------------------------------

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(
					writer));
			System.out.println(writer.toString());

			transformer.transform(new DOMSource(document), new StreamResult(
					new File("newXML.xml")));
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}