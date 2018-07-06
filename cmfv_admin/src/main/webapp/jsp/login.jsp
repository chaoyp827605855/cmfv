<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2018/7/4
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8"   pageEncoding="utf-8" isELIgnored="false" %>
<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <link rel="icon" href="${pageContext.request.contextPath }/img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/script/common.js"></script>
    <script type="text/javascript">

        $(function(){
            //点击更换验证码：
            $("#captchaImage").click(function(){//点击更换验证码
                /**
                 *在index.jsp中设置验证码，用户点击验证码时，调用js代码请求服务器得到新的验证码。
                 *因为上面的那个生成验证码的servlet会被浏览器缓存，
                 *所以js代码中需要给该servlet一个随机的参数，这样浏览器就会向服务器发请求得到新的验证码，而不是去缓存中读取。
                 */
                document.getElementById("captchaImage").src= "${pageContext.request.contextPath}/verification?h="+Math.random();
            });

            //  form 表单提交
            $("#loginForm").bind("submit",function(){
                var mName = $("#mName").val();
                var mPassword = $("#mPassword").val();
                alert(verifCode);
                console.log(mName.length);
                console.log(mPassword.length);
                if(verifCode){
                    if(mName.length==0)
                    {
                        $("input[id='mName']").css("background-color","pink");
                        return false;
                    }
                    if(mPassword.length==0){
                        $("input[id='mPassword']").css("background-color","pink");
                        return false;
                    } else {
                        document.forms[0].submit();
                    }
                }else {
                    return false;
                }
            });

            var verifCode = false;
            $("#txtVerifyCode").blur(function () {

                var submitVerification = $(this).val();
                console.log(submitVerification);
                $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/verifCode",
                    data:"submitVerification="+submitVerification,
                    success:function (data) {
                        if(data=="OK")
                        {
                            verifCode = true;
                        }else {
                            verifCode = false;
                        }
                    }
                });
            });

        });


    </script>

    <%-- 为coookie中的中文 解码 ， 并取出 --%>
    <%
        String name = "";
        javax.servlet.http.Cookie cs[] = request.getCookies();
        for(javax.servlet.http.Cookie c:cs){
            if(c.getName().equals("name")){
                name = c.getValue();
                name = java.net.URLDecoder.decode(name,"utf-8");
            }
        }
    %>

</head>
<body>

<div class="login">
    <form id="loginForm" action="${pageContext.request.contextPath }/manager/login" method="post" >
        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="${pageContext.request.contextPath }/img/header_logo.gif" />
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input id="mName" type="text"  name="name" class="text" value="<%=name%>" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input id="mPassword" type="password" name="password" class="text" value="" maxlength="20" autocomplete="off"/>
                </td>
                <span id="loginError" style="color: red">${loginError}</span>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th style="width: 100px">验证码:</th>
                <td>
                    <input type="text" id="txtVerifyCode" name="submitVerification" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/verification"  title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
                <td>
                    <label>
                        <input type="checkbox" checked name="checkbox" id="isRememberUsername" /> 记住用户名
                    </label>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody></table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>
