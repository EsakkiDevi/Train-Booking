function openTab(tabName){
    $('.tabcontent').hide();
    $('#'+tabName).show();
}

// default open
openTab('home');

// Fetch Trains from JSON
function fetchTrains(){
    var from = $('#from').val();
    var to = $('#to').val();
    if(from === "" || to === "") return;

    $.getJSON('LiveUpdateServlet', {from: from, to: to}, function(trains){
        var tbody = $('#trainTable tbody');
        tbody.empty();
        if(trains.length === 0){
            tbody.append('<tr><td colspan="11">No trains found</td></tr>');
            return;
        }
        $.each(trains, function(i, t){
            tbody.append('<tr>'+
                '<td>'+t.trainNo+'</td>'+
                '<td>'+t.name+'</td>'+
                '<td>'+t.from+'</td>'+
                '<td>'+t.departureTime+'</td>'+
                '<td>'+t.to+'</td>'+
                '<td>'+t.arrivalTime+'</td>'+
                '<td>'+t.duration+'</td>'+
                '<td>'+t.seats1A+'</td>'+
                '<td>'+t.seats2A+'</td>'+
                '<td>'+t.seats3A+'</td>'+
                '<td>'+t.seatsSL+'</td>'+
            '</tr>');
        });
    });
}

// Spot train
function getSpotTrain(){
    var tno = $('#spotTrainNo').val();
    if(!tno) return;
    $.getJSON('LiveUpdateServlet', {trainNo: tno}, function(train){
        $('#spotResult').text(JSON.stringify(train));
    });
}

// PNR stub
function getPNR(){
    var pnr = $('#pnrNo').val();
    if(!pnr) return;
    $.getJSON('PNRServlet', {pnr: pnr}, function(res){
        $('#pnrResult').text(JSON.stringify(res));
    });
}
/**
 * 
 */