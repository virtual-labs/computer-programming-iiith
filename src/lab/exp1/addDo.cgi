import cgitb; cgitb.enable()
import cgi
import sys
 
form = cgi.FieldStorage()
photos = form["photolist"]
 
i=0
for photo in photos:
    i = i + 1
    finalPhoto = finalPhoto + "," + photo[i]
