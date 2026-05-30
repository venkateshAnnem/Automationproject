package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
	
	//it will execute only one time before starting
	public void onStart(ITestContext context) {
	   System.out.println("this is onStart");
	  }
	//Before starting any test method this test will start
	//it will execute multiple times before every test method
	  public  void onTestStart(ITestResult result) {
		  System.out.println("this is onTestStart");
		  }
	  //Whenever test method will pass this test will trigger
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("this is onTestsucess");
		  }
     //whenever my test method will fail this method will execute
	  public void onTestFailure(ITestResult result) {
		  System.out.println("this is onTestfailure");
		  }
	//  //whenever my test method will skip this method will execute
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("this is onTestSkipped");
		  }
	  

}
