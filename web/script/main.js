    $.ajax({
        url:"getBooks",
        dataType: "json",
        async:false,
        success:function (ret) {
            $(".container .book").remove();
            $(ret).each(function () {
                let result=this;
                $(".container").append("<div class=\"book\">" +
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
