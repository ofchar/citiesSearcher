<html>
	<body style="font-family: Comic Sans MS; font-size: 169%; text-align: center;">
		<h1 style="color: rgba(219, 117, 250, 1); border: 3px solid green">Cities ordered by area</h1>

	 	<table style="width: 69%;" border="1" cellspacing="0" cellpadding="0" width="200" align="center" bgcolor="#E7A9FB">
		 	<tr>
			 	<th>
				 	City
				</th>
				<th>
					Area
				</th>
				<th>
					Inhabitants
				</th>
			</tr>
	 	{
			for $x in doc("..//resources//cities.xml")/citiesSearcher/cities/city
		 	order by $x/area descending
		 	return <tr>
				<td>
					{$x/name/text()}
				</td>
				<td>
					{$x/area/text()}
				</td>
				<td>
					{$x/inhabitants/text()}
				</td>
			</tr>
	 	}
	 	</table>
	</body>
</html>