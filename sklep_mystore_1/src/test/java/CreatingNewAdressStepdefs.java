import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreatingNewAdressStepdefs {
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
        driver.get("https://mystore-testlab.coderslab.pl/index.php?");
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
    public void iClickTheLoginButton() {
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

    @And("I click to Adresses")
    public void iClickToAdresses() {
        WebElement element = driver.findElement(By.id("addresses-link"));
        element.click();
    }

    @Then("I go to the controller addressess page")
    public void henIGoToTheControllerAddressessPage() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        String expectedUrl = "https://mystore-testlab.coderslab.pl/index.php?controller=addresses";
        TestCase.assertEquals("Current URL is not as expected", expectedUrl, currentUrl);
    }

    @And("I click to Create new addres")
    public void iClickToCreateNewAddres() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://mystore-testlab.coderslab.pl/index.php?controller=address'][data-link-action='add-address']")));
        element.click();
    }

    @When("I enter the alias {string}")
    public void iEnterTheData(String alias) {

        WebElement element = driver.findElement(By.id("field-alias"));
        element.sendKeys(alias);
    }

    @And("I enter the adress {string}")
    public void iEnterTheAdress(String address) {
        WebElement element = driver.findElement(By.id("field-address1"));
        element.sendKeys(address);
    }


    @And("I enter the city {string}")
    public void iEnterTheCity(String city) {
        WebElement element = driver.findElement(By.id("field-city"));
        element.sendKeys(city);
    }

    @And("I enter the zip {string}")
    public void iEnterTheZip(String zip) {
        WebElement element = driver.findElement(By.id("field-postcode"));
        element.sendKeys(zip);
    }

    @And("Select the country")
    public void selectTheCity() {
        Select dayDropdown = new Select(driver.findElement(By.id("field-id_country")));
        dayDropdown.selectByValue("17");
    }

    @And("I enter the phone {string}")
    public void iEnterThePhone(String phone) {
        WebElement element = driver.findElement(By.id("field-phone"));
        element.sendKeys(phone);
    }

    @And("I save the new address")
    public void iSaveTheNewAddress() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary.form-control-submit.float-xs-right[type='submit']")));
        element.click();
    }

    @When("I click Update")
    public void iClickUpdate() {
        List<WebElement> elements = driver.findElements(By.cssSelector("a[data-link-action='edit-address']"));
        WebElement lastElement = elements.get(elements.size() - 1);
        lastElement.click();
    }

    @Then("I verify the new alias with {string}")
    public void iVerifyTheNewAliasWith(String alias) {
        WebElement element = driver.findElement(By.id("field-alias"));
        String received = element.getAttribute("value");
        Assert.assertTrue(received.contains(alias));
    }

    @And("I verify the new address {string}")
    public void iVerifyTheNewAddress(String address) {
        WebElement element = driver.findElement(By.id("field-address1"));
        String received = element.getAttribute("value");
        Assert.assertTrue(received.contains(address));
    }

    @And("I verify the new city {string}")
    public void iVerifyTheNewCity(String city) {
        WebElement element = driver.findElement(By.id("field-city"));
        String received = element.getAttribute("value");
        Assert.assertTrue(received.contains(city));
    }

    @And("I verify the new  zip {string}")
    public void iVerifyTheNewZip(String zip) {
        WebElement element = driver.findElement(By.id("field-postcode"));
        String received = element.getAttribute("value");
        Assert.assertTrue(received.contains(zip));
    }

    @And("I verify the new phone {string}")
    public void iVerifyTheNewPhone(String phone) {
        WebElement element = driver.findElement(By.id("field-phone"));
        String received = element.getAttribute("value");
        Assert.assertTrue(received.contains(phone));
    }
}
 



