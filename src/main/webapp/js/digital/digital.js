/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#digital-data",
        data: {
            tit:"",
            digList: [],
            dig13Dto: [],
            dig14Dto: [],
            dig17Dto: [],
            dig18Dto: [],
            isShow: false,
            month: "",
            year: ""
        },
        methods: {
           initEchartData:function(domName1,data,domName2){
               for(var n=0;n<data.length;n++){
                   var real = parseFloat(data[n]["ioc4"].toString().replace(',',''));
                   var target = parseFloat(data[n]["ioc3"].toString().replace(',',''));
                   var real1 = parseFloat(data[n]["ioc10"].toString().replace(',',''));
                   var target1 = parseFloat(data[n]["ioc9"].toString().replace(',',''));
                   if(real>target){
                       initEchart(domName1+n,real);
                   }else{
                       var data1 = real/target;
                       var data2 = (target-real)/target;
                       initEchart(domName1+n,data1,data2);
                   }
                   if(real1>target1){
                       initEchart(domName2+n,real1);
                   }else{
                       var data3 = real1/target1;
                       var data4 = (target1-real1)/target1;
                       initEchart(domName2+n,data3,data4);
                   }
               }
           }
        },
        compiled:function () {

        },
        created: function () {
            var self = this;
            var tmpurl = _ctx+"/digital/vDigital"+urlNum+"Data";
            $.ajax({
                url: tmpurl,
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.tit = data.name;
                    switch(urlNum){
                        case "13":
                            self.digList = data.vDig13List;
                            break;
                        case "14":
                            self.digList = data.dig14List;
                            break;
                        case "17":
                            self.digList = data.dig17List;
                            break;
                        case "18":
                            self.digList = data.dig18List;
                            break;
                        default:
                            self.dig13Dto = data.dig13Dto;
                            self.dig14Dto = data.dig14Dto;
                            self.dig17Dto = data.dig17Dto;
                            self.dig18Dto = data.dig18Dto;
                            self.isShow = true;
                            var myDate = new Date();
                            var dataEnglish = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
                            self.month= dataEnglish[myDate.getMonth()];
                            self.year = myDate.getFullYear();
                    }
                    if(self.digList&&self.digList.length>=1){
                        for(var i=0,len=self.digList.length;i<len;i++){
                            self.digList[i].id="dig"+i;
                            self.digList[i].id1="dig-"+i;
                        }
                    }
                    if(self.dig13Dto.vDig13List&&self.dig13Dto.vDig13List.length>0){
                        for(var j=0,lens=self.dig13Dto.vDig13List.length;j<lens;j++){
                            self.dig13Dto.vDig13List[j].id="dig13"+j;
                            self.dig13Dto.vDig13List[j].id1="dig13-"+j;
                        }
                    }
                    if(self.dig14Dto.dig14List&&self.dig14Dto.dig14List.length>0){
                        for(var k=0,lenss=self.dig14Dto.dig14List.length;k<lenss;k++){
                            self.dig14Dto.dig14List[k].id="dig14"+k;
                            self.dig14Dto.dig14List[k].id1="dig14-"+k;
                        }
                    }
                    if(self.dig17Dto.dig17List&&self.dig17Dto.dig17List.length>01){
                        for(var m=0,l=self.dig17Dto.dig17List.length;m<l;m++){
                            self.dig17Dto.dig17List[m].id="dig17"+m;
                            self.dig17Dto.dig17List[m].id1="dig17-"+m;
                        }
                    }
                    if(self.dig18Dto.dig18List&&self.dig18Dto.dig18List.length>0){
                        for(var n=0,len=self.dig18Dto.dig18List.length;n<len;n++){
                            self.dig18Dto.dig18List[n].id="dig18"+n;
                            self.dig18Dto.dig18List[n].id1="dig18-"+n;
                        }
                    }

                    setTimeout(function(){
                        if(self.digList&&self.digList.length>0){
                            self.initEchartData("dig",self.digList,"dig-");
                        }
                        if(self.dig13Dto.vDig13List&&self.dig13Dto.vDig13List.length>0){
                            self.initEchartData("dig13",self.dig13Dto.vDig13List,"dig13-");
                        }
                        if(self.dig14Dto.dig14List&&self.dig14Dto.dig14List.length>0){
                            self.initEchartData("dig14",self.dig14Dto.dig14List,"dig14-");
                        }
                        if(self.dig17Dto.dig17List&&self.dig17Dto.dig17List.length>0){
                            self.initEchartData("dig17",self.dig17Dto.dig17List,"dig17-");
                        }
                        if(self.dig18Dto.dig18List&&self.dig18Dto.dig18List.length>0){
                            self.initEchartData("dig18",self.dig18Dto.dig18List,"dig18-");
                        }
                    },200);
                },
                error: function () {

                }
            });
        }
    });
    function initEchart(idDom,data1,data2){
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            color:['blue','khaki'],
            series : [
                {
                    type:'pie',
                    radius : '70%',
                    center: ['50%', '50%'],
                    itemStyle:{
                        normal:{
                            label:{
                                show: false
                            },
                            labelLine:{
                                show: false
                            }
                        }
                    },
                    data:[
                        {value:data1},
                        {value:data2}
                    ]
                }
            ]
        };
        myChart.setOption(option);
        $("#all",window.parent.document).click(function(){
            myChart.resize();
        });
        $("#small",window.parent.document).click(function(){
            myChart.resize();
        });
    }
});
