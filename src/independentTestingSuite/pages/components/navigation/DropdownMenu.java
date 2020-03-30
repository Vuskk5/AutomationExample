package independentTestingSuite.pages.components.navigation;

import org.kfir.components.PageComponent;
import org.kfir.customFindBy.CustomFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DropdownMenu extends PageComponent {
    @CustomFindBy (css = "span > span")
    private WebElement menuName;
    @CustomFindBy (tagName = "li")
    private List<WebElement> options;

    public DropdownMenu() {

    }

    public void andClickOption(String optionName) {
        new Actions(getDriver()).moveToElement(getOptionByName(optionName)).click().build().perform();
    }

    private WebElement getOptionByName(String optionName) {
        for (WebElement option : options) {
            if (option.getText().equals(optionName)) {
                return option;
            }
        }
        return null;
    }

    public String getMenuName() {
        return menuName.getText();
    }

    private List<WebElement> getOptions() {
        return options;
    }
}
