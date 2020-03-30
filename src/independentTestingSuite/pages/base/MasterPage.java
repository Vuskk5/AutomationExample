package independentTestingSuite.pages.base;

import independentTestingSuite.pages.components.navigation.NavigationBar;
import org.kfir.components.api.ComponentFactory;
import org.kfir.customFindBy.CustomFindBy;
import org.openqa.selenium.WebDriver;

public class MasterPage extends PageObject {
    @CustomFindBy (id = "main-menu")
    private NavigationBar navBar;

    protected MasterPage(WebDriver driver) {
        super(driver);

        ComponentFactory.initComponents(driver, this);
    }

    public NavigationBar navBar() {
        return this.navBar;
    }
}
