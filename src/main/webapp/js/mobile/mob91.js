/**
 * Created by lenovo on 2017/6/26.
 */
/*$(function () {
    var digitalData = new Vue({
        el: "#mob91-data",
        data: {
            mobLeft:[],
            mobRight:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/mobile/vMob91Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.mobLeft = data.mob91LeftList;
                    self.mobRight = data.mob9RightList;
                },
                error: function () {

                }
            });
        }
    });
});*/
$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/mobile/vMob91Data",
            method: "get",
            dataType: "json",
            success: function (data) {
                var mobLeft = data.mob91LeftList;
                var mobRight = data.mob9RightList;
                $("table.mobLeft tbody").html("");
                $("table.mobRight tbody").html("");
                var tmpHtml1  = '';
                var tmpHtml2  = '';
                for(var i = 0;i<mobLeft.length;i++){
                    tmpHtml1+='<tr><td>'+mobLeft[i].ioc1
                        +'</td><td>'+mobLeft[i].ioc2
                        +'</td><td>'+mobLeft[i].ioc3
                        +'</td><td>'+mobLeft[i].ioc4
                        +selectBg(mobLeft[i].ioc5,99)
                        +'</td><td>'+mobLeft[i].ioc6
                        +selectBg(mobLeft[i].ioc7,40)
                        +'</td></tr>';
                    tmpHtml2+='<tr><td>'+mobRight[i].ioc1
                        +'</td><td>'+mobRight[i].ioc2
                        +'</td><td>'+mobRight[i].ioc3
                        +'</td><td>'+mobRight[i].ioc4
                        +selectBg(mobRight[i].ioc5,99)
                        +'</td><td>'+mobRight[i].ioc6
                        +selectBg(mobRight[i].ioc7,40)
                        +'</td></tr>';
                }
                $("table.mobLeft tbody").html(tmpHtml1);
                $("table.mobRight tbody").html(tmpHtml2);
            },
            error: function () {

            }
        });
    }
    function selectBg(data,normal){
        var str='';
        if(parseFloat(data)>normal){
            str='<td class="mob-bg-blue">'+data+'</td>';
        }else{
            str='<td class="mob-bg-red">'+data+'</td>';
        }
        return str;
    }
    init();
    setInterval(function(){
        init();
    },300000)
});
