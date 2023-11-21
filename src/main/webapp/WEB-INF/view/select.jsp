<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>今日なに食べる？</title>
</head>
<body>
	<h1>今日なに食べる？</h1>
	<p>今日のご飯を決めるお手伝いをするよ！</p>
	<p>食べたいものを選択してね！</p>
	<a href="japanese"><input type="submit" value="和食料理" /></a>
	<a href="chinese"><input type="submit" value="中華料理" /></a>
	<a href="western"><input type="submit" value="西洋料理" /></a>
	
	<p>料理一覧は<a href="food">こちら</a></p>
	
	<a href="mypage"><input type="submit" value="マイページへ戻る" /></a>
	
	
</body>
</html>