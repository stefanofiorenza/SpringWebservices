package corso.spring.ee.demo.ws.basic.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.oxm.Marshaller;

@Slf4j
public class LoggerUtil {

	private final static TransformerFactory tFactory = TransformerFactory.newInstance();
	

	
	public static void logSourceAsXmlString(Source source){
	    log.info( getSourceAsXmlString(source));		
	}
	
	public static String getSourceAsXmlString(Source source){
	
		String xml=null;
		try {
		    
		    StringWriter writer = new StringWriter();
		    StreamResult result = new StreamResult(writer);		    
		    Transformer transformer = tFactory.newTransformer();
		    transformer.transform(source,result);
		    xml= writer.toString();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
	
		return xml;
	}
	
}
