<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="/WEB-INF/jstl/SampleAppTagsDescriptor.tld" prefix="app"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    
		<app:fullTitle pageTitle="${title}" />
		
		<link href="<c:url value='resources/application.css'/>" media="all" rel="stylesheet" />
			
		<jsp:include page="_shim.jsp" />
		
		<decorator:head />
	</head>
	<body>
	
		<jsp:include page="_header.jsp" />

		<div class="container">
			<decorator:body />
			<jsp:include page="_footer.jsp" />
		</div>
		
		<script src="<c:url value='resources/application.js'/>"></script>
	</body>
</html>