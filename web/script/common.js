window.onload=function(){
    /*sign界面聚焦失焦效果*/
    $(".sign-page input[type=text],input[type=password]").focus(function () {
        $(this).addClass("focus");
    })
    $(".sign-page input[type=text],input[type=password]").blur(function () {
        $(this).removeClass("focus");
    })
    $(".sign-page input[type=text],input[type=password]").focus(function () {
        $(this).addClass("focus");
    })
    $(".sign-page input[type=text],input[type=password]").blur(function () {
        $(this).removeClass("focus");
    })
    /*各个界面链接跳转效果*/
    $("#signin").click(function (data) {
        /*
        SignInInfo
         */
        var result;
        let signUpInfo=new Object();
        signUpInfo.username=$("input[name=username]").val();
        signUpInfo.password=$("input[name=password]").val();
        let json=JSON.stringify(signUpInfo);
        //alert(signUpJson)
        $.ajax({
            dataType:"json",
            url:"signIn",
            data:"username="+signUpInfo.username+"&password="+signUpInfo.password,
            async:false,
            //boolean
            success:function (msg) {
                if (msg==true){
                    $("#signin").attr("href","main")
                }

                result=JSON.parse(msg)
            }
        })
        if (result==false){
            alert("登陆失败")
        }
    });
    $("#gosignup").click(function (data) {
        $(this).attr("href","signup")
    });
    $("#signup").click(function (data) {
        /*
        SignInInfo
         */
        alert("开始了")
        let btn=this;
        let result;
        let user=new Object();
        let passwordAgain=$("input[name=passwordAgain]").val();

        user.username=$("input[name=username]").val();
        user.password=$("input[name=password]").val();
        user.email=$("input[name=email]").val();
        //前端校验
        if (passwordAgain!=user.password){
            alert("两次密码不同");
            return false;
        }
        let json="username="+user.username+"&password="+user.password+"&email="+user.email;
        $.ajax({
            url:"signUp",
            data:json,
            async:false,
            success:function (msg) {
                console.log(msg);
                alert(msg.isSuccessed)
                if (msg.isSuccessed==true){
                    $(btn).attr("href","signin")
                }

            }
        })
    });
    $("#gosignin").click(function (data) {
        $(this).attr("href","signin")
    });
    /*main页面搜索框      测试数据9787506380263*/
    $(".searchBox input[type=submit]").click(function () {

        let isbn= $(".searchBox input[type=text]").val();
        let optionValue=$(".searchBox option[selected=selected]").val();
        let type;
        if (optionValue=="ISBN"){
            type="getBookWithISBN";
        }else if (optionValue=="书名"){
            type="getBookWithName"
        }
        $.ajax({
            url:"type/"+isbn,
            dataType: "json",
            success:function (ret) {
                $(".container .book").remove();
                $(".container").append("<div class=\"book\">" +
                    "           <a href=\"#\" target=\"_blank\">"+
                    "            <table>" +
                    "                <tr>" +
                    "                    <td><img src=\""+ret.url+"\" alt=\"\"></td>" +
                    "                </tr>" +
                    "                <tr>" +
                    "                    <td><span class=\"title\">"+ret.name+"</span></td>" +
                    "                    " +
                    "                </tr>" +
                    "                <tr>" +
                    "                    <td><span class=\"author\">"+ret.author+"</span></td>" +
                    "                </tr>" +
                    "            </table>" +
                    "           </a>"+
                    "        </div>");

                    

            }
        })
    });



    /*todo:分页器*/

    /*侧边栏*/
    $(".navigation .Home").click(function () {
        $(this).attr("href","main")
    })
    $(".navigation .Profile").click(function () {
        $(this).attr("href","profile")
    })
    $(".navigation .Favorite").click(function () {
        $(this).attr("href","favorites")
    })
    $(".navigation .Upload").click(function () {
        $(this).attr("href","uploadfile")
    })
    /*todo:完成退出功能*/
    $(".navigation .Signout").click(function () {
        $.ajax({
            dataType:"json",
            url:"signOut",
            async:false,
            //boolean
            success:function (msg) {
                if (msg == true) {
                    $(".Signout").attr("href","signin")
                }
            }
        })


    })
    $(".navigation .QQ").click(function () {
        $(this).attr("href","QQ")
    })
    $(".navigation .Github").click(function () {
        $(this).attr("href","Github")
    })


}

