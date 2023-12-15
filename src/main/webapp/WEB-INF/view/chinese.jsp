<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>中華のオススメ料理 | 今日なに食べる？</title>
</head>
<body>
	<h1>中華のオススメ料理</h1>
	<p>食べたいものを選択してね！</p>
	
	<form action="" method="post">
		<input type="submit" name="1" value="米" />
		<input type="submit" name="2" value="麺" />
		<input type="submit" name="3" value="肉" />
		<input type="submit" name="4" value="魚" />
		<input type="submit" name="5" value="軽食" />
	</form>
	
	<p><a href="<%= request.getContextPath() %>/admin/select">今日なに食べる？トップへ戻る</a></p>
	<p><a href="<%= request.getContextPath() %>/admin/mypage">マイページへ戻る</a></p>
</body>
</html>