package independentTestingSuite.pages;

import independentTestingSuite.pages.base.PageObject;
import independentTestingSuite.pages.components.form.MultiChoiceComponent;
import independentTestingSuite.pages.components.form.TextComponent;
import independentTestingSuite.pages.components.form.YesNoComponent;
import org.kfir.components.api.ComponentFactory;
import org.kfir.customFindBy.CustomFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selophane.elements.base.Element;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SubmitRequirementsScreen extends PageObject {
    @CustomFindBy(rootXpathText = "Let's Go!")
    private Element letsGo;
    @CustomFindBy (id = "wispform1")
    private TextComponent email;
    @CustomFindBy (id = "wispform2")
    private TextComponent whatsAppContact;
    @CustomFindBy (id = "wispform3")
    private TextComponent nameOrBusinessName;
    @CustomFindBy (id = "wispform4")
    private MultiChoiceComponent offeredServices;
    @CustomFindBy (id = "wispform5")
    private MultiChoiceComponent platforms;
    @CustomFindBy (id = "wispform6")
    private YesNoComponent alreadyHasAWebSite;
    @CustomFindBy (className = "Form-nextbutton-button")
    private Element submitChoices;
    @CustomFindBy (className = "Submit-Button")
    private Element submitForm;
    @CustomFindBy (className = "CompletePage-Thumb")
    private Element pageCompletionIcon;

    public SubmitRequirementsScreen(WebDriver driver) {
        super(driver);

        wait.withTimeout(Duration.ofSeconds(10))
            .until(frameToBeAvailableAndSwitchToIt(By.className("wispformPlugin-iframe")));

        wait.until(visibilityOf(letsGo));

        ComponentFactory.initComponents(driver, this);
    }

    public void startForm() {
        wait.until(elementToBeClickable(letsGo)).click();
    }

    public void submitEmailAddress(String email) {
        waitAndSubmitTextBox(this.email, email);
    }

    public void submitWhatsAppContact(String whatsAppContact) {
        waitAndSubmitTextBox(this.whatsAppContact, whatsAppContact);
    }

    public void submitName(String name) {
        waitAndSubmitTextBox(nameOrBusinessName, name);
    }

    public void chooseOfferedServices(String... offeredServicesNames) {
        waitAndChooseOptionsInForm(this.offeredServices, offeredServicesNames);
    }

    public void chooseOfferedServices(Character... servicesAlphabetIndexes) {
        waitAndChooseOptionsInForm(this.offeredServices, servicesAlphabetIndexes);
    }

    public void choosePlatforms(String... platforms) {
        waitAndChooseOptionsInForm(this.platforms, platforms);
    }

    public void choosePlatforms(Character... letters) {
        waitAndChooseOptionsInForm(platforms, letters);
    }

    public void checkAlreadyHaveWebSite(boolean alreadyHasAWebSite) {
        this.alreadyHasAWebSite.waitUntilActive();

        if (alreadyHasAWebSite) {
            this.alreadyHasAWebSite.checkYes();
        }
        else {
            this.alreadyHasAWebSite.checkNo();
        }
    }

    public void submitForm() {
        moveToElement(submitForm).click();
    }

    private void waitAndSubmitTextBox(TextComponent form, String value) {
        form.waitUntilActive();
        form.textBox().set(value);
        form.submitOk().click();
    }

    private void waitAndChooseOptionsInForm(MultiChoiceComponent multiChoice, String... optionsText) {
        multiChoice.waitUntilActive();

        for (String optionText : optionsText) {
            moveToElement(multiChoice.getOptionByText(optionText)).click();
        }

        wait.until(elementToBeClickable(submitChoices)).click();
    }

    private void waitAndChooseOptionsInForm(MultiChoiceComponent multiChoice, Character... alphabetIndexes) {
        multiChoice.waitUntilActive();

        for (Character option : alphabetIndexes) {
            moveToElement(multiChoice.getOptionByChar(option)).click();
        }

        wait.until(elementToBeClickable(submitChoices)).click();
    }

    public Element getPageCompletionIcon() {
        return pageCompletionIcon;
    }
}
