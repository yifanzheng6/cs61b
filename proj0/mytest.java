public class mytest {
	public static void main(String[] args){
		String file = "./data/planets.txt";
		In in = new In(file);
		in.readInt();
		in.readDouble();
		while(!in.isEmpty()) {
			System.out.println(in.readDouble());
			System.out.println(in.readDouble());
			System.out.println(in.readDouble());
			System.out.println(in.readDouble());
			System.out.println(in.readDouble());
			System.out.println(in.readString());

		}
	}
}
