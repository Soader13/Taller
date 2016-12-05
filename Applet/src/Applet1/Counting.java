package Applet1;

public class Counting 
{
	
	
	
	/*
	 * Este metodo organiza de menor a mayor un conjunto de numeros
	 * <b>pre:</b> Evalua cual es el numero minimo y cual es el numero maximo del conjunto de números.
	 * Crea un vertor con el tamaño del conjunto de números en el cual se va contando la cantidad de números
	 * repetidos>br>
	 * <b>post:</b> Se recorre el vector para ser organizado <br>
	 * @param vector arreglo_inicial
	 * @return arreglo_inicial
	 */
	
	public  int [] Sort(int[]arreglo_inicial)
        {
		int tamano = arreglo_inicial.length,maximo = 0,indice = 0;
		for(int i = 0; i < tamano; i++)
                {
			maximo = arreglo_inicial[i] > maximo ? arreglo_inicial[i] : maximo;
		}
		int[] aux = new int[maximo + 1];
		for(int i = 0; i < tamano; i++)
                {
			aux[arreglo_inicial[i]] += 1;
		}
		for(int i = 0; i <= maximo; i++)
                {
			for(int j = 0; j < aux[i]; j++)
                        {
				arreglo_inicial[indice] = i;
				indice++;
			}
		}
		return arreglo_inicial;
	}
}