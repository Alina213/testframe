package eb.core.controls;


import eb.core.Selenium;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new HtmlElementDecorator(Selenium.getWebDriver()), this);
    }


}
