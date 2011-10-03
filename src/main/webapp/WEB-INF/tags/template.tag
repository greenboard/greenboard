<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Greenboard</title>
		<link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/resources/css/greenboard.less"></link>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/less-1.1.3.min.js"></script>
		
		<style type="text/css">
			body {
				padding-top: 60px;
			}
		</style>
	</head>
	
	<body>
		<div class="topbar">
			<div class="fill">
				<div class="container">
					<ul class="nav">
						<li class="active"><a href="#">Home</a>
						</li>
						<li><a href="#about">Learn More</a>
						</li>
						<li><a href="#contact">Contact</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	
		<div class="container">
			<jsp:doBody></jsp:doBody>
		</div>
	
		<footer>
			<p>&copy; Greenboard 2011</p>
		</footer>
	</body>
</html>
