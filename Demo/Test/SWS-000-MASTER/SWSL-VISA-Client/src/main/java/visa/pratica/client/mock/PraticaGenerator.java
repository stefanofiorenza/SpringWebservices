package visa.pratica.client.mock;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import visa.pratica.types.xml.app.PraticaType;
import visa.pratica.types.xml.app.RichiedenteType;
import visa.pratica.types.xml.app.TitoloViaggioType;
import visa.pratica.types.xml.app.VistoType;

public class PraticaGenerator {

	public static PraticaType createPratica(String praticaId){
	  	
       	RichiedenteType richiedente= new RichiedenteType();
    	richiedente.setCognome("Ayaluck");
    	richiedente.setDataNascita(date2XmlGregCalendar(new Date(74,3,3)));
    	richiedente.setLuogoNascita("El Cairo");
    	richiedente.setNazionalita("Egiziana");
    	richiedente.setNome("Mohamed");
    	richiedente.setSesso("M");
    	richiedente.setStatoCivile("Celibe");
    	
    	TitoloViaggioType titoloViaggio= new TitoloViaggioType();
    	titoloViaggio.setDataEmissioneTitoloViaggio(date2XmlGregCalendar(new Date(117,5,17)));
    	titoloViaggio.setDataScadenzaTitoloViaggio(date2XmlGregCalendar(new Date(122,5,17)));
    	titoloViaggio.setNumeroTitoloViaggio("45345346754453");
    	titoloViaggio.setStatoEmissione("Egitto");
    	titoloViaggio.setValiditaStatiSchengen("NO");
    	
    	VistoType visto= new VistoType();
    	visto.setDataFineSoggiorno(date2XmlGregCalendar(new Date(117,6,17)));
    	visto.setDataInizioSoggiorno(date2XmlGregCalendar(new Date(117,6,29)));
    	visto.setDurataSoggiorno(12);
    	visto.setMotivazioneVisto("Turismo");
    	visto.setTipoVisto("VTL");
    	
		PraticaType lPraticaType = new PraticaType();
    	lPraticaType.setIdPratica(praticaId);
    	lPraticaType.setRichiedente(richiedente);
    	lPraticaType.setTitoloViaggio(titoloViaggio);
    	lPraticaType.setVisto(visto);
    	return lPraticaType;
	}
	
	
	
	public static XMLGregorianCalendar date2XmlGregCalendar(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		XMLGregorianCalendar xmlDate=null;
		try {
			xmlDate= DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			
		} catch (DatatypeConfigurationException e) {		
			e.printStackTrace();
		}
		return xmlDate;
	}
	
	
}
