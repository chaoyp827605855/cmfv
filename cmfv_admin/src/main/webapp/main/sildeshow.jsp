<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2018/7/5
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<body>
<script type="application/javascript">
    $(function () {
        $('#DataGridViewSlideshow').datagrid({
            //title:'DataGrid - DetailView',
            width:500,
            height:250,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            fit:true,
            pagination:true,
            pageSize:3,
            pageList:[3,5,7,9,11],
            toolbar:"#searchSlideshow",
            url:"${pageContext.request.contextPath}/showSlideshowAll",
            columns:[[
                {field:'id',title:'序号',width:80},
                {field:'description',title:'描述信息',width:80,align:'right',sortable:true },
                {field:'date',title:'轮播图上传时间',width:80,align:'right',sortable:true},
                {field:'path',title:'图片路径',width:100,sortable:true},
                {
                    field:'status',
                    title:'Status',
                    width:150,
                    sortable:true,
                    formatter: function(value,row,index){
                        if (row.status == "on"){
                            return "<p style='color: red'>展示中</p>";
                        } else {
                            return "<p>未展示</p>";
                        }
                    }
                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+rowData.path+'" style="height:150px;"></td>' +
                    '</tr></table>';
            }
        });
//----------------------------------------------------------------------------------------------------------
        $("#addSlideshow").linkbutton({
            text:"添加",
            iconCls: 'icon-add',
            width:80,
            height:30,
            onClick: function(){

                /* alert('添加');*/
                //var rowData = $("#DataGridView").datagrid("getSelected");
                $("#dialogSlideshow").dialog({
                    title: "添加",
                    width: 500,
                    height: 350,
                    closed: false,
                    cache: false,
                    modal: true,
                    href: "${pageContext.request.contextPath}/main/form.jsp",
                    buttons:[{
                        text:'添加',
                        handler:function(){
                            $("#ff").form("submit", {
                                url:"${pageContext.request.contextPath}/uploadSlideshow",
                                onSubmit: function(){
                                    //验证表单
                                    var isValid = $(this).form('validate');
                                    if(!isValid){
                                        return false;
                                    }
                                },
                                success:function(data){
                                    $("#dialogSlideshow").dialog("close",{
                                    });
                                    $("#DataGridViewSlideshow").datagrid("reload",{});
                                }
                            });
                        }
                    },{
                        text:'关闭',
                        handler:function(){
                            $("#dialogSlideshow").dialog("close",{
                            });
                        }
                    }],
                    onLoad:function(){
                        //$("#h1").text("信息");
                    }
                });
            }
        });
//----------------------------------------------------------------------------------------------------------
        $("#deleteSlideshow").linkbutton({
            text:"删除",
            iconCls: 'icon-cancel',
            width:80,
            height:30,
            onClick: function(){
                /*  alert('删除');*/
                var rowData = $("#DataGridViewSlideshow").datagrid("getSelected");
                if(rowData==null) {
                    alert("请选择一条数据...");
                }else {
                    console.log(rowData.id);
                    $.ajax({
                        url:"${pageContext.request.contextPath}/removeById",
                        type:"POST",
                        data:{"id":rowData.id},
                        success:function () {
                            $("#DataGridViewSlideshow").datagrid("reload",{});
                        }
                    })
                }

            }
        });
//----------------------------------------------------------------------------------------------------------
        $("#updateSlideshow").linkbutton({
            text:"修改",
            iconCls: 'icon-edit',
            width:80,
            height:30,
            onClick: function(){
                var rowData = $("#DataGridViewSlideshow").datagrid("getSelected");
                if(rowData==null) {
                    alert("请选择一条数据...");
                }else {
                    $("#dialogSlideshow").dialog({
                        title: rowData.username + " 的信息",
                        width: 500,
                        height: 350,
                        closed: false,
                        cache: false,
                        modal: true,
                        href: "${pageContext.request.contextPath}/main/form.jsp",
                        buttons:[{
                            text:'修改',
                            handler:function(){
                                $("#ff").form("submit", {
                                    url:"${pageContext.request.contextPath}/modify",
                                    onSubmit: function(){
                                        //验证表单
                                        var isValid = $(this).form('validate');
                                        if(!isValid){
                                            return false;
                                        }
                                        // do some check
                                        // return false to prevent submit;
                                    },
                                    success:function(data){
                                        $("#dialogSlideshow").dialog("close",{
                                        });
                                        $("#DataGridViewSlideshow").datagrid("reload",{});
                                    }
                                });
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#dialogSlideshow").dialog("close",{

                                });
                            }
                        }],
                        onLoad:function(){
                            $("#h1").text(rowData.username + " 的信息");
                            //表单中 回显数据
                            $("#ff").form("load",rowData);
                        }

                    });
                }

            }
        });



    })
</script>



<table id="DataGridViewSlideshow"></table>

<div id="searchSlideshow">

    <a id="addSlideshow"></a>
    <a id="deleteSlideshow"></a>
    <a id="updateSlideshow"></a>

</div>

<div id="dialogSlideshow"></div>
</body>