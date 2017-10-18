/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mob87",
        data: {
            anoList:[],
            isShow: 0,
            nameList: ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'],
            illustruation:{
                SL_D: '(0,0,0)',
                FOAccess: '(0,0,0)',
                RadioAccess: '(0,0,0)',
                OTHERS: '(0,0,0)'

            },
            i: 0
        },
        methods: {
            navClick: function(n){
                var m = parseInt(n);
                $("#mob87 ul").find("li")
                    .css("background","#000");
                $("#mob87 ul").find("li").eq(m+1)
                    .css("background","#8D93A8");
                var thisName = this.nameList[m];
                initIn(this.anoList.map[thisName],this.illustruation);
                initEchart("echart1",this.anoList.map[thisName]);
                this.i = m;
            }
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/mobile/vMob87Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                    var d = new Date();
                    var years = d.getFullYear();
                    var month = add_zero(d.getMonth()+1);
                    var days = add_zero(d.getDate());
                    var hours = add_zero(d.getHours());
                    var minutes = add_zero(d.getMinutes());
                    var second=add_zero(d.getSeconds());
                    var nowTime = years+"-"+month+"-"+days+" "+hours+":"+minutes+":"+second;
                    function add_zero(temp) {
                        if(temp<10) return "0"+temp;
                        else return temp;
                    }
                    var time ='Last Update:'+ nowTime;
                    $('.ticket-time').text(time);
                    var illustruation={
                        SL_D: '(0,0,0)',
                        FOAccess: '(0,0,0)',
                            RadioAccess: '(0,0,0)',
                            OTHERS: '(0,0,0)'

                    };
                    self.anoList = data;
                    $("#mob87 ul").find("li").eq(1)
                        .css("background","#8D93A8");
                    initEchart("echart1",self.anoList.map['NAS']);
                    initIn(self.anoList.map['NAS'],self.illustruation);
                    setInterval(function(){
                        var initName = "";
                        self.i++;
                        if(self.i<=7){
                            initName = self.nameList[self.i];
                        }else{
                            self.i = 0;
                            initName = self.nameList[self.i];
                        }
                        initEchart("echart1",self.anoList.map[initName]);
                        initIn(self.anoList.map[initName],self.illustruation);
                        $("#mob87 ul").find("li")
                            .css("background","#000");
                        $("#mob87 ul").find("li").eq(self.i+1)
                            .css("background","#8D93A8");
                    },15000);
                },
                error: function () {

                }
            });
        }
    });
    function init(){
        $.ajax({
            url: _ctx+"/mobile/vMob87Data",
            method: "get",
            dataType: "json",
            success: function (data) {

                window.clearInterval(timer);
                var i = 0;
                var isShow = 0;
                var nameList = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
                var illustruation = {
                    SL_D: '(0,0,0)',
                    FOAccess: '(0,0,0)',
                    RadioAccess: '(0,0,0)',
                    OTHERS: '(0,0,0)'

                };
                var anoList = data;
                $("#mob87 ul").find("li").eq(1)
                    .css("background","#8D93A8");
                initEchart("echart1",anoList.map['NAS']);
                initIn(anoList.map['NAS'],illustruation);
                var timer = setInterval(function(){
                    var initName = "";
                    i++;
                    if(self.i<=7){
                        initName = nameList[i];
                    }else{
                        self.i = 0;
                        initName = nameList[i];
                    }
                    initEchart("echart1",anoList.map[initName]);
                    initIn(anoList.map[initName],illustruation);
                    $("#mob87 ul").find("li")
                        .css("background","#000");
                    $("#mob87 ul").find("li").eq(self.i+1)
                        .css("background","#8D93A8");
                },15000);
            },
            error: function () {

            }
        });
    }
    function initIn(data,illustruation){
        var tmpAdd = data;
        if(tmpAdd.length>0){
            for(var i=0;i<tmpAdd.length;i++){
                var tmpName = tmpAdd[i].name.replace(" ","");
                illustruation[tmpName] = tmpAdd[i].otherfull;
            }
        }
        for(var name in illustruation){
            var tmp = illustruation[name].toString().replace("(","").replace(")","").split(",");
            var htmlStr = "(<span style='color:#F50001;'>"+tmp[0]+",</span>"
                +"<span style='color:#E19713;'>"+tmp[1]+",</span>"
                +"<span style='color:#FFE302;'>"+tmp[2]+"</span>)";
            var domName  = name.replace(" ","");
            $("."+domName).html(htmlStr);
        }
    }
    function initEchart(idDom,echartData){
        var lendData = [];
        var serisData = [];
        var echartDatas;
        var echartLabel ={
            'SL_D':'',
            'FO ACCESS':'',
            'RADIO ACCESS':'',
            'OTHERS':''
        };
        var echartDatas2= [{},{},{},{}];

        if(echartData){
            echartDatas = echartData;
            for(var i=0,len=echartDatas.length;i<len;i++){
                console.log(i);
                console.log(echartDatas[i].name);
                if (echartDatas[i].name == 'SL_D') {
                    echartDatas2[0].name = echartDatas[i].name;
                    echartDatas2[0].value = echartDatas[i].value;
                }
                if (echartDatas[i].name == 'FO ACCESS') {
                    echartDatas2[1].name = echartDatas[i].name;
                    echartDatas2[1].value = echartDatas[i].value;
                }
                if (echartDatas[i].name == 'RADIO ACCESS') {
                    echartDatas2[2].name = echartDatas[i].name;
                    echartDatas2[2].value = echartDatas[i].value;
                }
                if (echartDatas[i].name == 'OTHERS') {
                    echartDatas2[3].name = echartDatas[i].name;
                    echartDatas2[3].value = echartDatas[i].value;
                }
                for(var name in echartLabel){
                    if(name==echartDatas[i].name){
                        echartLabel[name] = echartDatas[i].otherfull;
                    }
                }
            }
        }else{
            serisData = [
                {
                    value:1,name:'nodata'
                }
            ];;
        }
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title :{
                text: 'TICKET',
                subtext: '',
                x:'left',
                textStyle:{
                    fontSize: 18,
                    fontWeight: 'bolder',
                    color: '#fff'
                }
            },
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            gid:{

            },

            series : [
                {
                    name:"87Screen",
                    type:'pie',
                    radius : '60%',
                    center: ['60%', '50%'],

                    itemStyle:{
                        normal:{
                            label:{
                                show: true,
                                textStyle: {
                                    fontSize: '18',
                                    fontWeight: 'normal'
                                },
                                formatter: function(params) {
                                    var res="";
                                    var datas = params.series.data;
                                    for(var i=0;i<datas.length;i++){
                                        res+=params.value;
                                        break;
                                    }
                                    return res;
                                }
                            }

                        },
                        labelLine :{
                            show: true
                        }
                    },
                    data:echartDatas2

                }
            ],
            color:['#FF7F50', '#87CEFA','#DA70D6','#32CD32']
        };
        myChart.setOption(option);
        $("#all",window.parent.document).click(function(){
            myChart.resize();
        });
        $("#small",window.parent.document).click(function(){
            myChart.resize();
        });

    }
    setInterval(function(){
        init();
    },300000)
});