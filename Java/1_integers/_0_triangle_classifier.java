import java.math.BigDecimal;
import java.text.DecimalFormat;

public class _0_triangle_classifier {

    private final TriangleSide sideType;
    private final TriangleAngle angleType;
    private double sideA;
    private double sideB;
    private double sideC;

    public _0_triangle_classifier(double sideA, double sideB, double sideC) {
        if (!isTriangleValid(sideA, sideB, sideC)) {
            this.sideType = TriangleSide.INVALID;
            this.angleType = TriangleAngle.INVALID;
            return;
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideType = classifySide();
        this.angleType = classifyAngle();
    }

    /**
     * Desigualdade triangular: Para um triângulo existir, cada lado deve ser maior que a diferença dos outros dois.
     * <p> a < b + c </p>
     * <p>  b < a + c → b - c < a </p>
     * <p> c < a + b → c - b < a </p>
     * <p> | b - c | < a </p>
     * Em resumo, | b - c | < a < b + c </p>
     * <p>
     * Verifica se os lados fornecidos podem formar um triângulo válido com base no teorema da desigualdade triangular.
     *
     * @param sideA Comprimento do lado A
     * @param sideB Comprimento do lado B
     * @param sideC Comprimento do lado C
     * @return true se os lados formarem um triângulo válido, false caso contrário
     */
    public static boolean isTriangleValid(double sideA, double sideB, double sideC) {
        return sideA > 0 && sideB > 0 && sideC > 0 &&
                Math.abs(sideB - sideC) < sideA && sideA < sideB + sideC &&
                Math.abs(sideA - sideC) < sideB && sideB < sideA + sideC &&
                Math.abs(sideA - sideB) < sideC && sideC < sideA + sideB;
    }

    /**
     * Classifica o triângulo quanto aos lados.
     * <p>
     * Quanto aos lados, os triângulos se classificam em:
     * <p> - Equiláteros: se, e somente se, têm os três lados congruentes.
     * <p> - Isósceles: se, e somente se, têm dois lados congruentes.
     * <p> - Escalenos: se, e somente se, dois quaisquer lados não são congruentes.
     * <p>
     * A função também verifica se os lados fornecidos formam um triângulo válido:
     * - Os comprimentos dos lados devem ser positivos.
     * - A soma de dois lados deve ser maior que o terceiro lado.
     *
     * @return A classificação do triângulo quanto aos lados: EQUILATERAL, ISOSCELES, SCALENE ou INVALID.
     */
    private TriangleSide classifySide() {
        if (sideA == sideB && sideB == sideC) return TriangleSide.EQUILATERAL;
        if (sideA == sideB || sideB == sideC || sideA == sideC) return TriangleSide.ISOSCELES;

        return TriangleSide.SCALENE;
    }

    /**
     * Classifica o triângulo quanto aos ângulos.
     * <p>
     * A classificação é feita com base nas seguintes condições:
     * <p> - a^2 < b^2 + c^2 ⇒ Triângulo Acutângulo
     * <p> - a^2 = b^2 + c^2 ⇒ Triângulo Retângulo
     * <p> - a^2 > b^2 + c^2 ⇒ Triângulo Obtusângulo
     * <p>
     * A função também verifica se os lados fornecidos formam um triângulo válido.
     *
     * @return A classificação do triângulo quanto aos ângulos: ACUTE, RIGHT, OBTUSE ou INVALID.
     */
    private TriangleAngle classifyAngle() {
        double a2 = sideA * sideA;
        double b2 = sideB * sideB;
        double c2 = sideC * sideC;

        if (a2 + b2 == c2 || a2 + c2 == b2 || b2 + c2 == a2) return TriangleAngle.RIGHT;
        if (a2 < b2 + c2 || b2 < a2 + c2 || c2 < a2 + b2) return TriangleAngle.ACUTE;
        if (a2 > b2 + c2 || b2 > a2 + c2 || c2 > a2 + b2) return TriangleAngle.OBTUSE;

        return TriangleAngle.INVALID;
    }

    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public double calculateArea() {
        double semiPerimetro = (sideA + sideB + sideC) / 2;
        return Math.sqrt(semiPerimetro * (semiPerimetro - sideA) * (semiPerimetro - sideB) * (semiPerimetro - sideC));
    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"ladoA\": " + formatarDecimal(sideA) + ",\n" +
                "    \"ladoB\": " + formatarDecimal(sideB) + ",\n" +
                "    \"ladoC\": " + formatarDecimal(sideC) + ",\n" +
                "    \"classificação quanto ao lado:\" : \"" + sideType + "\",\n" +
                "    \"classificação quanto ao ângulo\": \"" + angleType + "\",\n" +
                "    \"perímetro\": " + formatarDecimal(calculatePerimeter()) + ",\n" +
                "    \"área\":      " + formatarDecimal(calculateArea()) + "\n" +
                "}";
    }

    /**
     * Formata um valor decimal com o número mínimo de casas decimais necessárias.
     *
     * <p>
     * O número de casas decimais é determinado pela precisão do valor.
     * Se o valor for inteiro, apenas uma casa decimal será exibida.
     * O número máximo de casas decimais é 3.
     * Se o valor for 0, retorna "0.0".
     * </p>
     *
     * @param valor O valor decimal a ser formatado.
     * @return O valor formatado como uma string.
     */
    private static String formatarDecimal(double valor) {
        if (valor == 0) return "0.0";

        BigDecimal bd = new BigDecimal(valor);
        int casasDecimais = Math.min(3, bd.precision() - bd.scale());

        // Verifica se o valor é inteiro
        if (bd.scale() == 0) casasDecimais = 1; // Usa apenas uma casa decimal para inteiros

        DecimalFormat df = new DecimalFormat("#." + "0".repeat(casasDecimais));
        return df.format(valor);
    }

    /*
    Todo: Implementar método(s) para relacionados aos pontos notáveis do triângulo
    Todo: Implemetar métodos(s) para critérios de semelhança de triângulos
    */

    enum TriangleSide {
        EQUILATERAL,
        ISOSCELES,
        SCALENE,
        INVALID
    }

    enum TriangleAngle {
        RIGHT,
        ACUTE,
        OBTUSE,
        INVALID
    }

    public static void main(String[] args) {
        // Teste 1: Triângulo Equilátero e Acutângulo
        _0_triangle_classifier triangle1 = new _0_triangle_classifier(5, 5, 5);
        System.out.println(triangle1);
        System.out.println("Triângulo é válido: " + _0_triangle_classifier.isTriangleValid(5, 5, 5));
        System.out.println();

        // Teste 2: Triângulo Isósceles e Retângulo
        _0_triangle_classifier triangle2 = new _0_triangle_classifier(5, 5, Math.sqrt(50));
        System.out.println(triangle2);
        System.out.println("Triângulo é válido: " + _0_triangle_classifier.isTriangleValid(5, 5, Math.sqrt(50)));
        System.out.println();

        // Teste 3: Triângulo Escaleno e Obtusângulo
        _0_triangle_classifier triangle3 = new _0_triangle_classifier(3, 4, 6);
        System.out.println(triangle3);
        System.out.println("Triângulo é válido: " + _0_triangle_classifier.isTriangleValid(3, 4, 6));
        System.out.println();

        // Teste 4: Triângulo Inválido
        _0_triangle_classifier triangle4 = new _0_triangle_classifier(1, 2, 3);
        System.out.println(triangle4);
        System.out.println("Triângulo é válido: " + _0_triangle_classifier.isTriangleValid(1, 2, 3));
        System.out.println();

        // Teste 5: Triângulo Isósceles e Acutângulo
        _0_triangle_classifier triangle5 = new _0_triangle_classifier(7, 7, 10);
        System.out.println(triangle5);
        System.out.println("Triângulo é válido: " + _0_triangle_classifier.isTriangleValid(7, 7, 10));
        System.out.println();

        // Teste 6: Triângulo Escaleno e Acutângulo
        _0_triangle_classifier triangle6 = new _0_triangle_classifier(7, 8, 9);
        System.out.println(triangle6);
        System.out.println("Triângulo é válido: " + _0_triangle_classifier.isTriangleValid(7, 8, 9));
        System.out.println();
    }
}


