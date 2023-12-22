<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/favorite.css" />
<title>お気に入り | 今日なに食べる？</title>
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
		<h2>お気に入り一覧</h2>
			<ul>
				<c:forEach items="${foods}" var="food" varStatus="vs">
					<li>
		<%-- 			<form action="" method="post">
						 <!-- ↓挙動OK -->
						 <!-- <form action="favoriteDetail" method="get">  -->
						 <!-- ↓挙動OK -->
						 <!-- <form action="foodDetail" method="get"> --> 
							<input type="hidden"
							value="<c:out value="${food.num}" />" name="num" 
							style="border: none; background-color: transparent; color: blue; text-decoration: underline;">
							<input type="submit" value="<c:out value="${food.name }" />"
							name="foodName"
							style="border: none; background-color: transparent; color: blue; text-decoration: underline;" />
		 
						</form>
		--%>
						<a href="<%= request.getContextPath() %>/admin/foodDetail?num=${food.num}&&name=${food.name}">${food.name}</a>
					</li>
				</c:forEach>
			</ul>
	
		<div class="link">
			<p><a href="<%= request.getContextPath() %>/admin/mypage">マイページへ戻る</a></p>
		</div>
	</main>
	
	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>
</body>
</html>