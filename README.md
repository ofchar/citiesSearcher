
# CitiesSearcher
### General information
CitiesSearcher is a data integration program in Java language which presents a unified view of information related to cities around the world. Application uses two data sources, namely Wikipedia.org and DB-city.com websites, to gather important data about each city with the use of Regex mappers. Then such data is processed, stored in XML based global schema for further use, and displayed to the end user. Project also offers functionalities to validate XML file against XSD or DTD, query already saved cities and create output files.

Code is divided into two modules Model and View; *Model* contains classes relevant to data and application’s logic, that is City class used to represent a single city, CityController used to perform operations on city/ies, and two separate components in form of helper packages: wrapper and xmler, first one containing classes used to get data from Wikipedia or DBCity sites and second used to perform operations on xml files.
*View* is based on Spring, and contains forms required to perform operations such as viewing, updating, deleting, and creating cities, querying existing cities and generating xml, html, or text output files. View communicates with Model through methods in CityController class.
###### Mateusz Owczarek, 2022
