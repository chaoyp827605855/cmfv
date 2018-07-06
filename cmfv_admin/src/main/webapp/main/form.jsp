<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2018/7/5
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="application/javascript">

    $(function () {

    });

</script>

<form id="ff" method="post" enctype="multipart/form-data">

    <input type="hidden" id="id" name="id">
    <div style="margin-left: 40px;margin-top: 50px;">
        <label for="description">轮播图描述:</label>
        <input class="easyui-textbox" data-options="required:true" name="description"  style="width:300px;height:40px;">
    </div>
    <%--<div style="margin-left: 40px;">--%>
        <%--<label for="status">轮播图状态:</label>--%>
        <%--<input class="easyui-textbox" data-options="required:true" prompt="status" name="status"  style="width:300px;height:40px;">--%>
    <%--</div>--%>
    <div style="margin-left: 40px;">
        <label for="status">轮播图状态:</label>
        <input class="easyui-switchbutton" data-options="onText:'展示中',offText:'未展示'" name="status" style="width:300px;height:40px;">
    </div>


    <div style="margin-left: 40px;">
        <label for="slideshowFile">上传轮播图:</label>
        <input class="easyui-filebox" name="slideshowFile"  style="width:300px;height:40px;">
    </div>

    <a id="btnff"></a>
</form>
