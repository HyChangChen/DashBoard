$(function(){
    var digitalData = new Vue({
        el: "#internal-data",
        data: {
             dataList: []
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/sla/internalData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.dataList = data.listMap;
                },
                error: function () {

                }
            });
        }
    });

});


function toDecimal(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return;
    }
    f = Math.round(x*100)/100;
    return f;
}
function toPercent(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return;
    }
    if(f==0){
        return 0;
    }
    f = Math.round(x*100*100)/100+"%";
    return f;
}