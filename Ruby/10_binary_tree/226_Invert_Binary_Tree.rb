class TreeNode
  attr_accessor :val, :left, :right

  def initialize(val = 0, left = nil, right = nil)
    @val = val
    @left = left
    @right = right
  end

  def clone
    TreeNode.new(@val, @left&.clone, @right&.clone)
  end

  def ==(other)
    return true if self.equal?(other)
    return false if other.nil?
    return false unless other.is_a?(TreeNode)

    @val == other.val &&
      @left == other.left &&
      @right == other.right
  end

  def hash
    prime = 31
    hash = 1

    hash *= prime + @val
    hash *= prime + (@left.nil? ? 0 : @left.hash)
    hash *= prime + (@right.nil? ? 0 : @right.hash)

    hash
  end

  def to_s(level = 0, indent = "    ")
    s = "#{indent * level}|-- #{@val}\n"
    s += @left.to_s(level + 1, indent) unless @left.nil?
    s += @right.to_s(level + 1, indent) unless @right.nil?
    s
  end
end

def invert_tree(root)
  return root if root.nil?

  left = invert_tree(root.left)
  right = invert_tree(root.right)

  root.left = right
  root.right = left

  root
end

def build_tree(nodes)
  return nil if nodes.nil? || nodes.empty?
  root = TreeNode.new(nodes[0])
  root.left = build_tree(nodes[1]) if nodes.length > 1
  root.right = build_tree(nodes[2]) if nodes.length > 2
  root
end

def test_invert_tree(root)
  puts "-------------------------------------------------"
  puts "Árvore:"
  puts root.to_s

  start = Time.now
  result = invert_tree(root)
  finish = Time.now

  puts "Árvore invertida:"
  puts result.to_s
  puts "Tempo de execução: #{((finish - start) * 1_000_000_000).to_i}ns"
end


test_invert_tree(build_tree([4, [2, [1], [3]], [7, [6], [9]]]))
test_invert_tree(build_tree([2, [1], [3]]))
test_invert_tree(build_tree([1, [2], [3]]))



