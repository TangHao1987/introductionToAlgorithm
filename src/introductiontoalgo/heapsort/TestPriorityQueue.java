package introductiontoalgo.heapsort;

public class TestPriorityQueue {
	public static void main(String [] args){
		PriorityQueue pq = new PriorityQueue(10);
		
		pq.insert(10);
		pq.insert(2);
		pq.insert(23);
		pq.insert(54);
		pq.insert(14);
		
		pq.printPriorityQueue();
		System.out.println("Start popup below:");
		System.out.print(pq.popMaximum() + " ");
		System.out.print(pq.popMaximum() + " ");
		System.out.print(pq.popMaximum() + " ");
		System.out.print(pq.popMaximum() + " ");
		System.out.print(pq.popMaximum() + " ");
	} 
}
