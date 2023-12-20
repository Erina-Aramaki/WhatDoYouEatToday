<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>会員専用 | 今日なに食べる？</title>
</head>
<body>
	<h1>会員ページ</h1>
	<p><c:out value="${name} さん、マイページへようこそ！" /></p>
	
	<p><a href="select">◆今日なに食べる？診断</a></p>
	<p><a href="favorite">◆お気に入り</a></p>
	<p><a href="user">◆会員情報</a></p>
	
	<p><a href="<%= request.getContextPath() %>/logout">ログアウト</a></p>
</body>
</html>