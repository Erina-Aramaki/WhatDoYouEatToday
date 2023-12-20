<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>ログアウト | 今日なに食べる？</title>
</head>
<body>
	<h1>ログアウトしました</h1>
	<p><a href="<%= request.getContextPath() %>/login">ログイン画面に戻る</a></p>
</body>
</html>