<table id="trainTable" border="1">
<thead>
<tr><th>Train</th><th>From</th><th>To</th><th>Date</th><th>Seats</th></tr>
</thead>
<tbody>
<c:forEach var="t" items="${trainList}">
<tr data-trainid="${t.trainId}">
    <td>${t.trainName}</td>
    <td>${t.source}</td>
    <td>${t.destination}</td>
    <td>${t.travelDate}</td>
    <td class="seats">${t.availableSeats}</td>
</tr>
</c:forEach>
</tbody>
</table>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function fetchTrains() {
    $.get("LiveUpdateServlet", {
        from: "${fromStation}", to: "${toStation}", date: "${travelDate}"
    }, function(data) {
        data.forEach(function(train) {
            var row = $("#trainTable tr[data-trainid='" + train.trainId + "']");
            row.find(".seats").text(train.availableSeats);
        });
    });
}
setInterval(fetchTrains, 5000);
</script>
