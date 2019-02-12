import java.util.Scanner;

public class Eat {
	public static void main(String[] args) {
		//啦啦啦
		//进入系统的欢迎
		System.out.println("欢迎使用吃货联盟系统");
		
		/*
		 * 主体：我要订餐	查看餐袋	删除订单	签收订单
		 * 订餐人		订餐信息		送餐时间		送餐地址		订单状态		总金额
		 * 
		*/
		String[] names = new String[4];		//订餐人
		String[] dishMegs = new String[4];	//餐品信息
		int[] times = new int[4];			//送餐时间
		String[] addresses = new String[4];	//送餐地址
		int[] states = new int[4];			//订单状态	0：已预订		1：已完成
		double[] sumPrices = new double[4];	//总金额
		
		
		//初始化2条订单信息
		Scanner input = new Scanner(System.in);
		
		names[0]="张晴";
		dishMegs[0] = "鱼香肉丝 1份";
		times[0] = 12;
		addresses[0] = "天成路209";
		states[0] = 0;
		sumPrices[0] = 24.0;

		
		names[1]="张晴";
		dishMegs[1] = "红烧带鱼 2份";
		times[1] = 12;
		addresses[1] = "天成路209";
		states[1] = 1;
		sumPrices[1] = 76.0;
		
		//数据主体，一组餐品信息
		String[] dishNames = {"红烧带鱼","鱼香肉丝","时令蔬菜"};
		double[] prices = {38.0,18.0,10.0};
		int[] praiseNums = new int[3];
		
		
		int num = -1;
		do{
//			循环操作
//			显示菜单
			System.out.println("*******************************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*******************************************");
//			提醒用户输入功能编号，执行相应操作
			System.out.println("请选择：");
			int choose = input.nextInt();//记录用户选择功能编号
			
			boolean isAdd = false;//true:为找到空位置；false：为没找到
			//根据用户输入的功能编号执行功能
			switch(choose){
				//1.我要订餐
				case 1:
					System.out.println("*****我要订餐*****");
					//查找插入位置
					for(int i=0;i<names.length;i++){
						if(names[i]==null){
							isAdd = true;
//							执行插入操作
//							插入餐品信息
							System.out.println("序号\t餐品名\t单价\t点赞数");
							for(int j=0;j<dishNames.length;j++){
								String price = prices[j]+"元";
								String praise = praiseNums[j]+"赞";
								System.out.println((j+1)+"\t"+dishNames[j]+"\t"+prices[j]+"\t"+praise);
							}
							
							
							//输入餐品编号以及份数
							System.out.print("请选择所定餐品序号：");
							int chooseDish = input.nextInt();
							System.out.println("请选择所定份数");
							int number = input.nextInt();
							String dishMeg = dishNames[chooseDish - 1]+" "+number+"份";
							
//							输入订餐人姓名
							System.out.println("请输入订餐人姓名：");
							String name = input.next(); 
							
//							输入送餐时间
							System.out.println("请输入（10~20整点送餐）");
							int time = input.nextInt();
							
							
//							如果输错了，重复输入
							while(time<10||time>20){
								System.out.println("您的输入有误，请重新输入10~20之间的整数：");
								time = input.nextInt();
							}
							
//							送餐地址
							System.out.println("请输入送餐地址：");
							String address = input.next();
							
//							计算餐费
							double sumPrice = prices[chooseDish-1]*number;
//							送餐费，当餐费达到50时，免6元餐费
							double deliCharge = sumPrice >= 50?0.0:6.0;
							
							
							//显示订单信息
							System.out.println("订餐成功！");
							System.out.println("您订的是："+dishMeg);
							System.out.println("订餐人："+name);
							System.out.println("送餐时间："+time+"点");
							System.out.println("送餐地址："+address);
							System.out.println("餐费"+sumPrice+",送餐餐费:"+deliCharge+"元");
							System.out.println("总金额："+(sumPrice+deliCharge)+"元");
							
//							保存数据
							names[i] = name;
							dishMegs[i] = dishMeg;
							times[i] = time;
							addresses[i] = address;
							sumPrices[i] = sumPrice+deliCharge;
							
							break;
						}
					}
//					如果没找到为空的位置，则提示信息
					if(!isAdd){
						System.out.println("对不起您的餐袋已满！");
					}
					break;
				//	2.查看餐袋
				case 2:
					System.out.println("*****查看餐袋*****");
					System.out.println("序号\t订餐人\t所定餐品信息\t送餐时间\t\t送餐地址\t\t总金额\t\t状态");
//					遍历数组
					for(int i=0;i<names.length;i++){
						if(names[i]!=null){
							String time = times[i]+"点";
							String sumPrice = sumPrices[i]+"元";
							String state = states[i]==0?"已预订":"已完成";
							System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t\t"+addresses[i]+"\t\t"+sumPrice+"\t\t"+state);
						}
					}
					break;
//					3.签收订单
				case 3:
					System.out.println("*****签收订单*****");
//					需要用户输入一个订单序号
					System.out.println("请输入要签收的订单编号：");
					int signOrderId = input.nextInt();
					boolean isFind = false;						//记录是否已经找到
//					查找这条订单
					for(int i=0;i<names.length;i++){
//						1、找到，状态是已完成（已签收完毕）
//						2、找到，状态是已预付（没有完成签收），可以签收
						if(names[i]!=null&&states[i]==1&&signOrderId==i+1){
							System.out.println("您选择的订单已经完成签收，不能再次签收！");
							isFind = true;
							break;
						}else if(names[i]!=null && states[i]==0 && signOrderId==i+1){
							states[i] = 1;
							System.out.println("订单签收完成！");
							isFind = true;
							break;
						}
						}
//						3、没找到订单
//						条件判断：如果没有找到这条订单，才提示没有找到
					if(!isFind){
						System.out.println("对不起没找到此订单");
						
					}
					
					break;
//				4.删除订单
				case 4:
//					1.输入要删除的订单序号
					System.out.println("******删除订单*****");
					System.out.println("请输入要删除的订单序号：");
					int delId = input.nextInt();
					int delIndex = -1;//删除下标
					boolean isDelFind = false;//记录是否找到此订单
//					2.循环查找这条订单
					for(int i=0;i<names.length;i++){
//					找到此订单，已签收：执行删除操作（先记录要删除的订单序号）
//					找到此订单，且未签收：提示信息	
						if(names[i]!=null && states[i]==1 && delId==i+1){
							delIndex = i;
							isDelFind = true;
							break;
						}else if(names[i]!=null && states[i]==0 && delId==i+1){
							System.out.println("您选择的订单未签收，不能删除！");
							isDelFind = true;
							break;
						}
					}
//					未找到此订单
					if(!isDelFind){
						System.out.println("对不起词条订单不存在！");
					}
					
//					执行删除操作
					if(delIndex!=-1){
//						删除移位
//					从要删除的元素后面一个开始，到数组最后一个元素依次向前移动一位
						for(int i=delIndex+1;i<=names.length-1;i++){
							names[i-1] = names[i];
							dishMegs[i-1] = dishMegs[i];
							times[i-1] = times[i];
							addresses[i-1] = addresses[i];
							states[i-1] = states[i];
						}
//						清空最后一位元素
						names[names.length-1] = null;
						dishMegs[names.length-1] = null;
						times[names.length-1] = 0;
						addresses[names.length-1] = null;
						states[names.length-1] = 0;
						System.out.println("订单删除成功！");
					}
					
					
					break;
//				5.我要点赞
				case 5:
					System.out.println("*****我要点赞*****");
//					提供点赞的餐品列表
					System.out.println("序号\t餐品名\t单价\t点赞数");
					for(int j=0;j<dishNames.length;j++){
						String price = prices[j]+"元";
						String praise = praiseNums[j]+"赞";
						System.out.println((j+1)+"\t"+dishNames[j]+"\t"+prices[j]+"\t"+praise);
					}
//					输入要点赞的餐品序号
					System.out.println("请输入要点赞的餐品序号：");
					int dishId = input.nextInt();
//					该序号的餐品点赞数+1
					praiseNums[dishId-1]++;
//					显示信息
					System.out.println("点赞成功！");
					System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"赞");
					break;
//				6.退出系统
				case 6:
				default:
					break;
			}
//			当用户输入的功能编号为1~5之外的数字时，退出循环，否则提示输入0返回
			if(choose<1||choose>5){
				break;
			}else{
//			提示输入0返回
			System.out.println("输入0返回：");
			num = input.nextInt();
			}
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临！");
	}
}
