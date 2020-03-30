package independentTestingSuite.pages.components.form;

import org.kfir.components.PageComponent;
import org.kfir.elementWait.ElementConditions;

public class FormComponent extends PageComponent {

    public FormComponent() {
        super();
    }

    public void waitUntilActive() {
        getWait().until(ElementConditions.attributeContains(getContext(), "class", "active"));
    }
}
