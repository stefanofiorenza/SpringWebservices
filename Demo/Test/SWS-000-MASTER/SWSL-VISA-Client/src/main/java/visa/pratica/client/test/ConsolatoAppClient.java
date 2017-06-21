package visa.pratica.client.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.core.WebServiceTemplate;

import visa.pratica.client.mock.PraticaGenerator;
import visa.pratica.types.xml.app.DeliveryType;
import visa.pratica.types.xml.app.InvioPraticaRequest;
import visa.pratica.types.xml.app.InvioPraticaResponse;
import visa.pratica.types.xml.app.PraticaType;

@Slf4j
public class ConsolatoAppClient {

	public static void main(String[] args) {
		ApplicationContext contesto = new ClassPathXmlApplicationContext("ws-template-example.xml");
		WebServiceTemplate webServiceTemplate =contesto.getBean("myWsTemplate",WebServiceTemplate.class);
		sendJaxbObject(webServiceTemplate);		
	}

	
	private static void sendJaxbObject(WebServiceTemplate webServiceTemplate){
    	
    	PraticaType mock000 =PraticaGenerator.createPratica("0001989");
    	PraticaType mockError =PraticaGenerator.createPratica("CodErr");
    	
    	InvioPraticaRequest requestPayload = new InvioPraticaRequest();
    	requestPayload.getPratica().add(mock000);
    	requestPayload.getPratica().add(mockError);
    	
    	InvioPraticaResponse response = (InvioPraticaResponse) webServiceTemplate.marshalSendAndReceive(requestPayload);
       	logJaxbResponse(response);
    }

    private static void sendXmlDataFromFile(WebServiceTemplate webServiceTemplate) 
    		throws JAXBException, XmlMappingException, IOException {
		
    	StreamSource fileAsStream=new StreamSource(new File("dataXML", "RichiestePratiche.xml"));
		InvioPraticaRequest requestPayload = (InvioPraticaRequest) webServiceTemplate.getUnmarshaller().unmarshal(fileAsStream);
		
		InvioPraticaResponse response = (InvioPraticaResponse) webServiceTemplate.marshalSendAndReceive(requestPayload);  
		logJaxbResponse(response);

	}
    
    

    
    private static void logJaxbResponse(InvioPraticaResponse response){
    	List<DeliveryType> lDeliveryTypeList = response.getDelivery();
    	for (Iterator<DeliveryType> iterator = lDeliveryTypeList.iterator(); iterator.hasNext();) {
			DeliveryType lDeliveryType = (DeliveryType) iterator.next();

			log.info("\n***************Delivery*********************"+
					"\nPratica Codice:\t\t" + lDeliveryType.getRiferimentoPratica()+
					"\nCodice Esito:\t\t" + lDeliveryType.getEsitoDeliveryCodice()+
					"\nDescrizione:\t\t" + lDeliveryType.getEsitoDeliveryDescrizione());
		}
    }

}
