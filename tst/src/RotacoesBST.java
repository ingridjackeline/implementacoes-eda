import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


class RotacoesBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		
		AVL arvore = new AVL();
		int raiz = Integer.parseInt(sequencia[0]);
		
		for (String elemento : sequencia) {
			arvore.recursiveAdd(Integer.parseInt(elemento));
		}
		
		if (raiz == arvore.getRootValue()) {
			System.out.println("balanceada");
		}
	}

}


class AVL {

	private Node root;
	private int size;
	
	public int getRootValue() {
		return this.root.value;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void add(int element) {
		this.size += 1;
		
		if (this.isEmpty()) {
			this.root = new Node(element);
		} else {
			Node aux = this.root;
			
			while (aux != null) {
				if (element < aux.value) {
					if (aux.left == null) {
						Node newNode = new Node(element);
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}	
					aux = aux.left;
				} else {
					if (aux.right == null) {
						Node newNode = new Node(element);
						aux.right = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.right;
				}
				
				this.rebalance(aux, element);
			}
		}
	}
	
	public void recursiveAdd(int element) {
		if (this.isEmpty()) {
			this.root = new Node(element);
		} else {
			this.recursiveAdd(this.root, element);
		}
		
		this.size += 1;
	}
	
	private void recursiveAdd(Node node, int element) {
		if (element < node.value) {
			if (node.left == null) {
				Node newNode = new Node(element);
				node.left = newNode;
				newNode.parent = node;
				return;
			}
			this.recursiveAdd(node.left, element);
		} else {
			if (node.right == null) {
				Node newNode = new Node(element);
				node.right = newNode;
				newNode.parent = node;
				return;
			}
			this.recursiveAdd(node.right, element);
		}
		
		this.rebalance(node, element);
	}
	
	public Node search(int element) {
		Node aux = this.root;
		
		while (aux != null) {
			if (aux.value == element) {
				return aux;
			} else if (aux.value > element) {
				aux = aux.left;
			} else {
				aux = aux.right;
			}
		}
		
		return null;
	}
	
	public Node recursiveSearch(int element) {
		return this.recursiveSearch(this.root, element);
	}
	
	private Node recursiveSearch(Node node, int element) {
		if (node == null ) {
			return null;
		}
		
		if (node.value == element) {
			return node;
		} else if (node.value > element) {
			return this.recursiveSearch(node.left, element);
		} else {
			return this.recursiveSearch(node.right, element); 
		}
	}
	
	public Node min() {
		if (this.isEmpty()) {
			return null;
		}
		
		return this.min(this.root);
	}
	
	private Node min(Node node) {
		if (node.left == null) {
			return node;
		} else {
			return this.min(node.left);
		}
	}
	
	public Node max() {
		if (this.isEmpty()) {
			return null;
		}
		
		Node node = this.root;
		
		while (node.right != null) {
			node = node.right;
		}
		
		return node;
	}
	
	private Node max(Node node) {
		if (node.right == null) {
			return node;
		} else {
			return this.max(node.right);
		}
	}
	
	public Node sucessor(Node node) {
		if (node == null) {
			return null;
		}
		
		if (node.right != null) {
			return this.min(node.right);
		} else {
			Node aux = node.parent;
			
			while (aux != null && aux.value < node.value) {
				aux = aux.parent;
			}
			
			return aux;
		}
	}
	
	public Node predecessor(Node node) {
		if (node == null) {
			return null;
		}
		
		if (node.left != null) {
			return this.max(node.left);
		} else {
			Node aux = node.parent;
			
			while (aux != null && aux.value > node.value) {
				aux = aux.parent;
			}
			
			return aux;
		}
	}
	
	public int height() {
		return this.height(this.root);
	}
	
	private int height(Node node) {
		if (node == null) {
			return -1;
		} else {
			return 1 + Math.max(this.height(node.left), this.height(node.right));
		}
	}
	
	public void remove(int element) {
		Node node = this.search(element);
		
		if (node != null) {
			this.remove(node);
			this.size -= 1;
		}
	}
	
	private void remove(Node node) {
		if (node.isLeaf() ) {
			if (node == this.root) {
				this.root = null;
			} else {
				if (node.value < node.parent.value) {
					node.parent.left = null;
				} else {
					node.parent.right = null;
				}
			}
		} else if (node.hasOnlyLeftChild()) {
			if (node == this.root) {
				this.root = node.left;
				this.root.parent = null;
			} else {
				node.left.parent = node.parent;
				if (node.value < node.parent.value) {
					node.parent.left = node.left;
				} else {
					node.parent.right = node.left;
				}
			}
		} else if (node.hasOnlyRightChild()) {
			if (node == this.root) {
				this.root = node.right;
				this.root.parent = null;
			} else {
				node.right.parent = node.parent;
				if (node.value < node.parent.value) {
					node.parent.left = node.right;
				} else {
					node.parent.right = node.right;
				}
			}
		} else {
			Node sucessor = this.sucessor(node);
			node.value = sucessor.value;
			this.remove(sucessor);
		}
	}
	
	private int calculateBalance(Node node) {
		return this.height(node.left) - this.height(node.right);
	}
	
	private void rebalance(Node node, int element) {
		int balance = this.calculateBalance(node);
		
		if (balance > 1 && element < node.left.value) {
			this.rotateRight(node);
		} else if (balance < -1 && element > node.right.value) {
			this.rotateLeft(node);
		} else if (balance > 1 && element > node.left.value) {
			this.rotateLeft(node.left);
			this.rotateRight(node);
		} else if (balance < -1 && element < node.right.value) {
			this.rotateRight(node.right);
			this.rotateLeft(node);
		}
	}
	
	private void rotateRight(Node node1) {
		Node node2 = node1.left;
		
		if (node1.value == this.root.value) {
			this.root = node2;
		}
		
		node1.left = node2.right;
		node2.right = node1;
		node2.parent = node1.parent;
		node1.parent = node2;
		
		if (node1.left != null) {
			node1.left.parent = node1;
		}
		
		if (node2.parent != null) {
			if (node2.parent.left == node1) {
				node2.parent.left = node2;
			} else {
				node2.parent.right = node2;
			}
		}
		
		System.out.println("rot_dir(" + node1.value + ")");
		System.out.println(Arrays.toString(this.preOrder().split(" ")));
	}
	
	private void rotateLeft(Node node1) {
		Node node2 = node1.right;
		
		if (node1.value == this.root.value) {
			this.root = node2;
		}
		
		node1.right = node2.left;
		node2.left = node1;
		node2.parent = node1.parent;
		node1.parent = node2;
		
		if (node1.right != null) {
			node1.right.parent = node1;
		}
		
		if (node2.parent != null) {
			if (node2.parent.left == node1) {
				node2.parent.left = node2;
			} else {
				node2.parent.right = node2;
			}
		}
		
		System.out.println("rot_esq(" + node1.value + ")");
		System.out.println(Arrays.toString(this.preOrder().split(" ")));
	}
	
	public String preOrder() {
		return this.preOrder(this.root);
	}
	
	private String preOrder(Node node) {
		if (node != null) {
			return node.value + " " + this.preOrder(node.left) + this.preOrder(node.right);
		} else {
			return "";
		}
	}
	
	public void inOrder() {
		this.inOrder(this.root);
	}
	
	private void inOrder(Node node) {
		if (node != null) {
			this.inOrder(node.left);
			System.out.println(node.value);
			this.inOrder(node.right);
		}
	}
	
	public void posOrder() {
		this.posOrder(this.root);
	}
	
	private void posOrder(Node node) {
		if (node != null) {
			this.posOrder(node.left);
			this.posOrder(node.right);
			System.out.println(node.value);
		}
	}
	
	public ArrayList<Integer> bfs() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Node> queue = new LinkedList<Node>();
		
		if(!this.isEmpty()) {
			queue.addLast(this.root);
			
			while (!queue.isEmpty()) {
				Node current = queue.removeFirst();
				list.add(current.value);
				
				if (current.left != null) {
					queue.addLast(current.left);
				}
				if (current.right != null) {
					queue.addLast(current.right);
				}
			}
		}
		
		return list;
	}
	
	public int size() {
		return this.size;
	}
	
}


class Node {
	
	int value;
	Node left;
	Node right;
	Node parent;
	
	public Node(int v) {
		this.value = v;
	}
	
	public boolean hasOnlyLeftChild() {
		return (this.left != null && this.right == null);
	}
	
	public boolean hasOnlyRightChild() {
		return (this.left == null && this.right != null);
	}
	
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	
}