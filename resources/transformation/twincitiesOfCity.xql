<html>
	<body>
		<h1 style="color: rgba(219, 117, 250, 1); border: 3px solid green">Twin cities of city</h1>

		<table style="width: 69%;" border="1" cellspacing="0" cellpadding="0" width="200" align="center" bgcolor="#E7A9FB">
			<tr>
				<th>
					Twin cities
				</th>
			</tr>
		{
			let $v := doc("..//resources//value.xml")/value
			for $x in doc("..//resources//cities.xml")/citiesSearcher/cities/city[name=$v]/twinCities/twinCity
			return <tr>
				<td>
					{$x/text()}
				</td>
			</tr>
		}
		</table>

 </body>
</html>