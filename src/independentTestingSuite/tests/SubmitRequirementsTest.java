package independentTestingSuite.tests;

import independentTestingSuite.pages.LandingPage;
import independentTestingSuite.pages.SubmitRequirementsScreen;
import independentTestingSuite.tests.base.SterileTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SubmitRequirementsTest extends SterileTest {
    private LandingPage mainPage;
    private SubmitRequirementsScreen submitScreen;

    @BeforeMethod
    public void setUp() {
        mainPage = openSystem();
        mainPage.navBar().hoverOnMenu("Features").andClickOption("Hotels Module");
    }

    @Test(  description = "Validate that the form works with valid input",
            groups = {"author:Kfir", "tag:Valid", "device:WindowsComputer"})
    public void submitValidRequirements() {
        submitScreen = mainPage.clickOnSubmitRequirements()
                                .openSubmitRequirementsScreen();
        submitScreen.startForm();
        submitScreen.submitEmailAddress("vuskk5@gmail.com");
        submitScreen.submitWhatsAppContact("0549576063");
        submitScreen.submitName("Kfir Doron");
        submitScreen.chooseOfferedServices("Hotel Rooms", "Cruises or Boats");
        submitScreen.choosePlatforms('A', 'C', 'E');
        submitScreen.checkAlreadyHaveWebSite(false);
        submitScreen.submitForm();

        wait.withMessage("Form was not completed")
            .until(visibilityOf(submitScreen.getPageCompletionIcon()));
    }
}
