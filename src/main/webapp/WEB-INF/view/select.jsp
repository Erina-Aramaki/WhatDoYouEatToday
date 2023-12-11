<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>今日なに食べる？ | 今日なに食べる？</title>
</head>
<body>
	<h1>今日なに食べる？</h1>
	<p>今日のご飯を決めるお手伝いをするよ！</p>
	<a href="genre"><input type="submit" value="診断スタート" /></a>
	
	<p>料理一覧は<a href="food">こちら</a></p>
	
	<p><a href="mypage">マイページへ戻る</a></p>
</body>
</html>