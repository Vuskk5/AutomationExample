package independentTestingSuite.pages.components.form.subform;

import org.kfir.components.PageComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OptionComponent extends PageComponent {
    @FindBy(className = "UI_Choice-content-text")
    private WebElement text;
    @FindBy(className = "UI_Choice-index")
    private WebElement index;

    public OptionComponent() {
        super();
    }

    public String getText() {
        return this.text.getText().trim();
    }

    public String getIndex() {
        return this.index.getText().trim();
    }

    public WebElement getContext() {
        return super.getContext();
    }

//    @Override
//    public String toString() {
//        return this.index.getText() + " - " + this.text.getText();
//    }
}
