<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>中華のオススメ料理 | 今日なに食べる？</title>
</head>
<body>
	<h1>中華のオススメ料理</h1>
	<p>あなたにピッタリのオススメ料理はコレ！</p>
	
	<!-- select() -->
	<!-- リストで取得してループさせていないため、配列番号を指定する必要がある -->
	<%-- <p><c:out value="${chinese.get(0).name}" /></p> --%>

	<p><img src="<%= request.getContextPath() %>/upload/${stapleChinese.name}.png" width="412" alt="${stapleChinese.name }の画像" /></p>
	<!-- stapleFood(String strId) -->
	<p><c:out value="${stapleChinese.name}" /></p>
	
	<!-- ChineseServletからフォワードで次のサーブレットに遷移させたときに実装する -->
	<!-- <p><a href=""></a>中華料理 選択画面へ戻る</p> -->
	<p><a href="<%= request.getContextPath() %>/admin/map">マップを表示する</a></p>
	<p><a href="<%= request.getContextPath() %>/admin/genre">もう一度診断する</a></p>
	<p><a href="<%= request.getContextPath() %>/admin/mypage">マイページへ戻る</a></p>
</body>
</html>