/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initMap(){
        var zoom = 9;
        var fromProjection = new OpenLayers.Projection("EPSG:4326");
        var toProjection = new OpenLayers.Projection("EPSG:900913");
        map = new OpenLayers.Map("Map");
        var mapnik = new OpenLayers.Layer.OSM();
        map.addLayer(mapnik);
        map.setCenter(new OpenLayers.LonLat(119.167, -1.394)//115.269, -0.286
            .transform(fromProjection, toProjection), 6.5);
        initLines(map, fromProjection, toProjection);
        initAllPoints(map, fromProjection, toProjection);

        initTable();
        //事件绑定
        $("#bottom-table").on("click","td",function(){
            $("#bottom-table tr td:not(:first)").css("color","#000");
            $(this).css("color","blue");
            var  params= $(this).attr("id").split("-");
            var  url;
            if(params[0]=='TOTAL'&&params[1]=='8'){
                url = _ctx+"/ano/openMapPoints";
            }else{
                url = _ctx+"/ano/mapPoint";
            }
            $.ajax({
                url: url,
                method: "get",
                data:{
                    mtype: params[0],
                    treg: params[1]
                },
                dataType: "json",
                success: function(data){

                    initPoints(data,map,fromProjection, toProjection);
                },
                error: function(){

                }
            })
        });
    }
    function initAllPoints(map,fromProjection, toProjection){
        $.ajax({
            url: _ctx+"/ano/openMapPoints",
            method: "get",
            dataType: "json",
            success: function(data){
                initPoints(data,map,fromProjection, toProjection);
            },
            error: function(){

            }
        });
    }
    function initPoints(pointDatas,map, fromProjection, toProjection){
        var size = new OpenLayers.Size(21, 25);
        var offset = new OpenLayers.Pixel(-(size.w / 2), -size.h);

        var lineLayers = map.getLayersByName(new RegExp("Markers", ""));
        for ( var t = 0; t < lineLayers.length; t++) {
            map.removeLayer(lineLayers[t]);
        }
        var markers = new OpenLayers.Layer.Markers("Markers");
        var points = pointDatas;
        for ( var i = 0; i < points.length; i++) {
            var point = points[i];
            var type = point["type"];
            var name = point["name"];
            var x = point["x"];
            var y = point["y"];
            var icon = new OpenLayers.Icon(_ctx+'/imgs/WIFIAP.png', size, offset);
            if(type==="METRO"){
                icon = new OpenLayers.Icon(_ctx+'/imgs/b-64.png', size, offset);
            }else if(type==="PE"){
                icon = new OpenLayers.Icon(_ctx+'/imgs/g-64.png', size, offset);
            }else if(type==="TERA"){
                icon = new OpenLayers.Icon(_ctx+'/imgs/y-64.png', size, offset);
            }
            eval("var position"
                + i
                + " = new OpenLayers.LonLat("
                + x
                + ", "
                + y
                + ").transform(fromProjection, toProjection);");
            eval("var marker = new OpenLayers.Marker(position"
                + i + ",icon);");
            eval("marker.events.register('mouseover', marker, function (evt) {popup"
                + i
                + " = new OpenLayers.Popup('"
                + name
                + "', position"
                + i
                + ", new OpenLayers.Size(200, 50), '"
                + name
                + "', false);map.addPopup(popup"
                + i
                + ");});");
            eval("marker.events.register('mouseout', marker, function (evt) {popup"
                + i + ".hide();}); ");
            eval("markers.addMarker(marker);");
        }

        map.addLayer(markers,{zoomOffset:12});

    }

    function initLines(map, fromProjection, toProjection) {
        $.ajax({
            url: _ctx+"/ano/openMapLines",
            method: "get",
            dataType: "json",
            success: function(data){
                var lineList = data.mapOpenmaplineList;
                for(var i=0;i<lineList.length;i++){
                    var line = lineList[i];
                    var from_point = new OpenLayers.LonLat(line.fromX,
                        line.fromY).transform(fromProjection,
                        toProjection);
                    var to_point = new OpenLayers.LonLat(line.toX,
                        line.toY).transform(fromProjection,
                        toProjection);
                    var vectors,lineFeature;//存放线路
                    //线路样式
                    var style_green = {
                        strokeColor: "red",
                        strokeWidth: 3,
                        strokeDashstyle: "solid",
                        pointRadius: 6,
                        pointerEvents: "visiblePainted"
                    };
                    //画线图层设置
                    var layer_style = OpenLayers.Util.extend({}, OpenLayers.Feature.Vector.style['default']);
                    layer_style.fillOpacity = 0.2;
                    layer_style.graphicOpacity = 1;
                    //画线图层
                    vectors = new OpenLayers.Layer.Vector("Simple Geometry", {style: layer_style});
                    map.addLayer(vectors,{zoomOffset:12});
                    //一下采用数组型式填充轨迹
                    var pointList = [];
                    var newPoint1 = new OpenLayers.Geometry.Point(from_point.lon,from_point.lat);
                    pointList.push(newPoint1);
                    var newPoint2 = new OpenLayers.Geometry.Point(to_point.lon,to_point.lat);
                    pointList.push(newPoint2);
                    lineFeature = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.LineString(pointList),null,style_green);
                    vectors.addFeatures([lineFeature]);
                    map.addLayer(vectors);
                }

            },
            error: function(){

            }
        })
    }
    function initTable(){
        $("#top-table").empty();
        $("#bottom-table").empty();
        $.ajax({
            url: _ctx+"/ano/openMapTable",
            method: "get",
            dataType: "json",
            success: function(data){
                //初始化top-table
                var arrlist = data["mapOpenmaptableRighttableList"];
                for(var i=0;i<arrlist.length;i++){
                    var index = i+1;
                    var tmpHtml = '<tr style="height: 60px"><td>'+index
                        +'</td><td>'+arrlist[i].dates
                        +'</td><td>'+arrlist[i].ruas
                        +'</td><td>'+arrlist[i].nodeId
                        +'</td><td>'+arrlist[i].interface_
                        +'</tr>';
                    $("#top-table").append(tmpHtml);
                }
                //初始化bottom-table
                var bottomObj = data["mttrM"];
                var metroStr = "<tr><td><img src="+_ctx+"/imgs/b-64.png>Metro-E</td>";
                var peStr = "<tr><td><img src="+_ctx+"/imgs/g-64.png>PE</td>";
                var teraStr = "<tr><td><img src="+_ctx+"/imgs/y-64.png>Tera</td>";
                var ToStr = "<tr><td>Total</td>";
                for(var name in bottomObj){
                    switch(name){
                        case "METRO":
                            var tableData1 = bottomObj[name];
                            for(var i=0;i<tableData1.length;i++){
                                var index = i+1;
                                metroStr+="<td id='METRO-"+index+"'>"+tableData1[i]+"</td>"
                            }
                            break;
                        case "PE":
                            var tableData2 = bottomObj[name];
                            for(var i=0;i<tableData2.length;i++){
                                var index = i+1;
                                peStr+="<td id='PE-"+index+"'>"+tableData2[i]+"</td>"
                            }
                            break;
                        case "TERA":
                            var tableData3 = bottomObj[name];
                            for(var i=0;i<tableData3.length;i++){
                                var index = i+1;
                                teraStr+="<td id='TERA-"+index+"'>"+tableData3[i]+"</td>"
                            }
                            break;
                        default:
                            var tableData4 = bottomObj[name];
                            for(var i=0;i<tableData4.length;i++){
                                var index = i+1;
                                ToStr+="<td id='TOTAL-"+index+"'>"+tableData4[i]+"</td>"
                            }
                    }
                }
                metroStr+="</tr>";
                peStr+="</tr>";
                teraStr+="</tr>";
                ToStr+="</tr>";
                var allHtml = metroStr+peStr+teraStr+ToStr;
                $("#bottom-table").append(allHtml);
            },
            error: function(){

            }
        })
    }

    initMap();
    setInterval(function(){
        initMap();
    },300000)
}());