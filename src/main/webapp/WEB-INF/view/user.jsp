<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/user.css" />
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
	        <li><a href="<%= request.getContextPath() %>/admin/favorite">Favorites</a></li>
	      </ul>
	    </nav>
	  </div> 
	</header>

	<main>
		<h2>会員情報</h2>
	
		<table border="1">
			<tr><th>お名前</th></tr>
			<tr><td><c:out value="${name}" /></td></tr>
			<tr><th>ログインID</th></tr>
			<tr><td><c:out value="${loginId}" /></td></tr>
			<tr><th>パスワード</th></tr>
			<tr><td><c:out value="${loginPass}" /></td></tr> <!-- 後ほど、パスワードを非表示にしログイン確認出来てからパスワードを表示する使用に変更する -->
			<tr><th>メールアドレス</th></tr>
			<tr><td><c:out value="${email}" /></td></tr>
		</table>
	
		<div class="link">
			<a href="<%= request.getContextPath() %>/admin/mypage"><input type="submit" value="マイページへ戻る" /></a>
			<a href="<%= request.getContextPath() %>/admin/editUser"><input type="submit" value="会員情報を編集する" /></a>
		</div>
	</main>

	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>
</body>
</html>