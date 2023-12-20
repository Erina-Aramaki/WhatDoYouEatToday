<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>今日なに食べる？</title>
</head>
<body>
	<h1>今日なに食べる？</h1>
	<p>食べたいジャンルを選択してね！</p>
	<a href="japanese"><input type="submit" value="和食料理" /></a>
	<a href="chinese"><input type="submit" value="中華料理" /></a>
	<a href="western"><input type="submit" value="西洋料理" /></a>
	
	<p><a href="<%= request.getContextPath() %>/admin/mypage">マイページへ戻る</a></p>
	
	
</body>
</html>