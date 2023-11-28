/**
 * 
 */

// お気に入りに登録
$(".addtofavorite").click(function(){
    var favorite_pages_start = JSON.parse(localStorage.getItem('favorite_pages'));
    var title = $("h1").text(); //ページのタイトルを取得("h1.page-title") 無い場合は、<head>タイトルを取得
    if(!title.length){  
        title = document.title;
    }
    var favorite_pages = [{
        url: CCM_CID, //CCM_CIDは、concrete5が各ページに付与しているID
        title: title,
        datetime: $.now()
    }];

    if(favorite_pages_start.length >= 10){ //最大10個まで
        alert("お気に入り登録数の上限に達しました。");
        return;
    }
    if(favorite_pages_start) {
        for(i = 0; i < 10; i++){
            if(favorite_pages_start[i] && favorite_pages[0].url !== favorite_pages_start[i].url){
                favorite_pages.push(favorite_pages_start[i]);
            }
        }
        localStorage.setItem('favorite_pages', JSON.stringify(favorite_pages));
        addFavorite();
    }
});

//画面表示を切り替える
function addFavorite(){
    $(".favoritedmark").removeClass('fade');
    $(".removefavorite").removeClass('hidden');
    $(".addtofavorite").addClass('hidden');
}

//お気に入り登録を外す
$(".removefavorite").click(function(){
    var favorite_pages_start = JSON.parse(localStorage.getItem('favorite_pages'));
    var favorite_pages = [];
    if(favorite_pages_start){
        for(i = 0; i < 10; i++){
            if(favorite_pages_start[i] && CCM_CID !== favorite_pages_start[i].url){
                favorite_pages.push(favorite_pages_start[i]);
            }
        }
    }
    localStorage.setItem('favorite_pages', JSON.stringify(favorite_pages));
    removeFavorite();
});

//画面表示を切り替える
function removeFavorite(){
    $(".favoritedmark").addClass('fade');
    $(".removefavorite").addClass('hidden');
    $(".addtofavorite").removeClass('hidden');
}

//ページ表示の際、既にお気に入り登録されているか判定
var favorite_pages = JSON.parse(localStorage.getItem('favorite_pages'));
var selected = false;
if(favorite_pages){
    for(i = 0; i < 10; i++){
        if(!selected && favorite_pages[i] && !isNaN(favorite_pages[i]['url'])){
            if(CCM_CID == favorite_pages[i]['url']){
                selected =true;
            }
        }
    }
}
if(selected){
    addFavorite();
}