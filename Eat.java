import java.util.Scanner;

public class Eat {
	public static void main(String[] args) {
		//������
		//����ϵͳ�Ļ�ӭ
		System.out.println("��ӭʹ�óԻ�����ϵͳ");
		
		/*
		 * ���壺��Ҫ����	�鿴�ʹ�	ɾ������	ǩ�ն���
		 * ������		������Ϣ		�Ͳ�ʱ��		�Ͳ͵�ַ		����״̬		�ܽ��
		 * 
		*/
		String[] names = new String[4];		//������
		String[] dishMegs = new String[4];	//��Ʒ��Ϣ
		int[] times = new int[4];			//�Ͳ�ʱ��
		String[] addresses = new String[4];	//�Ͳ͵�ַ
		int[] states = new int[4];			//����״̬	0����Ԥ��		1�������
		double[] sumPrices = new double[4];	//�ܽ��
		
		
		//��ʼ��2��������Ϣ
		Scanner input = new Scanner(System.in);
		
		names[0]="����";
		dishMegs[0] = "������˿ 1��";
		times[0] = 12;
		addresses[0] = "���·209";
		states[0] = 0;
		sumPrices[0] = 24.0;

		
		names[1]="����";
		dishMegs[1] = "���մ��� 2��";
		times[1] = 12;
		addresses[1] = "���·209";
		states[1] = 1;
		sumPrices[1] = 76.0;
		
		//�������壬һ���Ʒ��Ϣ
		String[] dishNames = {"���մ���","������˿","ʱ���߲�"};
		double[] prices = {38.0,18.0,10.0};
		int[] praiseNums = new int[3];
		
		
		int num = -1;
		do{
//			ѭ������
//			��ʾ�˵�
			System.out.println("*******************************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("*******************************************");
//			�����û����빦�ܱ�ţ�ִ����Ӧ����
			System.out.println("��ѡ��");
			int choose = input.nextInt();//��¼�û�ѡ���ܱ��
			
			boolean isAdd = false;//true:Ϊ�ҵ���λ�ã�false��Ϊû�ҵ�
			//�����û�����Ĺ��ܱ��ִ�й���
			switch(choose){
				//1.��Ҫ����
				case 1:
					System.out.println("*****��Ҫ����*****");
					//���Ҳ���λ��
					for(int i=0;i<names.length;i++){
						if(names[i]==null){
							isAdd = true;
//							ִ�в������
//							�����Ʒ��Ϣ
							System.out.println("���\t��Ʒ��\t����\t������");
							for(int j=0;j<dishNames.length;j++){
								String price = prices[j]+"Ԫ";
								String praise = praiseNums[j]+"��";
								System.out.println((j+1)+"\t"+dishNames[j]+"\t"+prices[j]+"\t"+praise);
							}
							
							
							//�����Ʒ����Լ�����
							System.out.print("��ѡ��������Ʒ��ţ�");
							int chooseDish = input.nextInt();
							System.out.println("��ѡ����������");
							int number = input.nextInt();
							String dishMeg = dishNames[chooseDish - 1]+" "+number+"��";
							
//							���붩��������
							System.out.println("�����붩����������");
							String name = input.next(); 
							
//							�����Ͳ�ʱ��
							System.out.println("�����루10~20�����Ͳͣ�");
							int time = input.nextInt();
							
							
//							�������ˣ��ظ�����
							while(time<10||time>20){
								System.out.println("����������������������10~20֮���������");
								time = input.nextInt();
							}
							
//							�Ͳ͵�ַ
							System.out.println("�������Ͳ͵�ַ��");
							String address = input.next();
							
//							����ͷ�
							double sumPrice = prices[chooseDish-1]*number;
//							�Ͳͷѣ����ͷѴﵽ50ʱ����6Ԫ�ͷ�
							double deliCharge = sumPrice >= 50?0.0:6.0;
							
							
							//��ʾ������Ϣ
							System.out.println("���ͳɹ���");
							System.out.println("�������ǣ�"+dishMeg);
							System.out.println("�����ˣ�"+name);
							System.out.println("�Ͳ�ʱ�䣺"+time+"��");
							System.out.println("�Ͳ͵�ַ��"+address);
							System.out.println("�ͷ�"+sumPrice+",�ͲͲͷ�:"+deliCharge+"Ԫ");
							System.out.println("�ܽ�"+(sumPrice+deliCharge)+"Ԫ");
							
//							��������
							names[i] = name;
							dishMegs[i] = dishMeg;
							times[i] = time;
							addresses[i] = address;
							sumPrices[i] = sumPrice+deliCharge;
							
							break;
						}
					}
//					���û�ҵ�Ϊ�յ�λ�ã�����ʾ��Ϣ
					if(!isAdd){
						System.out.println("�Բ������Ĳʹ�������");
					}
					break;
				//	2.�鿴�ʹ�
				case 2:
					System.out.println("*****�鿴�ʹ�*****");
					System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t\t�Ͳ͵�ַ\t\t�ܽ��\t\t״̬");
//					��������
					for(int i=0;i<names.length;i++){
						if(names[i]!=null){
							String time = times[i]+"��";
							String sumPrice = sumPrices[i]+"Ԫ";
							String state = states[i]==0?"��Ԥ��":"�����";
							System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t\t"+addresses[i]+"\t\t"+sumPrice+"\t\t"+state);
						}
					}
					break;
//					3.ǩ�ն���
				case 3:
					System.out.println("*****ǩ�ն���*****");
//					��Ҫ�û�����һ���������
					System.out.println("������Ҫǩ�յĶ�����ţ�");
					int signOrderId = input.nextInt();
					boolean isFind = false;						//��¼�Ƿ��Ѿ��ҵ�
//					������������
					for(int i=0;i<names.length;i++){
//						1���ҵ���״̬������ɣ���ǩ����ϣ�
//						2���ҵ���״̬����Ԥ����û�����ǩ�գ�������ǩ��
						if(names[i]!=null&&states[i]==1&&signOrderId==i+1){
							System.out.println("��ѡ��Ķ����Ѿ����ǩ�գ������ٴ�ǩ�գ�");
							isFind = true;
							break;
						}else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
							states[i] = 1;
							System.out.println("����ǩ����ɣ�");
							isFind = true;
							break;
						}
						}
//						3��û�ҵ�����
//						�����жϣ����û���ҵ���������������ʾû���ҵ�
					if(!isFind){
						System.out.println("�Բ���û�ҵ��˶���");
						
					}
					
					break;
//				4.ɾ������
				case 4:
//					1.����Ҫɾ���Ķ������
					System.out.println("******ɾ������*****");
					System.out.println("������Ҫɾ���Ķ�����ţ�");
					int delId = input.nextInt();
					int delIndex = -1;//ɾ���±�
					boolean isDelFind = false;//��¼�Ƿ��ҵ��˶���
//					2.ѭ��������������
					for(int i=0;i<names.length;i++){
//					�ҵ��˶�������ǩ�գ�ִ��ɾ���������ȼ�¼Ҫɾ���Ķ�����ţ�
//					�ҵ��˶�������δǩ�գ���ʾ��Ϣ	
						if(names[i]!=null && states[i]==1 && delId==i+1){
							delIndex = i;
							isDelFind = true;
							break;
						}else if(names[i]!=null && states[i]==0 && delId==i+1){
							System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
							isDelFind = true;
							break;
						}
					}
//					δ�ҵ��˶���
					if(!isDelFind){
						System.out.println("�Բ���������������ڣ�");
					}
					
//					ִ��ɾ������
					if(delIndex!=-1){
//						ɾ����λ
//					��Ҫɾ����Ԫ�غ���һ����ʼ�����������һ��Ԫ��������ǰ�ƶ�һλ
						for(int i=delIndex+1;i<=names.length-1;i++){
							names[i-1] = names[i];
							dishMegs[i-1] = dishMegs[i];
							times[i-1] = times[i];
							addresses[i-1] = addresses[i];
							states[i-1] = states[i];
						}
//						������һλԪ��
						names[names.length-1] = null;
						dishMegs[names.length-1] = null;
						times[names.length-1] = 0;
						addresses[names.length-1] = null;
						states[names.length-1] = 0;
						System.out.println("����ɾ���ɹ���");
					}
					
					
					break;
//				5.��Ҫ����
				case 5:
					System.out.println("*****��Ҫ����*****");
//					�ṩ���޵Ĳ�Ʒ�б�
					System.out.println("���\t��Ʒ��\t����\t������");
					for(int j=0;j<dishNames.length;j++){
						String price = prices[j]+"Ԫ";
						String praise = praiseNums[j]+"��";
						System.out.println((j+1)+"\t"+dishNames[j]+"\t"+prices[j]+"\t"+praise);
					}
//					����Ҫ���޵Ĳ�Ʒ���
					System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
					int dishId = input.nextInt();
//					����ŵĲ�Ʒ������+1
					praiseNums[dishId-1]++;
//					��ʾ��Ϣ
					System.out.println("���޳ɹ���");
					System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"��");
					break;
//				6.�˳�ϵͳ
				case 6:
				default:
					break;
			}
//			���û�����Ĺ��ܱ��Ϊ1~5֮�������ʱ���˳�ѭ����������ʾ����0����
			if(choose<1||choose>5){
				break;
			}else{
//			��ʾ����0����
			System.out.println("����0���أ�");
			num = input.nextInt();
			}
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
	}
}
