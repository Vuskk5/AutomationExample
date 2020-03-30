package independentTestingSuite.pages.components.form;

import org.kfir.customFindBy.CustomFindBy;
import org.kfir.customFindBy.CustomFindBys;
import org.openqa.selenium.WebElement;

public class YesNoComponent extends FormComponent {
    @CustomFindBys({
            @CustomFindBy(className = "UI_YesNo-InteractableOption"),
            @CustomFindBy(descendantXpathString = "Yes")
    })
    private WebElement yes;

    @CustomFindBys({
            @CustomFindBy(className = "UI_YesNo-InteractableOption"),
            @CustomFindBy(descendantXpathString = "No")
    })
    private WebElement no;

    public YesNoComponent() {
        super();
    }

    public void checkYes() {
        yes.click();
    }

    public void checkNo() {
        no.click();
    }
}
