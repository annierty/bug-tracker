<%-- 
    Document   : login
    Created on : 10 5, 18, 10:26:16 PM
    Author     : Admin
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/css/styles.css"/>
    </head>
    <div class="container">
        
       <nav class="navbar navbar-light bg-light">
        <form class="form-inline" action ="/home" method="POST">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Add New Track</button>
        </form>
       </nav>
       
        <table class="table table-striped">
            <thead class="thead-light">
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Ticket #</th>
              <th scope="col">Description</th>
              <th scope="col">Status</th>
              <th scope="col">Handled By</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${list}" var="item">
                <tr>
                 <th scope="row">1</th>
                 <td>${item.ticketNum}</td>
                 <td>${item.description}</td>
                 <td>${item.status}</td>
                 <td>${item.handleBy}</td>
                </tr>
            </c:forEach>
            
          </tbody>
        </table>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </body>
</html>
