<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログイン | 今日なに食べる？</title>
</head>
<body>
	<h1>会員ページ ログイン</h1>
	<form action="" method="post">
		<p>ログインID；<input type="text" name="loginId" placeholder="ログイン" /></p>
		<p>パスワード：<input type="password" name="loginPass" placeholder="パスワード" /></p>
		<p><input type="submit" value="ログイン" /></p>
	</form>
	<p><a href="register">会員登録はこちら</a></p> 
</body>
</html>