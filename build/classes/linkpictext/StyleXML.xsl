<?xml version="1.0" encoding="UTF-8"?>
<!-- StyleXML -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" omit-xml-declaration="no"/>
  <xsl:template match = "/">
    <xsl:value-of select="@category"></xsl:value-of>
    <xsl:value-of select="@item"></xsl:value-of>
    <xsl:value-of select="@link"></xsl:value-of>
    <xsl:value-of select="@pic"></xsl:value-of>
    <xsl:value-of select="@text"></xsl:value-of>
    <xsl:value-of select="@id"></xsl:value-of>
  </xsl:template>

</xsl:stylesheet>
