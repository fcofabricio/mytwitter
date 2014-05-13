package net.codeorbecoded.mytwitter.helpers;

import org.springframework.util.StringUtils;

public class ApplicationHelper {
	
	private static final String BASE_TITLE = "Java Web Tutorial Sample App";
	
	public static String getFullTitle(String title) {
		if (StringUtils.hasText(title)) {
			return BASE_TITLE + " | " + title;
		} else {
			return BASE_TITLE;
		}
	}

}
