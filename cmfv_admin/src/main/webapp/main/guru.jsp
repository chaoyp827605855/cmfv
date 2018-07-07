<%--
  Created by IntelliJ IDEA.
  User: Chao
  Date: 2018/7/6
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<body>
<script type="application/javascript">


    $(function () {
        $('#DataGridViewGuru').datagrid({
            //title:'DataGrid - DetailView',
            width:500,
            height:250,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            fit:true,
            pagination:true,
            singleSelect:true,
            pageSize:3,
            pageList:[3,5,7,9,11],
            toolbar:"#searchGuru",
            url:"${pageContext.request.contextPath}/guru/showGuruPage",
            columns:[[
                {field:'id',title:'序列号',width:80},
                {field:'religionName',title:'上师法名',width:80,align:'right',sortable:true },
                {field:'description',title:'上师简介',width:100,sortable:true},
                {field:'picture',title:'上师头像',width:80,align:'right',sortable:true},
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/'+rowData.picture+'" style="height:150px;"></td>' +
                    '</tr></table>';
            }
        });
//----------------------------------------------------------------------------------------------------------
        $("#addGuru").linkbutton({
            text:"添加",
            iconCls: 'icon-add',
            width:80,
            height:30,
            onClick: function(){
                /* alert('添加');*/
                //var rowData = $("#DataGridView").datagrid("getSelected");
                $("#dialogGuru").dialog({
                    title: "添加上师",
                    width: 500,
                    height: 350,
                    closed: false,
                    cache: false,
                    modal: true,
                    href: "${pageContext.request.contextPath}/main/guruForm.jsp",
                    buttons:[{
                        text:'添加',
                        handler:function(){
                            $("#guruForm").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/addOne",
                                onSubmit: function(){
                                    //验证表单
                                    var isValid = $(this).form('validate');
                                    if(!isValid){
                                        return false;
                                    }
                                },
                                success:function(data){
                                    $("#dialogGuru").dialog("close",{
                                    });
                                    $("#DataGridViewGuru").datagrid("reload",{});
                                }
                            });
                        }
                    },{
                        text:'关闭',
                        handler:function(){
                            $("#dialogGuru").dialog("close",{
                            });
                        }
                    }],
                    onLoad:function(){
                        $("#h1").text("上师信息");
                    }
                });
            }
        });
//----------------------------------------------------------------------------------------------------------
        $("#deleteGuru").linkbutton({
            text:"删除",
            iconCls: 'icon-cancel',
            width:80,
            height:30,
            onClick: function(){
                /*  alert('删除');*/
                var rowData = $("#DataGridViewGuru").datagrid("getSelected");
                if(rowData==null) {
                    alert("请选择一条数据...");
                }else {
                    console.log(rowData.id);
                    $.ajax({
                        url:"${pageContext.request.contextPath}/guru/removeById",
                        type:"POST",
                        data:{"id":rowData.id},
                        success:function () {
                            $("#DataGridViewGuru").datagrid("reload",{});
                        }
                    })
                }

            }
        });
//----------------------------------------------------------------------------------------------------------
        $("#updateGuru").linkbutton({
            text:"修改",
            iconCls: 'icon-edit',
            width:80,
            height:30,
            onClick: function(){
                var rowData = $("#DataGridViewGuru").datagrid("getSelected");
                if(rowData==null) {
                    alert("请选择一条数据...");
                }else {
                    $("#dialogGuru").dialog({
                        title: rowData.religionName + " 的信息",
                        width: 500,
                        height: 350,
                        closed: false,
                        cache: false,
                        modal: true,
                        href: "${pageContext.request.contextPath}/main/guruForm.jsp",
                        buttons:[{
                            text:'修改',
                            handler:function(){
                                $("#guruForm").form("submit", {
                                    url:"${pageContext.request.contextPath}/guru/modify",
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
                                        $("#dialogGuru").dialog("close",{

                                        });
                                        $("#DataGridViewGuru").datagrid("reload",{});
                                    }
                                });
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#dialogGuru").dialog("close",{

                                });
                            }
                        }],
                        onLoad:function(){
                            $("#h1").text(rowData.religionName + " 的信息");
                            //表单中 回显数据
                            $("#guruForm").form("load",rowData);
                        }

                    });
                }

            }
        });
//----------------------------------------------------------------------------------------------------------
        $('#ssGuru').searchbox({
            searcher:function(value,name){
                /*   alert(value + "," + name)*/
                $("#DataGridViewGuru").datagrid({
                    url:"${pageContext.request.contextPath}/guru/showGuruPage"
                }),
                    $("#DataGridViewGuru").datagrid("load",{
                        "key":name,
                        "value":value
                    })
            },
            menu:'#mmGuru',
            prompt:'请输入值',
            width:300,
            height:30
        });//searchbox
//----------------------------------------------------------------------------------------------------------
        $("#batchAddGuru").linkbutton({
            text:"批量添加",
            iconCls: 'icon-add',
            width:120,
            height:30,
            onClick: function(){
                /* alert('添加');*/
                //var rowData = $("#DataGridView").datagrid("getSelected");
                $("#dialogGuru").dialog({
                    title: "添加上师",
                    width: 500,
                    height: 350,
                    closed: false,
                    cache: false,
                    modal: true,
                    href: "${pageContext.request.contextPath}/main/excelForm.jsp",
                    buttons:[{
                        text:'提交',
                        handler:function(){
                            $("#excelForm").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/ajaxUpload",
                                onSubmit: function(){
                                    //验证表单
                                    var isValid = $(this).form('validate');
                                    if(!isValid){
                                        return false;
                                    }
                                },
                                success:function(data){
                                    $("#dialogGuru").dialog("close",{
                                    });
                                    $("#DataGridViewGuru").datagrid("reload",{});
                                }
                            });
                        }
                    },{
                        text:'关闭',
                        handler:function(){
                            $("#dialogGuru").dialog("close",{
                            });
                        }
                    }],
                    onLoad:function(){}
                });
            }
        });
    })

</script>



<table id="DataGridViewGuru"></table>

<div id="searchGuru">

    <a id="addGuru"></a>
    <a id="deleteGuru"></a>
    <a id="updateGuru"></a>

    <input id="ssGuru"></input>
    <div id="mmGuru" style="width:120px">
        <div data-options="name:'religionName'">上师法名</div>
    </div>
    <a id="batchAddGuru"></a>
</div>

<div id="dialogGuru"></div>
</body>

