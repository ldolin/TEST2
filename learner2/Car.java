public class Car {
	
    String CarName;
    String Tank;
    String OilComSumption;
    public Car(String a,String b,String c){
    	CarName=a;
    	Tank=b;
    	OilComSumption=c;
	}
    public String GetCarName(){
    	return CarName;
    }
    public String GetTank(){
    	return Tank;
    }
    public String GetOilComSumption(){
    	return OilComSumption;
    }
    
    /*public void AddGas(){
    	System.out.println("it can add oil 100 L");
    }
    public void CarRun(){
    	System.out.println("if it full of oil ,it can run 500km ");
    }
    */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Mycar[]=new String[]{"beichi","50L","1 L/km","baoma","60L","2 L/km"};
	    System.out.println("第一辆车是 "+Mycar[0]+" "+Mycar[1]+" "+Mycar[2]);
	    System.out.println("第二辆车是 "+Mycar[3]+" "+Mycar[4]+" "+Mycar[5]);
	    
	}

}