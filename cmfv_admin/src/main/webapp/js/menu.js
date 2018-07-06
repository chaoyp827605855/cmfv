/**
 * Created by Chao on 2018/7/5.
 */

function addTabs(menuName,menuUrl) {
    var exists = $("#tt").tabs("exists",menuName);
    if(!exists){
        //alert(menuUrl);
        $("#tt").tabs("add",{
                iconCls:"icon-ok",
                title:menuName,
                closable:true,
                href:menuUrl,
            });
    }else {
        $("#tt").tabs("select",menuName);
    }
}


$(function () {
    

    $.ajax({
        post: "POST",
        url: "/cmfv_admin/showAll",
        dataType:"json",
        success: function (data) {
            console.log(data);
            for (var i in data) {
                console.log(data[i]);
                $("#menuPanel").accordion("add", {
                    title: data[i].menuName,
                    //iconCls:'icon-ok',
                    //content: '新内容',
                    selected: false,
                    onOpen: function () {
                        var str = "<div><ul style='list-style-type:none;'>"
                        for (var j in data[i].lists) {
                            str += "<li style='padding-bottom: 15px'><a onclick=addTabs('"+data[i].lists[j].menuName+"','"+data[i].lists[j].menuUrl+"') id='"+data[i].menuCode+"' class=\"easyui-linkbutton\" data-options=\"iconCls:'"+data[i].lists[j].menuIcon+"','width':120\">" + data[i].lists[j].menuName + "</a></li>"
                        }
                        str += "</ul></div>";
                        this.innerHTML = str;
                        $.parser.parse("#menuPanel");

                    }
                });
            }
        }
    }); //ajax



});