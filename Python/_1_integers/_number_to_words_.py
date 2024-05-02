import inflect


def number_to_words(n: int) -> None:
    """Imprime os números de 0 até n (inclusive) por extenso em português.

    Args:
        n: O número inteiro limite (inclusive) até o qual os números serão impressos por extenso.
           Deve estar entre 0 e 1.000.000.000.000 (1 trilhão).

    Raises:
        ValueError: Se n não estiver dentro do intervalo permitido (0 a 1 trilhão).
    """
    if not 0 <= n <= 1000000000000:
        raise ValueError("O número deve estar entre 0 e 1.000.000.000.000")

    # Listas de unidades, dezenas, centenas, milhares, milhões, bilhões e trilhões
    unidades = ["", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"]
    dezenas = ["", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"]
    centenas = ["", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos",
                "oitocentos", "novecentos"]
    milhares = ["", "mil", "milhão", "milhões"]
    milhoes = ["", "milhão", "milhões"]
    bilhoes = ["", "bilhão", "bilhões"]
    trilhoes = ["", "trilhão", "trilhões"]

    def to_words(n: int) -> str:
        """Função auxiliar recursiva para converter partes do número em palavras."""
        if n == 0:
            return ""
        elif n < 10:
            return unidades[n]
        elif n < 20:
            return dezenas[n // 10] + (" e " + to_words(n % 10) if n % 10 else "")
        elif n < 100:
            return dezenas[n // 10] + (" e " + to_words(n % 10) if n % 10 else "")
        elif n < 1000:
            return centenas[n // 100] + (" e " + to_words(n % 100) if n % 100 else "")
        elif n < 1000000:
            return to_words(n // 1000) + " " + (milhares[3] if n // 1000 > 1 else milhares[1]) + (
                " e " + to_words(n % 1000) if n % 1000 else "")
        elif n < 1000000000:
            return to_words(n // 1000000) + " " + (milhoes[2] if n // 1000000 > 1 else milhoes[1]) + (
                " e " + to_words(n % 1000000) if n % 1000000 else "")
        elif n < 1000000000000:
            return to_words(n // 1000000000) + " " + (bilhoes[2] if n // 1000000000 > 1 else bilhoes[1]) + (
                " e " + to_words(n % 1000000000) if n % 1000000000 else "")
        else:
            return to_words(n // 1000000000000) + " " + (trilhoes[2] if n // 1000000000000 > 1 else trilhoes[1])

            # Loop de 0 até n (inclusive)

    for i in range(n + 1):
        print(f"{i}: {to_words(i)}")


def convert_number_to_words(number):
    p = inflect.engine()
    return p.number_to_words(number)


def main():
    start = 1
    end = 1000000  # 1 milhão

    for i in range(start, end + 1):
        number_in_words = convert_number_to_words(i)
        print(f"{i} por extenso: {number_in_words}")

    # number_to_words(999999999999)  # Exemplo de uso: até 999 bilhões 999 milhões 999 mil 999


if __name__ == "__main__":
    main()
