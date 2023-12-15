<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>レシピ | 今日なに食べる？</title>
<!-- 使わないため消す -->
</head>
<body>
	<%-- <c:forEach items="${foods}" var="food" varStatus="vs"> --%>
		
		<h1 class="page-title">${foodName }</h1>
		
		<!-- お気に入りボタン -->
		<!-- <form action="" method="post"> -->
		<form action="" method="get">
			<span class="favoritedmark fade">★</span>
			<!-- お気に入り登録用のもう一つのservletとjspを作る際には、post送信になるためformの中にnumを入れる -->
			
			
			<!-- <button class="btn btn-primary addtofavorite">お気に入りに登録</button> -->
		    <!-- <button class="btn btn-primary removefavorite hidden">お気に入りから外す</button> -->
	<!-- 		<input type="submit" name="addtofavorite" class="btn btn-primary addtofavorite" value="お気に入りに登録"  />
			<input type="submit" name="removefavorite" class="btn btn-primary removefavorite hidden" value="お気に入りから外す"  />
	 -->	    
			<input type="submit" name="addToFavorite" value="お気に入りに登録"  />
			<input type="submit" name="removeFavorite" value="お気に入りから外す"  />
		</form>
		
		<p><a href="<%= request.getContextPath() %>/admin/favorite">お気に入りに戻る</a></p>
		
		<%-- <p><img src="<%= request.getContextPath() %>/upload/${num}.png" width="412" alt="${foodName }の画像" /></p> --%>
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
 		
		<p><a href="<%= request.getContextPath() %>/admin/mypage">マイページへ戻る</a></p>
		<p><a href="<%= request.getContextPath() %>/admin/select">今日なに食べる？トップへ戻る</a></p>
	<%-- </c:forEach> --%>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="../js/favorite.js"></script> -->

</body>
</html>