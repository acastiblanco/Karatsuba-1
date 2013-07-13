package karatsuba;

import java.math.BigInteger;

public class KaratsubaAlgoritmo {
	
	private BigInteger resultadoOperacion;
	
	/**
	 * M�todo constructor
	 */
	public KaratsubaAlgoritmo(){
	}
	
	/**
	 * M�todo que multiplica los enteros recibidos con el
	 * algoritmo de Karatsuba
	 * 
	 * @param x
	 * @param y
	 */
	public void multiplicar(BigInteger x, BigInteger y) {
		resultadoOperacion = karatsuba(x, y);
	}
	
	/**
	 * M�todo que realiza la multiplicaci�n de Karatsuba 
	 * Nota: Basado en el pseudoc�digo presentado en http://en.wikipedia.org/wiki/Karatsuba_algorithm
	 * 
	 * @param x
	 * @param y
	 * @return El resultado de la multiplicaci�n de x y y
	 */
	public BigInteger karatsuba(BigInteger x, BigInteger y){
		//Si alguno de los valores es inferior a 10 se usa
		//la multiplicaci�n normal
		if(x.compareTo(BigInteger.TEN) < 0
				|| y.compareTo(BigInteger.TEN) < 0){
			return x.multiply(y);
		}
		
		//Se obtiene el n�mero de digitos mayor entre los dos n�meros
		int m = Math.max(x.toString().length(), y.toString().length());
		//El mayor n�mero de digitos se divide en 2
		m = (int) Math.round(m / 2.0);
		
		//Control de n�meros con tama�os diferentes
		if(m >= y.toString().length()
				|| m >= x.toString().length()){
			//Si el valor de m es superior o igual a la cantidad de
			//d�gitos del n�mero m�s peque�o en tama�o, se vuelve
			//a calcular con relaci�n a dicho tama�o
			m = Math.min(x.toString().length(), y.toString().length());
			m = (int) Math.round(m / 2.0);
		}
		
		//Se obtienen los valores de las variables x0, x1, y0, y1
		BigInteger x0;
		BigInteger x1;
		BigInteger y0;
		BigInteger y1;
		
		String stringX0 = ""; 
		String stringY0 = ""; 
		String stringX1 = ""; 
		String stringY1 = "";
		
		if(x.toString().length() >= 3 && y.toString().length() >= 3){
			//Si el tama�o de alguno de los n�meros es superior o
			//igual a 3 se obtienen las cifras de cada n�mero
			int contador = 0;
			do {
				//Se obtienen las diferentes partes del primer n�mero
				int digitoX = x.mod(BigInteger.TEN).intValue();
				x = x.divide(BigInteger.TEN);
				if(contador < m)
					stringX0 = digitoX + stringX0;
				else
					stringX1 = digitoX + stringX1;
				contador++;
			} while (x.compareTo(BigInteger.ZERO) > 0);
			
			contador = 0;
			do {
				//Se obtienen las partes del segundo n�mero
				int digitoY = y.mod(BigInteger.TEN).intValue();
				y = y.divide(BigInteger.TEN);
				if(contador < m)
					stringY0 = digitoY + stringY0;
				else
					stringY1 = digitoY + stringY1;
				contador++;
			} while (y.compareTo(BigInteger.ZERO) > 0);
			
			//Las partes obtenidas se asignan a sus respectivas variables
			x0 = new BigInteger(stringX0);
			x1 = new BigInteger(stringX1);
			y0 = new BigInteger(stringY0);
			y1 = new BigInteger(stringY1);
		}else{
			//Se ninguno de los n�mero est� conformado por m�s
			//de 3 d�gitos entonces se realiza una multiplicaci�n normal
			return x.multiply(y);
		}
		
		//Se inicia el c�lculo de las variables Z
		BigInteger z0;
		BigInteger z1;
		BigInteger z2;
		if(x.toString().length() >= 4 
				|| y.toString().length() >= 4){
			//Se realizan las tres multiplicaciones de forma
			//recursiva s�lo para numeros iguales o superiores
			//a 4 d�gitos
			
			//z0 = x0y0 --->
			z0 = karatsuba(x0, y0);
			//z2 = x1y1 --->
			z2 = karatsuba(x1, y1); 
			//z1 = (x1 + x0)(y1 + y0) - z2 - z0
			z1 = karatsuba(x0.add(x1), y0.add(y1));//(x1 + x0)(y1 + y0)
		}else{
			//Si ninguno de los n�meros supera 3 d�gitos se realiza
			//la multiplicaci�n para cada variable Z sin usar recursividad
			z0 = x0.multiply(y0);
			z2 = x1.multiply(y1);
			z1 = (x0.add(x1)).multiply(y0.add(y1));
		}
		
		//Se completa el c�lculo de la variable z1
		z1 = z1.subtract(z2).subtract(z0);//(x1 + x0)(y1 + y0) - z2 - z0
		
		//xy = z2B^2m + z1B^m + z0
		BigInteger parteZ2 = z2.multiply(BigInteger.TEN.pow(m * 2));//z2B^2m
		BigInteger parteZ1 = z1.multiply(BigInteger.TEN.pow(m));//z1B^m
		BigInteger parteZ0 = z0;//z0
		
		//Se suman las variables Z para completar la multiplicaci�n
		return parteZ2.add(parteZ1.add(parteZ0));//z2B^2m + z1B^m + z0
	}

	//---------------- ---------------- ----------------
    //M�todos GET y SET de los atributos de la clase
    //---------------- ---------------- ----------------

	public BigInteger getResultadoOperacion() {
		return resultadoOperacion;
	}

	public void setResultadoOperacion(BigInteger resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}	

}
