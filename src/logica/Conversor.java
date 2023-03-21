package logica;

public class Conversor {
	
	
	private double dolar = 1;
	private double peso = 0.0049;
	private double euro = 1.07;
	
	
	
	public double getDolar() {
		return dolar;
	}

	public double getPeso() {
		return peso;
	}

	public double getEuro() {
		return euro;
	}


	public double convertir (double input, double origen, double destino) {
		double cambio = input * origen / destino;
		return cambio;
	}

}
