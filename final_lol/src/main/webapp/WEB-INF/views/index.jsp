<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
=======
<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
>>>>>>> main
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
>>>>>>> 7ab4de91f2cc0f5272783670540236ef0d4bfe02
<html>
<head>
    <title>Summoner Search</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<<<<<<< HEAD
            });
        });
     
        function displayGameInfo(gameInfoList) {
            $("#gameInfoTable tbody").empty();

            if (gameInfoList.length > 0) {
                $.each(gameInfoList, function (index, gameInfo) {
                    var summonerInfo = gameInfo.info.participants.find(function (participant) {
                        return participant.riotIdGameName === gameName && participant.riotIdTagline === tagLine;
                    });
                    var gameWinInfo = gameInfo.info.teams.find(function (team){
                    	return team.win === summonerInfo.win;
                    });
                    if (summonerInfo) {
                        var gameRow = "<tr>" +
                            "<th rowspan='2'>" + gameInfo.info.gameMode + "</th>" +
                            "<th rowspan='3' colspan='2'>" + summonerInfo.championName + "</th>" +
                            "<th rowspan='2'>" + summonerInfo.kills + " / " + summonerInfo.deaths + " / " + summonerInfo.assists + "</th>" +
                            "<th>킬관여율</th>" +
                            "<th rowspan='3'>" + Math.floor(gameInfo.info.gameDuration / 60) + "분" + ((Math.floor(gameInfo.info.gameDuration % 60)) < 10 ? "0" : "") + Math.floor(gameInfo.info.gameDuration % 60) + "초 </th>" +
                            "<td rowspan='3' id ='showMore'><button class='btn_toggle' data-index='" + index + "'>더보기</button></td>" +
                            "</tr>"+
                        	"<tr>" +
                        	"<th>"+ parseFloat(((summonerInfo.kills + summonerInfo.assists) / gameWinInfo.objectives.champion.kills)* 100).toFixed(0) +"%</th>" +
                        	"</tr>" +
                            "<th>" + (summonerInfo.win ? "승리" : "패배") + "</th>" +
                            "<th>" + parseFloat(((summonerInfo.kills + summonerInfo.assists) / summonerInfo.deaths).toFixed(2)) + "점 </th>" +
                            "<th>골드</th>" +
                            "</tr>";
                        $("#gameInfoTable tbody").append(gameRow);
               

                        var showMore = "<tr class='Toggle" + index + "' style='display:none'>" +
                        	"<th colspan='2'>" + gameInfo.info.gameMode + "</th>" +
                            "<th>승리(팀컬러)</th>" +
                            "<th>KDA</th>" +
                            "<th>피해량</th>" +
                            "<th>cs</th>" +
                            "</tr>";
                        for (var i = 0; i < gameInfo.info.participants.length; i++) {
                        	showMore += "<tr class='Toggle" + index + "' style='display:none'>" +
                            	"<td> 챔피언 이미지 </td>" +
                            	"<td>" + gameInfo.info.participants[i].championName + "</td>" +
                            	"<td>" + gameInfo.info.participants[i].riotIdGameName + "</td>" +
                            	"<td>" + parseFloat(((gameInfo.info.participants[i].kills + gameInfo.info.participants[i].assists) / gameInfo.info.participants[i].deaths).toFixed(2)) + "점</td>" +
                            	"<td>" + gameInfo.info.participants[i].totalDamageDealt + "," + gameInfo.info.participants[i].totalDamageTaken + "</td>" +
                            	"<td>" + gameInfo.info.participants[i].totalMinionsKilled + "</td>" +
                            	"</tr>";
                        }
                        $("#gameInfoTable tbody").append(showMore);
                        console.log(showMore);
                    } else {
                        // summonerInfo가 정의되지 않은 경우 처리
                        console.warn("게임 이름에 대한 SummonerInfo를 찾을 수 없습니다:", gameName);
                    }
                });
            	
            } else {
                $("#gameInfoTable tbody").append("<tr><td colspan='3'>게임 정보가 없습니다.</td></tr>");
            }
        }
        $(document).on("click", ".btn_toggle", function () {
        	var currentIndex = $(this).data('index');
        	console.log("Clicked on button with index:", currentIndex);
        	$('.Toggle' + currentIndex).toggle();
    	});

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
<div >
    <table id="gameInfoTable" align="center" border="1" width = "600">
       <tr>
        <th rowspan="2">게임 모드</th>
        <th rowspan="3" colspan="2"> 챔피언 사진</th>
        <th rowspan="2">킬/데스/어시</th>
        <th>킬관여율</th>
       <th rowspan="3">게임시간</th>
       <td rowspan="3" id ="showMore"><button>더보기</button></td>

    </tr>
    <tr>
        <th>777</th> 
    </tr>
    <tr>
        <th>승패</th>
        <th>평균KDa</th>
        <th>골드</th>
    </tr>
    </table>
</div>

</body>
</html>
=======

                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/search", 
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
   <a href="/duo_matching/chatList">매칭 들어가기</a>
    <h1>Summoner Search</h1>
    <form id="searchForm" method="post"> <!-- method 속성 추가 -->
        <label for="gameName">gameName:</label>
        <input type="text" id="gameName" name="gameName" required>
        <label for="tagLine">Tag Line:</label>
        <input type="text" id="tagLine" name="tagLine">
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
        <tbody><!-- Game information will be displayed here -->
        </tbody>
    </table>

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
>>>>>>> 7ab4de91f2cc0f5272783670540236ef0d4bfe02
