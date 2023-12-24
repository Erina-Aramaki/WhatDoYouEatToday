<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/foodDetail.css" />
<title>レシピ | 今日なに食べる？</title>
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
		<form action="" method="post">
	<!-- 		<form action="" method="get"> -->
			<span class="favoritedmark fade">★</span>
			<input type="submit" name="addToFavorite" value="お気に入りに登録" id="addToFavorite"  />
			<input type="submit" name="removeFavorite" value="お気に入りから外す"  />
			<p><a href="favorite">お気に入りに戻る</a></p>
	
	<!-- form外から移動　開始位置 -->
				<input type="hidden" value="<c:out value="${num}" />" name="num" > 
				<input type="hidden" value="<c:out value="${foodName}" />" name="foodName"  /> 
				<p><img src="<%= request.getContextPath() %>/upload/${foodName}.png" width="412" alt="${num }${ foodName}の画像" /></p>
			
			<div class="flex">		
				<div class="item">
				<h3>材料</h3>
					 <ul>
						<c:forEach items="${Foods_material}" var="material" varStatus="vs">		
							<li>${material.material }</li>
						</c:forEach>
					</ul>
				</div>
				<div class="item">
					<h3>作り方</h3>
			 		 <ol>
			 			<c:forEach items="${Foods_howToMake}" var="howToMake" varStatus="vs">
			 				<li>${howToMake.howToMake }</li>
			 			</c:forEach>
			 		</ol> 
				</div>
				
			
			</div>
			
	<!-- form外から移動　修了位置 -->
		</form>
		
		<div class="link">
			<p><a href="mypage">マイページへ戻る</a></p>
			<p><a href="select">今日なに食べる？トップへ戻る</a></p> 
		</div>
	</main>	

	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>
  	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/script.js"></script>


</body>
</html>