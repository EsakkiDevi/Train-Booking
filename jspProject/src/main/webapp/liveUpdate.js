function fetchTrains() {
    var from = $('#fromStation').val();
    var to = $('#toStation').val();
    var date = $('#travelDate').val();

    if(from === "" || to === "" || date === "") {
        $('#trainTable tbody').remove();
        return;
    }

    $.ajax({
        url: 'LiveUpdateServlet',
        type: 'GET',
        data: { from: from, to: to, date: date },
        dataType: 'json',
        success: function(trains) {
            $('#trainTable tbody').remove();
            if(trains.length === 0){
                $('#trainTable').append('<tbody><tr><td colspan="6">No trains found for selected route/date.</td></tr></tbody>');
                return;
            }
            var tbody = '<tbody>';
            $.each(trains, function(index, train){
                tbody += '<tr>' +
                    '<td>' + train.trainNo + '</td>' +
                    '<td>' + train.name + '</td>' +
                    '<td>' + train.departureTime + '</td>' +
                    '<td>' + train.arrivalTime + '</td>' +
                    '<td>' + train.duration + '</td>' +
                    '<td>' + train.seatsAvailable + '</td>' +
                '</tr>';
            });
            tbody += '</tbody>';
            $('#trainTable').append(tbody);
        },
        error: function(err){
            console.error('Error fetching trains:', err);
            $('#trainTable tbody').remove();
            $('#trainTable').append('<tbody><tr><td colspan="6">Error fetching train data.</td></tr></tbody>');
        }
    });
}
