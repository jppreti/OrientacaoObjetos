package br.edu.ifmt.cba.java.enumerado;

public enum Currency {

	PENNY(1), NICKLE(2), DIME(10), QUARTER(25);
	
	public int value;
	
	private Currency(int value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		switch(this) {
		case PENNY:
			return "Penny (US$ 0,01)";
		case NICKLE:
			return "Nickle (US$ 0,05)";
		case DIME:
			return "Dime (US$ 0,10)";
		case QUARTER:
			return "Quarter (US$ 0,25)";
		}
		return super.toString();
	}
	
}
