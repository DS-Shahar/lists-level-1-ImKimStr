public class Main {
	
	public static void printList( Node<Integer> list) {
		Node<Integer> n=list;
		while (n!= null) {
			System.out.println(n.getValue()); 
			n=n.getNext(); 
		} 
	}
	
	public static void printListEven( Node<Integer> list) {
		Node<Integer> n=list; 
		while (n!= null) { 
			if (n.getValue()%2 == 0) 
				System.out.println(n.getValue()); 
			n=n.getNext();
		}
	} 
	
	public static void printListRecursion( Node<Integer> list) { 
		if (list == null)
			return; 
		System.out.println(list.getValue()); 
		printListRecursion(list.getNext()); 
	} 
	
	public static void printListRecursionReverse( Node<Integer> list) { 
		if (list == null) 
			return; 
		printListRecursionReverse(list.getNext()); 
		System.out.println(list.getValue()); 
	} 
	
	public static boolean isFound(Node<Integer> list, int n) { 
		while (list != null) { 
			if (list.getValue()==n) 
				return true; 
			list =list.getNext(); 
		} 
		return false; 
	} 
	
	public static Node<Integer> deleteNode(Node<Integer> list, int n) { 
		Node<Integer> tmp = list; 
		if (list == null) 
			return null; 
		if (list.getValue() == n) 
			return list.getNext(); 
		while (list != null && list.getNext()!=null ) { 
			if (list.getNext().getValue()==n) { 
				list.setNext(list.getNext().getNext()); 
				return tmp; 
			} 
			list =list.getNext(); 
		} 
		return tmp; 
	} 
	
	public static Node<Integer> buildList(int[] a) { 
		Node<Integer> h = new Node<Integer>(-1); 
		Node<Integer> p = h; 
		Node<Integer> x; 
		for (int i = 0; i < a.length; i++) { 
			x = new Node<Integer>(a[i]); 
			p.setNext(x); 
			p = p.getNext(); 
		} 
		return h.getNext(); 
	} 
	
	public static Node<Integer> deleteNodeX(Node<Integer> list ,int x){ 
		Node<Integer> tmp = list; 
		for (int i=1; i<x-1 && list !=null; i++) { 
			list = list.getNext(); 
		} 
		if (list != null) 
			list.setNext(list.getNext().getNext()); 
		return tmp; 
	} 

public static boolean ex5(Node <Integer> h, int x) {
		Node <Integer> p = h;
		while(p != null) {
			if (p.getValue() == x) {
				return true;
			}
			p = p.getNext();
		}
		return false;
	}

// סעיף 8 משתמשת בפעולה 5 כעזר

	public static boolean ex8(Node <Integer> n, Node <Integer> x) {
		if (n == null) {
			return true;
		}
		if  (ex5(x,n.getValue()) == false) {
			return false;
		}
		return ex8(n.getNext(),x);
	}


	public static void ex9(Node<Integer> L1, Node<Integer> L2) {
		while (L1 != null) {
			Node<Integer> p = L2; 
			while (p != null) {
				if (p.getValue() == L2.getValue())
					System.out.println(p.getValue());
				p = p.getNext();
			}
			L1 = L1.getNext();
		}
	}

	
	public static Node<Integer> ex10(Node<Integer> L1, Node<Integer> L2){
		Node<Integer> head = new Node<Integer>(null); 
		Node<Integer> current = head;
		while (L1 != null) {
			Node<Integer> p = L2; 
			while (p != null) {
				if (p.getValue().equals(L1.getValue())) {
					Node<Integer> c = new Node<Integer>(p.getValue()); 
					current.setNext(c);
					current = c;
				}
				p = p.getNext();	
			}
			L1 = L1.getNext();
		}
		return head.getNext();
	}
	
	
	public static void main(String[] args) {
		int[] arr = {0,3,6,5,6,7,90};
		int[] arr1 = {1,5,90,34,6};

		Node<Integer> L1 = buildList(arr1); 		
		Node<Integer> L2 = buildList(arr); 		

		ex9(L1, L2);
		System.out.println(ex10(L1, L2));
	}
}
