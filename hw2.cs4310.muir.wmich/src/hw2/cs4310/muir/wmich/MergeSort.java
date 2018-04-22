package hw2.cs4310.muir.wmich;

public class MergeSort {
	
	
    public static void cloneArray(Integer[] array){
        Integer[] arrayTemp = new Integer[array.length];
 
        // Clone into temp array
        for (int i = 0; i < arrayTemp.length; i++)
            arrayTemp[i] = array[i];
 
        //Sort
        sortArrays(arrayTemp, 0, array.length, array);
 
        for (int i = 0; i < arrayTemp.length; i++)
            array[i] = arrayTemp[i];
    }
 
    public static void sortArrays(Integer[] array, int lower, int upper, Integer[] finalArray){
        if (upper - lower < 2)
            return;
 
        //Split into thirds
        int firstThird = lower + ((upper - lower) / 3);
        int secondThird = lower + 2 * ((upper - lower) / 3) + 1;
 
        //Sort the arrays
        sortArrays(finalArray, lower, firstThird, array);
        sortArrays(finalArray, firstThird, secondThird, array);
        sortArrays(finalArray, secondThird, upper, array);
 
        //Merge sorted arrays
        mergeSort(finalArray, lower, firstThird, secondThird, upper, array);
    }
 
    public static void mergeSort(Integer[] array, int lower, int firstThird, int secondThird, int upper, Integer[] finalArray){
        int i = lower, j = firstThird, k = secondThird, l = lower;

        //get smallest of the 3 arrays
        while ((i < firstThird) && (j < secondThird) && (k < upper)){
            if (array[i].compareTo(array[j]) < 0){
                if (array[i].compareTo(array[k]) < 0)
                    finalArray[l++] = array[i++];
 
                else
                    finalArray[l++] = array[k++];
            }
            else
            {
                if (array[j].compareTo(array[k]) < 0)
                    finalArray[l++] = array[j++];
                else
                    finalArray[l++] = array[k++];
            }
        }
 
        //while first and second 3rds aren't empty
        while ((i < firstThird) && (j < secondThird)){
            if (array[i].compareTo(array[j]) < 0)
                finalArray[l++] = array[i++];
            else
                finalArray[l++] = array[j++];
        }
 
        //while second and third 3rds aren't empty
        while ((j < secondThird) && (k < upper)){
            if (array[j].compareTo(array[k]) < 0)
                finalArray[l++] = array[j++];
 
            else
                finalArray[l++] = array[k++];
        }
 
        //While first and third 3rds aren't empty
        while ((i < firstThird) && (k < upper)){
            if (array[i].compareTo(array[k]) < 0)
                finalArray[l++] = array[i++];
            else
                finalArray[l++] = array[k++];
        }
 
        //Load first 3rd into finalArray
        while (i < firstThird)
            finalArray[l++] = array[i++];
 
        //Load second 3rd into finalArray
        while (j < secondThird)
            finalArray[l++] = array[j++];
 
        //Load final 3rd into finalArray
        while (k < upper)
            finalArray[l++] = array[k++];
    }
}
