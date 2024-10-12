import java.util.Objects;


/**
 * A classe No representa um nó em uma árvore binária de busca.
 * Cada nó contém um valor do tipo X que implementa a interface Comparable,
 * e referências para os seus filhos esquerdo e direito.
 *
 * @param <X> O tipo de dado armazenado no nó, deve implementar a interface Comparable.
 */
public class Node<X extends Comparable<X>> implements Cloneable, Comparable<Node<X>> {

    /**
     * A referência para o filho esquerdo do nó.
     */
    private Node<X> esq;

    /**
     * O valor armazenado no nó.
     */
    private X info;

    /**
     * A referência para o filho direito do nó.
     */
    private Node<X> dir;

    /**
     * Construtor padrão que cria um nó vazio.
     */
    public Node() {
    }

    /**
     * Construtor que cria um nó com o valor especificado.
     *
     * @param info O valor a ser armazenado no nó, não pode ser nulo.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public Node(X info) {
        if (info == null) throw new IllegalArgumentException("Valor nulo");
        this.esq = null;
        this.info = info;
        this.dir = null;
    }

    public Node(Node<X> esq, X info) {
        if (info == null) throw new IllegalArgumentException("Valor nulo");
        this.esq = esq;
        this.info = info;
        this.dir = null;
    }

    public Node(X info, Node<X> dir) {
        if (info == null) throw new IllegalArgumentException("Valor nulo");
        this.esq = null;
        this.info = info;
        this.dir = dir;
    }

    /**
     * Construtor que cria um nó com o valor especificado e referências para os filhos esquerdo e direito.
     *
     * @param esq A referência para o filho esquerdo do nó.
     * @param info    O valor a ser armazenado no nó.
     * @param dir  A referência para o filho direito do nó.
     */
    public Node(Node<X> esq, X info, Node<X> dir) {
        this.esq = esq;
        this.info = info;
        this.dir = dir;
    }

    /**
     * Retorna o valor armazenado no nó, garantindo que seja retornado uma cópia ou o valor original dependendo da configuração de cópia.
     *
     * @return O valor armazenado no nó.
     */
    @SuppressWarnings("unchecked")
    public X getValor() {
        return (X) ShallowOrDeepCopy.verifyAndCopy(info);
    }

    /**
     * Retorna a referência para o filho esquerdo do nó.
     *
     * @return A referência para o filho esquerdo do nó.
     */
    public Node<X> getEsquerda() {
        return esq;
    }

    /**
     * Retorna a referência para o filho direito do nó.
     *
     * @return A referência para o filho direito do nó.
     */
    public Node<X> getDireita() {
        return dir;
    }

    /**
     * Define o valor armazenado no nó.
     *
     * @param valor O novo valor a ser armazenado no nó, não pode ser nulo.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public void setValor(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        this.info = valor;
    }

    /**
     * Define a referência para o filho esquerdo do nó.
     *
     * @param esquerda A nova referência para o filho esquerdo do nó.
     */
    public void setEsquerda(Node<X> esquerda) {
        this.esq = esquerda;
    }

    /**
     * Define a referência para o filho direito do nó.
     *
     * @param direita A nova referência para o filho direito do nó.
     */
    public void setDireita(Node<X> direita) {
        this.dir = direita;
    }

    /**
     * Busca um nó na subárvore com raiz neste nó que contém o valor especificado.
     *
     * @param valor O valor a ser buscado.
     * @return O nó que contém o valor, ou nulo se o valor não for encontrado.
     */
    public Node<X> buscarNo(X valor) {
        if (valor == null) return null;
        int comparacao = valor.compareTo(this.info);
        if (comparacao == 0) return this;
        if (comparacao < 0 && this.esq != null) return this.esq.buscarNo(valor);
        if (comparacao > 0 && this.dir != null) return this.dir.buscarNo(valor);
        return null;
    }

    /**
     * Busca o valor mínimo na subárvore com raiz neste nó.
     *
     * @return O valor mínimo na subárvore.
     */
    public X buscarMinimo() {
        if (this.esq == null)
            return this.info;
        else
            return this.esq.buscarMinimo();
    }

    /**
     * Busca o valor máximo na subárvore com raiz neste nó.
     *
     * @return O valor máximo na subárvore.
     */
    public X buscarMaximo() {
        if (this.dir == null)
            return this.info;
        else
            return this.dir.buscarMaximo();
    }

    /**
     * Verifica se o nó é uma folha, ou seja, se não possui filhos.
     *
     * @return True se o nó for uma folha, False caso contrário.
     */
    public boolean isFolha() {
        return esq == null && dir == null;
    }

    /**
     * Verifica se o nó possui ambos os filhos.
     *
     * @return True se o nó possuir ambos os filhos, False caso contrário.
     */
    public boolean temAmbosFilhos() {
        return esq != null && dir != null;
    }

    /**
     * Verifica se o nó possui apenas um filho.
     *
     * @return True se o nó possuir apenas um filho, False caso contrário.
     */
    public boolean temUmFilho() {
        return (esq != null && dir == null) || (esq == null && dir != null);
    }

    /**
     * Construtor de cópia que cria um novo nó com base em um nó modelo, realizando uma cópia profunda dos valores.
     *
     * @param modelo O nó modelo a ser copiado, não pode ser nulo.
     * @throws IllegalArgumentException Se o nó modelo fornecido for nulo.
     */
    @SuppressWarnings("unchecked")
    public Node(Node<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");

        this.info = (X) ShallowOrDeepCopy.verifyAndCopy(modelo.getValor());

        if (modelo.esq != null)
            this.esq = new Node<>(modelo.esq);
        else
            this.esq = null;

        if (modelo.dir != null)
            this.dir = new Node<>(modelo.dir);
        else
            this.dir = null;
    }

    /**
     * Cria e retorna um clone deste nó, realizando uma cópia profunda dos valores.
     *
     * @return Um clone deste nó.
     */
    @Override
    public Object clone() {
        Node<X> clone = null;
        try {
            clone = new Node<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    /**
     * Verifica se este nó é igual a outro objeto.
     *
     * @param o O objeto a ser comparado.
     * @return True se os objetos forem iguais, False caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> that = (Node<?>) o;
        return Objects.equals(this.info, that.info) &&
                equals(this.esq, that.esq) &&
                equals(this.dir, that.dir);
    }

    /**
     * Método auxiliar para verificar a igualdade entre dois nós, recursivamente.
     *
     * @param node1 O primeiro nó a ser comparado.
     * @param node2 O segundo nó a ser comparado.
     * @return True se os nós forem iguais, False caso contrário.
     */
    private boolean equals(Node<X> node1, Node<?> node2) {
        if (node1 == node2) return true;
        if (node1 == null || node2 == null) return false;
        if (!node1.info.equals(node2.info)) return false;
        return equals(node1.esq, node2.esq) &&
                equals(node1.dir, node2.dir);
    }

    /**
     * Retorna o código hash para este nó.
     *
     * @return O código hash para este nó.
     */
    @Override
    public int hashCode() {
        return hashCode(this);
    }

    /**
     * Método auxiliar para calcular o código hash de um nó, recursivamente.
     *
     * @param node O nó para o qual o código hash deve ser calculado.
     * @return O código hash do nó.
     */
    private int hashCode(Node<X> node) {
        final int prime = 31;
        int hash = 1;
        if (node == null) return 0;
        hash *= prime + ((node.info == null) ? 0 : node.info.hashCode());
        hash *= prime + hashCode(node.esq);
        hash *= prime + hashCode(node.dir);
        if (hash < 0) hash = -hash;
        return hash;
    }

    /**
     * Retorna uma representação em string deste nó.
     *
     * @return Uma representação em string deste nó.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        if (this.esq != null) sb.append(this.esq);
        sb.append(" } L { ");
        if (this.info != null) sb.append(this.info);
        sb.append(" } R { ");
        if (this.dir != null) sb.append(this.dir);
        sb.append(" }");
        return sb.toString();
    }

    /**
     * Compara este nó com outro nó.
     *
     * @param other O nó a ser comparado.
     * @return Um valor negativo se este nó for menor que o outro nó, zero se forem iguais,
     * ou um valor positivo se este nó for maior que o outro nó.
     * @throws NullPointerException Se o outro nó for nulo.
     */
    @Override
    public int compareTo(Node<X> other) {
        if (other == null) throw new NullPointerException("Cannot compare with null node");
        return this.info.compareTo(other.info);
    }
}