import inflect


def number_to_words(n: int) -> str:
    """Converte um número inteiro em sua representação por extenso em português.

    Args:
        n: O número inteiro a ser convertido.
        Deve estar entre 0 e 1 trilhão.

    Returns:
        A representação do número por extenso em português.

    Raises:
        ValueError: Se n não estiver dentro do intervalo permitido (0 a 1 trilhão).
    """
    if not 0 <= n <= 1000000000000:
        raise ValueError("O número deve estar entre 0 e 1.000.000.000.000")

    # Listas de unidades, dezenas, centenas, etc.
    unidades = ["", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"]
    teens = ["dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis",
             "dezessete", "dezoito", "dezenove"]
    dezenas = ["", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"]
    centenas = ["cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos",
                "oitocentos", "novecentos"]
    milhares = ["", "mil", "mil", "mil"]
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
            return teens[n - 10]
        elif n < 100:
            return dezenas[n // 10] + (" e " + to_words(n % 10) if n % 10 else "")
        elif n == 100:
            return centenas[0]  # "cem"
        elif n < 1000:
            return centenas[n // 100] + (" e " + to_words(n % 100) if n % 100 else "")  # "cento" para outros
        elif 1000 <= n < 2000:
            return milhares[1] + (" " + to_words(n % 1000) if n % 1000 else "")
        elif 2000 <= n < 1000000:
            return to_words(n // 1000) + " " + milhares[3] + (" " + to_words(n % 1000) if n % 1000 else "")
        elif n < 1000000000:
            return to_words(n // 1000000) + " " + (milhoes[2] if n // 1000000 > 1 else milhoes[1]) + (
                " e " + to_words(n % 1000000) if n % 1000000 else "")
        elif n < 1000000000000:
            return to_words(n // 1000000000) + " " + (bilhoes[2] if n // 1000000000 > 1 else bilhoes[1]) + (
                " e " + to_words(n % 1000000000) if n % 1000000000 else "")
        else:
            return to_words(n // 1000000000000) + " " + (trilhoes[2] if n // 1000000000000 > 1 else trilhoes[1])

    return to_words(n)


def convert_number_to_words(number):
    p = inflect.engine()
    return p.number_to_words(number)


def main():
    for i in range(1, 22342):
        number_in_words = number_to_words(i)
        print(f"{i} por extenso: {number_in_words}")

    # start = 1
    # end = 1000000 # 1 milhão
    #
    # for i in range(start, end + 1):
    #     number_in_words = convert_number_to_words(i)
    #     print(f"{i} por extenso: {number_in_words}")


if __name__ == "__main__":
    main()
