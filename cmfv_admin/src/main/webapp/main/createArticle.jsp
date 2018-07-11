<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2018/7/8
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    
    $(function () {
        $('#guruId').combobox({
            width:200,
            height:40,
            url:'${pageContext.request.contextPath}/article/queryAllGuru',
            valueField:'id',
            textField:'religionName',
            required:true,
        });

        $("#articleBtn").linkbutton({
            text:"提交",
            iconCls: 'icon-ok',
            width:120,
            height:30,
            onClick:function () {
                var articleHtml = editor.txt.html();
                console.log(articleHtml);
                $("#articleForm").form("submit",{
                    url:"${pageContext.request.contextPath}/article/addArticle",
                    onSubmit: function(param){
                        param.introduce = articleHtml;
                        //验证表单
                        var isValid = $(this).form('validate');
                        if(!isValid){
                            return false;
                        }
                    },
                    success:function(data){
                        $.messager.show({
                            title:'我的消息',
                            msg:'提交成功。',
                            timeout:2000,
                            showType:'slide'
                        });
                        $("#articleForm").form("reset");
                        editor.txt.html("");
                    }
                });//form
            }
        });

        $("#resetBtn").linkbutton({
            text:"重置",
            iconCls: 'icon-edit',
            width:120,
            height:30,
            onClick:function () {
                $("#articleForm").form("reset");
                editor.txt.html("");
            }
        })

    })
    
</script>
<form id="articleForm" method="post">
    <div style="margin-left: 40px;margin-top: 40px;">
        <label for="title">文章标题:</label>
        <input class="easyui-textbox" data-options="required:true" name="name"  style="width:200px;height:40px;">
    </div>
    <div style="margin-left: 40px;margin-top: 30px;">
        <label for="guru_religionName">文章作者:</label>
        <input id="guruId" name="guruId">
    </div>
    <div style="margin-left: 40px;margin-top: 30px;">
        <label for="name">文章状态:</label>
        <input class="easyui-switchbutton" name="picture" data-options="onText:'Yes',offText:'No'" style="width:200px;height:40px;">
    </div>


    <div style="margin-left: 40px;margin-top: 30px;">
        <label for="introduce">文章内容:</label>
        <div id="editor"></div>
        <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
        <script type="text/javascript">
            var E = window.wangEditor
            var editor = new E('#editor')
            // 或者 var editor = new E( document.getElementById('editor') )
            editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload'  // 上传图片到服务器
            editor.customConfig.uploadFileName = 'files';//上传图片的名称  files 相当于 input中的name值
            editor.create()
        </script>
    </div>
    <a id="articleBtn"></a>
    <a id="resetBtn"></a>
</form>
