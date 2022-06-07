(: html Cities that have a certain language as official language ordered by alphabetical order :)

<html>
 <body>
  

return <table><tr><th>Cities</th></tr>
{
   for $x in doc("..//resources//cities.xml")/citiesSearcher/cities/city
   let $v := doc("..//resources//value.xml")/value
   where $x/officialLanguages/language=$v
   order by $x/name 
   return <tr><td>{$x/name/text()}</td></tr>
}
</table>

 </body>
</html>