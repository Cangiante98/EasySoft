package residenza;

public class Node {
	
	private int value;
	private Node next; 
	
	public Node() {
		value =0;
		next = null;
	}
	public Node(int value) {
		this.value =value;
		next = null;
	}
	public Node(int value, Node node) {
		this.value =value;
		this.next = node;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + ", next=" + next + "]";
	}
	

}
