public class OperationFactory {
	public static Operation createOperation(String op) {
		Operation operation=null;
		switch (op) {
		case "+":
			operation=new OperationAdd();
			break;
		case "-":
			operation=new OperationSub();
			break;
		case "*":
			operation=new OperationMul();
			break;
		case "/":
			operation=new OperationDiv();
			break;
		default:
			break;
		}
		return operation;
	}
}