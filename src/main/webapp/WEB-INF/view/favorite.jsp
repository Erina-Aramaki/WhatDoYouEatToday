<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>お気に入り</title>
</head>
<body>
	<h1>お気に入り一覧</h1>
	<form action="" method="post">
		<c:forEach items="${foods}" var="food" varStatus="vs">
			<ul>
				<li>
					<!-- 画像 --> 
					<input type="hidden" value="<c:out value="${food.num}" />" name="num"
						style="border: none; background-color: transparent; color: blue; text-decoration: underline;">
					<input type="submit" value="<c:out value="${food.name }" />" name="foodName"
						style="border: none; background-color: transparent; color: blue; text-decoration: underline;" />

				</li>
			</ul>
		</c:forEach>
	</form>

	<p>
		<a href="mypage">マイページへ戻る</a>
	</p>
</body>
</html>