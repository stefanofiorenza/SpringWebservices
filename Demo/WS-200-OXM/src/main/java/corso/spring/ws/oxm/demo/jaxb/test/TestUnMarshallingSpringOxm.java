package corso.spring.ws.oxm.demo.jaxb.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.XmlMappingException;

import corso.jaxb.demo.model.gen.Catalog;
import corso.jaxb.demo.model.gen.CdsType;
import corso.spring.ws.oxm.demo.jaxb.components.ComponentXmlCD;

public class TestUnMarshallingSpringOxm {

	public static void main (String [] args){
		
		ApplicationContext contesto = new ClassPathXmlApplicationContext("corso/spring/ws/oxm/demo/jaxb/config/ws-oxm.xml");
		ComponentXmlCD componentXmlCD =contesto.getBean("myComponentXmlCD",ComponentXmlCD.class);
		StringWriter out = new StringWriter();
		StreamResult result = new StreamResult(out);
		Source source = new StreamSource(TestMarshallingSpringOxm.PATH_XML_FILE);
		try {
			Catalog catalogo =(Catalog)componentXmlCD.getUnmarshaller().unmarshal(source);
			for (CdsType cd : catalogo.getCds()){
				System.out.println("\nCD:"+cdsToString(cd));
			}
			
		} catch (XmlMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static String cdsToString(CdsType cd){
		
		StringBuffer sb= new StringBuffer();
		sb.append("\nartista :"+ cd.getArtist());
		sb.append("\ntitolo :"+ cd.getTitle());
		sb.append("\nanno :"+ cd.getYear());
		sb.append("\nprezzo :"+ cd.getPrice());
		sb.append("\npaese :"+ cd.getCountry());
		sb.append("\nquantita :"+ cd.getQuantity());
		
		return sb.toString();
		
	}

}
