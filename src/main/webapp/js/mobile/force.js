/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    function init(){
        $.ajax({
            url: _ctx+"/mobile/topologicalData",
            method: "get",
            dataType: "json",
            success: function (data) {
                window.clearInterval(timer);
                var linkMap = data.linkMap;
                var nodeMap = data.nodeMap;
                var totalData = {
                    'TREG-1': {
                        links: [],
                        nodes: []
                    },
                    'TREG-2': {
                        links: [],
                        nodes: []
                    },
                    'TREG-3': {
                        links: [],
                        nodes: []
                    },
                    'TREG-4': {
                        links: [],
                        nodes: []
                    },
                    'TREG-5': {
                        links: [],
                        nodes: []
                    },
                    'TREG-6': {
                        links: [],
                        nodes: []
                    },
                    'TREG-7': {
                        links: [],
                        nodes: []
                    }
                };
                var mainDom = document.getElementById('echart1');
                var constMaxDepth = 4;
                var categoryData = ['TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
                categoryData.forEach(function(el){
                    for(var i = 0;i<linkMap[el].length;i++){
                        var x = mainDom.clientWidth / 2 + (.5 - Math.random()) * 200;
                        var y = (mainDom.clientHeight - 20) * nodeMap[el][i].deptdepth / (constMaxDepth + 1) + 20;
                        var tmpLink = {};
                        var tmpNode = {};
                        tmpLink.source = linkMap[el][i].ttcId.toString();
                        tmpLink.target = linkMap[el][i].parentId.toString();
                        tmpLink.weight = 1;
                        tmpNode.category  = nodeMap[el][i].catagory;
                        tmpNode.depth = nodeMap[el][i].deptdepth;
                        tmpNode.name = nodeMap[el][i].ttcId;
                        tmpNode.id = nodeMap[el][i].ttcId;
                        tmpNode.index=i;
                        tmpNode.msg=nodeMap[el][i].msg;
                        tmpNode.initial = [x,y];
                        tmpNode.fixY = true;
                        totalData[el].links.push(tmpLink);
                        totalData[el].nodes.push(tmpNode);
                    }
                });
                initEchart("echart1",totalData["TREG-1"].nodes,totalData["TREG-1"].links,"Backhaul TTC Tsel TREG1");
                var i = 0;
                var timer = setInterval(function(){
                    i++;
                    if(i>=8){
                        i=0;
                    }else{
                        var index= i;
                        var liNav = '.first-nav li';
                        var thisLi = '.first-nav li:nth-child('+index+')';
                        $(liNav).css("color","#727386");
                        $(thisLi).css("color","#fff");

                        var liNav2 = '.sec-nav li'+' span';
                        var thisLi2 = '.sec-nav li:nth-child('+index+')'+' span';
                        $(liNav2).css("backgroundColor","#0a0f25");
                        $(thisLi2).css("backgroundColor","#4a476a");
                        var tit = "Backhaul TTC Tsel TREG"+i;
                        var objectName = "TREG-"+i;
                        initEchart("echart1",totalData[objectName].nodes,totalData[objectName].links,tit);
                    }
                },50000);

            },
            error: function () {

            }
        });
    }

   function initEchart(domId,nodes,links){
       var constMaxRadius = 10;
       var constMinRadius = 2;
       var myChart = echarts.init(document.getElementById(domId));
       option = {
           backgroundColor:'#0A0F25',
           title : {
               text: 'Force',
               subtext: 'Force-directed tree',
               x:'right',
               y:'bottom'
           },
           animation:false,
           tooltip : {
               trigger: 'item',
               formatter: function(params) {
                    var res="";
                    var datas = params.series.nodes;
                    for(var i=0;i<datas.length;i++){
                       if(i==params.dataIndex){
                           res=datas[i].msg;
                       }
                      while(res.indexOf("\\n")>=0){
                          var res2=res.replace(/\\n/g, "<br />");
                          break;
                      }
                        if(res!=null&&res!=""){
                            var a = res.split("\\n");
                            if(a.length==9){
                                var errors=a[5].split(":");
                                var flap=a[6].split(":");
                                var alters=a[7].split(":");
                                if(parseFloat(errors[1])==0||parseFloat(flap[1])==0||parseFloat(alters[1]==0)){
                                    params.color="red";
                                }
                            }
                        }
                    }
                       return res2;


               }
           },
           series : [
               {
                   type:'force',
                   name : "Force tree",
                   ribbonType: false,
                   categories : [
                       {
                           name: '叶子节点',
                           itemStyle: {
                               normal: {
                                   color : '#ff7f50'
                               }
                           }
                       },
                       {
                           name: '非叶子节点',
                           itemStyle: {
                               normal: {
                                   color : '#6f57bc'
                               }
                           }
                       },
                       {
                           name: '根节点',
                           itemStyle: {
                               normal: {
                                   color : '#af0000'
                               }
                           }
                       }
                   ],
                   itemStyle: {
                       normal: {
                           label: {
                               show: false
                           },
                           nodeStyle : {
                               brushType : 'both',
                               strokeColor : 'rgba(255,215,0,0.6)',
                               lineWidth : 1
                           }
                       }
                   },
                   minRadius : constMinRadius,
                   maxRadius : constMaxRadius,
                   nodes : nodes,
                   links : links
               }
           ]
       };
       myChart.setOption(option);
   }
    init();
    setInterval(function(){
        init();
    },300000);
});
