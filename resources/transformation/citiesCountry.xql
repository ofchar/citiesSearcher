for $x in doc("..//resources//cities.xml")/citiesSearcher/cities/city
let $v := doc("..//resources//value.xml")/value
where $x/country=$v
return concat($x/name, " ")
