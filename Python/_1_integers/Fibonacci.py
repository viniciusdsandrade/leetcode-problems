import time
from typing import Tuple


def fibonacci_recursivo(n: int) -> int:
    if n <= 1:
        return n
    else:
        return fibonacci_recursivo(n - 1) + fibonacci_recursivo(n - 2)


def fibonacci_iterativo(n: int) -> int:
    a, b = 0, 1
    for _ in range(n):
        a, b = b, a + b
    return a


def test(n: int) -> Tuple[int, int]:
    start_time_1 = time.perf_counter_ns()
    fibonacci_recursivo(n)
    end_time_1 = time.perf_counter_ns()

    start_time_2 = time.perf_counter_ns()
    fibonacci_iterativo(n)
    end_time_2 = time.perf_counter_ns()

    runtime_1 = end_time_1 - start_time_1
    runtime_2 = end_time_2 - start_time_2

    return runtime_1, runtime_2


def main():
    total_runtime_1 = 0
    total_runtime_2 = 0
    num_tests = 20

    for n in range(num_tests):
        runtime_1, runtime_2 = test(n)
        total_runtime_1 += runtime_1
        total_runtime_2 += runtime_2

    media_runtime_1 = total_runtime_1 / num_tests
    media_runtime_2 = total_runtime_2 / num_tests

    print(f"Média de desempenho recursivo: {media_runtime_1:.2f}ns")
    print(f"Média de desempenho iterativo: {media_runtime_2:.2f}ns")


if __name__ == "__main__":
    main()
