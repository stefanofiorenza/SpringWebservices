package corso.spring.ws.oxm.demo.jaxb.components;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;



public class ComponentXmlCD {

	@Autowired	
	@Getter
	private Marshaller marshaller;
	
	@Autowired
	@Getter
	private Unmarshaller unmarshaller;
	
	
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
