package polish;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class PolishConvertor {
    private List<String> result = new ArrayList<>();
    private Stack<Character> stack = new Stack<>();
    private Set<Character> operands = new HashSet<>(Arrays.asList('+', '-', '*', ':', '^'));
    private List<Character> number = new ArrayList<>();

    public List<String> convert(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return Collections.emptyList();
        }
        char[] characters = expression.toCharArray();
        for (char c : characters) {
            //Если символ является числом, добавляем его к выходной строке.
            if (isDigit(c)) {
                processDigit(c, number);
                continue;
            }
            if (isOperation(c)) {
                collectNumberAndPushToResult(number, result);
                processOperation(c, stack, result);
                continue;
            }
            if (isBracket(c)) {
                collectNumberAndPushToResult(number, result);
                processBracket(c, stack, result);
            }
        }
        return Collections.emptyList();
    }

    void processOperation(char symbol, Stack<Character> stack, List<String> result) {
    }

    void processBracket(char symbol, Stack<Character> stack, List<String> result) {
    }

    void collectNumberAndPushToResult(List<Character> number, List<String> result) {
        if (number == null || number.isEmpty()) {
            return;
        }
        result.add(number.stream().map(String::valueOf).collect(Collectors.joining()));
    }

    void processDigit(char symbol, List<Character> number) {
        number.add(symbol);
    }

    private boolean isBracket(char symbol) {
        return '(' == symbol || ')' == symbol;
    }

    private boolean isOperation(char symbol) {
        return operands.contains(symbol);
    }

    private boolean isDigit(char symbol) {
        return Character.isDigit(symbol);
    }

}
