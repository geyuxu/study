var data = require("./dataFromFile.js");
var createStatementData = require("./createStatementData.js");
var statement = require("./statement.js");

console.log(statement.renderPlainText(createStatementData(data.invoice,data.plays)));
// console.log(statement.renderHtml(createStatementData(data.invoice,data.plays)));
