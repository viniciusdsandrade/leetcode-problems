use std::time::{Duration, Instant};

pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut map = std::collections::HashMap::new();
    for (i, num) in nums.iter().enumerate() {
        let complement = target - num;
        if let Some(&j) = map.get(&complement) {
            return vec![j as i32, i as i32];
        }
        map.insert(num, i);
    }
    vec![]
}

pub(crate)fn test_two_sum(nums: Vec<i32>, target: i32) {
    println!("nums = {:?}" , nums);
    println!("target = {:?}" , target);

    let start: Instant = Instant::now();
    let result: Vec<i32> = two_sum(nums, target);
    let duration: Duration = start.elapsed();

    println!("result = {:?}", result);
    println!("duration = {:?}", duration);
}