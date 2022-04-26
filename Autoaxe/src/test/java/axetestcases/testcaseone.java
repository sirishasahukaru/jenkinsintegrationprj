package axetestcases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.deque.html.axecore.axeargs.AxeRunOnlyOptions;
import com.deque.html.axecore.axeargs.AxeRunOptions;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;

public class testcaseone {
	@Test
	public static void checkAccessibility() {
		System.setProperty("webdriver.chrome.driver","C://Users//siris//Downloads//chromedriver_win32//chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.google.com/");
	    
	  AxeRunOnlyOptions runOnlyOptions = new AxeRunOnlyOptions();
	    runOnlyOptions.setType("tag");
	    runOnlyOptions.setValues(Arrays.asList("wcag2a", "wcag2aa"));

	    AxeRunOptions options = new AxeRunOptions();
	    options.setRunOnly(runOnlyOptions);

	    AxeBuilder axe = new AxeBuilder().withOptions(options);
	    //Pass WebDriver Object
	    Results result = axe.analyze(driver);
	    List<Rule> violationList = result.getViolations();
	    System.out.println("Violation list size :"+result.getViolations().size());
	    for (Rule r : result.getViolations()) {
	        System.out.println("Complete = "+r.toString());
	        System.out.println("Tags = "+r.getTags());
	        System.out.println("Description = "+r.getDescription());
	        System.out.println("Help Url = "+r.getHelpUrl());
	        System.out.println("*****************************************************************************");
	    }

	    System.out.println("Inapplicable list size :"+result.getInapplicable().size());
	    for (Rule r : result.getInapplicable()) {
	        System.out.println("Complete = "+r.toString());
	        System.out.println("Tags = "+r.getTags());
	        System.out.println("Description = "+r.getDescription());
	        System.out.println("Help Url = "+r.getHelpUrl());
	        System.out.println("*****************************************************************************");
	    } 
	}

	
}
