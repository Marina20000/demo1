package polish;

import java.util.Stack;

/**
 * Created by Marina_Voronetckaia on 7/6/2017.
 */
public class PolishReverse {

    public Stack<Character> expression=new Stack<Character>();
    public Stack<String> out=new Stack<String>();
    public Stack<String> stack=new Stack<String>();
    String number="";

    public String  parseExpression(String ex) throws CalculatorException {
        if (ex==null|| ex.equals("")) throw new CalculatorException("не введено выражение");
        stringToStack(ex);
        while (!(expression.size()==0)){
            char c=expression.peek();
            char s=classificateSymbol(c);
            switch (s){
                case 'd': number=number+c;
                    expression.pop();
                    break;
                case ' ': pushNumber();
                    expression.pop();
                    break;
                case '(': pushNumber();
                    pushFromExpressionToStack();
                    break;
                case ')': pushNumber();
                    pushSymbolsFromStackToOut();
                    expression.pop();
                    break;
                case 'o': pushNumber();
                    operatorProcessing(c);
                    pushFromExpressionToStack();
                    break;
                default : throw new CalculatorException("в записи присутствуют недопустимые символы");
            }
        }
        pushNumber();
        pushAllSymbolsFromStackToOut();
        return stackToString(out);
    }

    public Double calculate(String string) throws CalculatorException {
        out=convertStringToStack(string);
        System.out.println(out);
        reverse();
        char c=' ';
        while (!(out.size() == 0)) {
            String s = out.pop();
            if (s.length()==1){
                c=s.charAt(0);
                if (isOperator(c)){
                    try{if (isOperator(c)) {
                        Double result = calc(getOperand(), getOperand(), c);
                        stack.push(Double.toString(result));}}
                    catch (NumberFormatException e){
                        throw new CalculatorException("неверный формат записи операндов");}
                }
                else {stack.push(s);}
            }
            else {stack.push(s);}
        }
        if (stack.size()>1) throw  new CalculatorException("не хватает знаков операций");
        System.out.println("result="+stack.peek());
        return Double.valueOf(stack.peek());
    }


    private Double getOperand() throws NumberFormatException, CalculatorException {
        if(stack.size()==0) throw new CalculatorException("не хватает операндов");
        return Double.parseDouble(stack.pop());
    }

    private Double calc(Double a, Double b, char c) throws CalculatorException {
        Double res = Double.valueOf(0);
        switch (c){
            case '+' : res=a+b; break;
            case '-' : res=a-b; break;
            case '*' : res=a*b; break;
            case '/' : res=a/b; break;
            default: throw new CalculatorException("лишние скобки");
        }
        return res;
    }

    private void pushSymbolsFromStackToOut() throws CalculatorException {
        String s=stack.lastElement();
        while (!(s.equals("("))||stack.isEmpty()){pushFromStackToOut();
            if (stack.size()==0) throw new CalculatorException("не хватает скобок");
            s=stack.lastElement();}
        if (stack.peek().equals("(")){stack.pop();}
    }

    private void pushAllSymbolsFromStackToOut(){
        while (!(stack.size()==0)){pushFromStackToOut();}
    }

    private void operatorProcessing(Character c){
        String s;
        if (stack.size()==0) {s=null;}
        else {s = stack.lastElement();}
        while (!(s==null)&&(getPriority(c)<=getPriority(s.charAt(0)))){
            pushFromStackToOut();
            if (stack.size()==0){s=null;}
            else{
                s = stack.lastElement();}
        }
    }

    private void pushNumber(){
        if (!(number.equals(""))){
            out.push(number);
            number="";
        }
    }

    private void reverse(){
        Stack<String> res = new Stack<String>();
        while (!(out.size() == 0)) {res.push(out.pop());}
        out=res;
    }

    private void pushFromExpressionToStack(){
        stack.push(expression.pop().toString());
    }

    private void pushFromStackToOut(){
        out.push(stack.pop());
    }

    private char classificateSymbol(char c){
        char res='e';
        if (isDigit(c)){res='d';}
        if (isDelimeter(c)){res=' ';}
        if (isOperator(c)){res='o';}
        if (c=='('){res='(';}
        if (c==')'){res=')';}
        return res;
    }

    private byte getPriority(char c)
    {
        switch (c)
        {
            case '(': return 0;
            case ')': return 1;
            case '+': return 2;
            case '-': return 2;
            case '*': return 4;
            case '/': return 4;
            case '^': return 5;
            default:  return 6;
        }
    }

    private boolean isOperator(char c)
    {
        return "+-/*()".contains(Character.toString(c));
    }

    private boolean isDelimeter(char c)
    {
        return ((c==' '));
    }

    private boolean isDigit(char c){
        return "0123456789.".contains(Character.toString(c));
    }

    private void stringToStack(String expr){
        Stack<Character> ex = new Stack<Character>();
        for (int i=0; i<expr.length(); i++){
            ex.push(expr.charAt(i));        }
        for (int i=0; i<expr.length(); i++){
            expression.push(ex.pop());        }
    }

    private Stack<String> convertStringToStack(String string){
        Stack<String> ex = new Stack<String>();
        for (int i = 0; i < string.split(" ").length; i++) {
            ex.push(string.split(" ")[i]);
        }
        return ex;
    }

    private String stackToString(Stack<String> stack){
        StringBuilder s = new StringBuilder();
        for (int i=0; i<stack.size(); i++){
            s.append(stack.get(i));
            s.append(" ");
        }
        return  s.toString();
    }
}

