


<html>
 <body>
  
  <h1>Flags of countries</h1>

<table border="1">
<tr><th>Country</th><th>Flag</th></tr>
{
   for $x in distinct-values(doc("..//resources//cities.xml")//country)
   return <tr><td>{$x}</td><td><img src="{doc('..//resources//cities.xml')//city[country/text()=$x][1]/countryFlag}"/></td></tr>
}
</table>

 </body>
</html>

