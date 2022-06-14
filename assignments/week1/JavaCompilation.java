public class JavaCompilation{


	public static void main(String[] args) {

		if(args.length == 1) {
			System.out.println((int)(new java.util.Random().nextDouble()*10));
		} else {
			for(int i = 0; i < Integer.parseInt(args[0]); i++) {
				System.out.println(args[1]);
			}
		}
	}

}
