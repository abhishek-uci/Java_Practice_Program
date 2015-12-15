
public class Hashmap {
	// size= 10 for now
	private Entry[] array;
	
	public Hashmap(){
		this.array = new Entry[10];
	}
	
	public void put(String key, int value){
		int hash = key.hashCode();
		int index = hash % 10;			
		
		if(array[index] == null){
			array[index] = new Entry(key,value);
		}		
		else{
			Entry e = array[index];
			if(e.key.equals(key))
				e.value=value;
			else{
				while(e.next!=null){
					if(e.key.equals(key))
						e.value = value;
					e=e.next;
				}
				e.next = new Entry(key, value);
			}
		}
	}
	
	public int get(String key){
		int hash = key.hashCode();
		int index = hash % 10;
		Entry e = array[index];
		
		while(e!=null){
			if(e.key.equals(key))
				return e.value;
			e = e.next;
			
		}
		 return (Integer) null;
		
	}
	
	public static void main(String[] args){
		
		Hashmap h = new Hashmap();
		h.put("a",1);
		h.put("b",2);
		System.out.println(h.get("b"));
		h.put("b",3);
		System.out.println(h.get("b"));
		h.put("c",4);
		h.put("k",10);
		
		
		System.out.println(h.get("c"));
		System.out.println(h.get("a"));
		System.out.println(h.get("k"));
	}
}
