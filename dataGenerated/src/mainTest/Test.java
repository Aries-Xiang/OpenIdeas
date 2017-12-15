package mainTest;

import excucation.Sql;

public class Test {

	public static void main(String[] args){
		System.out.println("*****************开始插入数据*******************");
		int isSuccess = Sql.insert(2000);
		if (isSuccess==1) {
			System.out.println("******************插入成功*******************");
		}else {
			System.out.println("******************插入失败*******************");
		}
	}
}
