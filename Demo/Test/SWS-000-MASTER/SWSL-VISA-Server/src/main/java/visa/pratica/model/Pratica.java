package visa.pratica.model;

public class Pratica {
	private String idPratica;
	private Richiedente richiedente;
	private TitoloViaggio titoloViaggio;
	private Visto visto;
	
	// Getters and setters
	public String getIdPratica() {
		return idPratica;
	}
	public void setIdPratica(String idPratica) {
		this.idPratica = idPratica;
	}
	public Richiedente getRichiedente() {
		return richiedente;
	}
	public void setRichiedente(Richiedente richiedente) {
		this.richiedente = richiedente;
	}
	public TitoloViaggio getTitoloViaggio() {
		return titoloViaggio;
	}
	public void setTitoloViaggio(TitoloViaggio titoloViaggio) {
		this.titoloViaggio = titoloViaggio;
	}
	public Visto getVisto() {
		return visto;
	}
	public void setVisto(Visto visto) {
		this.visto = visto;
	}
}
