<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>レシピ</title>
</head>
<body>
	<%-- <c:forEach items="${foods}" var="food" varStatus="vs"> --%>
		
		<h1 class="page-title">${foodName }</h1>
		
		<!-- お気に入りボタン -->
		<form action="" method="post">
			<span class="favoritedmark fade">★</span>
			<!-- <button class="btn btn-primary addtofavorite">お気に入りに登録</button> -->
		    <!-- <button class="btn btn-primary removefavorite hidden">お気に入りから外す</button> -->
	<!-- 		<input type="submit" name="addtofavorite" class="btn btn-primary addtofavorite" value="お気に入りに登録"  />
			<input type="submit" name="removefavorite" class="btn btn-primary removefavorite hidden" value="お気に入りから外す"  />
	 -->	    
			<input type="submit" name="addToFavorite" value="お気に入りに登録"  />
			<input type="submit" name="removeFavorite" value="お気に入りから外す"  />
		</form>
		
		<p><a href="favorite">お気に入りに戻る</a></p>
		
		<p><img src="<%= request.getContextPath() %>/upload/${num}.jpg" width="412" alt="${foodName }の画像" /></p>
		
		<h3>材料</h3>
		<!-- 後ほどデータベースに格納する。DaoImpliも修正する -->
		<!-- <ul>
			<li>ごはん 180g</li>
			<li>とんかつ豚ロース (厚切り) 100g</li>
			<li>塩こしょう 小さじ1/4</li>
			<li>薄力粉 小さじ2</li>
			<li>溶き卵 1/2個分</li>
			<li>パン粉 大さじ1</li>
			<li>揚げ油 適量</li>
			<li>玉ねぎ 1/4個</li>
			<li>卵 2個</li>
			<li>水 50ml</li>
			<li>料理酒 大さじ1</li>
			<li>みりん 大さじ1</li>
			<li>しょうゆ 大さじ1</li>
			<li>砂糖 小さじ1</li>
			<li>顆粒和風だし 小さじ1/2</li>
			<li>三つ葉 3g</li>
		</ul> -->
		
		<ul>
			<li>${material }</li>
		</ul>
		
	
		<h3>作り方</h3>
		<!-- 後ほどデータベースに格納する。DaoImpliも修正する -->
		<ol>
			<li>三つ葉は根元を切り落とし、2cm幅に切ります。</li>
			<li>玉ねぎは薄切りにします。</li>
			<li>豚ロースは筋を切ります。ラップをのせて麺棒で叩き、両面に塩こしょうをふります。</li>
			<li>薄力粉、溶き卵、パン粉の順に衣をつけます。</li>
			<li>フライパンの底から4cmほどの高さまで揚げ油を注ぎ、170℃に熱し、4を入れます。中に火が通り、表面が色づくまで5分ほど揚げ、油切りをします。</li>
			<li>2cm幅に切ります。</li>
			<li>鍋に2、水、調味料の材料を入れて中火で熱します。</li>
			<li>玉ねぎがしんなりしたら、中火のまま6と軽く溶きほぐした卵を入れます。蓋をして火を止め、30秒蒸らします。</li>
			<li>丼にごはんをよそい、8をのせ、1を散らして出来上がりです。</li>
		</ol>
		
		<p><a href="mypage">マイページへ戻る</a></p>
		<p><a href="select">今日なに食べる？トップへ戻る</a></p>
	<%-- </c:forEach> --%>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="../js/favorite.js"></script> -->

</body>
</html>