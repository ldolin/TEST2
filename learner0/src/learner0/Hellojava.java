package learner0;

public class Hellojava {
    private static String say="我要学会你" ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println("hellojava"+say);
     int N;
     for(N=99;N>=0;N--){
    	 System.out.println(N+" bottles of beer on the wall,"+N+" bottles of beer.");
    	 System.out.println("Take one down.");
    	 System.out.println("Pass it around.");    	 
    	 if(N==0)
    		 System.out.println("No more bottles of beer on the wall.");
    	 else
    		 System.out.println(N-1+" botttles of beer on the wall.");
     }
	}

}
