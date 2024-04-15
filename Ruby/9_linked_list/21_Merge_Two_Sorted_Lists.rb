class ListNode
  attr_accessor :val, :next

  def initialize(val = 0, _next = nil)
    @val = val
    @next = _next
  end

  def to_s
    node = self
    result = "["
    while node != nil
      result += node.val.to_s
      result += " -> " if node.next != nil
      node = node.next
    end
    result + "]"
  end
end

def merge_two_lists (list1, list2)
  return list1 if list2.nil?
  return list2 if list1.nil?

  if list1.val < list2.val
    list1.next = merge_two_lists(list1.next, list2)
    list1
  else
    list2.next = merge_two_lists(list1, list2.next)
    list2
  end
end

def test_merge_two_lists(list1, list2)
  puts "\nLista 1: #{list1.to_s}"
  puts "Lista 2: #{list2.to_s}"

  start = Time.now
  result = merge_two_lists(list1, list2)
  finish = Time.now

  puts "Resultado: #{result.to_s}"
  puts "Tempo de execução: #{((finish - start) * 1_000_000_000).to_i}ns\n"
end

# Criando listas para teste
list1 = ListNode.new(1, ListNode.new(2, ListNode.new(4)))
list2 = ListNode.new(1, ListNode.new(3, ListNode.new(4)))
test_merge_two_lists(list1, list2)

list3 = ListNode.new
list4 = ListNode.new
test_merge_two_lists(list3, list4)

list5 = ListNode.new
list6 = ListNode.new(0)
test_merge_two_lists(list5, list6)
