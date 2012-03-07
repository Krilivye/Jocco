<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='content-type' content='text/html;charset=utf-8'>
    <title>Jocco Doccumentation</title>
    <link rel=stylesheet href="http://jashkenas.github.com/docco/resources/docco.css">
	<link href="google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="google-code-prettify/prettify.js"></script>
</head>
<body onload="prettyPrint()">
<div id=container>
    <div id=background></div>
    <#list theList as alist>
    <table cellspacing=0 cellpadding=0>
    <thead>
      <tr>
        <th class=docs><h1>${alist.name}</h1></th>
        <th class=code></th>
      </tr>
    </thead>
    <tbody>
    		<#list alist.listOfSections as sections>
				<tr>
						<td class="docs">
							<div class="pilwrap">
	                			<a class="pilcrow" href="#${alist.name}_section_${sections_index + 1}">&#182;</a>
	              			</div>
							${sections.docHTML}
						</td>
						<td class="code">
							${sections.codeHTML}						
						</td>
				</tr>
			</#list>
    </tbody>
    </table>
    </#list>
</div>
</body>
</html>