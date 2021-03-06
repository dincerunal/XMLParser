package com.altay.main;

import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author unal
 *
 */
public class Read {
	public Vector Read() {
		Vector vector = new Vector();
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder bulider = factory.newDocumentBuilder();
			Document document = bulider.parse(new File("languages.xml"));
			Element root = document.getDocumentElement();

			NodeList list = root.getElementsByTagName("author");
			// NodeList list2 = root.getElementsByTagName("nokta");
			// rootNodedan baslayip XML icerisini dolasiyor
			for (int i = 0; i < list.getLength(); i++) {

				Element author = (Element) list.item(i);

				NodeList clist = author.getChildNodes();

				System.out.println("");

				for (int j = 0; j < clist.getLength(); j++) {
					Node c = clist.item(j);
					System.out.println(c.getNodeValue());
					//if (c instanceof Element) {
						System.out.println(c.getNodeName() + "="
								+ c.getTextContent());

						System.out.println("");
						vector.add(c.getTextContent());
					//}

				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vector;
	}

}
