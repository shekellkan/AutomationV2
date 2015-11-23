package steps;

import common.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.DriverManager;
import junit.framework.Assert;
import ui.pages.MainPage;
import ui.pages.TeamsPage;
import ui.pages.TopMenuPage;
import ui.pages.teams.AddTeamPage;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Teams {
    private TopMenuPage topMenu;
    private MainPage mainPage = new MainPage();
    private TeamsPage teamPage;
    private AddTeamPage addNewTeam;
    public String newMember;
    /*********** CREATE TEAM ************/
    @Given("^I go to Create Team page$")
    public void new_Team(){
        addNewTeam = mainPage.clickNewTeam();
    }

    @And("^I have to create a new team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void create_Teams_Description(String nameTeam, String description){
        teamPage = addNewTeam.createNewTeams(nameTeam, description);
    }

    @Then("^The new team \"([^\"]*)\" is created.$")
    public void new_Team_Created(String name){
        Assert.assertTrue(teamPage.isNameTeamsDisplayed());
        Assert.assertEquals(name, teamPage.nameTeam());

        teamPage.deleteTeam();
    }

    /**************** DELETE *************/
    @Given("^I create a team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void deleted_a_team(String nameTeam, String description){
        mainPage.clickNewTeam();
        teamPage = addNewTeam.createNewTeams(nameTeam, description);
    }

    @And("^I deleted the team$")
    public void deleted_Teams(){
        mainPage = teamPage.deleteTeam();
    }

    @Then("^The team \"([^\"]*)\" is deleted$")
    public void teams_is_deleted(String teamDeleted){
        //Assert.assertFalse(mainPage.isTeamPresent(teamDeleted));
    }

    /**************** ADD MEMBERS ****************/
    @Given("^I add new members in team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void new_members_team(String nameTeam, String description){
        mainPage.clickNewTeam();
        teamPage = addNewTeam.createNewTeams(nameTeam, description);
    }

    @And("^I navigate until to menu Members$")
    public void navigate_menu_members(){
        teamPage.clickMenuMembers();
    }

    @And("^I add to member \"([^\"]*)\" with the email \"([^\"]*)\"$")
    public void add_new_member(String nameMember, String email){
        teamPage.addMemberInTeam(nameMember, email);
        newMember = teamPage.isNewMemberTeamDisplayed(nameMember);
    }

    @Then("^The  member \"([^\"]*)\" is added in the team$")
    public void new_member_is_added(String nameMember){
        //Assert.assertEquals(nameMember, newMember);
    }

    /**************** AFTER ********************/
    @After(value = "@Teams", order = 999)
    public void afterTeamScenario() {
        topMenu = new TopMenuPage();
        topMenu.logout();
        //DriverManager.getInstance().quitDriver();
    }
}
