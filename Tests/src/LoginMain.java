import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TC-001
//Summary: When logging in from main with incorrect credentials, the system displays an error message.
//1) Visit https://parabank.parasoft.com/parabank/index.htm
//2) Enter an unregistered username in the 'Username' box
//3) Enter an unregistered password in the 'Password' box
//Expected: User is shown the error message: "An internal error has occurred and has been logged."

public class LoginMain {
    public static void main(String[] args) {



        // Set outcome of test result
        boolean pass;

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/keda/Desktop/drivers/chromedriver_mac_arm64/chromedriver");

        // Initialize a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Parabank
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Locate the login element and enter a username
        System.out.println("Entering incorrect username...");
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(2) > input")).sendKeys("invalid");

        // Locate the password element and enter a password
        System.out.println("Entering incorrect password...");
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(4) > input")).sendKeys("invalid");

        // Click on login button
        System.out.println("Clicking 'LOG IN'...");
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(5) > input")).click();

        // Get result of login status
        String output = driver.findElement(By.cssSelector("#rightPanel > p")).getText();

        // Assert the correct error message is displayed
        if (output.equals("An internal error has occurred and has been logged.")) {
            System.out.println(output);
            System.out.println("Expected message displayed.");
            pass = true;
        } else {
            System.out.println("No error message displayed.");
            pass = false;
        }

        System.out.println("Pass = " + pass);

        // Close the browser
        driver.quit();
    }
}
