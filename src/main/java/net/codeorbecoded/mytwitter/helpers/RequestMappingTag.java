package net.codeorbecoded.mytwitter.helpers;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.codeorbecoded.mytwitter.utils.RequestMappingUtils;

public class RequestMappingTag extends TagSupport {
	
	private String mappingName;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		try {
			out.write(
				pageContext.getServletContext().getContextPath() +
					RequestMappingUtils.getInstance().getPathFromMappingName(getMappingName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	public String getMappingName() {
		return mappingName;
	}

	public void setMappingName(String mappingName) {
		this.mappingName = mappingName;
	}

}
