public class LinkedStack implements Stack {
	private LinkedList  sll;
	public LinkedStack(Comparator comparator) {
		sll = new LinkedList(comparator);
	}
	public int size() {
		return sll.getCount();
	}
	public boolean isEmpty() {
		return sll.isEmpty();
	}
	public void push(Object item) throws StackFullException {
		sll.addToHead(item);
	}
	public Object pop() throws StackEmptyException {
		try {
			Object item = sll.removeFromHead();
			return item;
		}
		catch (EmptyListException e) {
			throw new StackEmptyException();
		}
	}

	public Object top() throws StackEmptyException {
		try {
			Object item = sll.removeFromHead();
			sll.addToHead(item);
			return item;
		}
		catch (EmptyListException e) {
			throw new StackEmptyException();
		}
	}
	
	// A function returning the instance of LinkedList
	public LinkedList GetLinkedListInstance() {
		return sll;
	}
	
	public String toString() {
		return sll.toString();
	}
}
