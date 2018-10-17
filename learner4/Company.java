import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Random;

import java.util.Scanner;





public class Company {

	public static int num_Employee = 10;//员工人数

	public static int num_Manager = 5;//经理人数

	public static int num_Shareholder = 3;//股东人数

	public int money = 2000000;//总营业额

	public static double  profit = 2000000;//利润

	public static void main(String[] args) {

		Random random=new Random(System.currentTimeMillis());

		String[] Surname= {"赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许",};

		//员工

		Employee [] employee = new Employee[10];

		//List<Employee> list = new ArrayList<>();

		for(int i = 0;i < num_Employee;i++) {

			employee[i] = new Employee();

			//list.add(employee[i]);

			int index=random.nextInt(Surname.length-1);

			employee[i].name = Surname[index]; //获得一个随机的姓氏

			if(random.nextBoolean()){//从常用字中选取一个或两个字作为名

				employee[i].name+=getChinese()+getChinese();

			}

			else {

				employee[i].name+=getChinese();

			}

			employee[i].birthday = randomDate("1980-01-01", "1980-12-30");

			employee[i].salay = (int) (Math.random()* 3000+3000);

			System.out.println("姓名："+employee[i].name+"\t"+"出生日期："

					+employee[i].birthday+"\t"+"薪水："+employee[i].salay);

		}

		System.out.println("员工数据初始化完毕!");

		//经理

		Manager [] manager = new Manager[5];

		for(int i = 0;i < num_Manager;i++) {

			manager[i] = new Manager();

			int index=random.nextInt(Surname.length-1);

			manager[i].name = Surname[index]; //获得一个随机的姓氏

			if(random.nextBoolean()){//从常用字中选取一个或两个字作为名

				manager[i].name+=getChinese()+getChinese();

			}

			else {

				manager[i].name+=getChinese();

			}

			manager[i].birthday = randomDate("1980-01-01", "1980-12-30");

			manager[i].salay = (int) (Math.random()* 6000+3000);

			manager[i].bonus = (int) (Math.random()* 2000+1000);

			System.out.println("姓名："+manager[i].name+"\t"+"出生日期："

					+manager[i].birthday+"\t"+"薪水："+manager[i].salay+"\t"+"奖金："+manager[i].bonus);

		}	

		System.out.println("经理数据初始化完毕!");

		//股东

		Shareholder [] shareholder = new Shareholder[3];

		for(int i = 0;i < num_Shareholder;i++) {

			shareholder[i] = new Shareholder();

		}

		shareholder[0].share = 50;

		shareholder[1].share = 30;

		shareholder[2].share = 20;

		for(int j = 0;j < num_Employee;j++) {

			profit = profit - employee[j].salay;

		}

		for(int j = 0;j < num_Manager;j++) {

			profit = profit - manager[j].salay- manager[j].bonus;

		}

		double a[] = new double[3];

		a[0] = 0.5*profit;

		a[1] = 0.3*profit;

		a[2] = 0.2*profit;

		for(int i = 0;i < num_Shareholder;i++) {

			int index=random.nextInt(Surname.length-1);

			shareholder[i].name = Surname[index]; //获得一个随机的姓氏

			if(random.nextBoolean()){//从常用字中选取一个或两个字作为名

				shareholder[i].name+=getChinese()+getChinese();

			}

			else {

				shareholder[i].name+=getChinese();

			}

			shareholder[i].birthday = randomDate("1980-01-01", "1980-12-30");

			System.out.println("姓名："+shareholder[i].name+"\t"+"出生日期："

					+shareholder[i].birthday+"\t"+"股份："+shareholder[i].share+"\t"+"分红："+a[i]);

		}

		System.out.println("股东信息初始化完毕!");

		System.out.println("请输入需要发工资的月份：");

		Scanner scanner = new Scanner(System.in);

		int month = scanner.nextInt();

		for (int i=0;i<10;i++) {

            if(employee[i].birthday.getMonth() == (month-1)) {

            	System.out.println("需要给"+employee[i].name+"员工生日礼物");

            }

		}

		for (int i=0;i<10;i++) {

            if(manager[i].birthday.getMonth() == (month-1)) {

            	System.out.println("需要给"+manager[i].name+"经理生日礼物");

            }

		}

	}

	

	private static Date randomDate(String beginDate, String endDate) {		

		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			Date start = format.parse(beginDate);// 构造开始日期

			Date end = format.parse(endDate);// 构造结束日期

			// getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

			if (start.getTime() >= end.getTime()) {

				return null;

			}

			long date = random(start.getTime(), end.getTime());

			return new Date(date);

		} 

		catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	

	private static long random(long begin, long end) {

		long rtn = begin + (long) (Math.random() * (end - begin));

		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值

		if (rtn == begin || rtn == end) {

			return random(begin, end);

		}

		return rtn;

	}

	

	public static String getChinese() {

		String str = null;

		int highPos, lowPos;

		Random random = new Random();

		highPos = (176 + Math.abs(random.nextInt(71)));//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字

		random=new Random();

		lowPos = 161 + Math.abs(random.nextInt(94));//位码，0xA0打头，范围第1~94列

		byte[] bArr = new byte[2];

		bArr[0] = (new Integer(highPos)).byteValue();

		bArr[1] = (new Integer(lowPos)).byteValue();

		try {

			str = new String(bArr, "GB2312");	//区位码组合成汉字

		}

		catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

		return str;

	}

}



class Employee{//父类

	public  String name;		//姓名

	public  int salay;		//工资

	public  Date birthday;	//生日

	public Employee(){

		name = "张三";

		salay = 5000;

		birthday = new Date();

	}

}





class Manager extends Employee{//经理

	public  int bonus;//奖金

	public Manager() {

		bonus = (int)(Math.random()*1000+1000);

	}

}



class Shareholder extends Employee{//股东

	public	 int share; 

	public Shareholder() {

		share = 0;

	}

}