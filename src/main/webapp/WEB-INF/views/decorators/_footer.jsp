<%@ taglib uri="/WEB-INF/jstl/RequestMappingTagDescriptor.tld" prefix="req"%>

<footer class="footer">
	<small> <a href="#">Java Web Tutorial</a> by Fabrício Lima
	</small>
	<nav>
		<ul>
			<li><a href="<req:pathTo mappingName='aboutPath'/>">About</a></li>
			<li><a href="<req:pathTo mappingName='contactPath'/>">Contacts</a></li>
			<li><a href="http://news.refactoring.me/">News</a></li>
		</ul>
	</nav>
</footer>