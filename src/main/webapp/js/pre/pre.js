$(function(){
	scroll('5','treg14');
	scroll('4','treg57');
	init();
	var totalData = {
		treg1:[],
		treg2:[],
		treg3:[],
		treg4:[],
		treg5:[],
		treg6:[],
		treg7:[]
	};
	function init(){
		$.ajax({
			url: _ctx+"/ano/per7xData",
			method: "get",
			dataType: "json",
			success: function (data) {
				totalData.treg1 = data.stringListMap['TREG-1'];
				totalData.treg2 = data.stringListMap['TREG-2'];
				totalData.treg3 = data.stringListMap['TREG-3'];
				totalData.treg4 = data.stringListMap['TREG-4'];
				totalData.treg5 = data.stringListMap['TREG-5'];
				totalData.treg6 = data.stringListMap['TREG-6'];
				totalData.treg7 = data.stringListMap['TREG-7'];
				dataBind(totalData.treg1,'treg14-table');
				initEPie("echart1",totalData.treg1[0].myindihome,totalData.treg1[0].other);
				initEPie("echart2",totalData.treg1[1].myindihome,totalData.treg1[1].other);
				dataBind(totalData.treg5,'treg57-table');
				initEPie("echart3",totalData.treg5[0].myindihome,totalData.treg5[0].other);
				initEPie("echart4",totalData.treg5[1].myindihome,totalData.treg5[1].other);
				var i = 0;
				var timer1 = setInterval(function(){
					var domName = 'treg14';
					i++;
					if(i>=5){
						i=0;
					}else{
						var index= i+1;
						var liNav = '.'+domName+' li';
						var thisLi = '.'+domName+' li:nth-child('+index+')';
						$(liNav).css("color","#727386");
						$(thisLi).css("color","#fff");
						var pieData = 'treg'+i;
						dataBind(totalData[pieData],'treg14-table');
						initEPie("echart1",totalData[pieData][0].myindihome,totalData[pieData][0].other);
						initEPie("echart2",totalData[pieData][1].myindihome,totalData[pieData][1].other);
					}
				},15000);

				var j = 4;
				var timer2 = setInterval(function(){
					var domName = 'treg57';
					j++;
					if(j>=8){
						j=4;
					}else{
						var index= j-3;
						var liNav = '.'+domName+' li';
						var thisLi = '.'+domName+' li:nth-child('+index+')';
						$(liNav).css("color","#727386");
						$(thisLi).css("color","#fff");
						var pieData = 'treg'+j;
						dataBind(totalData[pieData],'treg57-table');
						initEPie("echart3",totalData[pieData][0].myindihome,totalData[pieData][0].other);
						initEPie("echart4",totalData[pieData][1].myindihome,totalData[pieData][1].other);
					}
				},15000);
			},
			error: function () {

			}
		});//regional
	}
	function dataBind(data,domName){
        $('.'+domName+' .my-TregDown').text(data[0].regional);
		$('.'+domName+' .my-cPsDown').text(data[0].psDone);
		$('.'+domName+' .my-notPsDown').text(data[0].notPsDone);
		$('.'+domName+' .my-totalPsDown').text(data[0].grandTotal);
		$('.'+domName+' .others-cPsDown').text(data[1].psDone);
		$('.'+domName+' .others-notPsDown').text(data[1].notPsDone);
		$('.'+domName+' .others-totalPsDown').text(data[1].grandTotal);
		$('.'+domName+' .total-cPsDown').text(data[2].psDone);
		$('.'+domName+' .total-notPsDown').text(data[2].notPsDone);
		$('.'+domName+' .total-totalPsDown').text(data[2].grandTotal);
	}
	function scroll(count,domName){
		var i = 0;
		setInterval(function(){
           i++;
           if(i>=count){
              i=0;
           }else{
           	  var index= i+1; 
           	  var liNav = '.'+domName+' li';
           	  var thisLi = '.'+domName+' li:nth-child('+index+')';
              $(liNav).css("color","#727386");
			  $(thisLi).css("color","#fff");
           }
		},15000);
	}
	function initEPie(domId,openData,closeData) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
				background:'#21233c',
                color:['#d46e87','#35314e'],
			    //color:['#35314e','#d46e87'],
			    series : [{
			            type:'pie',
			            radius : '65%',
			            center: ['50%', '50%'],
			            itemStyle:{
			             normal:{
			                label:{
			                    show: true,
			                    position:'inner',
                                formatter:"{b}  {d}%",
                                textStyle:{
                                    color:'#fff',
                                    fontSize:18
                                }
			                },
			               labelLine:{
			                  show:false
			               }
			              }
			            },
			            data:[
			                {value:openData, name:'Comp'},
			                {value:closeData, name:'Not Comp'}
			            ]
			        }
			    ]
			};
        myChart.setOption(option);
    }
});