db.users.updateMany(
        { age: { $lt: 18}},
        { $set: { status: "reject"}}
)
