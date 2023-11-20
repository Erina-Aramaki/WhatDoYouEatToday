<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>会員専用</title>
</head>
<body>
	<h1>会員ページ</h1>
	<p><c:out value="${name} さん、マイページへようこそ！" /></p>
	
	<p><a href="select">◆今日なに食べる？</a></p>
	<p><a href="">◆お気に入り</a></p>
	<p><a href="user">◆会員情報</a></p>
	
	<p><a href="../logout">ログアウト</a></p>
</body>
</html>