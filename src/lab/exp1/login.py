import cgi
import cgitb; cgitb.enable()
# get the info from the html form
form = cgi.FieldStorage()
#set up the html stuff
reshtml = """Content-Type: text/html\n
<html>
 <head><title>Security Precaution</title></head>
 <body>
 """
 
print reshtml 
 
User = form['UserName'].value
Pass = form['PassWord'].value
 
if User == 'john' and Pass == 'jacob':
	print '<big><big>Welcome'
	print 'mr. Jingleheimerschmidt !</big></big><br>'
	print '<br>'
else:
	print 'Sorry, incorrect user name or password' 
	print '</body>'
print '</html>'
