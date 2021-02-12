$.ajax({
    url:"getFavoriteBooks",
    dataType: "json",
    async:false,
    success:function (ret) {
        /*
        Book
            private String name;
            private String ISBN;
            private String author;
            private String introduction;
            private String url;
         */
        /*alert(ret.name+"---->"+ret.isbn+"---->"+ret.author+"---->"+ret.introduction+"---->"+ret.url)*/
        $(".favoriteContainer .book").remove();
        $(ret).each(function () {
            let result=this;
            $(".favoriteContainer").append("<div class=\"book\">" +
            "           <a href=\"#\" target=\"_blank\">"+
            "            <table>" +
            "                <tr>" +
            "                    <td><img src=\""+result.url+"\" alt=\"\"></td>" +
            "                </tr>" +
            "                <tr>" +
            "                    <td><span class=\"title\">"+result.name+"</span></td>" +
            "                    " +
            "                </tr>" +
            "                <tr>" +
            "                    <td><span class=\"author\">"+result.author+"</span></td>" +
            "                </tr>" +
            "            </table>" +
            "           </a>"+
            "        </div>");
        })
    }
})

//点击书本事件
$(".book a").click(function() {
    let bookName=$(this).find(".title").text();
    $(this).attr("href","pdf/"+bookName+".pdf")
})