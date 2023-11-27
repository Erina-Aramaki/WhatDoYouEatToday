<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報</title>
</head>
<body>
	<h1>会員情報を編集</h1>
	<form action="" method="post">
		<table border="1" style="border-collapse: collapse">
			<tr><th>お名前</th></tr>
			<tr><td><input type="text" value="<c:out value="${name}" />" name="name" /></td></tr>
			<tr><th>ログインID<small>※変更不可</small></th></tr>
			<!-- 表示のみの入力フィールド disabled value -->
			<tr><td><input type="text" name="loginId" disabled value="<c:out value="${loginId}" />" /></td></tr>
			<tr><th>パスワード</th></tr>
			<tr><td><input type="text" value="<c:out value="${loginPass}" />" name="loginPass" /></td></tr>
			<tr><th>メールアドレス</th></tr>
			<tr><td><input type="text" value="<c:out value="${email}" />" name="email" /></td></tr>
		</table>
		<input type="submit" value="編集完了する" />
	</form>

</body>
</html>