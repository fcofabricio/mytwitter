package net.codeorbecoded.mytwitter.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.codeorbecoded.mytwitter.annotations.RequestMappingName;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;


public class RequestMappingUtils {
	
	private static final String URLMAPPING_NAME_SUFFIX = "Path";
	
	private static RequestMappingUtils instance;
	
	private Map<String, String> requestMappings;

	public RequestMappingUtils() {
		requestMappings = new HashMap<>();
		
		Reflections reflections = new Reflections(new ConfigurationBuilder()
	        .setUrls(ClasspathHelper.forPackage("net.codeorbecoded.mytwitter"))
	        .setScanners(new MethodAnnotationsScanner()));
		
		Set<Method> methods = reflections.getMethodsAnnotatedWith(RequestMapping.class);
		
		for (Method method : methods) {
			RequestMappingName annotation = method.getAnnotation(RequestMappingName.class);
			String name = (annotation == null ? method.getName() : annotation.value()) + URLMAPPING_NAME_SUFFIX;
			requestMappings.put(name, method.getAnnotation(RequestMapping.class).value()[0]);
		}

	}
	
	public static RequestMappingUtils getInstance() {
		if (instance == null) {
			instance = new RequestMappingUtils();
		}
		
		return instance;
	}
	
	public String getPathFromMappingName(String mappingName) {
		return requestMappings.get(mappingName);
	}

}
