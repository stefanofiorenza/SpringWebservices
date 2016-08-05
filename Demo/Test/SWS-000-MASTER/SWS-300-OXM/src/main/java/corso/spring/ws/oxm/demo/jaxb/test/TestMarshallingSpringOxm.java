package corso.spring.ws.oxm.demo.jaxb.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;

import javax.xml.transform.stream.StreamResult;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.XmlMappingException;


import corso.jaxb.demo.model.gen.Catalog;
import corso.jaxb.demo.model.gen.CdsType;
import corso.spring.ws.oxm.demo.jaxb.components.ComponentXmlCD;

public class TestMarshallingSpringOxm {


	public static final String PATH_XML_FILE="C:/Temp/cd.xml";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext contesto = new ClassPathXmlApplicationContext("ws-oxm.xml");
		ComponentXmlCD componentXmlCD =contesto.getBean("myComponentXmlCD",ComponentXmlCD.class);
		StringWriter out = new StringWriter();
		StreamResult result = new StreamResult(out);
		try {
			componentXmlCD.getMarshaller().marshal(getCatalog(),result);
			printResult(out);
		
		} catch (XmlMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void printResult(StringWriter resultString) throws IOException{
		
		System.out.println(resultString.toString());
		PrintWriter writer = new PrintWriter(PATH_XML_FILE);
		writer.print(resultString.toString());
		writer.close();
	}
	
	

public static Catalog getCatalog(){
		
		Catalog nuovoCatalogo = new Catalog();
		CdsType primoCd = new CdsType();
		primoCd.setArtist("Radiohead");
		primoCd.setTitle("The Bends");
		primoCd.setCompany("RCA");
		primoCd.setPrice(10.90);
		primoCd.setYear(new BigInteger("1998"));
		primoCd.setCountry("UK");
		primoCd.setQuantity(new BigInteger("12"));

		CdsType secondoCd = new CdsType();
		secondoCd.setArtist("The Beatles");
		secondoCd.setTitle("Abbey Road");
		secondoCd.setCompany("EMI");
		secondoCd.setPrice(12.90);
		secondoCd.setYear(new BigInteger("1968"));
		secondoCd.setCountry("UK");
		secondoCd.setQuantity(new BigInteger("34"));

		CdsType terzoCd = new CdsType();
		terzoCd.setArtist("Pink Floyd");
		terzoCd.setTitle("Atom Heart Mother");
		terzoCd.setCompany("EMI");
		terzoCd.setPrice(16.90);
		terzoCd.setYear(new BigInteger("1972"));
		terzoCd.setCountry("UK");
		terzoCd.setQuantity(new BigInteger("22"));

		nuovoCatalogo.getCd().add(primoCd);
		nuovoCatalogo.getCd().add(secondoCd);
		nuovoCatalogo.getCd().add(terzoCd);
		return nuovoCatalogo;
	}
}
