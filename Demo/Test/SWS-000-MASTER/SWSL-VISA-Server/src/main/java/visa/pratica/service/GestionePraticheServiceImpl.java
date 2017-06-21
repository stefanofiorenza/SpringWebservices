package visa.pratica.service;

import org.springframework.stereotype.Service;

import visa.pratica.model.Delivery;
import visa.pratica.model.Pratica;

@Service
public class GestionePraticheServiceImpl implements GestionePraticheService {

	@Override
	public Delivery esaminaPratica(Pratica pPratica) {
		Delivery lDeliveryRes = new Delivery();
		if (pPratica.getIdPratica().startsWith("00"))
		{
			lDeliveryRes.setEsitoDeliveryCodice(1024);
			lDeliveryRes.setEsitoDeliveryDescrizione("Success");
		}
		else
		{
			lDeliveryRes.setEsitoDeliveryCodice(303);
			lDeliveryRes.setEsitoDeliveryDescrizione("Codice pratica gia esistente");
		}
		lDeliveryRes.setRiferimentoPratica(pPratica.getIdPratica());

		return lDeliveryRes;
	}

}
