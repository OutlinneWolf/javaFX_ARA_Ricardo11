package application;

public class Animes {
	private String Nome;
	private String Sinopse;
	private String Comentario;
	
	
	
	
	public Animes(String nome, String descrição, String comentario) {
		super();
		Nome = nome;
		Sinopse = descrição;
		Comentario = comentario;
	}
	
	
	public Animes(String nome) {
		super();
		Nome = nome;
	}


	public Animes(String nome, String descrição) {
		super();
		Nome = nome;
		Sinopse = descrição;
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
	
	public void setSinopse(String descrição) {
		Sinopse = descrição;
	}
	
	public String getComentario() {
		return Comentario;
	}
	
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	
	
}
