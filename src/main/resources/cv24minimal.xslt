<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:cv24="http://univ.fr/cv24">
    <xsl:template match="/">
        <html>
            <head>
                <title>Liste des CV24</title>
                <style>
                    table {
                    border-collapse: collapse;
                    width: 100%;
                    }
                    th, td {
                    border: 1px solid black;
                    padding: 8px;
                    text-align: left;
                    }
                    th {
                    background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h2>Liste des CV24</h2>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Téléphone</th>
                        <th>Email</th>
                    </tr>
                    <xsl:for-each select="cv24:cvMinimalList/cv24:CVMinimal">
                        <tr>
                            <td><xsl:value-of select="cv24:id"/></td>
                            <td><xsl:value-of select="cv24:identite/cv24:nom"/></td>
                            <td><xsl:value-of select="cv24:identite/cv24:prenom"/></td>
                            <td><xsl:value-of select="cv24:identite/cv24:tel"/></td>
                            <td><xsl:value-of select="cv24:identite/cv24:mel"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
