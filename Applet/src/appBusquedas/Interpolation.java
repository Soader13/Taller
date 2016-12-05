package appBusquedas;

public class Interpolation
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
	public int interpolationSearch(int[] array,int data){
		int lower=0;
		int higher=array.length-1;
		int index=-1;
		int middle=0;
		while (true){
			if(lower>=higher ||array[lower]==array[higher])
			{
				break;
			}
			middle=lower+((higher-lower)/(array[higher]-array[lower])*(data-array[lower]));
			if(array[middle]==data)
			{
				index=middle;
				break; 
			}
			else
			{
				if(array[middle]<data)
				{
					lower=middle+1;
				}
				else
				{
					if(array[middle]>data)
					{
						higher=middle-1;
					}
				}
			}
		}
		return index;
	}  
}