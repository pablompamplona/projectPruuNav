package principalPombo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import entidades.Administrador;
import entidades.Pruu;
import entidades.Usuario;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int opMainMenu = 0, opAdminMenu = 0, opClientMenu = 0, opConfirmUserRemove = 0;
		int selecUserEdit = 0, selecUserRemove = 0, selecUserPost = 0, selecUserConsult = 0, selecUserCurtindo = 0;
		int selecPruuCurtido = 0, selecPruuBloq = 0, selecPruuDesbloq = 0;
		
		ArrayList<Pruu> pruusFeed = new ArrayList();
		ArrayList<Usuario> users = new ArrayList();
		
		Administrador admin = new Administrador("AdminUser","admin@admin","123456789");
		
		Usuario userJoao = new Usuario("Joazinho", "@joazinho", "123");
		Pruu pruuJoao1 = new Pruu("oi pessoal", userJoao);
		Pruu pruuJoao2 = new Pruu("to aqui enchendo o saco de novo!!!!!", userJoao);
		pruusFeed.add(pruuJoao1);
		pruusFeed.add(pruuJoao2);
		users.add(userJoao);
		
		Usuario userMaria = new Usuario("Mariazinha", "maria@maria", "987654321-00");
		Pruu pruuMaria1 = new Pruu("Teste... ah, era so escrever?", userMaria);
		Pruu pruuMaria2 = new Pruu("Agora foi gente!!!!! Boas Noites!!!!", userMaria);
		pruusFeed.add(pruuMaria1);
		pruusFeed.add(pruuMaria2);
		users.add(userMaria);
				
		userMaria.darLike(pruuJoao2);
		userMaria.darLike(pruuJoao2);
		
		userJoao.darLike(pruuMaria2);
		
		admin.bloquearPruu(pruuJoao1);
		
		do {
			System.out.println("================================================");
			System.out.println("       PRUU SOCIAL NET - MENU PRINCIPAL         ");
			System.out.println("================================================");
			System.out.println("");
			System.out.println("");
			System.out.println("  1  -  MENU ADMINISTRADOR");
			System.out.println("  2  -  MENU CLIENTE");
			System.out.println("  0  -  ENCERRAR SISTEMA");
			System.out.println("");
			System.out.println("");
			System.out.println("================================================");
			System.out.println("Selecione a opcao desejada: ");
			opMainMenu = input.nextInt();
			
			switch (opMainMenu) {
			case 1:
				System.out.println("================================================");
				System.out.println("     PRUU SOCIAL NET - MENU ADMINISTRADOR       ");
				System.out.println("================================================");
				System.out.println("");
				System.out.println("  1  -  INCLUIR USUARIO");
				System.out.println("  2  -  LISTAR USUARIOS");
				System.out.println("  3  -  EDITAR USUARIO");
				System.out.println("  4  -  EXCLUIR USUARIO");
				System.out.println("  5  -  BLOQUEAR PRUU");
				System.out.println("  6  -  DESBLOQUEAR PRUU");
				System.out.println("  9  -  RETORNAR AO MENU PRINCIPAL");
				System.out.println("");
				System.out.println("================================================");
				System.out.println("Selecione a opcao desejada: ");
				opAdminMenu = input.nextInt();
				input.nextLine();
				if (opAdminMenu == 9) {
					break;
				}
				
				switch (opAdminMenu) {
					case 1:
						Usuario user = new Usuario();
						user.cadastrarUser();
						users.add(user);
						break;
					
					case 2:
						System.out.println("================================================");
						System.out.println(" PRUU SOCIAL NET - MENU ADMIN - LISTA USUARIOS  ");
						System.out.println("================================================");
						System.out.println("");
						for (int i = 0; i < users.size(); i++) {
							System.out.println("");
							System.out.println("Usuario: " + users.get(i));
							System.out.println("");
							System.out.println("************************************************");
						}
						break;
					case 3:
						System.out.println("================================================");
						System.out.println("   PRUU SOCIAL NET - MENU ADMIN - EDIT USUARIO  ");
						System.out.println("================================================");
						System.out.println("");
						System.out.println("Selecione o usuario para editar os dados:");
						System.out.println("");
						for (int i = 0; i < users.size(); i++) {
							System.out.println("ID: " + i + " Nome: " + users.get(i).getNome());
							System.out.println("");
						}
						System.out.println("================================================");
						System.out.println("");
						System.out.println("Informe o ID do usuario selecionado: ");
						selecUserEdit = input.nextInt();
						user = users.get(selecUserEdit);
						user.editUser(users.get(selecUserEdit));
						break;
						
					case 4:
						System.out.println("================================================");
						System.out.println(" PRUU SOCIAL NET - MENU ADMIN - EXCLUIR USUARIO ");
						System.out.println("================================================");
						System.out.println("");
						System.out.println("Selecione o usuario para EXCLUIR:");
						System.out.println("");
						for (int i = 0; i < users.size(); i++) {
							System.out.println("ID: " + i + "Nome: " + users.get(i).getNome());
							System.out.println("");
							}
						System.out.println("================================================");
						System.out.println("");
						System.out.println("Informe o ID do usuario selecionado: ");
						selecUserRemove = input.nextInt();
						System.out.println(" ");
						System.out.println("*************************************************");
						System.out.println(" Tem certeza que deseja excluir o usuario " + users.get(selecUserRemove) + "? (1 - SIM / 2 - NAO)");
						opConfirmUserRemove = input.nextInt();
						if (opConfirmUserRemove == 1) {
							users.remove(selecUserRemove);
							System.out.println(" ");
							System.out.println("*************************************************");
							System.out.println("          USUARIO EXCLUIDO COM SUCESSO           ");
							System.out.println("*************************************************");
						} else {
							System.out.println("*************************************************");
							System.out.println("                OPERACAO CANCELADA               ");
							System.out.println("*************************************************");
						}
						break;
						
					case 5 :
						System.out.println("================================================");
						System.out.println("  PRUU SOCIAL NET - MENU ADMIN - BLOQUEAR PRUU  ");
						System.out.println("================================================");
						System.out.println("");
						System.out.println("Selecione qual Pruu deseja bloquear: ");
						System.out.println("");
						for (int i = 0; i < pruusFeed.size(); i++) {
							if(pruusFeed.get(i).isBloqueado() == false) {
								System.out.println("ID: " + i + pruusFeed.get(i));
							}
						}
						System.out.println("Informe o ID do pruu selecionado: ");
						selecPruuBloq = input.nextInt();
						admin.bloquearPruu(pruusFeed.get(selecPruuBloq));
						System.out.println("*************************************************");
						System.out.println("           PRUU BLOQUEADO COM SUCESSO            ");
						System.out.println("*************************************************");
						
						break;
						
					case 6:
						System.out.println("================================================");
						System.out.println("PRUU SOCIAL NET - MENU ADMIN - DESBLOQUEAR PRUU ");
						System.out.println("================================================");
						System.out.println("");
						System.out.println("Selecione qual Pruu deseja desbloquear: ");
						System.out.println("");
						for (int i = 0; i < pruusFeed.size(); i++) {
							if (pruusFeed.get(i).isBloqueado()) {
								System.out.println("ID: " + i + pruusFeed.get(i));
							}
						}
						System.out.println("Informe o ID do pruu selecionado: ");
						selecPruuDesbloq = input.nextInt();
						admin.desbloquearPruu(pruusFeed.get(selecPruuDesbloq));
						System.out.println("*************************************************");
						System.out.println("         PRUU DESBLOQUEADO COM SUCESSO           ");
						System.out.println("*************************************************");
						break;
											
				}
				break;
				
			case 2:
				System.out.println("================================================");
				System.out.println("         PRUU SOCIAL NET - MENU CLIENTE         ");
				System.out.println("================================================");
				System.out.println("");
				System.out.println("  1  -  INCLUIR PRUU");
				System.out.println("  2  -  LISTAR MEUS PRUUS");
				System.out.println("  3  -  LISTAR TODOS OS PRUUS");
				System.out.println("  4  -  CURTIR PRUUS");
				System.out.println("  9  -  RETORNAR AO MENU PRINCIPAL");
				System.out.println("");
				System.out.println("================================================");
				System.out.println("Selecione a opcao desejada: ");
				opClientMenu = input.nextInt();
				input.nextLine();
				if (opClientMenu == 9) {
					break;
				}
				switch (opClientMenu) {
					case 1:
						System.out.println("================================================");
						System.out.println(" PRUU SOCIAL NET - MENU CLIENTE - INCLUIR PRUU  ");
						System.out.println("================================================");
						System.out.println("");
						System.out.println(" Qual usuario esta postando? ");
						for (int i = 0; i < users.size(); i++) {
							System.out.println("ID: " + i + " - Usuario: " + users.get(i).getNomePerfil());
							System.out.println("");
							}
						System.out.println("================================================");
						System.out.println(" Informe o ID correspondente: ");
						selecUserPost = input.nextInt();
						Pruu pruu = new Pruu();
						pruu.incluirPruu();
						pruu.setUsuario(users.get(selecUserPost));
						pruusFeed.add(pruu);
						break;
						
					case 2:
						System.out.println("================================================");
						System.out.println("   PRUU SOCIAL NET - MENU CLIENTE - MEUS PRUUS  ");
						System.out.println("================================================");
						System.out.println("");
						System.out.println(" Qual usuario esta pesquisando? ");
						for (int i = 0; i < users.size(); i++) {
							System.out.println("ID: " + i + " - Usuario: " + users.get(i).getNomePerfil());
							System.out.println("");
							}
						System.out.println("================================================");
						System.out.println(" Informe o ID correspondente: ");
						selecUserConsult = input.nextInt();
						System.out.println("");
						System.out.println("  ****  PRUUS DO USER " + users.get(selecUserConsult).getNomePerfil() + "   ****    ");
						for (int i = 0; i < pruusFeed.size(); i++) {
							Usuario userAtual = pruusFeed.get(i).getUsuario();
							if (userAtual == users.get(selecUserConsult)) {
								System.out.println(pruusFeed.get(i));
							}
						}
						break;
						
					case 3:
						System.out.println("================================================");
						System.out.println("      PRUU SOCIAL NET    --      PRUUS FEED     ");
						System.out.println("================================================");
						System.out.println("");
						for (int i = 0; i < pruusFeed.size(); i++) {
							System.out.println("ID: " + i);
							System.out.println(pruusFeed.get(i));
							System.out.println(" ");
							System.out.println("************************************************");
						}
						break;
						
					case 4:
						System.out.println("================================================");
						System.out.println("          PRUU SOCIAL NET - CURTIR PRUUS        ");
						System.out.println("================================================");
						System.out.println("");
						System.out.println(" Qual usuario esta pesquisando? ");
						for (int i = 0; i < users.size(); i++) {
							System.out.println("ID: " + i + " - Usuario: " + users.get(i).getNomePerfil());
							System.out.println("");
							}
						System.out.println("================================================");
						System.out.println(" Informe o ID correspondente: ");
						selecUserCurtindo = input.nextInt();
						System.out.println("");
						for (int i = 0; i < pruusFeed.size(); i++) {
							Usuario userAtual = pruusFeed.get(i).getUsuario();
							if (userAtual != users.get(selecUserCurtindo)) {
								System.out.println("ID: " + i);
								System.out.println(pruusFeed.get(i));
								System.out.println(" ");
								System.out.println("************************************************");
							}
						}
						System.out.println("Digite o ID referente ao pruu que voce curtiu: ");
						selecPruuCurtido = input.nextInt();
						pruusFeed.get(selecPruuCurtido).adicionarLike();
						System.out.println("");
						System.out.println("  ******   PRUU CURTIDO COM SUCESSO   ******   ");
						break;
						
				}
			
			}
			
		} while (opMainMenu != 0);
	
	}
}
