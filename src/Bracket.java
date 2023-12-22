import java.util.Stack;

/**
 * Correct brackets
 *
 * @Author Tretyakov Alexandr
 */

public class Bracket {
    public static void main(String[] args) {
        String in = "(423(rewr(ret[gfd[gfd{df{gd}gdf}df]gdf]s)gf)gfd)";
        String regexOpen = "[\\{\\[\\(]";
        String regexClose = "[\\}\\]\\)]";
        Stack<String> stack = new Stack<>();
        stack.push(null);
        for (int i=0; i < in.length(); i++) {
            String s = in.substring(i, i + 1);
            if (s.matches(regexOpen)) {
                stack.push(s);
                System.out.println(s);
            }
            if (s.matches(regexClose)) {
                System.out.println("close " + s);
                System.out.println("stack" + stack.peek());
                if (stack.peek() == null) throw new RuntimeException("wrong bracket in position " + i);
                if (stack.peek().equals(rotate(s))) stack.pop();
                else System.out.println("Неправильный символ " + s + " in position " + i);

            }
        }
        System.out.println(stack.peek());
        if (stack.peek() == null) System.out.println("All right");
        else System.out.println("Excess bracket " + stack.peek());
    }

    public static String rotate(String closeBracket) {
        String s = "";
        switch (closeBracket) {
            case ")" : s = "("; break;
            case "}" : s = "{"; break;
            case "]" : s = "["; break;
        }
        return s;

    }

}
