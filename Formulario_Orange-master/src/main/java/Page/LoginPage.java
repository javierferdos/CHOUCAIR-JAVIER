package Page;

import base.Base;
import Locators.Locators;

public class LoginPage extends Base {
    
    public String VerificacionPagina() {
        String titulo="";
        titulo= getDriver().getTitle();
        return titulo;
    }

    public void Login(String username, String password) throws Exception {
        this.wait(1);
        this.type(Locators.txUsernameCampo, username);
        this.wait(1);
        this.type(Locators.txPasswordCampo, password);
        this.wait(2);
        this.click(Locators.btnIngresar);
        this.wait(2);
        if (this.isElementPresent(Locators.msgAlert)){
            String msgalert = this.getAlertText("//div[@id='app']//p");
            throw new IllegalStateException(msgalert+". Terminando el step.");
        }
        System.out.println("Se logro Login exitosamente");
    }


}
