package net.codeorbecoded.mytwitter.helpers;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FullTitleTag extends TagSupport {

	private String pageTitle;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println(String.format("<title>%s</title>", ApplicationHelper.getFullTitle(getPageTitle())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

}
