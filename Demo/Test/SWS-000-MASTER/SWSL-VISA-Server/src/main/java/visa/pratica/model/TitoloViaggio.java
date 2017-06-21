package visa.pratica.model;

import java.util.Date;

public class TitoloViaggio {
	private String numeroTitoloViaggio;
	private Date dataEmissioneTitoloViaggio;
	private Date dataScadenzaTitoloViaggio;
	private String validitaStatiSchengen;
	private String statoEmissione;
	
	// Getters and setters
	public String getNumeroTitoloViaggio() {
		return numeroTitoloViaggio;
	}
	public void setNumeroTitoloViaggio(String numeroTitoloViaggio) {
		this.numeroTitoloViaggio = numeroTitoloViaggio;
	}
	public Date getDataEmissioneTitoloViaggio() {
		return dataEmissioneTitoloViaggio;
	}
	public void setDataEmissioneTitoloViaggio(Date dataEmissioneTitoloViaggio) {
		this.dataEmissioneTitoloViaggio = dataEmissioneTitoloViaggio;
	}
	public Date getDataScadenzaTitoloViaggio() {
		return dataScadenzaTitoloViaggio;
	}
	public void setDataScadenzaTitoloViaggio(Date dataScadenzaTitoloViaggio) {
		this.dataScadenzaTitoloViaggio = dataScadenzaTitoloViaggio;
	}
	public String getValiditaStatiSchengen() {
		return validitaStatiSchengen;
	}
	public void setValiditaStatiSchengen(String validitaStatiSchengen) {
		this.validitaStatiSchengen = validitaStatiSchengen;
	}
	public String getStatoEmissione() {
		return statoEmissione;
	}
	public void setStatoEmissione(String statoEmissione) {
		this.statoEmissione = statoEmissione;
	}
}
