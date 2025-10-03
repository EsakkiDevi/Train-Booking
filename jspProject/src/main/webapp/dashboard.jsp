<%@ page import="java.util.List" %>
<%@ page import="model.Station" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if(username == null){
        response.sendRedirect("login.jsp");
        return;
    }

    List<Station> stations = (List<Station>) request.getAttribute("stations");
%>

<html>
<head>
    <title>Train Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>Hello, <%= username %>! Search Trains</h2>

<!-- From station input + dropdown -->
<input list="fromList" id="fromStation" placeholder="From" oninput="fetchTrains()"/>
<datalist id="fromList">
<% if(stations != null){
       for(Station s : stations){ %>
    <option value="<%= s.getName() %> - <%= s.getCity() %>"></option>
<% } } %>
</datalist>

<!-- To station input + dropdown -->
<input list="toList" id="toStation" placeholder="To" oninput="fetchTrains()"/>
<datalist id="toList">
<% if(stations != null){
       for(Station s : stations){ %>
    <option value="<%= s.getName() %> - <%= s.getCity() %>"></option>
<% } } %>
</datalist>

<!-- Date picker -->
<input type="date" id="travelDate" onchange="fetchTrains()" min="<%= java.time.LocalDate.now() %>"/>

<hr>

<!-- Train table -->
<table id="trainTable" border="1">
    <thead>
        <tr>
            <th>Train No</th>
            <th>Name</th>
            <th>Departure</th>
            <th>Arrival</th>
            <th>Duration</th>
            <th>Seats</th>
            <th>Book</th>
        </tr>
    </thead>
</table>

<script>
function fetchTrains(){
    var from = $('#fromStation').val();
    var to = $('#toStation').val();
    var date = $('#travelDate').val();

    if(from === "" || to === "" || date === "") {
        $('#trainTable tbody').remove();
        return;
    }

    // Convert date to dd-MM-yyyy for API
    var parts = date.split('-');
    var apiDate = parts[2] + '-' + parts[1] + '-' + parts[0];

    $.ajax({
        url: 'LiveUpdateServlet',
        type: 'GET',
        data: { from: from, to: to, date: apiDate },
        dataType: 'json',
        success: function(trains){
            $('#trainTable tbody').remove();
            var tbody = $('<tbody></tbody>');

            if(!trains || trains.length === 0){
                tbody.append('<tr><td colspan="7">No trains found.</td></tr>');
            } else {
                $.each(trains, function(i, t){
                    tbody.append(
                        '<tr>'+
                            '<td>'+t.trainNo+'</td>'+
                            '<td>'+t.name+'</td>'+
                            '<td>'+t.departureTime+'</td>'+
                            '<td>'+t.arrivalTime+'</td>'+
                            '<td>'+t.duration+'</td>'+
                            '<td>'+t.seatsAvailable+'</td>'+
                            '<td>'+
                                '<input type="number" id="seats_'+t.trainNo+'" value="1" min="1" max="'+t.seatsAvailable+'">'+
                                '<button onclick="bookTrain(\''+t.trainNo+'\')">Book</button>'+
                            '</td>'+
                        '</tr>'
                    );
                });
            }

            $('#trainTable').append(tbody);
        },
        error: function(err){
            console.error('Error fetching trains:', err);
            $('#trainTable tbody').remove();
            $('#trainTable').append('<tbody><tr><td colspan="7">Error fetching data</td></tr></tbody>');
        }
    });
}

function bookTrain(trainNo){
    var seats = $('#seats_' + trainNo).val();
    var date = $('#travelDate').val();
    if(!seats || seats < 1){
        alert('Enter valid number of seats');
        return;
    }

    $.post('BookTrain', { trainNo: trainNo, seats: seats, date: date }, function(response){
        alert(response);
        fetchTrains();
    });
}
</script>
</body>
</html>
