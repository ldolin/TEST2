package learner0;

public class learner1 {
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String a="hello";
	  String c="world";
	  System.out.println(System.identityHashCode(a));
	  System.out.println(System.identityHashCode(c));
	  a=c;
	  a="123";
	  System.out.println(System.identityHashCode(a));
	  System.out.println(System.identityHashCode(c));
     }

}
