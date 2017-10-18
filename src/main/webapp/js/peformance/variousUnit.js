$(function(){
	function init(){
		$.ajax({
			url: _ctx+"/sla/variousunitData",
			method: "get",
			dataType: "json",
			success: function (data) {
				var leftTop  = data.fmap.DBS.lefttop;
				var rightTop = data.fmap.DBS.righttopList;
				var bottom = data.fmap.DBS.pieDto.arcMap;
				var bottomPie = data.fmap.DBS.pieDto.pieMap;
				var dataSquence = ['DBS','DES','DGS','DWS'];
                initData(leftTop,rightTop,bottom,bottomPie);
				var n = 0;
				setInterval(function(){
                    n++;
                    if(n>=4){
                    	n=0;
					}
                    var objName = dataSquence[n];
                    leftTop = data['fmap'][objName]['lefttop'];
                    rightTop = data['fmap'][objName]['righttopList'];
                    bottom = data['fmap'][objName]['pieDto']['arcMap'];
                    bottomPie = data['fmap'][objName]['pieDto']['pieMap'];
                    initData(leftTop,rightTop,bottom,bottomPie);
				},5000);
			},
			error: function () {

			}
		});
	}
	function initData(leftTop,rightTop,bottom,bottomPie){
        //初始化左上角的数据
        $('.t_standard').text(leftTop.tStandard);
        $('.t_closeYear').text(leftTop.closeYears);
        $('.t_num').text(leftTop.ticketNums);
        $('.r_mtt').text(leftTop.rMtt);
        $('.class_name').text(leftTop.custType);
        //初始化右上角的数据
        var data2 = [];
        for(var i=0;i<rightTop.length;i++){
            var tmpObj = {};
            tmpObj.value = rightTop[i].ticketNums
            tmpObj.name = rightTop[i].pieLabel;
            data2.push(tmpObj);
        }
        initEchart('echart1',true,true,data2);
        //初始化底部数据的数据

        var data4 = [];
        if('TOP 20' in bottom){
            $('.ach-left').text(bottom['TOP 20'][0].openMttrLeft);
            $('.r-left').text(bottom['TOP 20'][0].rMtt.toFixed(2));
            var pieData1 = bottomPie['TOP 20'];
            for(var k=0;k<pieData1.length;k++){
                var tmpObj1 = {};
                tmpObj1.value = pieData1[k].ticketNums
                tmpObj1.name = pieData1[k].pieLabel;
                data4.push(tmpObj1);
            }
        }

        var data3 = [];
        if('Other Top' in bottom){
            $('.ach-right').text(bottom['Other Top'][0].openMttrLeft);
            $('.r-right').text(bottom['Other Top'][0].rMtt.toFixed(2));
            var pieData0 = bottomPie['Other Top'];
            for(var j=0;j<pieData0.length;j++){
                var tmpObj0 = {};
                tmpObj0.value = pieData0[j].ticketNums
                tmpObj0.name = pieData0[j].pieLabel;
                data3.push(tmpObj0)
            }
        }

        var data5 = [];
        if('TOP 200' in bottom){
            $('.ach-center').text(bottom['TOP 200'][0].openMttrLeft);
            $('.r-center').text(bottom['TOP 200'][0].rMtt.toFixed(2));
            var pieData2 = bottomPie['TOP 200'];
            for(var m=0;m<pieData2.length;m++){
                var tmpObj2 = {};
                tmpObj2.value = pieData2[m].ticketNums
                tmpObj2.name = pieData2[m].pieLabel;
                data5.push(tmpObj2);
            }
        }
        initEchart('echart2',false,false,data4);
        initEchart('echart3',false,false,data5);
        initEchart('echart4',false,false,data3);
        initPie('echart',leftTop.openMttrLeft,leftTop.colseMttrLeft);
	}
	init();
	function initPie(domId,data1,data2){
		var myChart = echarts.init(document.getElementById(domId));
		option = {
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			series : [
				{
					name:'mttr',
					type:'pie',
					radius : ['50%', '70%'],
					itemStyle : {
						normal : {
							label : {
								show : false
							},
							labelLine : {
								show : false
							}
						},
						emphasis : {
							label : {
								show : true,
								position : 'center',
								textStyle : {
									fontSize : '12',
									fontWeight : 'bold'
								}
							}
						}
					},
					data:[
						{value:data1, name:'open'},
						{value:data2, name:'close'}
					]
				}
			]
		};
		myChart.setOption(option);
	}
	function initEchart(domId,isTit,isLabel,initData) {
		var myChart = echarts.init(document.getElementById(domId));
		var color = [ "#ff7f50", "#87cefa", "#da70d6", "#32cd32", "#6495ed"];
		if(initData.length==0){
			initData = [
				{
					value:0,name:'noData'
				}
			];

		}
        color = ['#ececec'];
		option = {
			backgroundColor:'#0a0f25',
			title : {
				show:isTit,
				text: 'closed',
				x:'center',
				y:'bottom',
				textStyle : {
					fontSize : '30',
					fontWeight : 'bold',
					color: '#cecece'
				}
			},
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
            legend:{
			    show:true,
                textStyle:{
                    color:'#fff',
                    fontSize:14
                },
                orient:'vertical',
                x : 'left',
                data:['1~3H','3H~24H','24H~7D','>7D']

            },
			series : [
				{
					name:'ticketNum',
					type:'pie',
					itemStyle:{
						normal:{
							label:{
								show: isLabel,
								position:'inner',
                                formatter: "{d}%"
							},
							labelLine:{
								show:false
							}
						}
					},
					radius : '40%',
					center: ['50%', '40%'],
					data:initData
				}
			]
		};
		myChart.setOption(option);
	}
});