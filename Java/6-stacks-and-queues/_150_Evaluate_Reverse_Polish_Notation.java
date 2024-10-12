import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class _150_Evaluate_Reverse_Polish_Notation {

    /*
    150. Evaluate Reverse Polish Notation
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

    Evaluate the expression.
    Return an integer that represents the value of the expression.

    Note that:

    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.

    Example 1:
    Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9

    Example 2:
    Input: tokens = ["4","13","5","/","+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6

    Example 3:
    Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    Output: 22
    Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    = ((10 * (6 / (12 * -11))) + 17) + 5
    = ((10 * (6 / -132)) + 17) + 5
    = ((10 * 0) + 17) + 5
    = (0 + 17) + 5
    = 17 + 5
    = 22

    Constraints:
    1 <= tokens.length <= 104
    tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
     */
    public static void main(String[] args) {

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        TestEvalRPN(tokens1);

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        TestEvalRPN(tokens2);

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        TestEvalRPN(tokens3);

        String[] expression = {"2", "+", "3", "*", "4"};
        TestEvalExpression(expression);

        String[] expression2 = {"(", "2", "+", "3", ")", "*", "4"};
        TestEvalExpression(expression2);
    }

    private static final Map<String, Integer> OPERATOR_PRECEDENCE = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public static int evalExpression(String[] tokens) {
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        for (String token : tokens) {
            if (OPERATOR_PRECEDENCE.containsKey(token)) {
                while (!operators.isEmpty() && OPERATOR_PRECEDENCE.getOrDefault(operators.peek(), 0) >= OPERATOR_PRECEDENCE.get(token)) {
                    processAnOperator(operands, operators);
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    processAnOperator(operands, operators);
                }
                operators.pop();
            } else {
                operands.push(Integer.parseInt(token));
            }
        }
        while (!operators.isEmpty()) {
            processAnOperator(operands, operators);
        }
        return operands.pop();
    }

    private static void processAnOperator(Stack<Integer> operands, Stack<String> operators) {
        int operand2 = operands.pop();
        int operand1 = operands.pop();
        String operator = operators.pop();

        switch (operator) {
            case "+" -> operands.push(operand1 + operand2);
            case "-" -> operands.push(operand1 - operand2);
            case "*" -> operands.push(operand1 * operand2);
            case "/" -> operands.push(operand1 / operand2);
        }
    }


    public static void TestEvalExpression(String[] tokens) {
        System.out.println("\nInput: " + Arrays.toString(tokens));

        long startTime = System.nanoTime();
        int result = evalExpression(tokens);
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Result: " + result);
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> stack.push(-stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 / num1);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void TestEvalRPN(String[] tokens) {
        System.out.println("\nInput: " + Arrays.toString(tokens));

        long startTime = System.nanoTime();
        int result = evalRPN(tokens);
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Result: " + result);
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
    }
}
