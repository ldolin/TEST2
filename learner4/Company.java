import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Random;

import java.util.Scanner;





public class Company {

	public static int num_Employee = 10;//Ա������

	public static int num_Manager = 5;//��������

	public static int num_Shareholder = 3;//�ɶ�����

	public int money = 2000000;//��Ӫҵ��

	public static double  profit = 2000000;//����

	public static void main(String[] args) {

		Random random=new Random(System.currentTimeMillis());

		String[] Surname= {"��","Ǯ","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��","��","��",};

		//Ա��

		Employee [] employee = new Employee[10];

		//List<Employee> list = new ArrayList<>();

		for(int i = 0;i < num_Employee;i++) {

			employee[i] = new Employee();

			//list.add(employee[i]);

			int index=random.nextInt(Surname.length-1);

			employee[i].name = Surname[index]; //���һ�����������

			if(random.nextBoolean()){//�ӳ�������ѡȡһ������������Ϊ��

				employee[i].name+=getChinese()+getChinese();

			}

			else {

				employee[i].name+=getChinese();

			}

			employee[i].birthday = randomDate("1980-01-01", "1980-12-30");

			employee[i].salay = (int) (Math.random()* 3000+3000);

			System.out.println("������"+employee[i].name+"\t"+"�������ڣ�"

					+employee[i].birthday+"\t"+"нˮ��"+employee[i].salay);

		}

		System.out.println("Ա�����ݳ�ʼ�����!");

		//����

		Manager [] manager = new Manager[5];

		for(int i = 0;i < num_Manager;i++) {

			manager[i] = new Manager();

			int index=random.nextInt(Surname.length-1);

			manager[i].name = Surname[index]; //���һ�����������

			if(random.nextBoolean()){//�ӳ�������ѡȡһ������������Ϊ��

				manager[i].name+=getChinese()+getChinese();

			}

			else {

				manager[i].name+=getChinese();

			}

			manager[i].birthday = randomDate("1980-01-01", "1980-12-30");

			manager[i].salay = (int) (Math.random()* 6000+3000);

			manager[i].bonus = (int) (Math.random()* 2000+1000);

			System.out.println("������"+manager[i].name+"\t"+"�������ڣ�"

					+manager[i].birthday+"\t"+"нˮ��"+manager[i].salay+"\t"+"����"+manager[i].bonus);

		}	

		System.out.println("�������ݳ�ʼ�����!");

		//�ɶ�

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

			shareholder[i].name = Surname[index]; //���һ�����������

			if(random.nextBoolean()){//�ӳ�������ѡȡһ������������Ϊ��

				shareholder[i].name+=getChinese()+getChinese();

			}

			else {

				shareholder[i].name+=getChinese();

			}

			shareholder[i].birthday = randomDate("1980-01-01", "1980-12-30");

			System.out.println("������"+shareholder[i].name+"\t"+"�������ڣ�"

					+shareholder[i].birthday+"\t"+"�ɷݣ�"+shareholder[i].share+"\t"+"�ֺ죺"+a[i]);

		}

		System.out.println("�ɶ���Ϣ��ʼ�����!");

		System.out.println("��������Ҫ�����ʵ��·ݣ�");

		Scanner scanner = new Scanner(System.in);

		int month = scanner.nextInt();

		for (int i=0;i<10;i++) {

            if(employee[i].birthday.getMonth() == (month-1)) {

            	System.out.println("��Ҫ��"+employee[i].name+"Ա����������");

            }

		}

		for (int i=0;i<10;i++) {

            if(manager[i].birthday.getMonth() == (month-1)) {

            	System.out.println("��Ҫ��"+manager[i].name+"������������");

            }

		}

	}

	

	private static Date randomDate(String beginDate, String endDate) {		

		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			Date start = format.parse(beginDate);// ���쿪ʼ����

			Date end = format.parse(endDate);// �����������

			// getTime()��ʾ������ 1970 �� 1 �� 1 �� 00:00:00 GMT ������ Date �����ʾ�ĺ�������

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

		// ������ص��ǿ�ʼʱ��ͽ���ʱ�䣬��ݹ���ñ������������ֵ

		if (rtn == begin || rtn == end) {

			return random(begin, end);

		}

		return rtn;

	}

	

	public static String getChinese() {

		String str = null;

		int highPos, lowPos;

		Random random = new Random();

		highPos = (176 + Math.abs(random.nextInt(71)));//���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������

		random=new Random();

		lowPos = 161 + Math.abs(random.nextInt(94));//λ�룬0xA0��ͷ����Χ��1~94��

		byte[] bArr = new byte[2];

		bArr[0] = (new Integer(highPos)).byteValue();

		bArr[1] = (new Integer(lowPos)).byteValue();

		try {

			str = new String(bArr, "GB2312");	//��λ����ϳɺ���

		}

		catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

		return str;

	}

}



class Employee{//����

	public  String name;		//����

	public  int salay;		//����

	public  Date birthday;	//����

	public Employee(){

		name = "����";

		salay = 5000;

		birthday = new Date();

	}

}





class Manager extends Employee{//����

	public  int bonus;//����

	public Manager() {

		bonus = (int)(Math.random()*1000+1000);

	}

}



class Shareholder extends Employee{//�ɶ�

	public	 int share; 

	public Shareholder() {

		share = 0;

	}

}