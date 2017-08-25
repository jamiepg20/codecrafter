// $(document).ready(function () {
//
//     $("#container").ready(function (event) {
//         console.log("Container Ready : $(document)")
//         populateChart();
//     });
//

// });

// DO GET
function ajaxGet(series0, series1, series2, series3, series4) {
    // var url = window.location;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/tickers",
        success: function (data) {
            var luno = data[0];
            var bitstamp = data[1]
            var kraken = data[2];
            var cexio = data[3];
            var coinbase = data[4];

            series0.addPoint([luno['timestamp'], luno['price']], true, true);
            series1.addPoint([bitstamp['timestamp'], bitstamp['price']], true, true);
            series2.addPoint([kraken['timestamp'], kraken['price']], true, true);
            series3.addPoint([cexio['timestamp'], cexio['price']], true, true);
            series4.addPoint([coinbase['timestamp'], coinbase['price']], true, true);

        },
        error: function (e) {
            console.log("ERROR: ", e.responseText);
        }
    });
}

