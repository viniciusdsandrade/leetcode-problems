from typing import List
from time import perf_counter_ns


class Solution:
    """
    Gera todas as combinações possíveis de letras com base nos dígitos fornecidos.
    Cada dígito de '2' a '9' mapeia para um conjunto de letras, conforme mostrado em um teclado telefônico.
    O metodo usa uma abordagem de backtracking para explorar todas as possíveis combinações de letras.

    :param digits: Os dígitos fornecidos pelo usuário como uma string. Cada dígito deve estar entre '2' e '9'.
    :return: Uma lista de todas as combinações possíveis de letras.

    Exemplo:
    Se a entrada for "23", as combinações possíveis serão ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    """

    @staticmethod
    def letter_combinations(digits: str) -> List[str]:
        # Mapeia cada dígito de '2' a '9' para um conjunto de letras, conforme layout do teclado numérico de um telefone.
        phone_map = {
            '2': "abc",
            '3': "def",
            '4': "ghi",
            '5': "jkl",
            '6': "mno",
            '7': "pqrs",
            '8': "tuv",
            '9': "wxyz"
        }

        # Lista que armazenará todas as combinações possíveis de letras geradas a partir dos dígitos.
        combinations = []

        # Verifica se a entrada é nula ou vazia, caso seja, retorna uma lista vazia, pois não há combinações a gerar.
        if not digits:
            return combinations

        # Inicia o processo de backtracking para gerar as combinações. O índice começa em 0 e o caminho é inicialmente vazio.
        def backtrack(index: int, path: List[str]):
            # Condição de parada: quando o índice alcança o tamanho da string digits, significa que todas as letras foram combinadas.
            if index == len(digits):
                combinations.append("".join(path))  # Adiciona o caminho gerado até agora à lista de combinações.
                return

            # Obtém o dígito atual a ser processado com base no índice.
            digit = digits[index]
            # Recupera as letras associadas ao dígito atual do mapa.
            letters = phone_map[digit]

            # Itera sobre cada letra associada ao dígito atual.
            for letter in letters:
                path.append(letter)  # Adiciona a letra atual ao caminho em construção.
                backtrack(index + 1, path)  # Faz uma chamada recursiva para processar o próximo dígito.
                path.pop()  # Remove a última letra adicionada ao caminho para permitir a exploração de outras combinações.

        backtrack(0, [])  # Chama a função auxiliar com o índice inicial 0 e um caminho vazio.
        return combinations


# Função para testar as combinações e medir o tempo de execução com mais precisão
def test_letter_combination(digits: str, iterations: int = 1_000_000):
    print(f"\nInput: {digits}")

    # Realiza a medição repetida para maior precisão
    total_time = 0
    for _ in range(iterations):
        # Captura o tempo inicial usando time.perf_counter_ns()
        start = perf_counter_ns()

        # Chama a função para obter as combinações de letras
        Solution.letter_combinations(digits)

        # Captura o tempo final
        end = perf_counter_ns()

        # Calcula o tempo de execução e acumula
        total_time += (end - start)

    # Calcula o tempo médio por iteração
    average_runtime = total_time / iterations

    print(f"Output: {Solution.letter_combinations(digits)}")
    print(f"Average Runtime: {average_runtime:.2f} ns\n")


# Função principal para testar com diferentes entradas
if __name__ == "__main__":
    digits1 = "23"
    test_letter_combination(digits1)

    digits2 = ""
    test_letter_combination(digits2)

    digits3 = "2"
    test_letter_combination(digits3)
