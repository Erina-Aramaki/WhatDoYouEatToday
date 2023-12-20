<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>会員登録 | 今日なに食べる？</title>
</head>
<body>
	<h1>会員登録</h1>
	<form action="" method="post">
		<p>名前：<input type="text" name="name" placeholder="山田花子" /></p>
		<p>メールアドレス：<input type="email" name="email" placeholder="1234@mail.com" /></p>
		<p>ログインID：<input type="text" name="loginId" placeholder="ログインID" /></p>
		<p><small>※登録完了後、ログインIDは変更できません</small></p>
		<p>パスワード：<input type="password" name="loginPass" placeholder="パスワード" /></p>
		<p><input type="submit" value="登録" /></p>
	</form>
	
	<p><a href="<%= request.getContextPath() %>/login">ログインはこちら</a></p>
</body>
</html>