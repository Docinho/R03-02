package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	public static void main(String[] args) {
		MergeSort<Integer> tst = new MergeSort<Integer>();
		Integer[] array = { 30, 28, 7, 29, 11, 26};
		tst.sort(array, 0, array.length -1);
		
	}


	public void sort(T[] array, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;

		if (leftIndex < rightIndex) {

			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);

		}

	}

	private void merge(T[] array, int inicio, int meio, int fim) {
		int i = inicio;
		int j = meio + 1;

		T[] aux = Arrays.copyOf(array, array.length);
		int k = inicio;

		while (i <= meio && j <= fim) {
			if (aux[i].compareTo(aux[j]) == -1) {
				array[k] = aux[i];
				i = i + 1;
			} else {
				array[k] = aux[j];
				j = j + 1;
			}

			k = k + 1;
		}
	
		while (i <= meio) {
			array[k] = aux[i];
			i = i + 1;
			k = k + 1;
		}

		while (j <= fim) {
			array[k] = aux[j];
			k = k + 1;
			j = j + 1;
		}
	}
}
