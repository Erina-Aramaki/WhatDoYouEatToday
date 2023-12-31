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

	<header>
	  <div class="flex">
	    <h1>What do you eat today?</h1>
	    <nav>
	      <ul class="flex">
	        <li><a href="<%= request.getContextPath() %>/register">会員登録</a></li>
	        <li><a href="<%= request.getContextPath() %>/login">ログイン</a></li>
	      </ul>
	    </nav>
	  </div> 
	</header>
	
	<main>
		<h2>ログアウトしました</h2>
		<p><a href="<%= request.getContextPath() %>/login">ログイン画面に戻る</a></p>
	</main>
	
	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>
</body>
</html>