
package javaapplication15;
import java.util.*;
/** Class that can evaluate a postfix expression.
*   @author Koffman & Wolfgang
* */

public class PostfixEvaluator {


    

  // Constant
  /** A list of operators. */
  private static final String OPERATORS = "+-*/^";

  // Data Field
  /** The operand stack. */
  private Stack < Integer> operandStackInt;
private Stack<Double> operandStackDouble;
  // Methods
  /** Evaluates the current operation.
      This function pops the two operands off the operand
      stack and applies the operator.
      @param op A character representing the operator
      @return The result of applying the operator
      @throws EmptyStackException if pop is attempted on
              an empty stack
   */
  private int evalOpInt(char op) {
    // Pop the two operands off the stack.
    int rhs = operandStackInt.pop();
    int lhs = operandStackInt.pop();
    int result = 0;
    // Evaluate the operator.
    switch (op) {
      case '+':
        result = lhs + rhs;
        break;
      case '-':
        result = lhs - rhs;
        break;
      case '/':
        result = lhs / rhs;
        break;
      case '*':
        result = lhs * rhs;
        break;
      case '^':
          result=1;
          int i;
          for(i=0;i<rhs;++i)
              result*=lhs;
          break;
    }
    return result;
  }
/*double operandlar arasindaki islemi hesaplar ve return eder*/  
  public double evalOpFloat(char op){
       // Pop the two operands off the stack.
    double rhs = operandStackDouble.pop();
    double lhs = operandStackDouble.pop();
    double result = 0;
    // Evaluate the operator.
    switch (op) {
      case '+':
        result = lhs + rhs;
        break;
      case '-':
        result = lhs - rhs;
        break;
      case '/':
        result = lhs / rhs;
        break;
      case '*':
        result = lhs * rhs;
        break;
      case '^':
          int i;
          result=1;
          for(i=0;i<rhs;++i)
              result*=lhs;
          break;
    }
    return result;
  }

  /** Determines whether a character is an operator.
      @param op The character to be tested
      @return true if the character is an operator
   */
  private boolean isOperator(char ch) {
    return OPERATORS.indexOf(ch) != -1;
  }

  /** Evaluates a postfix expression.
      @param expression The expression to be evaluated
      @return The value of the expression
      @throws SyntaxErrorException if a syntax error is detected
   */
  public int evalInt(String expression) throws Excep {
    // Create an empty stack.
    operandStackInt = new Stack < Integer> ();

    // Process each token.
    StringTokenizer tokens = new StringTokenizer(expression);
    try {
      while (tokens.hasMoreTokens()) {
        String nextToken = tokens.nextToken();
        // Does it start with a digit?
        if (Character.isDigit(nextToken.charAt(0))) {
          // Get the integer value.
          int value = Integer.parseInt(nextToken);
          // Push value onto operand stack.
          operandStackInt.push(value);
        } // Is it an operator?
        else if (isOperator(nextToken.charAt(0))) {
          // Evaluate the operator.
          int result = evalOpInt(nextToken.charAt(0));
          // Push result onto the operand stack.
          operandStackInt.push(result);
        }
        else {
          // Invalid character.
          throw new Excep(
              "Invalid character encountered");
        }
      } // End while.

      // No more tokens - pop result from operand stack.
      int answer = operandStackInt.pop();
      // Operand stack should be empty.
      if (operandStackInt.empty()) {
        return answer;
      }
      else {
        // Indicate syntax error.
        throw new Excep(
            "Syntax Error: Stack should be empty");
      }
    }
    catch (EmptyStackException ex) {
      // Pop was attempted on an empty stack.
      throw new Excep(
          "Syntax Error: The stack is empty");
    }
  }
   public double evalDouble(String expression) throws Excep {
    // Create an empty stack.
    operandStackDouble = new Stack < Double > ();

    // Process each token.
    StringTokenizer tokens = new StringTokenizer(expression);
    try {
      while (tokens.hasMoreTokens()) {
        String nextToken = tokens.nextToken();
        // Does it start with a digit?
        if (Character.isDigit(nextToken.charAt(0))) {
          // Get the integer value.
          double value = Double.parseDouble(nextToken);
          // Push value onto operand stack.
          operandStackDouble.push(value);
        } // Is it an operator?
        else if (isOperator(nextToken.charAt(0))) {
          // Evaluate the operator.
          double result = evalOpFloat(nextToken.charAt(0));
          // Push result onto the operand stack.
          operandStackDouble.push(result);
        }
        else {
          // Invalid character.
          throw new Excep(
              "Invalid character encountered");
        }
      } // End while.

      // No more tokens - pop result from operand stack.
      double answer = operandStackDouble.pop();
      // Operand stack should be empty.
      if (operandStackDouble.empty()) {
        return answer;
      }
      else {
        // Indicate syntax error.
        throw new Excep(
            "Syntax Error: Stack should be empty");
      }
    }
    catch (EmptyStackException ex) {
      // Pop was attempted on an empty stack.
      throw new Excep(
          "Syntax Error: The stack is empty");
    }
  } 
}