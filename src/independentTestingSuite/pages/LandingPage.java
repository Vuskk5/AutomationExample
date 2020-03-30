package independentTestingSuite.pages;

import independentTestingSuite.pages.base.MasterPage;
import org.kfir.customFindBy.CustomFindBy;
import org.openqa.selenium.WebDriver;
import org.selophane.elements.base.Element;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LandingPage extends MasterPage {
    @CustomFindBy(rootXpathString = "Submit Requirements")
    private Element submitRequirements;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public SubmitRequirementsPage clickOnSubmitRequirements() {
        moveToElement(wait.until(visibilityOf(submitRequirements))).click();

        return new SubmitRequirementsPage(driver);
    }
}
