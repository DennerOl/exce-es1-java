package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.DomainException;

public class Reservas {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	
	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut)  {
		if (!checkOut.after(checkIn)) {
			throw new DomainException ("Erro: A data de check-out deve ser posterior à data de check-in ");
		} 
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}


	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}


	public Date getCheckIn() {
		return checkIn;
	}

	/* 
	 * as datas só vão ser mudadas através de um metodo
	 * 
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	*/

	public Date getCheckOut() {
		return checkOut;
	}

/*
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	*/
	
	// metodo que aplica a diferença entre duas datas checkin e checkout
	
	public long duracao() {
		
		// gettime pega a diferença em milisegundos
		long dif = checkOut.getTime() - checkIn.getTime(); 		
		
		// convertendo o milisegundos  para dia 
		return TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS);
	}
	
	/*
	 * throws para tratar exceção personalizada da classe domain modo Exception 
	 * porque sou obrigado a trata-la. coloca  "throws DomainException"
	 * 
	 */
	public void atualizaData (Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
	// uso esta exceção quando os argumentos que passo para o metodo é invalido
			throw new DomainException ("Erro: As Datas devem ser futuras ");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException ("Erro: A data de check-out deve ser posterior à data de check-in ");
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// imprimir data no toString tenho que converter nesse formato acima
	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: "
				+ sdf.format(checkOut) + ", " + duracao()+ " Noites " ;
	}
	
}

