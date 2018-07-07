<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2018/7/6
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="application/javascript">

    $(function () {

    });

</script>

<form id="guruForm" method="post" enctype="multipart/form-data">

    <input type="hidden" id="id" name="id">
    <div style="margin-left: 40px;margin-top: 50px;">
        <label for="religionName">上师法名:</label>
        <input class="easyui-textbox" data-options="required:true" name="religionName"  style="width:300px;height:40px;">
    </div>
    <div style="margin-left: 40px;">
        <label for="description">上师简介:</label>
        <input class="easyui-textbox" data-options="required:true" prompt="description" name="description"  style="width:300px;height:40px;">
    </div>

    <div style="margin-left: 40px;">
        <label for="pictureImg">上传头像:</label>
        <input class="easyui-filebox" name="pictureImg"  style="width:300px;height:40px;">
    </div>

    <a id="guruBtn"></a>
</form>
