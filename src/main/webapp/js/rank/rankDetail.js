/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var system = new Vue({
        el: "#detail-data",
        data: {
            custname: '',
            custid:'',
            custtype:'',
            custrank:'',
            newId:'',
            shortName:''
        },
        methods: {
            update:function(){
                var self = this;
                if(self.shortName.trim().length==0){
                   alert("Short Name reqired!");
                }else{
                    if(self.shortName.trim().length==10){
                        alert("Short Name is too long!");
                    }else{
                        $.ajax({
                            url: _ctx+"/system/updateRank",
                            method: "get",
                            dataType: "json",
                            data:{
                                ioccustomeruserid: self.newId,
                                ioccustomerusertop7id: custid,
                                name: self.shortName
                            },
                            success: function (data) {
                                if(data.code==1){
                                    alert('update success!');
                                    window.location.href=_ctx+'/system/rankList';
                                }else{
                                    alert('update fail!');
                                }

                            },
                            error: function () {

                            }
                        });
                    }
                }
            }
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/system/getrankDetail",
                method: "get",
                dataType: "json",
                data:{
                    ioccustomerusertop7id:custid
                },
                success: function (data) {
                    self.custname = data.custname;
                    self.custid = data.custid;
                    self.custtype = data.custtype;
                    self.custrank = data.custrank;
                    self.shortName = data.name;
                },
                error: function () {

                }
            });
        }
    });
    function searchCustumer(){
        var custName = $("input#custName").val();
        var type = $("input#type").val();
        $.ajax({
            url: _ctx+"/system/customeruserListData",
            method: "get",
            dataType: "json",
            data:{
                name:custName,
                div:type
            },
            success: function (data) {
                $('.box table tbody').html("");
                var tmpHtml = '';
                for(var i=0;i<data.length;i++){
                    var index=i+1;
                    tmpHtml+='<tr><td width="3%">'+index
                        +'</td><td class="cid" style="display: none;width: 12%;">'+data[i].ioccustomeruserid
                        +'</td><td style="display: none;width: 12%;">'+data[i].grpCust
                        +'</td><td width="12%">'+data[i].custName
                        +'</td><td width="12%">'+data[i].div
                        +'</td></tr>';
                }
                $('.box table tbody').html(tmpHtml);
            },
            error: function () {

            }
        });
    }
    $('.search-name').click(function(){
        $('.box').show();
        searchCustumer();
    });
    $("input#custName").keyup(function(){
        if(event.keyCode ==13){
            searchCustumer();
        }
    });
    $("input#type").keyup(function(){
        if(event.keyCode ==13){
            searchCustumer();
        }
    });
    $('.box table tbody').on("click", "tr",function(){
        $('.box').hide();
        system.newId = $(this).find("td").eq(1).text();
        system.custid = $(this).find("td").eq(2).text();
        system.custname = $(this).find("td").eq(3).text();
        system.custtype = $(this).find("td").eq(4).text();
    });
    $('.close').click(function(){
        $('.box').hide();
    });

});