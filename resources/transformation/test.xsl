<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html"/>
<xsl:template match="citiesSearcher">
  <html>
     <head>
      <title>Monuments of Warsaw</title>
     </head>
     <body>
           <xsl:for-each select="//cities/city[name='warsaw']/landmarks/landmark">
           <tr>
             <td><img src="{.}"></img></td>
           </tr>
        </xsl:for-each>
     </body>
  </html>
</xsl:template>
</xsl:stylesheet>