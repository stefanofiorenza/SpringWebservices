package visa.pratica.model;

public class Delivery {
	private String riferimentoPratica;
	private int esitoDeliveryCodice;
	private String esitoDeliveryDescrizione;
	
	// Getters and setters
	public String getRiferimentoPratica() {
		return riferimentoPratica;
	}
	public void setRiferimentoPratica(String riferimentoPratica) {
		this.riferimentoPratica = riferimentoPratica;
	}
	public int getEsitoDeliveryCodice() {
		return esitoDeliveryCodice;
	}
	public void setEsitoDeliveryCodice(int esitoDeliveryCodice) {
		this.esitoDeliveryCodice = esitoDeliveryCodice;
	}
	public String getEsitoDeliveryDescrizione() {
		return esitoDeliveryDescrizione;
	}
	public void setEsitoDeliveryDescrizione(String esitoDeliveryDescrizione) {
		this.esitoDeliveryDescrizione = esitoDeliveryDescrizione;
	}

}
