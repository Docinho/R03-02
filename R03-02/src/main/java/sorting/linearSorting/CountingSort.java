package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	public static void main(String[] args) {
		CountingSort tst = new CountingSort();
		Integer[] array = { 4, 9, 3, 4, 0, 5, 1, 4 };
		tst.sort(array, 0, array.length - 1);

	}

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length != 0) {
			int maiorElemento = encontraMaior(array, leftIndex, rightIndex);
			Integer[] aux = new Integer[maiorElemento + 1];
			Integer[] arrayFinal = new Integer[array.length];

			for (int i = 0; i < aux.length; i++) {
				aux[i] = 0;
			}
			for (int i = leftIndex; i <= rightIndex; i++) {
				aux[array[i]] = aux[array[i]] + 1;
			}

			for (int i = 1; i < aux.length; i++)
				aux[i] = aux[i] + aux[i - 1];

			int atual = 0;
			System.out.println(atual);
			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayFinal[aux[array[i]]-1] = array[i];
				aux[array[i]] = aux[array[i]] - 1;
			}
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayFinal[i];
			}
			System.out.println(Arrays.toString(array));
		}
	}

	private int encontraMaior(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] > maior)
				maior = array[i];
		}

		return maior;
	}

}
