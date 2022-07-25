package entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	
	private String nome;
	private String email;
	private String cpf;
	private ArrayList<Pruu> pruus;
	private String nomePerfil;
		
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.nomePerfil = "@" + this.nome;
	}
	public void cadastrarUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("================================================");
		System.out.println("     PRUU SOCIAL NET - MENU ADMINISTRADOR       ");
		System.out.println("================================================");
		System.out.println("");
		System.out.print("*** Informe o nome do usuario: ");
		this.nome = input.nextLine();
		System.out.print("*** Informe o email do usuario: ");
		this.email = input.nextLine();
		System.out.print("*** Informe o CPF do usuario: ");
		this.cpf = input.nextLine();
		this.nomePerfil = "@" + this.nome;
		System.out.println("");
		System.out.println("   **** USUARIO INCLUIDO COM SUCESSO ***   ");
		System.out.println("");
		
	}
	
	public void editUser(Usuario user) {
		Scanner input = new Scanner(System.in);
		System.out.print("Confirme o nome do usuario: ");
		user.setNome(input.nextLine());
		System.out.println("Confirme o email do usuario: ");
		user.setEmail(input.nextLine());
		System.out.println("Confirme o CPF do usuario: ");
		user.setCpf(input.nextLine());
	}
	
	
	public void darLike(Pruu pruuParaCurtir) {
		pruuParaCurtir.adicionarLike();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Pruu> getPruus() {
		return pruus;
	}

	public void setPruus(ArrayList<Pruu> pruus) {
		this.pruus = pruus;
	}

	
	public String getNomePerfil() {
		return nomePerfil;
	}

	@Override
	public String toString() {
		return "Usuario: " + nomePerfil + "\nNome: " + nome + "\nE-mail: " + email + "\nCPF : " + cpf ;
	}

	

	
}
