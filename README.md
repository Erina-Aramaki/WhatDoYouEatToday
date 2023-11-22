# WhatDoYouEatToday? 今日何食べる？               

今日食べるものを提案してくれるアプリです。     
材料からレシピを検索してくれるサイトや、食べたいものからお店を検索してくれるサイトはよく見かけますよね。     
しかし、「食べるもの」を提案してくれるサイトはあまり見かけません。      
「食事のレパートリーが不足していて食べたいものが思い浮かばない」「いつもとは違うものが食べたい！」    
そんな気持ちになったことはありませんか？      
このアプリは、ボタンを選択していくだけであなたの希望に沿ったメニューを提案してくれます。      
「何を食べたいのか自分でも分からない・・・！」と思ったときは是非診断機能を使ってみてください。   

## 制作状況
2023年11月14日 製作開始。   
2023年11月22日 README作成。    

## 制作ページ
- 会員ページ     
![会員ページ](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/c0b5e2b9-0c7b-4e9c-8f90-15d5e59272b1)

- 診断ページ   
  （例）「和食料理」をクリック    
![select](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/7e89609c-0c81-45d9-be22-74dd16abd867)

- 「米」をクリック   
![Japanese](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/39bcbd4d-ca57-4008-bbd3-0a211bed2df0)

- 診断結果  
![診断結果2](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/93983390-dca6-4311-9809-3893c209db7e)


## 使用技術        
- Java    
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
テーブル結合したものに「ROW_NUMBER()」で連番を付与を付与し、ランダム関数の結果と一致する番号のカラムを取得することに苦戦しました。   
- 「WesternDaoImpl.java」の select(String strId) メソッド

![苦戦したポイント](https://github.com/Erina-Aramaki/WhatDoYouEatToday/assets/75921588/ab0c6f6d-98b5-4f0e-b661-9a92e2e4e561)

## ER図
今後記載予定




