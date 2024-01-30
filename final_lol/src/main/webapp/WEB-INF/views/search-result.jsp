<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Result</title>
    <style>
        /* Add your styling here */
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        // You can add JavaScript logic if needed
    </script>
</head>
<body>
    <h1>Search Result</h1>

    <%-- Get parameters from the request --%>
    <% String gameName = request.getParameter("gameName"); %>
    <% String tagLine = request.getParameter("tagLine"); %>

    <%-- Display search parameters --%>
    <p>Showing results for gameName: <%= gameName %>, tagLine: <%= tagLine %></p>

    <%-- You can iterate over the search results and display them here --%>
    <c:forEach var="gameInfo" items="${gameInfoList}">
        <p>Game Mode: ${gameInfo.info.gameMode}</p>
        <p>Win: ${gameInfo.info.participants[0].win}</p>
        <p>Time: ${gameInfo.info.gameDuration}</p>
        <p>Champion: ${gameInfo.info.participants[0].championName}</p>
        <!-- Add more information as needed -->
        <hr>
    </c:forEach>
</body>
</html>