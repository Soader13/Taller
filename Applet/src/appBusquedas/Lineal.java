package appBusquedas;


public class Lineal
{
	/*
	 * Este metodo organiza de menor a mayor un conjunto de numeros
	 * <b>pre:</b> Compara la posicion 0 con cada una de las otras posiciones preguntando siempre
	 * si el numero de la derecha es mayor al de la posicion actual, siendo esto cierto se cambiara la posicion
	 * de los dos numeros involucrados >br>
	 * <b>post:</b> Ya habiendo comparado posicion por posicion se obtiene el arreglo ordenado <br>
	 * @param vector arreglo
	 * @return vector arreglo
	 */
	public int[] Ordenar (int[] arreglo) 
    {
        int auxiliar;
        int[] arregloOrdenado;
        for (int i = 1; i < arreglo.length; i++) 
        {
            for (int j = 0; j < arreglo.length - i; j++) 
            {
                if (arreglo[j] >= arreglo[j + 1])
                {
                    auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = auxiliar;
                }
            }
        }
        
        return arreglo;
    }
	
	/*
	 * Método que permite la busqueda de un numero
	 * <b>pre:</b>Determina inicio y fin y escoje la mitad 
	 * y pregunta si el dato de la mitad es igual al buscado, si esto es verdadero lo retorna
	 * <b>post:</b> si es falso el dato minimo mas 1 se vuelve el de la mitad y vuelve a realizar el mismo proceso
	 * 
	 * @param vector array  
	 * @param entero data
	 * @return entero index
	 */
    public int Buscar (int[] arreglo, int buscar)
    {
      int n = arreglo.length;
       for (int i = 0; i < n; i++)
        {
             if(arreglo[i]== buscar)
            {
              return i;
              
            }
        }
       return -1;
    }
}