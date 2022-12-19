package UtilsLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseLayer.BaseClass;

public class ActionMethods extends BaseClass {
	
protected static Actions act=new Actions(driver);
	
	public static void clickOnElement(WebElement wb)
	{
		act.click().build().perform();
	}
	public static void doubleClickOnElement(WebElement wb)
	{
		act.doubleClick().build().perform();
	}
	public static void contextClickOnElement(WebElement wb)
	{
		act.contextClick().build().perform();
	}
	public static void moveToElement(WebElement wb)
	{
		act.moveToElement(wb).build().perform();
	}
	public static void dragAndDrop(WebElement src,WebElement dest)
	{
		act.dragAndDrop(src, dest).build().perform();
	}
	public static void dragAndHold(WebElement src)
	{
		act.clickAndHold(src).build().perform();
	}
	public static void releaseHoldElement(WebElement dest)
	{
		//try clickandhold any element from one webpage and release on another window
		act.release(dest).build().perform();
	}
	//find any wey to create reusable script for at least freqyently used keyboard keys
	public static void pressTab(int tabpress)
	{
		if(tabpress==1)
		{
			act.sendKeys(Keys.TAB).build().perform();
		}
		else if(tabpress==2)
		{
			act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		}
		else if(tabpress==3)
		{
			act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		} 
		else if(tabpress==4)
		{
			act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		}
		else if(tabpress==5)
		{
			act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		}
	}
}