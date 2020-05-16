var fs = require("fs");
exports.plays = JSON.parse(fs.readFileSync("plays.json"));
exports.invoice = JSON.parse(fs.readFileSync("invoices.json"))[0];

