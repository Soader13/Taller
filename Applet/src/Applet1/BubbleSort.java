package Applet1;

public class BubbleSort
{
	/*
	 * Este metodo organiza de menor a mayor un conjunto de numeros
	 * <b>pre:</b> Compara la posicion 0 con cada una de las otras posiciones preguntando siempre
	 * si el numero de la derecha es mayor al de la posicion actual, siendo esto cierto se cambiara la posicion
	 * de los dos numeros involucrados >br>
	 * <b>post:</b> Ya habiendo comparado posicion por posicion se obtiene el arreglo ordenado <br>
	 * @param vector arreglo
	 * @return vector arregloOrdenado
	 */
	public  int[] sort(int[] arreglo)
    {
      int auxiliar;
      int[] arregloOrdenado;
      for(int i = 1; i < arreglo.length; i++)
      {
        for(int j = 0; j < arreglo.length-i; j++)
        {
          if(arreglo[j] >= arreglo[j+1])
          {
            auxiliar = arreglo[j];
            arreglo[j] = arreglo[j+1];
            arreglo[j+1] = auxiliar;
          }   
        }
      }
      arregloOrdenado = arreglo;
      return arregloOrdenado;
    }
}
