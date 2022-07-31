package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pruu {

	private static int id;
	private int idPruu;
	private String texto;
	private Date dataCriacao;
	private String dataFormatada;
	private int qtdLikes;
	private boolean bloqueado;
	private Usuario usuario;
	private boolean textoValido = true;
	private ArrayList <Comentario> comentarios = new ArrayList();
	
	
	public Pruu() {
		super();
	}
	
	
	public Pruu(String texto, Usuario usuario) {
		super();
		validarTexto(texto);
		if (textoValido) {
			this.texto = texto;
			this.usuario = usuario;
			this.dataCriacao = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataFormatada = formatador.format(dataCriacao);
			this.dataFormatada = dataFormatada;
			Pruu.id++;
			idPruu = Pruu.id;
		}
	}
	
	//metodos
	public void incluirPruu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite sua mensagem: ");
		this.texto = input.nextLine();
		validarTexto(texto);
		if (textoValido) {
			this.dataCriacao = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataFormatada = formatador.format(dataCriacao);
			this.dataFormatada = dataFormatada;
			System.out.println("*****      POSTADO COM SUCESSO      *****");
			Pruu.id++;
			idPruu = Pruu.id;
		} else {
			do {
				System.out.println("***       Minimo 1 e maximo 300 caracteres      ***");
				System.out.println("***Texto fora dos parametros!!! Digite novamente***");
				System.out.println("Digite sua mensagem: ");
				texto = input.nextLine();
				validarTexto(texto);
			} while (textoValido == false);
			this.dataCriacao = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataFormatada = formatador.format(dataCriacao);
			this.dataFormatada = dataFormatada;
			System.out.println("*****      POSTADO COM SUCESSO      *****");
			Pruu.id++;
			idPruu = Pruu.id;
		}
	}
	
	public void incluirComentario(String texto, Usuario usuario) {
		Comentario comentario = new Comentario(texto, usuario);
		comentarios.add(comentario);
	}
	
	public boolean validarTexto(String texto) {
		if ((texto.length() > 300) || (texto.trim().length() < 1)) {
			textoValido = false;
		} else {
			textoValido = true;
		}
		return textoValido;
	}
	
	public void adicionarLike() {
		this.qtdLikes++;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public int getId() {
		return id;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public int getQtdLikes() {
		return qtdLikes;
	}
	
	public boolean isBloqueado() {
		return bloqueado;
	}
	
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}


	public boolean isTextoValido() {
		return textoValido;
	}

	public void setTextoValido(boolean textoValido) {
		this.textoValido = textoValido;
	}

	public int getIdPruu() {
		return idPruu;
	}


	public void setIdPruu(int idPruu) {
		this.idPruu = idPruu;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	@Override
	public String toString() {
		if (bloqueado) {
			return "\n" +
					"ID: " + idPruu + 
					"\n" +
					"\nEsse pruu foi bloqueado por descumprir \nas normas do portal!!!" + 
					"\nPostado em " + dataFormatada + 
					"\nPostado por: " + usuario.getNomePerfil() + 
					"\n";
		} else {
			
		return "\n" +
				"ID: " + idPruu + 
				"\n" +
				"\nPruuuuuu: " + texto + 
				"\nPostado em " + dataFormatada + 
				"\n" + qtdLikes + " curtidas" + 
				"\nPostado por: " + usuario.getNomePerfil() + 
				"\n" +
				"\n" +
				"---- Comentarios -----" + "\n" +
				"\n" +
				comentarios + "\n" +
				"\n";
			
		}
	}


	
	
}
