import java.util.Scanner;
import myutil.myqueue.MyQueue;
import myutil.mystack.MyStack;

public class Perhitungan {
    private String[] operators = {"^", "*", "/", "+", "-"};

    public void getResult(String data) {
        String[] dataSplited = data.split(" ");
        MyStack daftarOperand = new MyStack();
        MyStack daftarOperator = new MyStack();

        for (String item : dataSplited) {
            if (item.equalsIgnoreCase(")")) {

                MyStack operandIn = new MyStack();
                MyStack operatorIn = new MyStack();

                operandIn.push(daftarOperand.pop());
                while (!daftarOperand.isEmpty()) {
                    if (daftarOperand.peek().equalsIgnoreCase("(")) {
                        daftarOperand.pop();
                        break;
                    } else {
                        operatorIn.push(daftarOperator.pop());
                        operandIn.push(daftarOperand.pop());
                    }
                }
                //change the direction
                MyQueue qTmp = new MyQueue();
                while (!operandIn.isEmpty()) {
                    qTmp.add(operandIn.pop());
                }
                while (!qTmp.isEmpty()) {
                    operandIn.push(qTmp.remove());
                }
                while (!operatorIn.isEmpty()) {
                    qTmp.add(operatorIn.pop());
                }
                while (!qTmp.isEmpty()) {
                    operatorIn.push(qTmp.remove());
                }
                calculate(operandIn, operatorIn);
                daftarOperand.push(operandIn.pop());
            } else if (isOperators(item)) {
                daftarOperator.push(item);
            } else {
                daftarOperand.push(item);
            }
        }
        ///( 3 ^ ( 3 ^ 2 ^ 0 ) )
        calculate(daftarOperand, daftarOperator);
        String hasil = daftarOperand.pop();
        double hasilDbl = Double.parseDouble(hasil);
        System.out.println("= " + hasilDbl);
    }

    public void calculate(MyStack operandIn, MyStack operatorIn) {
        calculate(operandIn, operatorIn, new String[]{"^"});
        calculate(operandIn, operatorIn, new String[]{"*", "/"});
        calculate(operandIn, operatorIn, new String[] {"+","-"});
    }

    public void calculate(MyStack operandIn, MyStack operatorIn, String[] operatorsUsed) {
        if (operatorsUsed.length == 1 && operatorsUsed[0].equalsIgnoreCase("^")) {

            MyStack operatorTmp = new MyStack();
            MyStack operandTmp = new MyStack();

            operandTmp.push(operandIn.pop());
            while (!operandIn.isEmpty()) {
                //check if operator is the used one
                boolean used = false;
                String operator = operatorIn.pop();
                for (String op : operatorsUsed) {
                    if (operator.equalsIgnoreCase(op)) {
                        used = true;
                    }
                }
                if (used) {
                    String operand1 = operandIn.pop();
                    String operand2 = operandTmp.pop();
                    try {
                        String res = calculate(operand1, operand2, operator);
                        operandTmp.push(res);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        System.exit(0);
                    }
                } else {
                    operatorTmp.push(operator);
                    operandTmp.push(operandIn.pop());
                }
            }
            while (!operandTmp.isEmpty()) {
                operandIn.push(operandTmp.pop());
            }
            while (!operatorTmp.isEmpty()) {
                operatorIn.push(operatorTmp.pop());
            }
        } else {
            //change the direction
            MyQueue qTmp = new MyQueue();
            while (!operandIn.isEmpty()) {
                qTmp.add(operandIn.pop());
            }
            while (!qTmp.isEmpty()) {
                operandIn.push(qTmp.remove());
            }
            while (!operatorIn.isEmpty()) {
                qTmp.add(operatorIn.pop());
            }
            while (!qTmp.isEmpty()) {
                operatorIn.push(qTmp.remove());
            }
            MyStack operatorTmp = new MyStack();
            MyStack operandTmp = new MyStack();

            operandTmp.push(operandIn.pop());
            while (!operandIn.isEmpty()) {
                //check if operator is the used one
                boolean used = false;
                String operator = operatorIn.pop();
                for (String op : operatorsUsed) {
                    if (operator.equalsIgnoreCase(op)) {
                        used = true;
                    }
                }
                if (used) {
                    String operand1 = operandIn.pop();
                    String operand2 = operandTmp.pop();
                    try {
                        String res = calculate(operand2, operand1, operator);
                        operandTmp.push(res);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        System.exit(0);
                    }
                } else {
                    operatorTmp.push(operator);
                    operandTmp.push(operandIn.pop());
                }
            }
            while (!operandTmp.isEmpty()) {
                operandIn.push(operandTmp.pop());
            }
            while (!operatorTmp.isEmpty()) {
                operatorIn.push(operatorTmp.pop());
            }

            //change the direction again
            while (!operandIn.isEmpty()) {
                qTmp.add(operandIn.pop());
            }
            while (!qTmp.isEmpty()) {
                operandIn.push(qTmp.remove());
            }
            while (!operatorIn.isEmpty()) {
                qTmp.add(operatorIn.pop());
            }
            while (!qTmp.isEmpty()) {
                operatorIn.push(qTmp.remove());
            }
        }
    }

    private String calculate(String operand1, String operand2, String operator) throws Exception {
//        System.out.println(operand1 + " " + operator + " " + operand2);
        if (operator.equalsIgnoreCase("^")) {
            return Double.toString(Math.pow(Double.parseDouble(operand1), Double.parseDouble(operand2)));
        } else if (operator.equalsIgnoreCase("*")) {
            return Double.toString((Double.parseDouble(operand1)) * (Double.parseDouble(operand2)));
        } else if (operator.equalsIgnoreCase("/")) {
            double a = Double.parseDouble(operand1);
            double b = Double.parseDouble(operand2);
            if (b == 0.0 || a == 0.0) {
                throw new Exception("= ERROR");
            }
            return Double.toString((Double.parseDouble(operand1)) / (Double.parseDouble(operand2)));
        } else if (operator.equalsIgnoreCase("+")) {
            return Double.toString((Double.parseDouble(operand1)) + (Double.parseDouble(operand2)));
        } else if (operator.equalsIgnoreCase("-")) {
            return Double.toString((Double.parseDouble(operand1)) - (Double.parseDouble(operand2)));
        }
//        System.out.println("Operator Not Found");
        return "Operator Not Found";
    }

    private boolean isOperators(String data) {
        for (String op : operators) {
            if (data.equalsIgnoreCase(op)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input = (new Scanner(System.in)).nextLine();
        (new Perhitungan()).getResult(input);
    }
}
