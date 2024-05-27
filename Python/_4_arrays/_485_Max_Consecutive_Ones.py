from typing import List
import time


# 485. Max Consecutive Ones
# Given a binary array nums,
# return the maximum number of consecutive 1's in the array.
#
# Example 1:
# Input: nums = [1,1,0,1,1,1]
# Output: 3
# Explanation: The first two digits or the last three digits are consecutive
# 1s. The maximum number of consecutive 1s is 3.
#
# Example 2:
# Input: nums = [1,0,1,1,0,1]
# Output: 2
#
# Constraints:
# 1 <= nums.length <= 10^5
# nums[i] is either 0 or 1.


class Solution:
    @staticmethod
    def findMaxConsecutiveOnes(nums: List[int]) -> int:
        max_count = 0
        count = 0
        for i in nums:  # Itera sobre cada elemento 'i' na lista 'nums'
            if i == 1:  # Se o elemento atual 'i' for igual a 1:
                count += 1  # Incrementa a contagem atual de 1s consecutivos
            else:  # Caso contrário (o elemento atual 'i' não é 1):
                max_count = max(max_count, count)  # Atualiza 'max_count' se a contagem atual for maior
                count = 0  # Reinicia a contagem atual para 0
        return max(max_count, count)  # Retorna o maior valor entre 'max_count' e a contagem final

    # E se eu quisesse saber uma função que retorna a quantidade de vezes que um determinado valor se repete
    # consecutivamente e o valor desse numero
    # Exemplo: [1,1,1,2,3,4,5,5,5,5,5] -> 5, 5
    @staticmethod
    def findMaxConsecutiveOnes2(nums: List[int]) -> (int, int):
        # Se a lista 'nums' estiver vazia: Retorna 0 (contagem) e None (valor)
        if not nums: return 0, None

        max_count = 0  # Inicializa a contagem máxima de elementos consecutivos como 0
        count = 0  # Inicializa a contagem atual de elementos consecutivos como 0
        max_value = None  # Inicializa o valor com a maior repetição consecutiva como None
        value = None  # Inicializa o valor atual sendo verificado como None
        for i in nums:  # Itera sobre cada elemento 'i' na lista 'nums'
            if i == value:  # Se o elemento atual 'i' for igual ao valor atual:
                count += 1  # Incrementa a contagem atual de elementos consecutivos
            else:  # Caso contrário (o elemento atual 'i' é diferente do valor atual):
                if count > max_count:  # Se a contagem atual for maior que a contagem máxima:
                    max_count = count  # Atualiza a contagem máxima
                    max_value = value  # Atualiza o valor com a maior repetição consecutiva
                count = 1  # Reinicia a contagem atual para 1 (pois 'i' é um novo valor)
                value = i  # Define o valor atual como o elemento 'i'
        if count > max_count:  # Verifica novamente após o loop, para o caso do último elemento ser parte da sequência máxima
            max_count = count
            max_value = value
        return max_count, max_value  # Retorna a contagem máxima e o valor com essa repetição


def testFindMaxConsecutiveOnes(nums: List[int]) -> int:
    print("Input: ", nums)

    start_time_1 = time.perf_counter_ns()
    result = Solution.findMaxConsecutiveOnes(nums)
    end_time_1 = time.perf_counter_ns()

    print("result: ", result)
    print(f"Runtime_1:  {end_time_1 - start_time_1}ns")


def testFindMaxConsecutiveOnes2(nums: List[int]) -> (int, int):
    print("Input: ", nums)

    start_time_1 = time.perf_counter_ns()
    result = Solution.findMaxConsecutiveOnes2(nums)
    end_time_1 = time.perf_counter_ns()

    print("Repeticoes:  ", result[0])
    print("Valor:       ", result[1])
    print(f"Runtime_1:  {end_time_1 - start_time_1}ns")


def main():
    list_1 = [1, 1, 0, 1, 1, 1]
    list_2 = [1, 0, 1, 1, 0, 1]

    testFindMaxConsecutiveOnes(list_1)
    testFindMaxConsecutiveOnes(list_2)

    list_3 = [1, 1, 1, 2, 3, 4, 5, 5, 5, 5, 5]
    testFindMaxConsecutiveOnes2(list_3)
    list_4 = [1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6]
    testFindMaxConsecutiveOnes2(list_4)
    list_5 = [6, 6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1]
    testFindMaxConsecutiveOnes2(list_5)


if __name__ == '__main__':
    main()
