package testCases;

import java.util.ArrayList;
import org.junit.Test;
import driver.IOSLaunch;


public class linearTestCase extends IOSLaunch
{
	long totalTime;
	AbstractMethods am_test = new AbstractMethods();
	boolean loginFlag =true;
	
	
	@Test
	public void TestScenario() throws InterruptedException
	{
		for(MVPD mvpds : mvpd) {
			System.out.println("Name : "+ mvpds.getName());
				accountLooper(mvpds.getAccount(),mvpds.getName());
			
		}
			
	}
	private void accountLooper(ArrayList<Accounts> accounts,String accountName) throws InterruptedException {
		
		for(Accounts account : accounts){
			if(loginFlag)
				am_test.loginAccountSettings(accountName);
			loginFlag = am_test.login(account);
			System.out.println(account.getUsername() + " Login: " + loginFlag);
			if(loginFlag){
				am_test.playVideos();
				am_test.logout();
			}
			
		}
		
	}
}
