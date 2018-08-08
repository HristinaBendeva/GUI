package mk.com.nk.seminarska;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MetodiXml {
	
	public void zacuvajVoXml(Slavenik novSlavenik)  throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		try {
	        Document doc = db.parse("slavenici.xml");
	        dodadiVoXml(novSlavenik);
	       
		} catch (Exception e) {
			 zacuvajVoNovXml(novSlavenik);
		}
	}

	public void zacuvajVoNovXml(Slavenik novSlavenik){
		try{
			System.out.println("zacuvaj");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			Element slavenici = doc.createElement("Slavenici");
				Element slavenik = doc.createElement("Slavenik");
				Element ime = doc.createElement("Ime");
				Element prezime = doc.createElement("Prezime");
				Element godini = doc.createElement("Godini");
				Element ulica = doc.createElement("Ulica");
				Element grad = doc.createElement("Grad");
				Element lokal = doc.createElement("Lokal");
				Element gosti = doc.createElement("Gosti");
				ime.appendChild(doc.createTextNode(novSlavenik.getIme()));
				prezime.appendChild(doc.createTextNode(novSlavenik.getPrezime()));
				godini.appendChild(doc.createTextNode(Integer.toString(novSlavenik.getGodini())));
				ulica.appendChild(doc.createTextNode(novSlavenik.getLokacija().getUlica()));
				grad.appendChild(doc.createTextNode(novSlavenik.getLokacija().getGrad()));
				lokal.appendChild(doc.createTextNode(novSlavenik.getLokacija().getLokal()));
				gosti.appendChild(doc.createTextNode(Integer.toString(novSlavenik.getLokacija().getBrNaGosti())));
				slavenik.appendChild(ime);
				slavenik.appendChild(prezime);
				slavenik.appendChild(godini);
				slavenik.appendChild(ulica);
				slavenik.appendChild(grad);
				slavenik.appendChild(lokal);
				slavenik.appendChild(gosti);
				slavenici.appendChild(slavenik);
			
			doc.appendChild(slavenici);
			Source s = new DOMSource(doc);
			StreamResult r = new StreamResult("slavenici.xml");
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.transform(s, r);
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void dodadiVoXml(Slavenik novSlavenik) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse("slavenici.xml");
       
        Element root = doc.getDocumentElement();

        Element slavenik = doc.createElement("Slavenik");
		Element ime = doc.createElement("Ime");
		Element prezime = doc.createElement("Prezime");
		Element godini = doc.createElement("Godini");
		Element ulica = doc.createElement("Ulica");
		Element grad = doc.createElement("Grad");
		Element lokal = doc.createElement("Lokal");
		Element gosti = doc.createElement("Gosti");
		ime.appendChild(doc.createTextNode(novSlavenik.getIme()));
		prezime.appendChild(doc.createTextNode(novSlavenik.getPrezime()));
		godini.appendChild(doc.createTextNode(Integer.toString(novSlavenik.getGodini())));
		ulica.appendChild(doc.createTextNode(novSlavenik.getLokacija().getUlica()));
		grad.appendChild(doc.createTextNode(novSlavenik.getLokacija().getGrad()));
		lokal.appendChild(doc.createTextNode(novSlavenik.getLokacija().getLokal()));
		gosti.appendChild(doc.createTextNode(Integer.toString(novSlavenik.getLokacija().getBrNaGosti())));
		slavenik.appendChild(ime);
		slavenik.appendChild(prezime);
		slavenik.appendChild(godini);
		slavenik.appendChild(ulica);
		slavenik.appendChild(grad);
		slavenik.appendChild(lokal);
		slavenik.appendChild(gosti);
		root.appendChild(slavenik);
		
        DOMSource source = new DOMSource(doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("slavenici.xml");
        transformer.transform(source, result);
    }

}
