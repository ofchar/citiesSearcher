<html>
 <body>
   <h1>Cities ordered by area</h1>

   <table border="1" cellspacing="0" cellpadding="0" width="200" align="center" bgcolor="#E7A9FB"><tr><th>City</th><th>Area</th><th>Inhabitants</th></tr>
   {
     for $x in doc("..//resources//cities.xml")/citiesSearcher/cities/city
     order by $x/area descending
     return <tr><td>{$x/name/text()}</td><td>{$x/area/text()}</td><td>{$x/inhabitants/text()}</td></tr>
   }
   </table>
   </body>
 </html>