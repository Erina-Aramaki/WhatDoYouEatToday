<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css" />
<title>西洋のオススメ料理 | 今日なに食べる？</title>
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
		<h2>西洋のオススメ料理</h2>
		<p>あなたにピッタリのオススメ料理はコレ！</p>
		
		<!-- detail() -->
		<!-- リストで取得してループさせていないため、配列番号を指定する必要がある -->
		<%-- <p><c:out value="${western.get(0).name}" /></p> --%>
	
		<p><img src="<%= request.getContextPath() %>/upload/${stapleWestern.name}.png" width="412" alt="${stapleWestern.name }の画像" /></p>
		<!-- select(String strId) -->
		<p><c:out value="${stapleWestern.name}" /></p>
		
		<!-- WesternServletからフォワードで次のサーブレットに遷移させたときに実装する -->
		<!-- <p><a href=""></a>西洋料理 選択画面へ戻る</p> -->
		
		<div class="link">
			<p><a href="<%= request.getContextPath() %>/admin/map">マップを表示する</a></p>
			<p><a href="<%= request.getContextPath() %>/admin/genre">もう一度診断する</a></p>
			<p><a href="<%= request.getContextPath() %>/admin/mypage">マイページへ戻る</a></p>
		</div>
	</main>
	
	<footer>
    	<p><small>Copyright &copy; 2023 Erina Aramaki rights reserved.</small></p>
  	</footer>
</body>
</html>