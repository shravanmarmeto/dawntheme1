package cartTest;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.Cart;
import pom.CheckoutPage;
import pom.CollectionsPage;
import pom.HomePage;
import pom.LoginPage;
import pom.MyAccountPage;
import pom.PDP;
import pom.RegisterPage;

public class Script5 extends OpenCloseApplication 
{
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.closeInitialPopUp();
		homePage.verifyLogo();
		homePage.verifyAnnouncementBar();
		homePage.verifyBanner();
		homePage.takeScreenShotsOfMenuItems();
		
		homePage.clickAccountIcon();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyLoginPage();
		loginPage.clickCompanyLogo();
		homePage = new HomePage(driver);
		
		homePage.takeScreenShotOfBanner();
		homePage.clickSearchIcon();
		homePage.verifySearchField();
		homePage.clickCartIcon();
		
		Cart cart = new Cart(driver);
		cart.verifyEmptyCart();
	}
}