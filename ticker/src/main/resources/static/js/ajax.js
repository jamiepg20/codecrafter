// $(document).ready(function () {
//
//     $("#container").ready(function (event) {
//         console.log("Container Ready : $(document)")
//         populateChart();
//     });
//

// });

// DO GET
function ajaxGet(series0, series1) {
    // var url = window.location;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/tickers",
        success: function (data) {
            var luno = data[0];
            var bitstamp = data[1];

            series0.addPoint([luno['timestamp'], luno['price']], true, true);
            series1.addPoint([bitstamp['timestamp'], bitstamp['price']], true, true);
        },
        error: function (e) {
            console.log("ERROR: ", e.responseText);
        }
    });
}

