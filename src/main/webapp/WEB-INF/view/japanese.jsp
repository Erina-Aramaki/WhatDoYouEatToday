<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>和食のオススメ料理</title>
</head>
<body>
	<h1>和食のオススメ料理</h1>
	<p>あなたにピッタリのオススメ料理はコレ！</p>
	
	<!-- リストで取得してループさせていないため、配列番号を指定する必要がある -->
	<p><c:out value="${japanese.get(0).name}" /></p>

	
	<p><a href="select">今日なに食べる？トップへ戻る</a></p>
	<p><a href="mypage">マイページへ戻る</a></p>
</body>
</html>