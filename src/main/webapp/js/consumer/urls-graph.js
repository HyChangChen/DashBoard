$(function(){
    var urls = [
        'http://backbone.telkom.co.id/graph.php?action=view&rra_id=all&local_graph_id=85053',
        'http://backbone.telkom.co.id/graph.php?action=view&rra_id=all&local_graph_id=85054',
        'http://backbone.telkom.co.id/graph.php?action=view&rra_id=all&local_graph_id=85020',
        'http://backbone.telkom.co.id/graph.php?action=view&rra_id=all&local_graph_id=84999',
        'http://backbone.telkom.co.id/graph.php?action=view&rra_id=all&local_graph_id=85022',
        'http://backbone.telkom.co.id/graph.php?action=view&rra_id=all&local_graph_id=84997',
        'http://backbone.telkom.co.id/graph.php?action=view&rra_id=all&local_graph_id=85083'
    ];
    var i = 0;
    setInterval(function(){
        i++;
        if(i>7){
            i=0;
        }
        $("#menuFrame").attr("src",urls[i]);
    },10000);
});