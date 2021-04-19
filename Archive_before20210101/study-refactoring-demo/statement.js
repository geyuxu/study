exports.renderPlainText = function(data) {
    let result = `Statement for ${data.customer}\n`;
    for (let perf of data.performances) {
        result += `  ${perf.play.name}: ${usd(perf.amount)} (${perf.audience} seats)\n`;
    }
    result += `Amount owed is ${usd(data.totalAmount)}\n`;
    result += `You earned ${data.totalVolumeCredits} credits\n`;
    return result;
}

exports.renderHtml = function(data) {
    let result = `<h1>Statement for ${data.customer}</h1>\n`;
    result += "<table>\n";
    result += "<tr><th>play</th><th>seats</th><th>cost</th></tr>";
    for (let perf of data.performances) {
        result += `<tr><td>${perf.play.name}</td><td>${usd(perf.amount)}</td>`
        result += `<td>${perf.audience} </td></tr>\n`;
    }
    result += "</table>\n";
    result += `<p>Amount owed is ${usd(data.totalAmount)}<\p>\n`;
    result += `<p>You earned ${data.totalVolumeCredits} credits<\p>\n`;
    return result;
}

function usd(aNumber){
    return new Intl.NumberFormat("en-US",
                    { style:"currency",currency:"USD",
                     minimumFractionDigits:2}).format(aNumber / 100);
}
