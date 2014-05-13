package net.codeorbecoded.mytwitter.test.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import net.codeorbecoded.mytwitter.helpers.ApplicationHelper;

import org.junit.Test;

public class StaticPagesIT extends BaseIT {

	// Home page

	@Test
	public void homePageShouldHaveRightTitle() {
		goToPage(siteBase);
		assertThat(getTitle(), is(equalTo(ApplicationHelper.getFullTitle(""))));
	}

	@Test
	public void homePageShouldNotHaveWrongTitle() {
		goToPage(siteBase);
		assertThat(getTitle(), is(not(equalTo(ApplicationHelper.getFullTitle("Home")))));
	}

	@Test
	public void homePageShouldHaveRightContent() {
		goToPage(siteBase);
		assertThat(getTextByTag("h1"), is(equalTo("Welcome to the My Twitter")));
	}

	// Help page

	@Test
	public void helpPageShouldHaveRightTitle() {
		goToPage(siteBase + "help");
		assertThat(getTitle(), is(equalTo(ApplicationHelper.getFullTitle("Help"))));
	}

	@Test
	public void helpPageShouldHaveRightContent() {
		goToPage(siteBase + "help");
		assertThat(getTextByTag("h1"), is(equalTo("Help")));
	}

	// About page

	@Test
	public void aboutPageShouldHaveRightTitle() {
		goToPage(siteBase + "about");
		assertThat(getTitle(), is(equalTo(ApplicationHelper.getFullTitle("About"))));
	}

	@Test
	public void aboutPageShouldHaveRightContent() {
		goToPage(siteBase + "about");
		assertThat(getTextByTag("h1"), is(equalTo("About Us")));
	}

	// Contact page

	@Test
	public void contactPageShouldHaveRightTitle() {
		goToPage(siteBase + "contact");
		assertThat(getTitle(), is(equalTo(ApplicationHelper.getFullTitle("Contact"))));
	}

	@Test
	public void contactPageShouldHaveRightContent() {
		goToPage(siteBase + "contact");
		assertThat(getTextByTag("h1"), is(equalTo("Contact")));
	}

}
