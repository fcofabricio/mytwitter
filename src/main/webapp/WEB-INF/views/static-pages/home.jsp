<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/jstl/RequestMappingTagDescriptor.tld" prefix="req"%>

<div class="center jumbotron">
  <h1>Welcome to the My Twitter</h1>

  <h2>
    This is the home page for the <a href="#">Java Web Tutorial</a> sample application 
  </h2>

	<a href="<req:pathTo mappingName='signupPath'/>" class="btn btn-primary btn-lg" role="button">Sign up now!</a>
</div>
