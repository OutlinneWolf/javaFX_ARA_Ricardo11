package application;

public class Animes {
	private String Nome;
	private String Sinopse;
	private String Comentario;
	
	
	
	
	public Animes(String nome, String descri��o, String comentario) {
		super();
		Nome = nome;
		Sinopse = descri��o;
		Comentario = comentario;
	}
	
	
	public Animes(String nome) {
		super();
		Nome = nome;
	}


	public Animes(String nome, String descri��o) {
		super();
		Nome = nome;
		Sinopse = descri��o;
	}


	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getSinopse() {
		return Sinopse;
	}
	
	public void setSinopse(String descri��o) {
		Sinopse = descri��o;
	}
	
	public String getComentario() {
		return Comentario;
	}
	
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	
	
}
