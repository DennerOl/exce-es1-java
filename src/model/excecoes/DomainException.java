package model.excecoes;

public class DomainException extends RuntimeException  {
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
		/* modo Runtime não obriga eu tratar as exceções
		 * 
		 */
	}
	
}
