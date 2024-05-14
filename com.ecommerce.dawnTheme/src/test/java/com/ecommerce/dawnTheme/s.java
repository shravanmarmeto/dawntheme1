package com.ecommerce.dawnTheme;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import dawnObjectRepository.homePage;
import dawnObjectRepository.plpPage;
import genericUtility.propertyFileUtllity;

public class s {
	@Test
	public void colorDropDownSelection() throws Exception {
		propertyFileUtllity pUtil = new propertyFileUtllity();
		String color1 = pUtil.toReadDataFromPropertyFile("color1");
		String proName = "Sera Tote";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(
				"https://themes.shopify.com/themes/dawn/styles/default/preview?surface_detail=free-themes&surface_inter_position=1&surface_intra_position=6&surface_type=collection");
		homePage h = new homePage(driver);
		driver.switchTo().frame(h.getIframe());
		h.getBagsDropdown().click();
		String text = "Tote bags";
		driver.findElement(By.xpath("//ul[@id='HeaderMenu-MenuList-1']//a[contains(text(),'" + text + "')]")).click();
		plpPage p = new plpPage(driver);
		p.getColorDropdown().click();
		List<WebElement> a = driver.findElements(By.xpath(
				"//ul[@class='facets-layout facets-layout-list facets-layout-list--swatch facets__list list-unstyled']"));
		Thread.sleep(1000);
		for (WebElement b : a) {
			if (b.getText().contains(color1)) {
				b.click();
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				break;
			}

		}
		Thread.sleep(2000);
		List<WebElement> productList = driver.findElements(By.xpath("//h3[@class='card__heading h5']"));
		for (WebElement prod : productList) {
			if (prod.getText().contains(proName)) {
				prod.click();
			}
		}
		

	}
}
