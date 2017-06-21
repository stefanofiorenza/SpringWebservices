package visa.pratica.client.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import visa.pratica.types.xml.app.DeliveryType;
import visa.pratica.types.xml.app.InvioPraticaRequest;
import visa.pratica.types.xml.app.InvioPraticaResponse;

public class ConsolatoAppClientRaw {

	public static void main(String[] args) throws Exception {
		ApplicationContext contesto = new ClassPathXmlApplicationContext("ws-template-example.xml");
		WebServiceTemplate webServiceTemplate =contesto.getBean("myWsTemplate",WebServiceTemplate.class);
		sendXmlObject(webServiceTemplate);
	}

	private static void sendXmlObject(WebServiceTemplate webServiceTemplate) throws JAXBException {
		File file = new File("dataXML", "RichiestePratiche.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(InvioPraticaRequest.class);
		Unmarshaller lUnmarshaller = jaxbContext.createUnmarshaller();
		InvioPraticaRequest requestPayload = (InvioPraticaRequest) lUnmarshaller.unmarshal(file);

		InvioPraticaResponse response = (InvioPraticaResponse) webServiceTemplate.marshalSendAndReceive(requestPayload);
    	System.out.println("Ricevuto: "+response);
    	printJaxbObject(response);

	}

    private static void printJaxbObject(InvioPraticaResponse response){
    	List<DeliveryType> lDeliveryTypeList = response.getDelivery();
    	
    	System.out.println("INIZIO ANALISI PRATICHE");
    	System.out.println("Pratiche da esaminare: " + lDeliveryTypeList.size());
    	for (Iterator<DeliveryType> iterator = lDeliveryTypeList.iterator(); iterator.hasNext();) {
			DeliveryType lDeliveryType = (DeliveryType) iterator.next();

			System.out.println("==================================================================");
			System.out.println("Pratica:            " + lDeliveryType.getRiferimentoPratica());
			System.out.println("Codice errore:      " + lDeliveryType.getEsitoDeliveryCodice());
			System.out.println("Descrizione errore: " + lDeliveryType.getEsitoDeliveryDescrizione());
		}
		System.out.println("==================================================================");
    	System.out.println("FINE ANALISI PRATICHE");
    }

}
