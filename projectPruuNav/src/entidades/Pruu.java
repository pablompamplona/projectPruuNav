package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	
	public Pruu() {
		super();
		// TODO Auto-generated constructor stub
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
			
		} else {
			this.texto = "Pruu digitado fora dos parametros \nrequisitados pelo sistema, pruu descartado.";
			this.usuario = usuario;
			this.dataCriacao = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataFormatada = formatador.format(dataCriacao);
			this.dataFormatada = dataFormatada;
		}
				
	}
	//metodos
	public void incluirPruu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite sua mensagem: ");
		this.texto = input.nextLine();
		validarTexto(texto);
		if (textoValido == false) {
			System.out.println("***       Minimo 1 e maximo 300 caracteres      ***");
			System.out.println("***Texto fora dos parametros!!! Digite novamente***");
			
			
		} else {
		this.dataCriacao = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = formatador.format(dataCriacao);
		this.dataFormatada = dataFormatada;
		System.out.println("*****      POSTADO COM SUCESSO      *****");
		
		}
	
	}
	
	public boolean validarTexto(String texto) {
		if ((texto.length() > 300) || (texto.trim().length() < 1)) {
			textoValido = false;
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

	@Override
	public String toString() {
		if (bloqueado) {
			return "\nEsse pruu foi bloqueado por descumprir \nas normas do portal!!!" + "\nPostado em " + dataFormatada
					 + "\nPostado por: " + usuario.getNomePerfil() + "\n";
		} else {
			
		return "\nPruuuuuu: " + texto + "\nPostado em " + dataFormatada + "\n" + qtdLikes
				+ " curtidas" + "\nPostado por: " + usuario.getNomePerfil() + "\n";
		}
	}


	
	
}
