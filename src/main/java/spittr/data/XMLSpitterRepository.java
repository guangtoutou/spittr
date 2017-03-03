package spittr.data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Component;

import spittr.Spitter;

@Component
public class XMLSpitterRepository implements SpitterRepository {
	private SAXReader reader;

	private Document doc;

	private String path = System.getProperty("web.root") + "WEB-INF/" + "spitters.xml";

	public Spitter findByUsername(String username) {
		List<Element> elements = doc.selectNodes("spitters/spitter[username='" + username + "']");
		Iterator<Element> i = elements.iterator();
		while (i.hasNext()) {
			Element e = i.next();
			String firstName = e.elementText("firstname");
			String lastName = e.elementText("lastname");
			String password = e.elementText("password");

			Spitter spitter = new Spitter(firstName, lastName, username, password);
			return spitter;
		}

		return null;
	}

	public void addSpitter(Spitter spitter) {
		Element element = doc.getRootElement().addElement("spitter");
		element.addElement("firstname").setText(spitter.getFirstName());
		element.addElement("lastname").setText(spitter.getLastName());
		element.addElement("username").setText(spitter.getUsername());
		element.addElement("password").setText(spitter.getPassword());

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			OutputFormat of = new OutputFormat();
			of.setEncoding("UTF-8");
			of.setIndent(true);
			of.setIndent("    ");
			of.setNewlines(true);
			XMLWriter writer = new XMLWriter(osw, of);
			writer.write(doc);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public XMLSpitterRepository() throws DocumentException {
		this.reader = new SAXReader();
		this.doc = reader.read(path);
	}

}
