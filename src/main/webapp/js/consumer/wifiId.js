$(function(){
	function init(){
		$.ajax({
			url: _ctx+"/ano/srviewData",
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
                var time ='Last Update:'+ nowTime;
                $('.ticket-time').text(time);
				var dataOrder = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
				var scale = data.lineM;
				var scaleName = data.linelist;
				var line = data.pillM;
				var lineName = data.pilllist;
				initEchart("echart1",line,lineName);
				initEScale("echart2",scale['TREG-1'].Platinum,scaleName,'PLATINUM');
				initEScale("echart3",scale['TREG-1'].Gold,scaleName,'TITANNIUM&GOLD');
				initEScale("echart4",scale['TREG-1'].Silver,scaleName,'SILVER');
				var i = 0;
				var timer = setInterval(function(){
					i++;
					if(i>=9){
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

						var indexName = dataOrder[i-1];

						initEScale("echart2",scale[indexName].Platinum,scaleName,'PLATINUM');
						initEScale("echart3",scale[indexName].Gold,scaleName,'TITANNIUM&GOLD');
						initEScale("echart4",scale[indexName].Silver,scaleName,'SILVER');

					}
				},5000);
			},
			error: function () {

			}
		});
	}
    function add_zero(temp) {
        if(temp<10) return "0"+temp;
        else return temp;
    }
	function initEchart(domId,data,xdata) {
		var tol = [
			{value:0 ,name:0},
            {value:0 ,name:0},
            {value:0 ,name:0},
            {value:0 ,name:0},
            {value:0 ,name:0},
            {value:0 ,name:0},
            {value:0 ,name:0},
			];
		for(var i = 0;i<7;i++){
			tol[i].name = data.IPTV[i] + data.Internet[i] +data.Pots[i];
			if(tol[i].name.toString().length>3)
			{
				var c = tol[i].name.toString().length % 3;
                tol[i].name = tol[i].name.toString().substring(0,c) +","+ tol[i].name.toString().substring(c,tol[i].name.toString().length);
			}

		}

        var myChart = echarts.init(document.getElementById(domId));
			option = {
			  backgroundColor:'#0A0F25',
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    legend: {
			        data:['IPTV','Internet','Pots'],
			        x: 'right',
			        y: 'top',
			        textStyle:{
			           fontSize: 12,
			           color: '#B4B3B3'
			       }
			    },
			    calculable : true,
			    grid:{
			        borderWidth: 0
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data : xdata,
			           axisLabel:{
			               show: true,
			               textStyle:{
			                   color:'#9FA0A1',
			               }
			           },
			          axisLine : {    // 轴线
			                        show: true,
			                        lineStyle: {
			                          color: '#494868',
			                          type: 'solid',
			                          width: 2
			                    },
			          },
			          splitLine : { //网格分隔线
			                        show:true,
			                        lineStyle: {
			                            color: '#23283B',
			                            type: 'solid',
			                            width: 1
			                        }
			                    },
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			             axisLabel:{
			                 show: true,
			                 textStyle:{
			                     color:'#9FA0A1',
			                 }
			             },
			            axisLine : {    // 轴线
			                        show: true,
			                        lineStyle: {
			                          color: '#494868',
			                          type: 'solid',
			                          width: 2
			                    },
			          },
			            splitLine : { //网格分隔线
			                        show:true,
			                        lineStyle: {
			                            color: '#494868',
			                            type: 'solid',
			                            width: 1
			                        }
			                    },
			          splitArea:{
			               show: false
			          }
			        }
			    ],
			    series : [
			        {
			            name:'IPTV',
			            type:'bar',
			            barWidth:'40',
			            itemStyle:{
			                 normal:{
			                      color: '#4B476A',
			                      barBorderColor: '#4B476A',
			                      barBorderWidth: 6,
			                      barBorderRadius:0,
			                      label:{
			                            show: true,
			                            position:'inside',
			                            textStyle:{
			                                color: '#fff',
			                                align: 'center',
			                                fontSize: 12,
			                            }
			                      }
			                 }
			            },
			            stack: '广告',
			            data:data.IPTV
			        },
			        {
			            name:'Internet',
			            type:'bar',
			            stack: '广告',
			            itemStyle:{
			                 normal:{
			                      color: '#D46E86',
			                      barBorderColor: '#D46E86',
			                      barBorderWidth: 6,
			                      barBorderRadius:0,
			                      label:{
			                            show: true,
			                            position:'inside',
			                            textStyle:{
			                                color: '#fff',
			                                align: 'center',
			                                fontSize: 12,
			                            }
			                      }
			                 }
			            },
			            data:data.Internet
			        },
			        {
			            name:'Pots',
			            type:'bar',
			            stack: '广告',
			            itemStyle:{
			                 normal:{
			                      color: '#F7AA62',
			                      barBorderColor: '#F7AA62',
			                      barBorderWidth: 6,
			                      barBorderRadius:0,
			                      label:{
			                            show: true,
			                            position:'inside',
			                            textStyle:{
			                                color: '#fff',
			                                align: 'center',
			                                fontSize: 12,
			                            }
			                      }
			                 }
			            },
			            data:data.Pots
			        },
                    {
                        name:' ',
                        type:'bar',
                        stack: '广告',
                        itemStyle:{

                            normal:{

                                color: '#F7AA62',
                                barBorderColor: '#F7AA62',
                                barBorderWidth: 6,
                                barBorderRadius:0,
                                label:{
                                    show: true,
                                    position:'top',
                                    formatter:function(params){
                                        if(params['name'] == 'R1')
                                            return tol[0].name;
                                        else if(params['name'] == 'R2')
                                            return tol[1].name;
                                        else if(params['name'] == 'R3')
                                            return tol[2].name;
                                        else if(params['name'] == 'R4')
                                            return tol[3].name;
                                        else if(params['name'] == 'R5')
                                            return tol[4].name;
                                        else if(params['name'] == 'R6')
                                            return tol[5].name;
                                        else
											return tol[6].name;
                                    },
                                    textStyle:{
                                        color: '#fff',
                                        align: 'center',
                                        fontSize: 12,
                                    }
                                }
                            }
                        },
                        data:tol
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
    function initEScale(domId,data,xdata,tit){
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			  backgroundColor:'#0A0F25',
			   title: {
			        text: tit,
			        backgroundColor:'#2a2b48',
			        textStyle: {
			            fontSize: 12,
			            fontFamily: 'Arial',
			            color: '#9F9FA1'
			        }
			    },
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    calculable : true,
			    grid:{
			        borderWidth: 0,
			        x:'40',
			        y:'40',
			        width: '90%',
			        height: '40%'
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data : xdata,
			           axisLabel:{
			               show: true,
			               textStyle:{
			                   color:'#9FA0A1',
			               }
			           },
			          axisLine : {    // 轴线
			                        show: true,
			                        lineStyle: {
			                          color: '#494868',
			                          type: 'solid',
			                          width: 2
			                    },
			          },
			          splitLine : { //网格分隔线
			                        show:true,
			                        lineStyle: {
			                            color: '#23283B',
			                            type: 'solid',
			                            width: 1
			                        }
			                    },
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			             axisLabel:{
			                 show: true,
			                 textStyle:{
			                     color:'#9FA0A1',
			                 }
			             },
			            axisLine : {    // 轴线
			                        show: true,
			                        lineStyle: {
			                          color: '#494868',
			                          type: 'solid',
			                          width: 2
			                    },
			          },
			            splitLine : { //网格分隔线
			                        show:true,
			                        lineStyle: {
			                            color: '#494868',
			                            type: 'solid',
			                            width: 1
			                        }
			                    },
			          splitArea:{
			               show: false
			          }
			        }
			    ],
			    series : [
			        {
			            name:'成交',
			            type:'bar',
                        barWidth: 40,
			            smooth:true,
			            symbol:'none',
			            itemStyle: {
			            	normal: {
                                label:{
                                    show : true,
									textStyle: {
                                        color: '#ffffff'
                                    }
								},
			            		areaStyle: {
			            			type: 'default',
			            			color:'#2a2b48'
			            		},
			            		lineStyle: {
                                    color:'#2a2b48'
			            		}
			            	}
			            },
			            data:data
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
	init();
});