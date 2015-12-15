import java.util.HashMap;


public class Cache {
	
	
	HashMap<Integer, Node> hmap = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;
	int size;
	
	public Cache(int size){
		this.size = size;
	}
	
	int get(int key){
		if(hmap.containsKey(key)){
			Node n = hmap.get(key);
			delete(n);
			setAtHead(n);
			return n.value;
		}
		else 
			return -1;
		}
	
	void delete(Node n){
		if(n.prev!=null)
			n.prev.next=n.next;
		else
			head= n.next;
		if(n.next!=null)
			n.next.prev=n.prev;
		else
			end = n.prev;
	}
	
	void setAtHead(Node n){
		n.next = head;
		n.prev = null;
		
		if(head!=null)
			head.prev = n;
		head = n;
		
		if(end == null)
			end = head;
	}
	
	void set(int key, int value){
		if(hmap.containsKey(key)){
			Node n = hmap.get(key);
			n.value = value;
			delete(n);
			setAtHead(n);
		}
		else{
			Node newN = new Node(key,value);
			if(hmap.size()>=size){
				delete(end);
				hmap.remove(end.key);
			}
			setAtHead(newN);
			hmap.put(key, newN);
			}
	}
	
	void print(){
		Node travel = head;
		while(travel!=null){
			System.out.println(travel.value);
			travel = travel.next;
		}
	}
	
}
