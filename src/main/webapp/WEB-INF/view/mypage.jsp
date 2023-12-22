<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>会員専用 | 今日なに食べる？</title>
</head>
<body>

	<header>
	  <div class="flex">
	    <h1><a href="<%= request.getContextPath() %>/admin/mypage">What do you eat today?</a></h1>
	    <nav>
	      <ul class="flex">
	        <li><a href="<%= request.getContextPath() %>/admin/select">Diagnosis</a></li>
	        <li><a href="<%= request.getContextPath() %>/admin/favorite">favorites</a></li>
	      </ul>
	    </nav>
	  </div> 
	</header>
	
	<main>
		<h2>会員ページ</h2>
		<p><c:out value="${name} さん、マイページへようこそ！" /></p>
		
		<div class="start">
			<p><a href="<%= request.getContextPath() %>/admin/select">◆今日なに食べる？診断</a></p>
			<p><a href="<%= request.getContextPath() %>/admin/favorite">◆お気に入り</a></p>
			<p><a href="<%= request.getContextPath() %>/admin/user">◆会員情報</a></p>
		</div>
		
		<div class="link">
			<p><a href="<%= request.getContextPath() %>/logout">ログアウト</a></p>
		</div>
	</main>
	
	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>
  
</body>
</html>