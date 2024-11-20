package Steps;


import Page.HomePage;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import org.junit.After;
import org.junit.Before;


public class hooks {
    HomePage homepage = new HomePage();
@BeforeScenario
    public void setUp(){
        homepage.open();
    }


    @After
    public void trearDown(){

    }
}