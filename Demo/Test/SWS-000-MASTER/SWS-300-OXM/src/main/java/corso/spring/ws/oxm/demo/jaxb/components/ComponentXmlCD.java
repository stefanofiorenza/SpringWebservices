package corso.spring.ws.oxm.demo.jaxb.components;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;



public class ComponentXmlCD {

	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	

	public Marshaller getMarshaller() {
		return marshaller;
	}


	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}


	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}


	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}


	public Result marshal (Object objectXml) throws XmlMappingException, IOException{
		Result risultato = new StreamResult();
		marshaller.marshal(objectXml, risultato);
		return risultato;
	}
	
	
	public Object unmarshal (Source streamXml) throws XmlMappingException, IOException{
		Object object =unmarshaller.unmarshal(streamXml);
		return object;
	}
}
