<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2018/7/7
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script type="text/javascript">



    </script>
</head>

<body>
<%--<div>1.通过简单的form表单提交方式，进行文件的上</br> 2.通过jquery.form.js插件提供的form表单一步提交功能 </div></br>--%>
<form id="excelForm" method="POST"  enctype="multipart/form-data">
    <table>
        <div style="margin-left: 40px;margin-top: 50px;">
            <label for="Excel"><h3>请选择相应的Excel表格文件 : </h3></label>
        </div>

        <div style="margin-left: 40px;margin-top: 50px;">
            <label for="upfile">上传文件:</label>
            <input class="easyui-filebox" data-options="required:true" name="upfile"  style="width:300px;height:40px;">
        </div>

    </table>
</form>

</body>
</html>
