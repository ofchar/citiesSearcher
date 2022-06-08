<html>
	<body>
  	{
  		let $v := doc("..//resources//value.xml")/value
  		for $x in doc("..//resources//cities.xml")/citiesSearcher/cities/city[name/text()=$v]/landmarks/landmark
  		return <img src="{$x}"/>
  	}
  	</body>
</html>