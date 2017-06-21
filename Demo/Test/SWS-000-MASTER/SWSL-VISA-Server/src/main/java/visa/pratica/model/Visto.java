package visa.pratica.model;

import java.util.Date;

public class Visto {
	private String tipoVisto;
	private String motivazioneVisto;
	private int durataSoggiorno;
	private Date dataInizioSoggiorno;
	private Date dataFineSoggiorno;
	
	
	public String getTipoVisto() {
		return tipoVisto;
	}
	public void setTipoVisto(String tipoVisto) {
		this.tipoVisto = tipoVisto;
	}
	public String getMotivazioneVisto() {
		return motivazioneVisto;
	}
	public void setMotivazioneVisto(String motivazioneVisto) {
		this.motivazioneVisto = motivazioneVisto;
	}
	public int getDurataSoggiorno() {
		return durataSoggiorno;
	}
	public void setDurataSoggiorno(int durataSoggiorno) {
		this.durataSoggiorno = durataSoggiorno;
	}
	public Date getDataInizioSoggiorno() {
		return dataInizioSoggiorno;
	}
	public void setDataInizioSoggiorno(Date dataInizioSoggiorno) {
		this.dataInizioSoggiorno = dataInizioSoggiorno;
	}
	public Date getDataFineSoggiorno() {
		return dataFineSoggiorno;
	}
	public void setDataFineSoggiorno(Date dataFineSoggiorno) {
		this.dataFineSoggiorno = dataFineSoggiorno;
	}
	
	
}
