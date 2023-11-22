# WhatDoYouEatToday? 今日何食べる？               

今日食べるものを提案してくれるアプリです。     
材料からレシピを検索してくれるサイトや、食べたいものからお店を検索してくれるサイトはよく見かけますよね。     
しかし、「食べたいもの」を検索し提案してくれるサイトはあまり見かけません。      
「食べたいもののレパートリーが不足している」「いつもとは違うものが食べたい」そんな気持ちになったことはありませんか？      
このアプリは、ボタンを選択していくだけであなたに今日の食事メニューを提案してくれます。      
「何を食べたいのか自分でも分からない・・・！」そんな時に使ってみてください。  

## URL
レンタルサーバーの契約が完了次第、記載します。

## 使用技術        
- Java    
- MySQL      
- MySQL
- Git/GitHub


## 機能一覧      
- ユーザー登録    
- ログイン機能    
- ログアウト機能    
- 診断機能    
- 商品一覧表示機能    
- ユーザー詳細表示機能    


## 今後実装予定    
- ユーザー情報更新機能    
- ユーザー情報削除機能    
- API（レシピ検索、お店検索）    
- お気に入り登録機能
- サイトデザイン（HTML、CSS、JavaScript）

## 苦労した点
MySQLに慣れていないこともあり、SQL文の作成に苦戦しました。
このアプリでは、5つのテーブルを作成しており、そのうち4つのテーブルを機能に合わせて結合しています。
使用例は以下の通りです。

1. SQLで複数の検索結果を結合し、１つの結果として取得するために、「UNION」を使用
SELECT japanese_food.name AS japanese_name FROM japanese_food
UNION 
SELECT chinese_food.name AS chinese_name FROM chinese_food
UNION
SELECT western_food.name AS western_name FROM western_food;

2. 結合したテーブルに対して「HAVING」で条件指定 
SELECT chinese_food.id, chinese_food.name, chinese_food.staple_id, 
staple_food.name AS staplefood_name, 
FROM chinese_food JOIN staple_food ON chinese_food.staple_id = staple_food.id 
HAVING staplefood_name = ?;

3. サブクエリを使用しテーブル結合したものに「ROW_NUMBER()」で連番を付与
SELECT 
ROW_NUMBER() OVER(ORDER BY id ASC) Num, id, Name, staple_id, staplefood_id, staplefood_name
FROM (SELECT chinese_food.id, chinese_food.name, chinese_food.staple_id, 
staple_food.id AS staplefood_id, staple_food.name AS staplefood_name 
FROM chinese_food JOIN staple_food ON chinese_food.staple_id = staple_food.id 
HAVING staplefood_name = ?) AS staple_chinese;

## ER図





