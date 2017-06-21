package visa.pratica.endpoints;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import visa.pratica.model.Delivery;
import visa.pratica.model.Pratica;
import visa.pratica.service.GestionePraticheService;
import visa.pratica.types.xml.app.DeliveryType;
import visa.pratica.types.xml.app.InvioPraticaRequest;
import visa.pratica.types.xml.app.InvioPraticaResponse;
import visa.pratica.types.xml.app.PraticaType;

@Endpoint
public class MinEsteriServiceEndpoint {

	public static final String PRATICA_REQUEST_LOCAL_NAME = "InvioPraticaRequest";
	public static final String PRATICA_RESPONSE_LOCAL_NAME = "InvioPraticaResponse";
	public static final String PRATICA_NAMESPACE_URI = "http://xml.types.pratica.visa/app";


	@Autowired
	private GestionePraticheService gestionePraticheService;

	@PayloadRoot(localPart = PRATICA_REQUEST_LOCAL_NAME, namespace = PRATICA_NAMESPACE_URI)
	@ResponsePayload
	public InvioPraticaResponse invioPraticaResponse(
			@RequestPayload InvioPraticaRequest request) {

		List<PraticaType> lPraticaList = request.getPratica();
		InvioPraticaResponse response = new InvioPraticaResponse();
		
		Iterator<PraticaType> iterator = lPraticaList.iterator(); 
		
		while (iterator.hasNext() ) {

			Pratica lPratica = xmlType2Bean((PraticaType) iterator.next());

			Delivery lDelivery = gestionePraticheService.esaminaPratica(lPratica);
			
			DeliveryType lDeliveryType = bean2XmlType(lDelivery);
			
			response.getDelivery().add(lDeliveryType);
		}

		return response;

	}

	private Pratica xmlType2Bean(PraticaType lPraticaType) {
		Pratica lPratica = new Pratica();
		lPratica.setIdPratica(lPraticaType.getIdPratica());
		return lPratica;
	}

	private DeliveryType bean2XmlType(Delivery lDelivery) {
		
		DeliveryType lDeliveryType = new DeliveryType();
		lDeliveryType
				.setEsitoDeliveryCodice(lDelivery.getEsitoDeliveryCodice());
		lDeliveryType.setEsitoDeliveryDescrizione(lDelivery
				.getEsitoDeliveryDescrizione());
		lDeliveryType.setRiferimentoPratica(lDelivery.getRiferimentoPratica());
		return lDeliveryType;
	}

	
}
