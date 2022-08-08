package estruturas;


import java.util.NoSuchElementException;


public class LinkedList {

	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void addLast(int valor) {
		Node newNode = new Node(valor);
		
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			newNode.prev = tail;
			this.tail = newNode;
		}
		
		this.size += 1;
	}
	
	public void addFirst(int valor) {
		Node newNode = new Node(valor);
		
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		
		this.size += 1;
	}
	
	public void add(int index, int valor) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node newNode = new Node(valor);
		
		if (index == 0) {
			this.addFirst(valor);
		} else if (index == size - 1) {
			this.addLast(valor);
		} else {
			Node aux = this.head;
			
			for (int i = 0; i < index - 1; i++) {
				aux = aux.next;
			}
			
			newNode.next = aux.next;
			aux.next = newNode;
			newNode.next.prev = newNode;
			newNode.prev = aux;
			
			this.size += 1;
		}
	}
	
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node aux = this.head;
		
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		
		return aux.valor;
	}
	
	public int indexOf(int valor) {
		Node aux = this.head;
		int index = 0;
		
		while (aux != null) {
			if (aux.valor == valor) {
				return index;
			}
			
			aux = aux.next;
			index += 1;
		}
		
		return -1;
	}
	
	public boolean contains(int valor) {
		return indexOf(valor) != -1;
	}
	
	public int size() {
		return this.size;
	}
	
	public int getFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return this.head.valor;
	}
	
	public int getLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return this.tail.valor;
	}
	
	public int removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		int valor = this.head.valor;
		
		if (this.head.next == null) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		
		this.size -= 1;
		
		return valor;
	}
	
	public int removeLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		int valor = this.tail.valor;
		
		if (this.head.next == null) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		
		this.size -= 1;
		
		return valor;
	}
	
	public int removeByIndex(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		}
		
		Node aux = this.head;
		
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		
		aux.prev.next = aux.next;
		aux.next.prev = aux.prev;
		this.size -= 1;
		
		return aux.valor;
	}
	
	public boolean removeByValue(int valor) {
		Node aux = this.head;
		
		for (int i = 0; i < this.size; i++) {
			if (aux.valor == valor) {
				if (i == 0) {
					removeFirst();
				} else if (i == size - 1) {
					removeLast();
				} else {
					aux.prev.next = aux.next;
					aux.next.prev = aux.prev;
					this.size -= 1;
				}
				
				return true;
			}
			
			aux = aux.next;
		}
		
		return false;
	}
	
}


class Node {
	
	int valor;
	Node prev;
	Node next;
	
	public Node(int valor) {
		this.valor = valor;
		this.prev = null;
		this.next = null;
	}
	
}