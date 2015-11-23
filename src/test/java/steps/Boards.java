package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import ui.pages.*;

/**
 * Created by amateur on 22/11/2015.
 */
public class Boards{
    //private MainPage mainPage;
    private ProjectsPage projectPage;
    private BoardsPage boardsPage;
    private AddBoardPage addBoardPage = new AddBoardPage();
    private TopMenuPage topMenu;

    @And("^I create a board \"([^\"]*)\"$")
    public void create_a_board(String nameBoard){
        projectPage = addBoardPage.createNewBoard(nameBoard);
    }

    @And("^I create a User Stories \"([^\"]*)\"$")
    public void iCreateAUserStories(String nameUserStories){
        boardsPage.createUserStories(nameUserStories);
    }

    @Then("^the board \"([^\"]*)\" is created in the project with a user stories$")
    public void theBoardIsCreatedInTheProjectWithAUserStories(String nameBoard){
        Assert.assertEquals(nameBoard, projectPage.isBoardPresent(nameBoard));
    }

    /**************** AFTER ********************/
    @After(value = "@Teams", order = 999)
    public void afterTeamScenario() {
        projectPage.deleteProject();
        topMenu = new TopMenuPage();
        topMenu.logout();
        //DriverManager.getInstance().quitDriver();
    }
}
