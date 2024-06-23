import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.lang.Thread;


public class PurchasesStepdefs {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iOpenTheBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void closeBrowser() {
        driver.quit();
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
        WebElement element = driver.findElement(By.cssSelector("h1"));
        String actualText = element.getText();
        String expectedText = "HUMMINGBIRD PRINTED SWEATER";
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @And("I choose the size {string} on size selection")
    public void iChooseTheSize(String size) {
        WebElement sizeDropdown = driver.findElement(By.id("group_1"));
        sizeDropdown.sendKeys(size);
    }

    @And("I choose {string} pieces")
    public void iChoosePiecesPieces(String pieces) {
        WebElement piecesDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity_wanted")));
        piecesDropdown.click();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ignored) {
        }

        while (!piecesDropdown.getAttribute("value").isEmpty()) {
            piecesDropdown.sendKeys(Keys.CONTROL, "A");
            piecesDropdown.sendKeys(Keys.DELETE);
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException ignored) {
        }

        piecesDropdown.sendKeys(pieces);
    }

    @And("I click Add To cart button")
    public void iClickAddToCartButton() {
        WebElement clickButton = driver.findElement(By.cssSelector("button.btn.btn-primary.add-to-cart"));
        clickButton.click();
    }

    @Then("I click Proceed to checkout button")
    public void iClickProceedToCheckoutButton() {
        WebElement clickButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary[href*='controller=cart'][href*='action=show']")));
        clickButton.click();
    }

    @When("I am on controller cart action show page")
    public void iAmOnControllerCartActionShowPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=cart&action=show");
    }

    @Then("I click Proceed to checkout btn")
    public void iClickProceedToCheckoutBtn() {
        WebElement clickButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary")));
        clickButton.click();
    }

    @When("I am on controller order page")
    public void iAmOnControllerOrderPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=order");
    }


    @And("I click continue button")
    public void iClickContinueButton() {
        WebElement button = driver.findElement(By.name("confirm-addresses"));
        button.click();
    }

    @And("I click on radio button method of delivery {string}")
    public void iClickOnRadioButtonMoD(String methodOfDelivery) {

        List<WebElement> buttons = driver.findElements(By.cssSelector("label[class='col-xs-9 col-sm-11 delivery-option-2']"));
        for (int i = 0; i < buttons.size(); i++) {
            WebElement btn = buttons.get(i);
            String html = btn.getAttribute("innerHTML");
            if (html.contains(methodOfDelivery)) {
                btn.click();
                break;
            }
        }
    }

    @And("I click continue button on Shipping Method")
    public void iClickContinueButtonOnShippingMethod() {
        WebElement button = driver.findElement(By.name("confirmDeliveryOption"));
        button.click();
    }

    @And("I choice radio method of payment {string}")
    public void iChoiceRadioMoP(String methodOfPayment) {
        List<WebElement> buttons = driver.findElements(By.cssSelector("label[for*='payment-option']"));
        for (int i = 0; i < buttons.size(); i++) {
            WebElement btn = buttons.get(i);
            String html = btn.getAttribute("innerHTML");
            if (html.contains(methodOfPayment)) {
                btn.click();
                break;
            }
        }
    }

    @And("I check checkbox \"i agree terms and conditions\"")
    public void iCheckCheckbox() {
        WebElement checkbox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        checkbox.click();
    }

    @And("I click Place order button")
    public void iClickPlaceOrderButton() {
        List<WebElement> buttons = driver.findElements(By.cssSelector("button[type='submit']"));
        for (int i = 0; i < buttons.size(); i++) {
            WebElement btn = buttons.get(i);
            String btn_txt = btn.getText().toLowerCase();
            if (btn_txt.contains("place order")) {
                btn.click();
                break;
            }
        }
    }

    @When("I am on order confirmation page")
    public void iAmOnOrderConfirmationPage() {
        List<WebElement> elements = driver.findElements(By.className("page-order-confirmation"));
        TestCase.assertTrue(elements.size() > 0);
    }

    @Then("I make screenshot confirment order and price")
    public void iMakeScreenshotConfirmentOrderAndPrice() {
        WebElement element = driver.findElement(By.id("main"));
        File screenshotFile = element.getScreenshotAs(OutputType.FILE);

        try {
            Path destinationPath = new File("element_screenshot.png").toPath();
            Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Zapisano zrzut ekranu elementu jako element_screenshot.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
