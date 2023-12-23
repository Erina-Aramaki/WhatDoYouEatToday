<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>会員情報 | 今日なに食べる？</title>
</head>
<body>

	<header>
	  <div class="flex">
	    <h1><a href="<%= request.getContextPath() %>/admin/mypage">What do you eat today?</a></h1>
	    <nav>
	      <ul class="flex">
	        <li><a href="<%= request.getContextPath() %>/admin/mypage">Mypage</a></li>
	        <li><a href="<%= request.getContextPath() %>/admin/select">Diagnosis</a></li>
	        <li><a href="<%= request.getContextPath() %>/admin/favorite">favorites</a></li>
	      </ul>
	    </nav>
	  </div> 
	</header>
	
	<main>
		<h2>会員情報を編集</h2>
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
			<div class="link">
				<input id="completion" type="submit" value="編集完了する" />
			</div>
		</form>
	</main>
	
	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/script.js"></script>

</body>
</html>