package base;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;

import java.awt.Robot;

import static org.openqa.selenium.By.xpath;

public class Base extends PageObject {

    WebElementFacade element = null;
    List<WebElementFacade> elements = null;

    /******** FUNCIONALIDADES COMUNES ********/

    /***
     * Encontrar elemento con una expresion de busqueda en formato string retornando
     * un WebElementFacade
     ***/
    public WebElementFacade getElement(String locator) {
        return getElement(getBy(locator));

    }

    /***
     * Encontrar elemento con una expresion de busqueda en formato locator
     * retornando un WebElementFacade
     ***/
    public WebElementFacade getElement(By locator) {
        try {
            element = find(locator);
        } catch (Exception e) {
            e.getMessage();
        }
        return element;
    }

    /***
     * Ayuda a identificar un elemento para el metodo getElement(String) que recibe
     * como parametro un string
     ***/
    private By getBy(String locator) {
        By by = null;

        try {
            if (locator.startsWith("id")) {
                locator = locator.substring(3);
                by = By.id(locator);
            } else if (locator.startsWith("xpath")) {
                locator = locator.substring(6);
                by = xpath(locator);
            } else if (locator.startsWith("css")) {
                locator = locator.substring(4);
                by = By.cssSelector(locator);
            } else if (locator.startsWith("name")) {
                locator = locator.substring(5);
                by = By.name(locator);
            } else if (locator.startsWith("link")) {
                locator = locator.substring(5);
                by = By.linkText(locator);
            }

        } catch (Throwable t) {
            t.getMessage();
        }
        return by;
    }

    /***
     * Encontrar multiples elementos con una expresion de busqueda en formato string
     * retornando un WebElementFacade
     ***/
    public List<WebElementFacade> getElements(String locator) {
        return getElements(getBy(locator));

    }

    /***
     * Encontrar multiples elementos con una expresion de busqueda en formato string
     * retornando un WebElementFacade
     ***/
    public List<WebElementFacade> getElements(By locator) {
        try {
            elements = findAll(locator);
        } catch (Exception e) {
            e.getMessage();
        }
        return elements;

    }


    /***
     * Clickea el elemento por medio del parametro locator String
     *
     * @param locator
     */
    public void click(String locator) {
        click(getElement(getBy(locator)));
    }

    /***
     * Clickea el elemento por medio del parametro locator By
     *
     * @param locator
     */
    public void click(By locator) {
        click(getElement(locator));
    }

    public void click(WebElement element) {
        waitFor(element).click();
    }

    /**
     * Ingresa el texto en el elemento
     *
     * @param locator
     * @param value
     */
    public void type(String locator, String value) {
        type(getElement(locator), value);
    }

    /**
     * Ingresa el texto en el elemento
     *
     * @param locator
     * @param value
     */
    public void type(By locator, String value) {
        type(getElement(locator), value);
    }

    public void type(WebElement element, String value) {
        waitFor(element).sendKeys(value);
    }

    /**
     * Retorna el texto por medio de un locator String
     *
     * @param locator
     * @return
     */
    public String getText(String locator) {
        return getText(getElement(locator));
    }

    /**
     * Retorna el texto por medio de un locator By
     *
     * @param locator
     * @return
     */
    public String getText(By locator) {
        return getText(getElement(locator));
    }

    public String getText(WebElement element) {
        return waitFor(element).getText();
    }

    /**
     * Colocar el mouse sobre un elemento por medio de un locator String
     *
     * @param locator
     */
    public void moveMouseTo(String locator) {
        moveMouseTo(getElement(locator));
    }

    /**
     * Colocar el mouse sobre un elemento por medio de un locator By
     *
     * @param locator
     */
    public void moveMouseTo(By locator) {
        moveMouseTo(getElement(locator));
    }

    public void moveMouseTo(WebElement element) {
        WebElement moveTo = waitFor(element);
        withAction().moveToElement(moveTo).perform();
    }

    public String getAlertText(String xpaht) {
        // Ubicar la alerta usando un XPath más corto
        WebElement alertElement = find(xpath(xpaht));
        // Obtener y retornar el texto de la alerta
        return alertElement.getText();
    }

    public boolean isElementPresent(By locator) {
        // Verifica si el elemento existe en la página y retorna true o false
        return !findAll(locator).isEmpty();
    }
    public void wait(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectOptionFromDropdown(By selector, String optionText) {
        // Esperar y hacer clic en el menú desplegable
        WebElementFacade dropdown = find(selector);
        dropdown.waitUntilClickable().click();

        // Localizar la opción basada en el texto proporcionado
        By optionLocator = xpath("//span[text()='" + optionText + "']");

        // Esperar a que la opción esté visible y hacer clic en ella
        WebElementFacade option = find(optionLocator);
        option.waitUntilVisible().click();
    }
    public void uploadFile(String filePath) {
        pause(2000); // Ajusta el tiempo según sea necesario
        // Usar la clase Robot para escribir la ruta del archivo
        try {
            // Copiar la ruta del archivo al portapapeles
            StringSelection stringSelection = new StringSelection(filePath);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            // Usar Robot para simular Ctrl+V para pegar la ruta
            Robot robot = new Robot();

            // Simular Ctrl + V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Simular la tecla "Enter" para aceptar
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    public int getNumfilas(By locator) {
        List<WebElement>tablaPrincipla=getDriver().findElements(locator);
        int numFilas= tablaPrincipla.size();
        return numFilas;
    }

}






