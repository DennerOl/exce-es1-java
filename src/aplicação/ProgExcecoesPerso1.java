package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;
import model.excecoes.DomainException;

public class ProgExcecoesPerso1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/*
		 * bloco try iniciando a versão boa e bloco catch tratando as possiveis exceções
		 */
		try {
			System.out.print("Digite o número do Quarto: ");
			int n = sc.nextInt();
			System.out.print("Digite o Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Digite o Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			
			Reservas reserva = new Reservas(n, checkIn, checkOut);
			System.out.println();
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data para atualizar à reserva ");
			System.out.print("Digite o Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Digite o Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizaData(checkIn, checkOut);		
			System.out.println("Reserva: " + reserva);
		}
		
		catch(ParseException e) {
			System.out.println("Erro: Formato da data é invalido");
		}
		/*
		 * bloco catch capturando a exceção da classe Domain
		 */
		catch (DomainException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		catch (RuntimeException e ) {
			System.out.println("Erro inesperado ");
		}
		sc.close();
	}

}
