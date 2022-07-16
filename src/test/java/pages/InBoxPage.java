package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;
import lombok.Getter;
@Getter
@Data

public class InBoxPage extends BaseClass{
//	public WebElement getEmail() {
//		return email;
//	}
//	public WebElement getNext() {
//		return next;
//	}
//	public WebElement getPwd() {
//		return pwd;
//	}
	public InBoxPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
@FindBy(xpath="//input[@type='email']")
private WebElement email;

@FindBy(xpath="//span[contains(text(),'Next')]")
private WebElement next;
	
@FindBy(xpath="//input[@type='password']")
private WebElement pwd;

@FindBy(xpath="//div[contains(text(),'Compose')]")
private WebElement compose;
@FindBy(xpath="//textarea[@name='to']")
private WebElement to;
@FindBy(xpath="//input[@name='subjectbox']")
private WebElement subject;
@FindBy(xpath="//div[@aria-label='Message Body']")
private WebElement body;
@FindBy(xpath="//div[@aria-label='More options']//div[2]")
private WebElement options;
@FindBy(xpath="(//div[contains(text(),'Label')])[1]")
private WebElement label;
@FindBy(xpath="//div[contains(text(),'Create new')]")
private WebElement create_new;
@FindBy(xpath="//input[@class='xx']")
private WebElement labelname;
@FindBy(xpath="//button[contains(text(),'Create')]")
private WebElement create;
@FindBy(xpath="(//div[contains(text(),'Send')])[2]")
private WebElement send;
@FindBy(xpath="//td[@class='apU xY']/span")
private WebElement starred;

@FindBy(xpath="//a[contains(text(),'Starred')]")
private WebElement starred_menu;
@FindBy(xpath="//a[contains(text(),'Inbox')]")
private WebElement inbox;
@FindBy(xpath="//a[contains(text(),'Social')]")
private WebElement social;
@FindBy(xpath="((//div[@class='Cp']//table)[6]//tbody/tr/td)[5]")
private WebElement mail;
@FindBy(xpath="//div[@class='ha']/h2")
private WebElement mail_subject;
@FindBy(xpath="//div[@class='ii gt']//div[@dir='ltr']")
private WebElement mail_body;

}
