package entidades;

public class Comentario {
	
	private String comentario;
	private Usuario usuario;
	
	
	public Comentario() {
	}


	public Comentario(String comentario, Usuario usuario) {
		this.comentario = comentario;
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return comentario + "\n" +
				"Comentado por: " + usuario.getNomePerfil();
	}
	
	
	
	

}
