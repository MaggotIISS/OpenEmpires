<?xml version="1.0" encoding="UTF-8"?>
<!-- StyleTable -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html"/>
  <xsl:template match="/">
    <html>
      <head>
        <script>
          SCRIPT
        </script>
      </head>
      <body>
        <h2>TITLE</h2>
        <table border="1">
          <tr bgcolor="#9acd32">
            <th>LINK</th>
            <th>PICTURE</th>
            <th>TEXT</th>
            <th>ID</th>
          </tr>
          <xsl:for-each select="category/item">
            <tr>
              <td>
                <xsl:value-of select="link"/>
              </td>
              <td>
                <xsl:value-of select="picture"/>
              </td>
              <td>
                <xsl:value-of select="text"/>
              </td>
              <td>
                <xsl:value-of select="id"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
