import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchasesStepdefs {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iOpenTheBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 3);
    }

    @After
    public void closeBrowser() {
        //driver.quit();
    }

    @Then("I go the page My Store")
    public void iGoThePageMyStore() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @And("I click to the Sign in button")
    public void iClickToTheSignInButton() {
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Log in to your customer account']")));
        signInLink.click();
    }

    @When("I enter {string} in the Email")
    public void iEnterInTheEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-email")));
        element.sendKeys(email);
    }

    @And("I enter {string} i the Password")
    public void iEnterIThePassword(String password) {
        WebElement element = driver.findElement(By.id("field-password"));
        element.sendKeys(password);
    }

    @And("I click the Login button Sign In")
    public void iClickTheLoginButtonSignIn() {
        WebElement element = driver.findElement(By.id("submit-login"));
        element.click();
    }

    @Then("I'm logged in")
    public void iMLoggedIn() {
        wait.until(ExpectedConditions.urlContains("controller=my-account"));
        WebElement element = driver.findElement(By.cssSelector("h1"));
        String actualText = element.getText();
        String expectedText = "Your account";
        TestCase.assertTrue(actualText.contains(expectedText));
    }

    @And("I search for {string}")
    public void iSearch(String productSearched) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='s']")));
        searchInput.click();
        searchInput.sendKeys(productSearched);
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("see list of products")
    public void seeListOfProducts() {
        WebElement element = driver.findElement(By.cssSelector("h1"));
        String actualText = element.getText();
        String expectedText = "SEARCH RESULTS";
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @And("I click on {string} product")
    public void iClickOnProduct(String productSearched) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productSearched)));
        element.click();
    }

    @When("I am on the page with the selected product")
    public void iAmOnThePageWithTheSelectedProduct() {
    }

    @Then("I check if there is a {int}% discount")
    public void iCheckIfThereIsADiscount(int sales) {
    }

    @And("I click on size selection")
    public void iClickOnSizeSelection() {
    }

    @And("I choose the size {string}")
    public void iChooseTheSize(String size) {
    }

    @Then("I click on the number of pieces")
    public void iClickOnTheNumberOfPieces() {
    }

    @And("I choose {int} pieces")
    public void iChoosePiecesPieces(int pieces) {
    }

    @And("I click Add To cart button")
    public void iClickAddToCartButton() {
    }

    @When("i see Product successfully added to your shopping cart")
    public void iSeeProductSuccessfullyAddedToYourShoppingCart() {
    }

    @Then("I click Proceed to checkout button")
    public void iClickProceedToCheckoutButton() {
    }

    @When("I am on controller cart action show page")
    public void iAmOnControllerCartActionShowPage() {
    }

    @Then("I click Proceed to checkout btn")
    public void iClickProceedToCheckoutBtn() {
    }

    @When("I am on controller order page")
    public void iAmOnControllerOrderPage() {
    }

    @Then("if address not exists quit error")
    public void ifAddressNotExistsQuitError() {
    }

    @And("I click continue button")
    public void iClickContinueButton() {
    }

    @When("I am on Shipping Method step")
    public void iAmOnShippingMethodStep() {
    }

    @And("I click on radio button {string}")
    public void iClickOnRadioButton(String methodOfDelivery) {
    }

    @When("I am on Payment step")
    public void iAmOnPaymentStep() {
    }

    @And("I choice radio {string}")
    public void iChoiceRadio(String methodOfPayment) {
    }

    @And("I check checkbox \"i agree terms and conditions\"")
    public void iCheckCheckbox() {
    }

    @And("I click Place order button")
    public void iClickPlaceOrderButton() {
    }

    @When("I am on order confirmation page")
    public void iAmOnOrderConfirmationPage() {
    }

    @Then("I make screenshot confirment order and price")
    public void iMakeScreenshotConfirmentOrderAndPrice() {
    }
}
