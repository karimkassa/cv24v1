<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:cv24="http://univ.fr/cv24">

  <xsl:output method="html" encoding="UTF-8"/>

  <!-- Template pour le format des dates -->
  <xsl:template name="format-date">
    <xsl:param name="date"/>
    <xsl:variable name="day" select="substring($date, 9, 2)"/>
    <xsl:variable name="month" select="substring($date, 6, 2)"/>
    <xsl:variable name="year" select="substring($date, 1, 4)"/>
    <xsl:variable name="monthNames" select="'JanFevMarAvrMaiJunJulAouSepOctNovDec'"/>
    <xsl:variable name="monthIndex" select="number($month) * 3"/>
    <xsl:value-of select="concat($day, ' ', substring($monthNames, $monthIndex - 2, 3), ' ', $year)"/>
  </xsl:template>

  <!-- Template pour le format des numeros de telephone-->
  <xsl:template name="format-phone">
    <xsl:param name="phoneNumber"/>
    <xsl:choose>
      <xsl:when test="starts-with($phoneNumber, '+33')">
        <xsl:value-of select="concat('+33 (0)', substring($phoneNumber, 4))"/>
      </xsl:when>
      <xsl:otherwise>
        <xsl:value-of select="$phoneNumber"/>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <!-- templete racine -->
  <xsl:template match="/">
    <html>
      <head>
        <title>CV24</title>
      </head>
      <body>
        <h1>CV24 - XSLT V1.0</h1>
        <p>Le 14 février 2024</p>
   
        <xsl:apply-templates select="cv24:cv24/cv24:identite"/>
        <xsl:apply-templates select="cv24:cv24/cv24:objectif"/>
         <h2><xsl:text> Expériences professionnelles </xsl:text></h2>
        <xsl:apply-templates select="cv24:cv24/cv24:prof"/>
          <h2><xsl:text> Diplômes </xsl:text></h2>
        <xsl:apply-templates select="cv24:cv24/cv24:competences/cv24:diplome"/>
        <h2><xsl:text>Certifications </xsl:text></h2>
        <xsl:apply-templates select="cv24:cv24/cv24:competences/cv24:certif"/>
        <h2><xsl:text> Langues </xsl:text></h2>
        <xsl:apply-templates select="cv24:cv24/cv24:divers/cv24:lv"/>
        <h2><xsl:text> Divers </xsl:text></h2>
        <xsl:apply-templates select="cv24:cv24/cv24:divers/cv24:autre"/>
        
      </body>



      <style>
        body{
        width: 80%;
        max-width: 700px;
        margin: auto;
        padding: 25px;
        box-sizing: border-box;
        }
        h1{
        text-align: center;
        }
        h1, h2 {
        font-weight: bold;
        color: blue;
        }

        ol li:nth-child(odd) {
        background-color: #fff;
        }
        ol li:nth-child(even) {
        background-color: #f2f2f2;
        }


      </style>
    </html>
  </xsl:template>

  <!-- Template pour la section l'identité -->
  <xsl:template match="cv24:cv24/cv24:identite">
    <h2>
      <xsl:value-of select="cv24:genre"/>&#160;
      <xsl:value-of select="cv24:nom"/>&#160;
      <xsl:value-of select="cv24:prenom"/>
    </h2>
    <p>Tel: <xsl:call-template name="format-phone"><xsl:with-param name="phoneNumber" select="cv24:tel"/></xsl:call-template><br/> 
      Email: <xsl:value-of select="cv24:mel"/></p>
  </xsl:template>

  <!-- Template pour la  Section objectif -->
  <xsl:template match="cv24:cv24/cv24:objectif">
    <h2>Objectif</h2>
    <p>
      <xsl:value-of select="."/>
      <xsl:text> (Statut: </xsl:text>
      <xsl:value-of select="@statut"/>)
    </p>
  </xsl:template>

 <!-- Template pour la  Section experience prof -->
<xsl:template match="cv24:cv24/cv24:prof">
  <ol>
    <xsl:for-each select="cv24:detail">
      <li>
        <xsl:value-of select="cv24:titre"/>
        <xsl:text> (</xsl:text>
        <xsl:call-template name="format-date"><xsl:with-param name="date" select="cv24:datedeb"/></xsl:call-template>
        <xsl:text> au </xsl:text><xsl:call-template name="format-date"><xsl:with-param name="date" select="cv24:datefin"/></xsl:call-template>
        <xsl:text>)</xsl:text>
      </li>
    </xsl:for-each>
  </ol>
</xsl:template>

 <!-- Template pour la  Section diplome-->
<xsl:template match="cv24:cv24/cv24:competences/cv24:diplome">
  <table>   
    <xsl:for-each select=".">
      <tr>     
        <td><xsl:call-template name="format-date"><xsl:with-param name="date" select="cv24:date"/></xsl:call-template></td>
        <td><xsl:value-of select="cv24:titre"/></td>
        <td><xsl:text> (niveau </xsl:text><xsl:value-of select="@niveau"/><xsl:text>)</xsl:text></td>
        <td><xsl:value-of select="cv24:institut"/></td>
      </tr>
    </xsl:for-each>
  </table>
</xsl:template>


<!-- Template pour la section compétence -->
<xsl:template match="cv24:cv24/cv24:competences/cv24:certif">
  <table>
    <xsl:for-each select=".">
      <tr>
        <td><xsl:call-template name="format-date"><xsl:with-param name="date" select="cv24:datedeb"/></xsl:call-template></td>
         <td><xsl:text> - </xsl:text></td>
        <td><xsl:call-template name="format-date"><xsl:with-param name="date" select="cv24:datefin"/></xsl:call-template></td>
        <td><xsl:value-of select="cv24:titre"/></td>
      </tr>
    </xsl:for-each>
  </table>
</xsl:template>

<!-- Templete pour la section langue -->
<xsl:template match="cv24:cv24/cv24:divers/cv24:lv">
  <ul>
    <xsl:for-each select=".">
      <li><xsl:value-of select="@lang"/><xsl:text> : </xsl:text><xsl:value-of select="@cert"/> <xsl:text>(</xsl:text>       
        <xsl:choose>
          <xsl:when test="@nivi">
            <xsl:value-of select="@nivi"/>
          </xsl:when>
          <xsl:otherwise>
            <xsl:value-of select="@nivs"/>
          </xsl:otherwise>
        </xsl:choose>
        <xsl:text>)</xsl:text>
      </li>
    </xsl:for-each>
  </ul>
</xsl:template>

<!-- templete pour la section autre-->
<xsl:template match="cv24:cv24/cv24:divers/cv24:autre">
  <ul>
    <xsl:for-each select=".">
      <li>
        <xsl:value-of select="@titre"/>
        <xsl:text>: </xsl:text>
        <xsl:value-of select="@comment"/>
      </li>
    </xsl:for-each>
  </ul>
</xsl:template>
</xsl:stylesheet>
