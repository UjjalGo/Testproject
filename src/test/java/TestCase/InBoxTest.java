package TestCase;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utlity.DataReader;
import pages.BaseClass;
import pages.InBoxPage;

public class InBoxTest extends BaseClass {
	InBoxPage ibp;
	DataReader dr;
	WebDriverWait wait;
	Actions act;
	
		
	
@Test(priority=1,description="Verify user is able to login into gmail")//login to gmail
public void loginMail() throws InterruptedException{
	
	ibp.getEmail().sendKeys(dr.getUsername());
	ibp.getNext().click();
	Thread.sleep(2000);
	ibp.getPwd().sendKeys(dr.getPassword());
	ibp.getNext().click();
	Thread.sleep(1000);
}
@Test(priority=2,description="Verify user is able to compose a mail")//compose mail
public void composeMail() throws InterruptedException{
   wait.until(ExpectedConditions.visibilityOf(ibp.getCompose()));
   ibp.getCompose().click();
   wait.until(ExpectedConditions.visibilityOf(ibp.getTo()));
   ibp.getTo().sendKeys(dr.getUsername());
   ibp.getSubject().sendKeys(dr.getSubject());
   ibp.getBody().sendKeys(dr.getBody());
   Thread.sleep(1000);
}
@Test(priority=3,description="Verify user is able to create a label")//create label
public void createLabel() throws InterruptedException{
   ibp.getOptions().click();
   act.moveToElement(ibp.getLabel()).build().perform();
   Thread.sleep(2000);
  ibp.getCreate_new().click();
  Thread.sleep(2000);
  ibp.getLabelname().sendKeys(dr.getLabel());
 Thread.sleep(1000);
 ibp.getCreate().click();
 Thread.sleep(1000);
 ibp.getSend().click();
 Thread.sleep(2000);
}
@Test(priority=4,description="Verify mail can be marked as Starred")//mark a mail starred
public void createStarred() throws InterruptedException{
 ibp.getStarred_menu().click();
 Thread.sleep(1000);


 ibp.getInbox().click();
 Thread.sleep(1000);
 ibp.getStarred().click();
 Thread.sleep(2000);
}
@Test(priority=5,description="Verify mail is moved to Created Label")//Filtering a mail to the marked label
public void checkMailLabel() throws InterruptedException{
ibp.getSocial().click();
	 
Thread.sleep(1000); 
}
@Test(priority=6,description="Verify the Subject and Body of the mail")//Verify the subject and body
public void validateEmail() throws InterruptedException{
ibp.getMail().click();
Thread.sleep(1000);
Assert.assertEquals(ibp.getMail_subject().getText(),dr.getSubject());
Assert.assertEquals(ibp.getMail_body().getText(),dr.getBody());
 }
   
   
	

	
	@BeforeClass
	public void initialise() throws IOException{
		ibp=new InBoxPage(driver);
		dr=new DataReader();
		 wait=new WebDriverWait(driver, 10);
		 act=new Actions(driver);
	}
	
}
