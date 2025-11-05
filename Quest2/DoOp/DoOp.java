public class DoOp {
    public static String operate(String[] args) {
		if (args.length != 3) return "Error";
        int left = Integer.parseInt(args[0]);
        int right = Integer.parseInt(args[2]);
        String op = args[1];
        switch (op) {
            case "+":
                return String.valueOf(left + right);
            case "-":
                return String.valueOf(left - right);
            case "*":
                return String.valueOf(left * right);
            case "/":
                if (right == 0) return "Error";
                return String.valueOf(left / right);
            case "%":
                if (right == 0) return "Error";
                return String.valueOf(left % right);
            default:
                return "Error";
        }
    }
}
