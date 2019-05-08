<?xml version="1.0" encoding="UTF-8"?>
<!-- StyleText -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" omit-xml-declaration="yes"/>
  <xsl:template match="/">
    <xsl:for-each select="category/item">
      LINK = <xsl:value-of select="link"/>
      <br/>
      PIC = <xsl:value-of select="picture"/>
      <br/>
      TXT = <xsl:value-of select="text"/>
      <br/>
      ID = <xsl:value-of select="id"/>
      <br/>
      <br/>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>
