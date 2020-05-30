import java.util.*;
class FirstUniqueInteger{
	public static int firstUniqueInteger(Vector<Integer> vec)
	{
		Map<Integer,Integer> freq = new HashMap<>();
		for(int i = 0;i < vec.size();i++){
			freq.put(vec.get(i), freq.getOrDefault(vec.get(i), 0) + 1);
		}
		for(int i = 0;i < vec.size();i++){
			if(freq.get(vec.get(i)) == 1)
				return vec.get(i);
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Vector<Integer> vec=new Vector<Integer>();
		for(int i=0;i<n;i++)
			vec.add(sc.nextInt());
		System.out.println(firstUniqueInteger(vec));
	}
}
