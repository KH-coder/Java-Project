public class StackFullException extends RuntimeException {
	public StackFullException() {
		super("Stack is full.");
	}
}