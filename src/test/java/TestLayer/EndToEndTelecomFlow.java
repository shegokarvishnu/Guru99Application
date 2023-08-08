package TestLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class EndToEndTelecomFlow extends BaseClass {
	public static String cID;

	@BeforeClass()
	public void setUp() {
		BaseClass.initilization();
	}

	public static void verifyStatusAndEnterText(WebElement wb, String value) {
		if (wb.isDisplayed() && wb.isEnabled()) {
			wb.sendKeys(value);
		}

	}

	public static void verifyStatusAndClick(WebElement wb) {
		if (wb.isDisplayed() && wb.isEnabled()) {
			wb.click();
		}

	}

	public static String createNewCustomer(String firstname, String lastname, String email, String add, String mobile) throws InterruptedException {
		Thread.sleep(3000);
		WebElement addbtn = driver.findElement(By.xpath("(//div[@class='flex-item left'])/div/h3/a[text()='Add Customer']"));
		EndToEndTelecomFlow.verifyStatusAndClick(addbtn);

		WebElement done = driver.findElement(By.name("active"));
		EndToEndTelecomFlow.verifyStatusAndClick(done);

		WebElement fname = driver.findElement(By.name("fname"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(fname, firstname);

		WebElement lname = driver.findElement(By.name("lname"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(lname, lastname);

		WebElement emailID = driver.findElement(By.name("emailid"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(emailID, email);

		WebElement address = driver.findElement(By.name("addr"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(address, add);

		WebElement phone = driver.findElement(By.name("telephoneno"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(phone, mobile);

		Thread.sleep(7000);
		WebElement submit = driver.findElement(By.name("submit"));
		EndToEndTelecomFlow.verifyStatusAndClick(submit);

		WebElement custID = driver.findElement(By.xpath("//b[text()='Customer ID']//following::h3"));
		String customerID = custID.getText();

		return customerID;

	}

	@Test(priority=1)
	public void addCustomer() throws InterruptedException
	{
		cID = EndToEndTelecomFlow.createNewCustomer("Nirmala", "kshirsagar", "nirmala@gmail.com", "pune", "7845126390");
		WebElement home = driver.findElement(By.xpath("(//a[text()='Home'])[1]"));
		EndToEndTelecomFlow.verifyStatusAndClick(home);

	}
	

	public static void addTariffPlanMethod(String pname, String lminutes, String intMinutes, String spack,
			String micharges, String incharges, String scharges) throws InterruptedException 
	{
//		Thread.sleep(3000);

		WebElement planName = driver.findElement(By.xpath("//input[@id='rental1']"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(planName, pname);

		WebElement localMinutes = driver.findElement(By.name("local_minutes"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(localMinutes, lminutes);

		WebElement interMinutes = driver.findElement(By.name("inter_minutes"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(interMinutes, intMinutes);

		WebElement smspack = driver.findElement(By.name("sms_pack"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(smspack, spack);

		WebElement minutesCharges = driver.findElement(By.name("minutes_charges"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(minutesCharges, micharges);

		WebElement interCharges = driver.findElement(By.name("inter_charges"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(interCharges, incharges);

		WebElement smsCharges = driver.findElement(By.name("sms_charges"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(smsCharges, scharges);

		WebElement submit = driver.findElement(By.name("submit"));
		EndToEndTelecomFlow.verifyStatusAndClick(submit);

	}
	
	
	@Test(priority=2)
	public void addTariffPlan() throws InterruptedException {
		WebElement addTarifPlan = driver.findElement(By.xpath("//a[text()='Add Tariff Plan']"));
		EndToEndTelecomFlow.verifyStatusAndClick(addTarifPlan);
		Thread.sleep(10000);
		EndToEndTelecomFlow.addTariffPlanMethod("1000", "1000", "100", "1200", "100", "150", "1");
		WebElement homeClick = driver.findElement(By.xpath("(//a[text()='Home'])[1]"));
		EndToEndTelecomFlow.verifyStatusAndClick(homeClick);

	}
	
	@Test(priority=3)
	public static void addCutomerTariffPlan() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement tariifPlanclick=driver.findElement(By.xpath("(//a[text()='Add Tariff Plan to Customer'])[1]"));
		EndToEndTelecomFlow.verifyStatusAndClick(tariifPlanclick);
		
		WebElement custoID=driver.findElement(By.name("customer_id"));
		EndToEndTelecomFlow.verifyStatusAndEnterText(custoID, cID);
		
		WebElement submitClick=driver.findElement(By.name("submit"));
		EndToEndTelecomFlow.verifyStatusAndClick(submitClick);
		
	}
	
	

	
	
	
	
	
	
	
	
}
