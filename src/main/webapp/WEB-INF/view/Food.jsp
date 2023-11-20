<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>料理一覧</title>
</head>
<body>
	<h1>料理一覧</h1>
	<c:forEach items="${foods}" var="food" varStatus="vs">
		<p><c:out value="${food.name}" /></p>
	</c:forEach>
	
	<p><a href="select">今日なに食べる？トップへ戻る</a></p>
	<p><a href="mypage">マイページへ戻る</a></p>
</body>
</html>