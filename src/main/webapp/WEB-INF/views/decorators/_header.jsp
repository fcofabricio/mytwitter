<%@ taglib uri="/WEB-INF/jstl/RequestMappingTagDescriptor.tld" prefix="req"%>

<header>
	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
				<a class="navbar-brand" href="<req:pathTo mappingName='homePath'/>" id="logo">My Twitter</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
    	<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<req:pathTo mappingName='homePath'/>">Home</a></li>
					<li><a href="<req:pathTo mappingName='helpPath'/>">Help</a></li>
					<li><a href="#">Sign in</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>