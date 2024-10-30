import static java.lang.Float.compare;
import static java.lang.Float.floatToIntBits;
import static java.lang.Math.sqrt;

/**
 * A classe {@code Triangle} representa um triângulo com três lados e oferece operações relacionadas
 * à validação, classificação e cálculo de propriedades geométricas. A classe é imutável e seus
 * atributos não podem ser alterados após a criação do objeto.
 *
 * <p>Esta classe permite:</p>
 * <ul>
 *     <li>Verificar se três valores formam um triângulo válido.</li>
 *     <li>Determinar o tipo do triângulo com base nos ângulos e nos lados.</li>
 *     <li>Calcular a área e o perímetro do triângulo.</li>
 * </ul>
 *
 * <p>A classe é {@code final} para garantir que não possa ser estendida, preservando a integridade do objeto.</p>
 */
public final class Triangle {

    private final float a;
    private final float b;
    private final float c;

    /**
     * Construtor que cria um triângulo a partir dos três lados fornecidos. Se os valores não formarem
     * um triângulo válido, uma exceção é lançada.
     *
     * @param a Lado A do triângulo.
     * @param b Lado B do triângulo.
     * @param c Lado C do triângulo.
     * @throws IllegalArgumentException Se os valores fornecidos não formarem um triângulo válido.
     */
    public Triangle(float a, float b, float c) {
        if (!isValidTriangle(a, b, c))
            throw new IllegalArgumentException("Não é um triângulo");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Verifica se três lados formam um triângulo válido.
     * A condição para ser um triângulo válido é que a soma de dois lados seja maior que o terceiro.
     *
     * @param a Lado A do triângulo.
     * @param b Lado B do triângulo.
     * @param c Lado C do triângulo.
     * @return {@code true} se os lados formam um triângulo válido, caso contrário {@code false}.
     */
    public boolean isValidTriangle(float a, float b, float c) {
        return a + b > c && a + c > b && b + c > a;
    }

    /**
     * Determina o tipo de triângulo com base nos ângulos internos.
     *
     * @param a Lado A do triângulo.
     * @param b Lado B do triângulo.
     * @param c Lado C do triângulo.
     * @return Uma string indicando o tipo de ângulo: "Retângulo", "Acutângulo", "Obtusângulo",
     * ou "Não é um triângulo" se for degenerado.
     */
    public String typeAngleTriangle(float a, float b, float c) {
        double cosA = (b * b + c * c - a * a) / (2.0 * b * c);
        double cosB = (a * a + c * c - b * b) / (2.0 * a * c);
        double cosC = (a * a + b * b - c * c) / (2.0 * a * b);

        double sinA = sqrt(1 - cosA * cosA);
        double sinB = sqrt(1 - cosB * cosB);
        double sinC = sqrt(1 - cosC * cosC);

        if (sinA == 0 || sinB == 0 || sinC == 0) return "Não é um triângulo";
        else if (cosA == 0 || cosB == 0 || cosC == 0) return "Retângulo";
        else if (cosA > 0 && cosB > 0 && cosC > 0) return "Acutângulo";
        else return "Obtusângulo";
    }

    /**
     * Determina o tipo de triângulo com base nos lados.
     *
     * @param a Lado A do triângulo.
     * @param b Lado B do triângulo.
     * @param c Lado C do triângulo.
     * @return "Equilátero", "Isósceles" ou "Escaleno" de acordo com os lados fornecidos.
     */
    public static String typeSideTriangle(float a, float b, float c) {
        if (a == b && b == c) return "Equilátero";
        else if (a == b || a == c || b == c) return "Isósceles";
        else return "Escaleno";
    }

    /**
     * Calcula a área do triângulo usando a fórmula de Heron.
     *
     * @param a Lado A do triângulo.
     * @param b Lado B do triângulo.
     * @param c Lado C do triângulo.
     * @return A área do triângulo.
     */
    public static float area(float a, float b, float c) {
        float s = (a + b + c) / 2.0f;
        return (float) sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Calcula o perímetro do triângulo.
     *
     * @param a Lado A do triângulo.
     * @param b Lado B do triângulo.
     * @param c Lado C do triângulo.
     * @return O perímetro do triângulo.
     */
    public static float perimeter(float a, float b, float c) {
        return a + b + c;
    }


    public float getA() {
        return a;
    }
    public float getB() {
        return b;
    }
    public float getC() {
        return c;
    }

    /**
     * Construtor de cópia que cria uma nova instância de {@code Triangle} com os mesmos lados.
     *
     * @param triangle Objeto {@code Triangle} a ser copiado.
     */
    public Triangle(Triangle triangle) {
        this(triangle.a, triangle.b, triangle.c);
    }

    /**
     * Cria uma cópia do objeto atual.
     *
     * @return Uma nova instância de {@code Triangle} com os mesmos valores.
     */
    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Triangle clone() {
        Triangle clone = null;
        try {
            clone = new Triangle(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    /**
     * Verifica se o objeto atual é igual a outro objeto.
     *
     * @param o Objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Triangle that = (Triangle) o;
        return compare(this.a, that.a) == 0 &&
               compare(this.b, that.b) == 0 &&
               compare(this.c, that.c) == 0;
    }

    /**
     * Calcula o código hash do objeto.
     *
     * @return O valor do código hash.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash = prime * hash + floatToIntBits(a);
        hash = prime * hash + floatToIntBits(b);
        hash = prime * hash + floatToIntBits(c);

        return (hash < 0) ? -hash : hash;
    }

    /**
     * Retorna uma representação em string do triângulo.
     *
     * @return String representando os lados do triângulo.
     */
    @Override
    public String toString() {
        return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
}
