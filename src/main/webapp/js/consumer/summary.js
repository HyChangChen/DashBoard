$(function(){
	function init(){
		$.ajax({
			url: _ctx+"/ano/solutionData",
			method: "get",
			dataType: "json",
			success: function (data) {
				var htmls = '';
               for(var i=0;i<data['listMap']['DBS'].length;i++){

                	var j = i+1;
                	var DBS = data['listMap']['DBS'][i];

                   var time = DBS['ts'];
                   var ttime = "Last Update:" + time;
                   $(".ticket-time").text(ttime);

                	var DES = data['listMap']['DES'][i];
                	var DCS_P = data['listMap']['DCS_PLATINUM'][i];
                	var DCS_G = data['listMap']['DCS_GOLD'][i];
                	var DCS_S = data['listMap']['DCS_SILVER'][i];
                   var moningDtoList = data['moningDtoList'][i];
                	var srDtoList = data['srDtoList'][i];
                    var tmpHtml = '<tr><td>TREG-'+j+'</td>';
                   tmpHtml += '<td>' + DES['a'] + '</td>'
                       + '<td>' + DES['b'] + '</td>'
                       + '<td>' + DES['c'] + '</td>'
                       + '<td>' + DES['d'] + '</td>'
                       + '<td>' + DES['e'] + '</td>'
                       + '<td>' + DES['f'] + '</td>'
                       + '<td>' + DES['ttl'] + '</td>'
                       + '<td>' + DBS['a'] + '</td>'
                       + '<td>' + DBS['b'] + '</td>'
                       + '<td>' + DBS['c'] + '</td>'
                       + '<td>' + DBS['d'] + '</td>'
                       + '<td>' + DBS['e'] + '</td>'
                       + '<td>' + DBS['f'] + '</td>'
                       + '<td>' + DBS['ttl'] + '</td>'
                       + '<td>' + DCS_P['a'] + '</td>'
                       + '<td>' + DCS_P['b'] + '</td>'
                       + '<td>' + DCS_P['c'] + '</td>'
                       + '<td>' + DCS_P['d'] + '</td>'
                       + '<td>' + DCS_P['e'] + '</td>'
                       //+ '<td>' + DCS_P['f'] + '</td>'
                       + '<td>' + DCS_P['ttl'] + '</td>'
                       + '<td>' + DCS_G['a'] + '</td>'
                       + '<td>' + DCS_G['b'] + '</td>'
                       + '<td>' + DCS_G['c'] + '</td>'
                       + '<td>' + DCS_G['d'] + '</td>'
                       + '<td>' + DCS_G['e'] + '</td>'
                      // + '<td>' + DCS_G['f'] + '</td>'
                       + '<td>' + DCS_G['ttl'] + '</td>'
                       + '<td>' + DCS_S['a'] + '</td>'
                       + '<td>' + DCS_S['b'] + '</td>'
                       + '<td>' + DCS_S['c'] + '</td>'
                       + '<td>' + DCS_S['d'] + '</td>'
                       + '<td>' + DCS_S['e'] + '</td>'
                       //+ '<td>' + DCS_S['f'] + '</td>'
                       + '<td>' + DCS_S['ttl'] + '</td>'
					   //Todo  应该为allTTl
                       + '<td>' + moningDtoList.allttl + '</td>'
                       + '<td>' + srDtoList['smsopen'] + '</td>'
                       + '<td>' + srDtoList['smsbackend'] + '</td>'
                       + '<td>' + srDtoList['emailopen'] + '</td>'
                       + '<td>' + srDtoList['emailbackend'] + '</td>'
                       + '<td>' + srDtoList['reopen'] + '</td></tr>'
				   htmls+=tmpHtml;
               }


                var totalhtmls='<tr><td>Total</td>';
                var tdhtmls='';
                var sumList = data['sumList']
                for(var i=0;i<data['sumList'].length-2;i++){
                    if(i<=1) {
                        tdhtmls += '<td>' + sumList[i].a + '</td>'
                            + '<td>' + sumList[i].b + '</td>'
                            + '<td>' + sumList[i].c + '</td>'
                            + '<td>' + sumList[i].d + '</td>'
                            + '<td>' + sumList[i].e + '</td>'
                            + '<td>' + sumList[i].f + '</td>'
                            + '<td>' + sumList[i].ttl + '</td>'
                    }else{
                        tdhtmls += '<td>' + sumList[i].a + '</td>'
                            + '<td>' + sumList[i].b + '</td>'
                            + '<td>' + sumList[i].c + '</td>'
                            + '<td>' + sumList[i].d + '</td>'
                            + '<td>' + sumList[i].e + '</td>'
                            + '<td>' + sumList[i].ttl + '</td>'
                    }
                }
                tdhtmls +='<td>' + sumList[5]+ '</td>'
                    + '<td>' + sumList[6].smsopen + '</td>'
                    + '<td>' + sumList[6].smsbackend + '</td>'
                    + '<td>' + sumList[6].emailopen + '</td>'
                    + '<td>' + sumList[6].emailbackend + '</td>'
                    + '<td>' + sumList[6].reopen + '</td></tr>'
                 totalhtmls+=  tdhtmls;
                htmls+=totalhtmls;


               $('table.summary tbody').html(htmls);
			},
			error: function () {

			}
		});
	}
    init();
});