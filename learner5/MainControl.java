package com.hong.tools;



import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import java.util.Scanner;



/**

 * @version 1.0

 * @author 22053

 * @category Java,abstract,implements

 * @illustration 

 */



//��ͨ���߳�����

abstract class Transportation{

	public String transName;  //��ͨ��������

	public Date setOffTime; //��վʱ��

	public Date returnTime; //����ʱ��

	public Date checkInTime; //ȡƱʱ��

	public Date securityCheckTime; //����ʱ��

	public Date waitTime; //�Ⱥ�ʱ��

	public double speed;  //����

	public double unitPrice; //����

	abstract ArrayList<String>cost(String departure,String destination,double disdance);//�������ĵ�ʱ��ͽ�Ǯ

	void TimeAndPrice(String departure,String distination,double distance) { //�������ĵ�ʱ��ͼ۸�

		ArrayList<String>list=cost(departure,distination,distance);  //ʱ��ͷ��ñ�

		System.out.println("����"+transName+"����ʱ��: "+list.get(0)); //��ȡʱ��

		System.out.println("�����ǣ�"+list.get(1));  //��ȡ����

	}  

}



//������

class Car extends Transportation{

	Car() {

		transName="����";

		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

		try {

			setOffTime=dateFormat.parse("00:10:00");

			returnTime=dateFormat.parse("00:10:00");

			checkInTime=dateFormat.parse("00:05:00");

			securityCheckTime=dateFormat.parse("00:05:00");

			waitTime=dateFormat.parse("00:20:00");

		}catch (ParseException e) {

			e.printStackTrace();

		}

		speed=100;

		unitPrice=0.32;

	}



	@Override

	ArrayList<String> cost(String departure, String destination, double disdance) {

		double money=disdance*unitPrice;

		double time=disdance/speed;

		double time_m=(time-(int)time)*60;

		double time_s=(time_m-(int)time_m)*60;

		String hour =String.valueOf((int)time);

		String minute=String.valueOf((int)time_m);

		String second=String.valueOf((int)time_s);

		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");//HH��д����24Сʱ���ƣ�hhСд����12����

		Date times=null;

		try {

			times=dateFormat.parse(hour+":"+minute+":"+second);

		}catch (ParseException e) {

			e.printStackTrace();

		}

		ArrayList<String>list=new ArrayList<String>();

		list.add(dateFormat.format(times));

		list.add(String.valueOf(money));

		return list;

	}

}



//������

class HighSpeedRail extends Transportation{

	

	public HighSpeedRail() {

		transName="����";

		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

		try {

			setOffTime=dateFormat.parse("00:10:00");

			returnTime=dateFormat.parse("00:10:00");

			checkInTime=dateFormat.parse("00:05:00");

			securityCheckTime=dateFormat.parse("00:05:00");

			waitTime=dateFormat.parse("00:10:00");

		}catch (ParseException e) {

			e.printStackTrace();

		}

		speed=300;

		unitPrice=0.42;

	}

	@Override

	ArrayList<String> cost(String departure, String destination, double disdance) {

		double money=disdance*unitPrice;

		double time=disdance/speed;

		double time_m=(time-(int)time)*60;

		double time_s=(time_m-(int)time_m)*60;

		String hour =String.valueOf((int)time);

		String minute=String.valueOf((int)time_m);

		String second=String.valueOf((int)time_s);

		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

		Date times=null;

		try {

			times=dateFormat.parse(hour+":"+minute+":"+second);

		}catch (ParseException e) {

			e.printStackTrace();

		}

		

		ArrayList<String>list=new ArrayList<String>();

		list.add(dateFormat.format(times));

		list.add(String.valueOf(money));

		return list;

	}



	

}



//�ɻ���

class Aircraft extends Transportation{

	public Aircraft() {

		transName="�ɻ�";

		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

		try {

			setOffTime=dateFormat.parse("00:20:00");

			returnTime=dateFormat.parse("00:20:00");

			checkInTime=dateFormat.parse("00:05:00");

			securityCheckTime=dateFormat.parse("00:10:00");

			waitTime=dateFormat.parse("00:5:00");

		}catch (ParseException e) {

			e.printStackTrace();

		}

		speed=900;

		unitPrice=0.75;

	}

	@Override

	ArrayList<String> cost(String departure, String destination, double disdance) {

		double money=disdance*unitPrice;

		double time=disdance/speed;

		double time_m=(time-(int)time)*60; //��ȡ����

		double time_s=(time_m-(int)time_m)*60; //��ȡ����

		String hour =String.valueOf((int)time);  //ʱ

		String minute=String.valueOf((int)time_m); //��

		String second=String.valueOf((int)time_s); //��

		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

		Date times=null;

		try {

			times=dateFormat.parse(hour+":"+minute+":"+second);

		}catch (ParseException e) {

			e.printStackTrace();

		}

		

		ArrayList<String>list=new ArrayList<String>();

		list.add(dateFormat.format(times));

		list.add(String.valueOf(money));

		return list;

	}

	

}



//�ܿ�����

public class MainControl {

	public void show() {

		Car car=new Car();  //����Car����

		HighSpeedRail highSpeedRail=new HighSpeedRail(); //����HighSpeedRail����

		Aircraft aircraft=new Aircraft();  //����aircraft����

		

		Scanner scanner=new Scanner(System.in);

		System.out.println("�����������: ");

		String departure=scanner.nextLine();

		System.out.println("������Ŀ�ĵأ�");

		String distination=scanner.nextLine();

		System.out.println("���������ؾ��룺");

		double distance=scanner.nextDouble();

		

		car.TimeAndPrice(departure, distination, distance);

		highSpeedRail.TimeAndPrice(departure, distination, distance);

		aircraft.TimeAndPrice(departure, distination, distance);

		scanner.close();

	}

	public static void main(String[] args) {

		MainControl test=new MainControl();

		test.show();

	}

}