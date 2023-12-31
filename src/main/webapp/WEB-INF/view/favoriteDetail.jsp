<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>レシピ | 今日なに食べる？</title>
<!-- 使わないため消す -->
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
		<h2 class="page-title">${foodName }</h2>
		
		<!-- お気に入りボタン -->
		<form action="" method="get">
			<span class="favoritedmark fade">★</span>
			<!-- お気に入り登録用のもう一つのservletとjspを作る際には、post送信になるためformの中にnumを入れる -->
		    
			<input type="submit" name="addToFavorite" value="お気に入りに登録"  />
			<input type="submit" name="removeFavorite" value="お気に入りから外す"  />
		</form>
		
		<p><a href="<%= request.getContextPath() %>/admin/favorite">お気に入りに戻る</a></p>
		
		<p><img src="<%= request.getContextPath() %>/upload/${foodName}.png" width="412" alt="${ foodName}の画像" /></p>
		
		<h3>材料</h3>
		
		 <ul>
			<c:forEach items="${Foods_material}" var="material" varStatus="vs">		
				<li>${material.material }</li>
			</c:forEach>
		</ul>
		
	
		<h3>作り方</h3>

 		 <ol>
 			<c:forEach items="${Foods_howToMake}" var="howToMake" varStatus="vs">
 				<li>${howToMake.howToMake }</li>
 			</c:forEach>
 		</ol> 
 		
 		<div class="link">
			<p><a href="<%= request.getContextPath() %>/admin/mypage">マイページへ戻る</a></p>
			<p><a href="<%= request.getContextPath() %>/admin/select">今日なに食べる？トップへ戻る</a></p>
		</div>
	</main>	
	
	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>

</body>
</html>