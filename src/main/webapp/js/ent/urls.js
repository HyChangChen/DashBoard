$(function(){
    var urls = [
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=820dbfe0d4fb021e42d9',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=3daa93daec650badad10',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=55a496385e87d5ad301e',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=7c409b8e8f940997b878'
    ];
    var i = 0;
    setInterval(function(){
        i++;
        if(i>4){
            i=0;
        }
        $("#menuFrame").attr("src",urls[i]);
        console.log(urls[i]);
    },15000);
});