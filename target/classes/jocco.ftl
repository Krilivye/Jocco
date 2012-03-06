<!DOCTYPE html>
<html>
<head>
    <meta http-eqiv='content-type' content='text/html;charset=utf-8'>
    <title>$1</title>
    <link rel=stylesheet href="http://jashkenas.github.com/docco/resources/docco.css">
</head>
<body>
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