<html>
	<body>
		<h1 style="color: rgba(219, 117, 250, 1); border: 3px solid green">Cities queried by language</h1>

		<table style="width: 69%;" border="1" cellspacing="0" cellpadding="0" width="200" align="center" bgcolor="#E7A9FB">
			<tr>
				<th>
					Cities
				</th>
			</tr>
		{
			for $x in doc("..//resources//cities.xml")/citiesSearcher/cities/city
			let $v := doc("..//resources//value.xml")/value
			where $x/officialLanguages/language=$v
			order by $x/name
			return <tr>
				<td>
					{$x/name/text()}
				</td>
			</tr>
		}
		</table>

	</body>
</html>