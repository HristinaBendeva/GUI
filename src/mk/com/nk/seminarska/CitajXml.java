package mk.com.nk.seminarska;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CitajXml {

	public List<Slavenik> find(String searchTerm) {
		List<Slavenik> slavenikXml = new ArrayList<Slavenik>();
		try {
			File xmlFile = new File("slavenici.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);

			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList nodeList = doc.getElementsByTagName("Slavenik");
			int total = nodeList.getLength();
			System.out.println(total);

			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				Node node = nodeList.item(temp);
				System.out.println(node.getNodeName());
				boolean found = false;
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element slavenikEl = (Element) node;
					if (slavenikEl.getElementsByTagName("Ime").item(0)
							.getTextContent().equalsIgnoreCase(searchTerm)) {
						found = true;
					} else if (slavenikEl.getElementsByTagName("Prezime")
							.item(0).getTextContent()
							.equalsIgnoreCase(searchTerm)) {
						found = true;
					} else if (slavenikEl.getElementsByTagName("Lokal").item(0)
							.getTextContent().equalsIgnoreCase(searchTerm)) {
						found = true;
					}

					if (found) {
						slavenikXml.add(new Slavenik(slavenikEl
								.getElementsByTagName("Ime").item(0)
								.getTextContent(), slavenikEl
								.getElementsByTagName("Prezime").item(0)
								.getTextContent(), Integer.parseInt(slavenikEl
								.getElementsByTagName("Godini").item(0)
								.getTextContent()), new Lokacija(slavenikEl
								.getElementsByTagName("Ulica").item(0)
								.getTextContent(), slavenikEl
								.getElementsByTagName("Grad").item(0)
								.getTextContent(), slavenikEl
								.getElementsByTagName("Lokal").item(0)
								.getTextContent(), Integer.parseInt(slavenikEl
								.getElementsByTagName("Gosti").item(0)
								.getTextContent()))));
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return slavenikXml;
	}

	public List<Slavenik> zemiGiSiteSlavenici() {
		List<Slavenik> siteSlaveniciLista = new ArrayList<Slavenik>();

		try {
			File xmlFile = new File("slavenici.xml");
			if (xmlFile.exists()) {
				DocumentBuilderFactory dbf = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(xmlFile);

				doc.getDocumentElement().normalize();
				System.out.println(doc.getDocumentElement().getNodeName());

				NodeList nodeList = doc.getElementsByTagName("Slavenik");
				int total = nodeList.getLength();
				System.out.println(total);

				for (int temp = 0; temp < nodeList.getLength(); temp++) {
					Node node = nodeList.item(temp);
					System.out.println(node.getNodeName());
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element slavenikEl = (Element) node;
						siteSlaveniciLista.add(new Slavenik(slavenikEl
								.getElementsByTagName("Ime").item(0)
								.getTextContent(), slavenikEl
								.getElementsByTagName("Prezime").item(0)
								.getTextContent(), Integer.parseInt(slavenikEl
								.getElementsByTagName("Godini").item(0)
								.getTextContent()), new Lokacija(slavenikEl
								.getElementsByTagName("Ulica").item(0)
								.getTextContent(), slavenikEl
								.getElementsByTagName("Grad").item(0)
								.getTextContent(), slavenikEl
								.getElementsByTagName("Lokal").item(0)
								.getTextContent(), Integer.parseInt(slavenikEl
								.getElementsByTagName("Gosti").item(0)
								.getTextContent()))));

					}

				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return siteSlaveniciLista;
	}

	public void izbrisiSlavenik(Slavenik slavenik) {

		try {
			File xmlFile = new File("slavenici.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);

			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList nodeList = doc.getElementsByTagName("Slavenik");
			
			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				Node node = nodeList.item(temp);
				System.out.println(node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element slavenikEl = (Element) node;

					if (slavenikEl.getElementsByTagName("Ime").item(0)
							.getTextContent()
							.equalsIgnoreCase(slavenik.getIme())
							&& slavenikEl.getElementsByTagName("Prezime")
									.item(0).getTextContent()
									.equalsIgnoreCase(slavenik.getPrezime())) {
						slavenikEl.getParentNode().removeChild(node);
					}

				}
			}
			Source s = new DOMSource(doc);
			StreamResult r = new StreamResult("slavenici.xml");
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.transform(s, r);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
