package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

   public static void main(String[] args) {
      ExtendedCountingSort tst = new ExtendedCountingSort();
      Integer[] array = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
      tst.sort(array, 0, array.length - 1);

   }

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {
      if (array.length != 0) {
         int menor = procuraMenor(array, leftIndex, rightIndex);
         int maior = procuraMaior(array, leftIndex, rightIndex);
         Integer[] aux = new Integer[maior - menor + 1];
         Integer[] arrayOrdenado = new Integer[rightIndex - leftIndex + 1];

         for (int i = 0; i < aux.length; i++)
            aux[i] = 0;

         for (int i = leftIndex; i <= rightIndex; i++)
            aux[array[i] - menor]++;

         for (int i = 1; i < aux.length; i++)
            aux[i] = aux[i] + aux[i - 1];

         for (int i = rightIndex; i >= leftIndex; i--) {
            arrayOrdenado[aux[array[i] - menor] - 1] = array[i];
            aux[array[i] - menor]--;
         }

         int i = rightIndex;
         int j = arrayOrdenado.length - 1;
         while (i >= leftIndex && j >= 0) {

            array[i] = arrayOrdenado[j];
            i--;
            j--;

         }
      }

   }

   private int procuraMaior(Integer[] array, int leftIndex, int rightIndex) {
      int maior = array[leftIndex];

      for (int i = leftIndex + 1; i <= rightIndex; i++)
         if (array[i] > maior)
            maior = array[i];

      return maior;
   }

   private int procuraMenor(Integer[] array, int leftIndex, int rightIndex) {
      int menor = array[leftIndex];

      for (int i = leftIndex + 1; i < rightIndex; i++)
         if (array[i] < menor)
            menor = array[i];

      return menor;
   }

}
