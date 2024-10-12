public final class Triangle {

    private final float a;
    private final float b;
    private final float c;

    public Triangle(float a, float b, float c) {

        if (!isValidTriangle(a, b, c))
            throw new IllegalArgumentException("Não é um triângulo");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isValidTriangle(float a, float b, float c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public String typeAngleTriangle(float a, float b, float c) {
        double cosA = (b * b + c * c - a * a) / (2.0 * b * c);
        double cosB = (a * a + c * c - b * b) / (2.0 * a * c);
        double cosC = (a * a + b * b - c * c) / (2.0 * a * b);

        // Calculate the sine of each angle using trigonometric identities
        double sinA = Math.sqrt(1 - cosA * cosA);
        double sinB = Math.sqrt(1 - cosB * cosB);
        double sinC = Math.sqrt(1 - cosC * cosC);

        // Compare the sine and cosine values to determine the angle classification
        if (sinA == 0 || sinB == 0 || sinC == 0)
            return "Não é um triângulo"; // Degenerate triangle (one angle is 0°)
        else if (cosA == 0 || cosB == 0 || cosC == 0)
            return "Retângulo"; // Right triangle (one angle is 90°)
        else if (cosA > 0 && cosB > 0 && cosC > 0)
            return "Acutângulo"; // Acute triangle (all angles are less than 90°)
        else if (cosA < 0 || cosB < 0 || cosC < 0)
            return "Obtusângulo"; // Obtuse triangle (one angle is greater than 90°)
        else
            return "";
    }

    public static String typeSideTriangle(float a, float b, float c) {
        if (a == b && b == c)
            return "Equilátero"; // Equilateral triangle (all sides are equal)
        else if (a == b || a == c || b == c)
            return "Isósceles"; // Isosceles triangle (two sides are equal)
        else
            return "Escaleno"; // Scalene triangle (no sides are equal)
    }

    public static float area(float a, float b, float c) {
        float s = (a + b + c) / 2.0f;
        return (float) Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

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

    //Construtor de cópia
    public Triangle(Triangle triangle) {
        this(triangle.a, triangle.b, triangle.c);
    }

    @Override
    public Triangle clone() {
        Triangle clone = null;

        try {
            clone = new Triangle(this);
        } catch (IllegalArgumentException e) {
            // Ignorar a exceção
        }

        return clone;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return Float.compare(a, triangle.a) == 0 &&
                Float.compare(b, triangle.b) == 0 &&
                Float.compare(c, triangle.c) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + Float.floatToIntBits(a);
        hash *= prime + Float.floatToIntBits(b);
        hash *= prime + Float.floatToIntBits(c);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}