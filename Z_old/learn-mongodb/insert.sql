db.inventory.insertMany([
    { item:"aa",qty:22,status:"A",
     size:{h:14,w:22}}
])

db.users.insertOne(
        {
            name: "sue",
            age: 22,
            status: "pending"
        }
)
