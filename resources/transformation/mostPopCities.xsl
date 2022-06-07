<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml"/>
<xsl:template match="citiesSearcher">
    <cities>
        <xsl:for-each select="//city">
            <xsl:sort select="inhabitants" data-type="number" order="DESCENDING"/>
        <xsl:if test="position() &lt;=5">
            <xsl:apply-templates select="."></xsl:apply-templates>
            </xsl:if>
        </xsl:for-each>
    </cities>
</xsl:template>
<xsl:template match="city">
        <xsl:copy-of select="."/>
</xsl:template>
</xsl:stylesheet>