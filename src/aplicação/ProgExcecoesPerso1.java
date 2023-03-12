package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;

public class ProgExcecoesPerso1 {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o número do Quarto: ");
		int n = sc.nextInt();
		System.out.print("Digite o Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Digite o Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		// data de checkOut deve ser posterior a checkIn
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro: A data de check-out deve ser posterior à data de check-in ");
		} 
		else {
			Reservas reserva = new Reservas(n, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.println("Entre com a data para atualizar à reserva ");
			System.out.print("Digite o Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Digite o Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			/*Se meu string retornar do metodo um valor diferente de null
			 * significa que tem um erro nele (versão ruim)
			 */
			String error = reserva.atualizaData(checkIn, checkOut);
			if (error != null) {
				System.out.println("Erro: " + error);
			}
			else {
			System.out.println("Reserva: " + reserva);
			}
		}
		sc.close();
	}

}
