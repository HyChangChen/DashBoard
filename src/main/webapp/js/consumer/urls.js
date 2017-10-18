$(function(){
    var urls = [
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=75bc85557b1814f6c544',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=add123aa02c8c17ac97e',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=bf54954e4d77e3d097ba',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=69bd7e439f68a6ea5c2e',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=f9640693df8d5fc9ae3c',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=fcd88e3c934ec8d4bc50',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=bbda61a7d90b9c1f4cd8',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=569648791d37c305405d',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=c3dae046971099971c231',
        'http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=d8038905479c2a0c8656'
    ];
    var i = 0;
    setInterval(function(){
        i++;
        if(i>10){
            i=0;
        }
        $("#menuFrame").attr("src",urls[i]);
    },10000);
});