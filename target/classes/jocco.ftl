<!DOCTYPE html />
<html>
	<head>
		<title>@Title</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link href="@(PathToCss)" rel="stylesheet" media="all" type="text/css" />
		<script src="@(PathToJs)" type="text/javascript"></script>
	</head>
	<body onload="prettyPrint()">
		<div id="container">
			<div id="background"></div>
			@if (@Sources.Count > 1) {
				<div id="jump_to">
					Jump To &hellip;
					<div id="jump_wrapper">
						<div id="jump_page">
							@for (var i = 0; i < Sources.Count; i++) {
								<a class="source" href="@GetSourcePath(Sources[i])">
									@Sources[i].Substring(2)
								</a>
							}
						</div>
					</div>
				</div>
			}
			<table cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th class="docs">
							<h1>@Title</h1>
						</th>
						<th class="code"></th>
					</tr>
				</thead>
				<tbody>
				<#list theList as alist>
					<tr id="section_@(i + 1)">
						<td class="docs">
							<div class="pilwrap">
								<a class="pilcrow" href="#section_@(i + 1)">&#182;</a>
							</div>
							${alist.name}
						</td>
						<td class="code">
						<#list alist.listOfSections as sections>
						<pre><code class='prettyprint'>${sections.docHTML}</code></pre>
						</#list>
						</td>
						
					</tr>
				</#list>
				</tbody>
			</table>
		</div>
	</body>
</html>