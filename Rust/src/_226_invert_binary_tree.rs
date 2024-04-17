use std::cell::{RefCell};
use std::rc::Rc;
use std::time::{Duration, Instant};

#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }

    pub fn with_children(val: i32, left: Option<Rc<RefCell<TreeNode>>>, right: Option<Rc<RefCell<TreeNode>>>) -> Self {
        TreeNode {
            val,
            left,
            right,
        }
    }

    pub fn to_string_pretty(&self) -> String {
        self.build_string(0, "    ")
    }

    fn build_string(&self, level: usize, indent: &str) -> String {
        let mut s = format!("{}|-- {}\n", indent.repeat(level), self.val);
        if let Some(left) = &self.left {
            s.push_str(&left.borrow().build_string(level + 1, indent));
        }
        if let Some(right) = &self.right {
            s.push_str(&right.borrow().build_string(level + 1, indent));
        }
        s
    }
}

pub(crate) fn invert_tree(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
    root.map(|node| {
        let node_clone = Rc::clone(&node);
        let mut node = node.borrow_mut();

        let temp_left = node.left.take();
        let temp_right = node.right.take();

        node.left = invert_tree(temp_right);
        node.right = invert_tree(temp_left);

        node_clone
    })
}

pub(crate) fn test_invert_tree(root: Option<Rc<RefCell<TreeNode>>>) {
    println!("-------------------------------------");
    println!("árvore original:");
    if let Some(root) = &root {
        println!("{}", root.borrow().to_string_pretty());
    }

    let start: Instant = Instant::now();
    let result: Option<Rc<RefCell<TreeNode>>> = invert_tree(root);
    let duration: Duration = start.elapsed();

    println!("\nárvore invertida:");
    if let Some(result) = &result {
        println!("{}", result.borrow().to_string_pretty());
    }
    println!("Execution time: {:?}", duration);
}


