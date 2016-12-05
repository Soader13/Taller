package Applet1;
public class MergeSort {

	


		/**
		 * Zero-parameter constructor 
		 */
		
		
		
		/**
		 * Method for traditional Merge Sort 
		 * @param array
		 * @return ordered array 
		 */
		public int[] sort(int[] array)
		{
			if(array.length > 1) //Condition to end recursive: If array is of size equal to 1, no more calls are necessary
			{
				int n = array.length / 2; //Get half size of the array
				int[] array_left = new int[n]; //Create array of the left side of n size
				int[] array_right = new int[array.length - n]; //Create array of the right side 
				
				for(int i = 0; i < n; i++) //Copy first half of the array inside left array
					array_left[i] = array[i]; //Copy data
				
				for(int i = 0; i < array_right.length; i++) //Copy second half of the array inside right array
					array_right[i] = array[n + i]; //Copy data
				
				array_left = sort(array_left); //Call recursive to order array of left size
				array_right = sort(array_right); //Call recursive to order array of left size
				
				return merge(array_left, array_right); //Merge order arrays of both left and right size
			}
			else
			{
				return array; //Return array if his size is 1 
			}
		}

		
		/**
		 * This method merge both left and right arrays in an ordered way 
		 * @param array_left
		 * @param array_right
		 * @return ordered array base on both left and right array
		 */
		public int[] merge(int[] array_left, int[] array_right)
		{
			int[]temp = new int[array_left.length + array_right.length]; //Create array of complete size, i.e. size of left array plus size of right array
			int left = 0, right = 0, index = 0; //Index for: left array, right array, and temp array. All must start in zero.
			
			while(left < array_left.length && right < array_right.length) //While are still elements inside left array or right array, we can made comparisons
			{
				if(array_left[left] <= array_right[right]) //If element in left array is minor or equal to element in right array
				{
					temp[index] = array_left[left]; //Add element of left array
					left += 1; //Because we add an element of left array, index that control left array must increase
				}
				else
				{
					temp[index] = array_right[right]; //Add element of right array
					right += 1; //Because we add an element of right array, index that control right array must increase
				}
				
				index += 1; //Increase index of complete array
			}
			
			if(left < array_left.length) //If there are still element in left array
				for(int i = left; i < array_left.length; i++) //Add all elements of left array
				{
					temp[index] = array_left[left]; //Add element
					left += 1; //Increase index over left array
					index += 1; //Increase index over complete array
				}	
			else //If there are still element in left array
				for(int i = right; i < array_right.length; i++) //Add all elements of right array
				{
					temp[index] = array_right[right]; //Add element
					right += 1; //Increase index over right array
					index += 1;  //Increase index over complete array
				}	
			
			return temp; //Return complete array 
		}
		
		
		/**
		 * 
		 * @param numbers
		 * @param column
		 * @return
		 */
		public int[][] sortByColumn(int[][] numbers, int column)
		{
			if(numbers.length > 1)
			{
				int n = numbers.length / 2;
				int[][] array_left = new int[n][ numbers[0].length ];
				int[][] array_right = new int[numbers.length - n][ numbers[0].length ];
				
				for(int i = 0; i < n; i++)
				{
					array_left[i] = numbers[i];
				}
				
				for(int i = 0; i < array_right.length; i++)
				{
					array_right[i] = numbers[i + n];
				}
				
				array_left = sortByColumn(array_left, column);
				array_right = sortByColumn(array_right, column);
				
				return mergeByColumn(array_left, array_right, column);
			}
			else
			{
				return numbers;
			}
		}
		
		
		/**
		 * 
		 * @param array_left
		 * @param array_right
		 * @param column
		 * @return
		 */
		public static int[][] mergeByColumn(int[][] array_left, int[][] array_right, int column)
		{
			int[][] temp = new int[array_left.length + array_right.length][2];
			int left = 0, right = 0, index = 0;
			
			while(left < array_left.length && right < array_right.length)
			{
				if(array_left[left][column] <= array_right[right][column])
				{
					temp[index] = array_left[left];
					left += 1;
				}
				else
				{
					temp[index] = array_right[right];
					right += 1;
				}
						
				index += 1;
			}
			
			if(left < array_left.length)
				for(int i = left; i < array_left.length; i++)
				{
					temp[index] = array_left[i];
					index += 1;
				}
			else
				for(int i = right; i < array_right.length; i++)
				{
					temp[index] = array_right[i];
					index += 1;
				}
			
			return temp;
		}
	}