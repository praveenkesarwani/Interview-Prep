import java.util.*;

class FrequentWords{
	public static Vector<String> frequentWords(Vector<String> words,int k)
	{
        //Count the frequency of each word, and store it in a hashmap.
		Map<String,Integer> freq = new HashMap<>();
        for(String word:words)
            freq.put(word,freq.getOrDefault(word, 0) + 1);
            
        PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1,w2) ->freq.get(w1).equals(freq.get(w2))?
            w2.compareTo(w1):freq.get(w1) - freq.get(w2));
        
        for(String word:freq.keySet()){
            heap.offer(word);
            if(heap.size() > k)
                heap.poll();
        }
        
        Vector<String> res = new Vector<>();
        while(!heap.isEmpty()){
            res.add(heap.poll());
        }
        
        Collections.reverse(res);
        return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Vector<String> vec=new Vector<String>();
		for(int i=0;i<n;i++)
			vec.add(sc.next());
		int k=sc.nextInt();
		Vector<String> ans = frequentWords(vec, k);
		for(int i=0;i<k;i++)
			System.out.println(ans.get(i));
	}
}
