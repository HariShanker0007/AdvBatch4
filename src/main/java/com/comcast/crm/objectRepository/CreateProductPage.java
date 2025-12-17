package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateProductPage {
	WebDriver driver;
	
	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name = "productCategory")
	private WebElement productCategory;
	
	@FindBy(name = "quantity")
	private WebElement quantity;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(name = "vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath = "//button[.='Add']")
	private WebElement Add;

	public WebElement getAdd() {
		return Add;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorId() {
		return vendorId;
	}
	
	
	
	public void createProductWithMandatoryDetails(String ProdnName,String Catg,String quan,String pricee,String vendor) throws Throwable {
		productName.sendKeys(ProdnName);
		productCategory.sendKeys(Catg);
		quantity.sendKeys(quan);
		price.clear();
		price.sendKeys(pricee);
		vendorId.sendKeys(vendor);	
		Add.click();
	}	
}
