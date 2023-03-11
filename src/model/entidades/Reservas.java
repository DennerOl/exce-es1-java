package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	
	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) {
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
	
	public void atualizaData (Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// imprimir data no toString tenho que converter nesse formato acima
	@Override
	public String toString() {
		return "Quarto" + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: "
				+ sdf.format(checkOut) + ", " + duracao()+ "Noites " ;
	}
	
}

