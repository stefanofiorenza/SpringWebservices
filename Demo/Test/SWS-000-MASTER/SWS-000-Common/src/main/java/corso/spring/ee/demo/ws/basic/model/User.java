package corso.spring.ee.demo.ws.basic.model;



public class User {

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	@Override
	public String toString() {
		return "User [cognome=" + cognome + ", email=" + email + ", id=" + id
				+ ", nome=" + nome + ", telefono=" + telefono + "]";
	}


	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String telefono;
 
}

