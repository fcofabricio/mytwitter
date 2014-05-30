package net.codeorbecoded.mytwitter.test.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class UsersPageIT extends BaseIT {
	
		@Test
		public void signupPageShouldHaveRightTitle() {
			drv.get(siteBase + "signup");
			assertThat(getTitle(),
					is(equalTo("Java Web Tutorial Sample App | Sign up")));
		}

		@Test
		public void signupPageShouldHaveRightContent() {
			drv.get(siteBase + "signup");
			assertThat(getBodyText(), containsString("Sign up"));
		}

}
