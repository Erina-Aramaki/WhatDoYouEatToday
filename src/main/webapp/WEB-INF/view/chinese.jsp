<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/select.css" />
<title>中華のオススメ料理 | 今日なに食べる？</title>
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
		<h2>中華のオススメ料理</h2>
		<p>食べたいものを選択してね！</p>
		
		<form action="" method="post">
			<input type="submit" name="1" value="米" class="button" />
			<input type="submit" name="2" value="麺" class="button" />
			<input type="submit" name="3" value="肉" class="button" />
			<input type="submit" name="4" value="魚" class="button" />
			<input type="submit" name="5" value="軽食" class="button" />
		</form>
		
		<div class="link">
			<p><a href="<%= request.getContextPath() %>/admin/select">今日なに食べる？トップへ戻る</a></p>
			<p><a href="<%= request.getContextPath() %>/admin/mypage">マイページへ戻る</a></p>
		</div>
	</main>
	
	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>
</body>
</html>