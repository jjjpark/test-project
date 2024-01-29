<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
=======
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
>>>>>>> 58f9ecd9e071598ff1fa33eeb740af7e3be8d525
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<<<<<<< HEAD
    <title>Summoner Search</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
    $(document).ready(function () {
        var gameName;
        var tagLine;

        $("#searchForm").submit(function (event) {
            event.preventDefault();
            gameName = $("#gameName").val();
            tagLine = $("#tagLine").val();

            if (gameName.trim() === "") {
                alert("gameName cannot be empty.");
                return;
            }

            $.ajax({
                type: "POST",
                url: "search",
                data: { gameName: gameName, tagLine: tagLine },
                success: function (data) {
                    console.log("Received data:", data);
                    displayGameInfo(data);
                },
                error: function (xhr, textStatus, errorThrown) {
                    console.error("Error occurred during AJAX request:");
                    console.error("Status: " + textStatus);
                    console.error("Error: " + errorThrown);
                    alert("Error occurred during AJAX request. See the console for details.");
                }
            });
        });

        function displayGameInfo(gameInfoList) {
            $("#gameInfoTable tbody").empty();
            if (gameInfoList.length > 0) {
                $.each(gameInfoList, function (index, gameInfo) {
                    var summonerInfo = gameInfo.info.participants.find(function (participant) {
                        return participant.riotIdGameName === gameName && participant.riotIdTagline === tagLine;
                    });

                    if (summonerInfo) {
                        var row = "<tr>" +
                            "<td>" + gameInfo.info.gameMode + "</td>" +
                            "<td>" + (summonerInfo.win ? "Win" : "Lose") + "</td>" +
                            "<td>" + Math.floor(gameInfo.info.gameDuration / 60) + "분" + ((Math.floor(gameInfo.info.gameDuration % 60)) < 10 ? "0" : "") + Math.floor(gameInfo.info.gameDuration % 60) + "초 </td>" +
                            "<td>" + summonerInfo.championName + "</td>" +
                            "<td>" + summonerInfo.kills + " / " + summonerInfo.deaths + " / " + summonerInfo.assists + "</td>" +
                            "<td>" + parseFloat(((summonerInfo.kills + summonerInfo.assists) / summonerInfo.deaths).toFixed(2)) + "</td>" +
                            "</tr>";

                        $("#gameInfoTable tbody").append(row);
                    } else {
                        // Handle the case when summonerInfo is undefined
                        console.warn("SummonerInfo not found for gameName:", gameName);
                    }
                });
            } else {
                $("#gameInfoTable tbody").append("<tr><td colspan='3'>No game information available.</td></tr>");
            }
        }
    });
    </script>
</head>
<body>
    <h1>Summoner Search</h1>
    <form id="searchForm">
        <label for="gameName">gameName:</label>
        <input type="text" id="gameName" name="gameName" required>
        <label for="tagLine">Tag Line:</label>
        <input type="text" id="tagLine" name="tagLine"> <!-- 태그라인 입력 필드 추가 -->
        <input type="submit" value="Search">
    </form>

    <h2>Game Information</h2>
    <table id="gameInfoTable" border="1">
        <thead>
            <tr>
                <th>GameMode</th>
                <th>Win</th>
                <th>Time</th>
                <th>Champion</th>
                <th>KDA</th>
                <th>Score</th>
            </tr>
        </thead>
        <tbody>
            <!-- Game information will be displayed here -->
        </tbody>
    </table>
</body>
</html>
=======
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Summoner Search</title>
</head>
<body>
<<<<<<< HEAD
<h1>INDEX 메인페이지</h1>
  <a href="/register">회원가입</a>
    <a href="/login">로그인</a>
    <a href="#">게시판</a>
    
      <form action="${pageContext.request.contextPath}/search" method="post">
        <label for="summonerName">Summoner Name:</label>
        <input type="text" id="summonerName" name="summonerName" />
        <button type="submit">Search</button>
    </form>
    <h3>index.jsp</h3>
	<a href="/duo_maching/matching">매칭 들어가기</a>
</body>
</html>
<<<<<<< HEAD
>>>>>>> 58f9ecd9e071598ff1fa33eeb740af7e3be8d525
=======
<<<<<<< HEAD
=======













>>>>>>> main

</body>
</html>
>>>>>>> e9746785505a6e4aef761cf8ca82580f438e524d
=======

	<h1>INDEX 메인페이지</h1>
	<a href="/register">회원가입</a>
	<a href="/login">로그인</a>
	<a href="#">게시판</a>

	<form action="${pageContext.request.contextPath}/search" method="post">
		<label for="summonerName">Summoner Name:</label> 
		<input type="text"id="summonerName" name="summonerName" />
		<button type="submit">Search</button>
	</form>
</body>
</html>
>>>>>>> 658bc8d46c18f152ccf9a58000e16a75977438d1
