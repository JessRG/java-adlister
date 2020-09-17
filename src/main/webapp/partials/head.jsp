<%-- This is where all the code in the <head> tag will go --%>
<%-- Here, we'll need 1) Page Title, 2) Bootstrap CSS --%>

<%-- The Bootstrap CSS will always remain the same --%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<%-- The Page title should be dynamic, based on what page we are viewing --%>
<title>${param.title}</title>
