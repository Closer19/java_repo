package dbpackate;

import java.sql.Date;

public class App {

	public static void main(String[] args) {		
		DBManager.initDBConnect();
		User[] userList=DBManager.allFetch();
		for(int i=0; i<userList.length;i++) {
			System.out.println(userList[i].getUserId());
			System.out.println(userList[i].getUserName());
			System.out.println(userList[i].getHeight());
			System.out.println(userList[i].getBirthYear());
		}
		System.out.println("=======================");
		DBManager.selectUser("유재석");
		
		DBManager.inputUser(new User("hcg", "홍창기", 2000, "서울", null, 
				null, 193, Date.valueOf("2024-09-27")));
		
		DBManager.releaseDB();
	}

}
