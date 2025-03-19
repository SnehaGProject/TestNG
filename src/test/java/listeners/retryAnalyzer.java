package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer {

    private final int maxRetry=2;
    private int count=0;


    @Override
   public boolean retry(ITestResult result){
       if(count<maxRetry){
           count++;
           System.out.println("Retrying test again:"+result.getName() +"count is :"+count);
           return true;
       }
       return false;
   }
}
