# WhatDoYouEatToday? 今日何食べる？               

今日食べるものを提案してくれるアプリです。     
材料からレシピを検索してくれるサイトや、食べたいものからお店を検索してくれるサイトはよく見かけますよね。     
しかし、「食べるもの」を提案してくれるサイトはあまり見かけません。      
「食事のレパートリーが不足していて食べたいものが思い浮かばない」「いつもとは違うものが食べたい！」    
そんな気持ちになったことはありませんか？      
このアプリは、ボタンを選択していくだけであなたの希望に沿ったメニューを提案してくれます。      
「何を食べたいのか自分でも分からない・・・！」と思ったときは是非診断機能を使ってみてください。  

## URL
レンタルサーバーの契約が完了次第、記載します。

## 作成ページ
- 会員ページ     
![会員ページ](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/c0b5e2b9-0c7b-4e9c-8f90-15d5e59272b1)

- 診断ページ   
![select](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/7e89609c-0c81-45d9-be22-74dd16abd867)

- 「和食料理」をクリック   
![Japanese](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/39bcbd4d-ca57-4008-bbd3-0a211bed2df0)

- 「米」をクリック
![Japanese](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/ac0e1622-a4ac-4ecc-93e0-cedd521071ac)

- 診断結果
![診断結果](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/31b761a3-5a42-4eab-a110-8dd466ac8362)

![診断結果2](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/93983390-dca6-4311-9809-3893c209db7e)


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
- お気に入り登録、削除、一覧表示機能
- サイトデザイン（HTML、CSS、JavaScript）

## 苦労した点
MySQLに慣れていないこともあり、SQL文の作成に苦戦しました。     
作成例は以下の通りです。

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





