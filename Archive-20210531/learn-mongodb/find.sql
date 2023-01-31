db.inventory.find({})
db.inventory.find({status:"D"})
db.inventory.find({"size.uom":"in"})
db.inventory.find({tags:"red"})
db.inventory.find({tags:["red","blank"]})

db.user.find(
    {age: {$gt: 18}},
    {name:1,address:1}
).limit(5)
