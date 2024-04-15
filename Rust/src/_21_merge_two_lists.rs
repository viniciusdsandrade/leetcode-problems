use std::time::Instant;

#[derive(Debug)]
pub struct ListNode {
    pub(crate) val: i32,
    pub(crate) next: Option<Box<ListNode>>,
}

impl ListNode {
    pub(crate) fn new(val: i32) -> Self {
        ListNode { val, next: None }
    }

    pub(crate) fn to_string(&self) -> String {
        let mut current = Some(self);
        let mut result = String::from("[");
        while let Some(node) = current {
            result += &node.val.to_string();
            if node.next.is_some() {
                result += " -> ";
            }
            current = node.next.as_deref();
        }
        result += "]";
        result
    }
}

pub(crate) fn merge_two_lists(mut l1: Option<Box<ListNode>>, mut l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut dummy_head = Some(Box::new(ListNode::new(0)));
    let mut tail = &mut dummy_head;

    while l1.is_some() && l2.is_some() {
        let l1_val = l1.as_ref().unwrap().val;
        let l2_val = l2.as_ref().unwrap().val;

        if l1_val < l2_val {
            let next = l1.as_mut().unwrap().next.take();
            tail.as_mut().unwrap().next = l1.take();
            l1 = next;
        } else {
            let next = l2.as_mut().unwrap().next.take();
            tail.as_mut().unwrap().next = l2.take();
            l2 = next;
        }

        tail = &mut tail.as_mut().unwrap().next;
    }

    if l1.is_some() {
        tail.as_mut().unwrap().next = l1;
    } else {
        tail.as_mut().unwrap().next = l2;
    }

    dummy_head.unwrap().next
}


pub(crate) fn test_merge_two_lists(list1: Option<Box<ListNode>>, list2: Option<Box<ListNode>>) {
    println!("\nLista 1: {}", list1.as_ref().map(|n| n.to_string()).unwrap_or(String::from("None")));
    println!("Lista 2: {}", list2.as_ref().map(|n| n.to_string()).unwrap_or(String::from("None")));

    let start = Instant::now();
    let result = merge_two_lists(list1, list2);
    let duration = start.elapsed();

    println!("Resultado: {}", result.as_ref().map(|n| n.to_string()).unwrap_or(String::from("None")));
    println!("Tempo de execução: {}ns\n", duration.as_nanos());
}
