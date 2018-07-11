<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2018/7/9
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" isELIgnored="false" %>

<script type="application/javascript">
    $(function () {
        $('#datagridArticle').datagrid({
            //title:'DataGrid - DetailView',
            width: 500,
            height: 250,
            singleSelect: true, //如果为true，则只允许选择一行。
            //nowrap: false,    //如果为true，则在同一行中显示数据。设置为true可以提高加载性能。
            fitColumns: true,
            fit: true,
            pagination: true,   //如果为true，则在DataGrid控件底部显示分页工具栏。
            striped:true,   //是否显示斑马线效果。
            pageSize: 3,
            pageList: [3, 5, 7, 9, 11],
            toolbar: "#searchArticle",
            url: "${pageContext.request.contextPath}/article/queryAllArticle",
            columns: [[
                {field: 'id', title: '序号', width: 100},
                {field: 'name', title: '文章标题', width: 80, align: 'right', sortable: true},
                {field: 'date', title: '文章上传时间', width: 80, align: 'right', sortable: true},
                {field: 'guru', title: '文章作者', width: 80, sortable: true,
                    formatter:function(value){
                        return value.religionName;
                    }
                },
                {field: 'introduce', title: '文章作者', width: 80, sortable: true,hidden:true},
                {field: 'status',title: '状态',width: 80,sortable: true,
                    formatter: function (value, row, index) {
                        if (row.status == "on") {
                            return "<p style='color: red'>展示中</p>";
                        } else {
                            return "<p>未展示</p>";
                        }
                    }
                },
                {
                    field: 'operation',
                    title: '操作',
                    width: 100,
                    sortable: true,
                    formatter: function (value, row, index) {
                        console.log("------------"+row.introduce);
                        return "<button id='"+row.id+"' class='articleDetails' value='"+row.introduce+"'></button>&nbsp&nbsp<button class='articleUpdate'></button>";
                    }
                },
            ]],
            onLoadSuccess:function () {

                $(".articleDetails").linkbutton({
                    text:"文章详情",
                    iconCls:'icon-accept',
                    width:110,
                    height:30,
                    <%--onClick:function () {--%>
                        <%--var introduce = $(".articleDetails").val();--%>
                        <%--console.log($(".articleDetails"));--%>
                        <%--console.log(introduce);--%>
                        <%--$("#dialogArticle").dialog({--%>
                            <%--title: "文章详情",--%>
                            <%--width: 500,--%>
                            <%--height: 350,--%>
                            <%--closed: false,--%>
                            <%--cache: false,--%>
                            <%--modal: true,--%>
                            <%--//href:'${pageContext.request.contextPath}/article/queryById',--%>
<%--//                            onOpen:function () {--%>
                                <%--$("#dialogArticle").html(introduce);--%>
                            <%--}--%>
                        <%--})//dialog--%>
                    <%--}--%>
                });
                $(".articleUpdate").linkbutton({
                    text:"修改内容",
                    iconCls:'icon-edit',
                    width:110,
                    height:30,
                });
            }, //onLoadSuccess
            onDblClickRow:function (index , row) {
                $("#dialogArticle").dialog({
                    title: "文章详情",
                    width: 500,
                    height: 350,
                    closed: false,
                    cache: false,
                    modal: true,
                    resizable:true,
                    maximizable:true,
                    minimizable:true,
                    onOpen:function () {
                        $("#dialogArticle").html(row.introduce);
                    }
                })//dialog
            }

        });


    })
</script>


<table id="datagridArticle"></table>

<div id="dialogArticle">

</div>
