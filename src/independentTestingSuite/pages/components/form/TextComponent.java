package independentTestingSuite.pages.components.form;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selophane.elements.widget.TextBox;

public class TextComponent extends FormComponent {
    @FindBy (tagName = "input")
    private TextBox textBox;

    @FindBy (className = "TextSubmitButton-OK")
    private WebElement submitOk;

    public TextComponent() {
        super();
    }

    public TextBox textBox() {
        return textBox;
    }

    public WebElement submitOk() {
        return submitOk;
    }
}
