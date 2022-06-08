<html>
	<body>

		<h1 style="color: rgba(219, 117, 250, 1); border: 3px solid green">Flags of countries</h1>

		<table style="width: 69%;" border="1" cellspacing="0" cellpadding="0" width="200" align="center" bgcolor="#E7A9FB">
			<tr>
				<th>
					Country
				</th>
				<th>
					Flag
				</th>
			</tr>
		{
			for $x in distinct-values(doc("..//resources//cities.xml")//country)
			return <tr>
				<td>
					{$x}
				</td>
				<td>
					<img src="http://{doc('..//resources//cities.xml')//city[country/text()=$x][1]/countryFlag}"/>
				</td>
			</tr>
		}
		</table>

	</body>
</html>

