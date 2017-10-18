
$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/sla/perserviceData",
            method: "get",
            dataType: "json",
            success: function (data) {
            	//处理数据，数据顺序输出
				var echartdata = [];
               var dealedData = [];
               var tableName = ['DSO','CONS','DES','DBS','DWS','DGS'];
               var month = ['jan','feb','mar','apr','may','jun','jul','aug','sep','oct','nov','decp'];
               tableName.forEach(function(el){
                   var tmp = [];
                   var tmpEchart = {};
                   var tmpData = data['fmap'][el];
               	   month.forEach(function(els){
               	   	   tmp.push(tmpData[0][els]);
				   })
               	   if(el == 'DSO'){
                       tmpEchart.name = el;
                       tmpEchart.type = 'bar';
                       tmpEchart.barWidth = '40';
                       tmpEchart.data = tmp;
				   }else{
                       tmpEchart.name = el;
                       tmpEchart.type = 'line';
                       tmpEchart.data = tmp;
				   }
                   dealedData.push(tmp);
                   echartdata.push(tmpEchart);
			   });
               //渲染数据
               var htmls = '';
               for(var i=0;i<dealedData.length;i++){
               	   var tmpHtml = '<tr><td></td><td>'+tableName[i]+'</td>';
               	   var data = dealedData[i];
               	   for(var j=0;j<data.length;j++){
               	   	  var tdHtml='';
               	   	  if(parseFloat(data[j])<100){
                          tdHtml='<td style="color: red">'+data[j]+'</td>';
					  }else {
                          tdHtml= '<td>' + data[j] + '</td>';
                      }
                       tmpHtml+=tdHtml
				   }
				   tmpHtml+='</tr>';
				   htmls+=tmpHtml;
			   }
               $('table.perservice tbody').html(htmls);

                //echart渲染
                var legend = tableName;
                var xData = month;
                initELine('echart1',echartdata,legend,xData);
            },
            error: function () {

            }
        });
    }
    init();

function initELine(domId,data,legendData,xData) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			    backgroundColor: '#0A0F25',
			    color:['#4a476a','#FF7F50','#32CD32','#e9e857','#4019d3','#e99c1a'],

                    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data: legendData,
			        x: 'right',
			        y: 'top',
			        textStyle: {
			            fontSize: 16,
			            fontFamily: "Arial",
			            color: '#CECECE'
			        }
			    },
			    calculable: true,
			    grid: {
			    	show: false,
			        borderWidth: 1,
			        borderColor: '#212538'
			    },
			    xAxis: [{
			        show: true,
			        type: 'category',
			        axisLabel: {
			            show: true,
			            textStyle: {
			                fontSize: 12,
			                fontFamily: "Arial",
			                color: '#9F9FA1'
			            }
			        },
			        splitArea: {
			            show: false
			        },
			        splitLine: {
			            show: false,
			            lineStyle: {
			                color: '#212538',
			            }
			        },
			        data: ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sept','Oct','Nov','Dec']
			    }],
			    yAxis: [{
			        type: 'value',
			        axisLabel: {
			            show: true,
			            textStyle: {
			                fontSize: 12,
			                fontFamily: "Arial",
			                color: '#9F9FA1'
			            }
			        },
			        splitArea: {
			            show: false
			        },
			        splitLine: {
			            show: true,
			            lineStyle: {
			                color: '#212538',
			            }
			        },
			    }],
			    series: data
			};      
        myChart.setOption(option);
    }
});
