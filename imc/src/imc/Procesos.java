package imc;

import javax.swing.JOptionPane;

public class Procesos {

	String nombres[], telefono[], conclusion[];
	Double imc[];
	int n, i;
	
	
	public Procesos() {
		
		n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas a registrar"));
		nombres= new String[n];
		telefono = new String[n];
		conclusion = new String[n];
		imc = new Double[n];
		
		registrarDatos();
	}
	

	private void registrarDatos() {
		double peso, talla;
		
		for (i = 0; i < n; i++) {
			nombres[i]=JOptionPane.showInputDialog("Ingrese el nombre # " + (i+1));
			telefono[i]=JOptionPane.showInputDialog("Ingrese el telefono de " + nombres[i]);
			peso = validar("Ingrese el peso de " + nombres[i]);
			talla = validar("Ingrese la altura de " + nombres[i]);
			
			calcularImc(peso, talla);
		}
	}


	public double validar(String mensaje) {
		double dato;
		
		do {
			dato = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
		} while(dato <= 0);
		
		return dato;
	}
	
	
	private void calcularImc(double peso, double talla) {
		double imc1;
		
		imc1 = peso / Math.pow(talla, 2);
		imc[i] = imc1;
		
		conclusion(imc1);
	}

	private void conclusion(double imc1) {
		
		if(imc1 < 18) {
			conclusion[i] = ("Anorexia");
			
		} else if (imc1 >= 18 && imc1 < 20) {
			conclusion[i] = ("Delgadez");
			
		} else if (imc1 >= 20 && imc1 < 27) {
			conclusion[i] = ("Normalidad");
			
		} else if (imc1 >= 27 && imc1 < 30) {
			conclusion[i] = ("Obesidad(1)");
			
		} else if (imc1 >= 30 && imc1 < 35) {
			conclusion[i] = ("Obesidad(2)");
			
		} else if (imc1 >= 35 && imc1 < 40) {
			conclusion[i] = ("Obesidad(3)");
			
		} else if (imc1 >= 40) {
			conclusion[i] = ("Obesidad mórbida");
		}
		
		imprimir();
	}
	
	
	private void imprimir() {
		String resultado = "";
		
		resultado = "Datos de " + nombres[i] + "\n";
		resultado += "Nombre: " + nombres[i] + "\n";
		resultado += "tel: " + telefono[i] + "\n";
		resultado += "Conclusion: " + conclusion[i] + "\n";
		resultado += "Imc: " + imc[i] + "\n";
		
		JOptionPane.showMessageDialog(null, resultado);
	}
	
	}