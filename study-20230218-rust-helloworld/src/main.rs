//mod Study01HelloEs;
// mod study02_lexical_scope;
// mod study03_if_let;
// mod study04_while_let;
#![feature(decl_macro)]

#[macro_use]
extern crate rocket;

use rocket::{Request, response::status::NotFound};
use serde::{Serialize, Deserialize};
use std::collections::HashMap;
use rocket_contrib::json::{Json, JsonValue};
use once_cell::sync::Lazy;
use rocket_contrib::json;

type ID = usize;

#[derive(Debug, Serialize, Deserialize, Clone)]
struct User {
    id: ID,
    name: String,
    email: String,
}

// This is a temporary database for testing purposes
// In production, you'd want to use a proper database
static mut USER_DB: Lazy<HashMap<ID, User>> = Lazy::new(||
    HashMap::new()
);

#[post("/user", format = "json", data = "<user>")]
fn create_user(user: Json<User>) -> JsonValue {
    let mut user = user.into_inner();
    let id = unsafe { USER_DB.len() };
    user.id = id;
    unsafe { USER_DB.insert(id, user.clone()); }
    json!({
        "status": "ok",
        "user": user
    })
}

#[get("/user/<id>")]
fn get_user(id: ID) -> Option<Json<User>> {
    let user = unsafe { USER_DB.get(&id).cloned() };
    user.map(|user| Json(user))
}

#[put("/user/<id>", format = "json", data = "<user>")]
fn update_user(id: ID, user: Json<User>) -> JsonValue {
    let mut user = user.into_inner();
    user.id = id;
    unsafe { USER_DB.insert(id, user.clone()); }
    json!({
        "status": "ok",
        "user": user
    })
}

// Handle requests for unknown routes
#[catch(404)]
fn not_found(req: &Request) -> NotFound<String> {
    NotFound(format!("I couldn't find '{}'. Try something else?", req.uri()))
}

fn main() {
   // Study01HelloEs::initData().await
   // study02_lexical_scope::test();
    //study03_if_let::test();
    // study04_while_let::test();
    // study04_while_let::test2();

    rocket::ignite()
        .mount("/", routes![create_user, get_user, update_user])
        .register(catchers![not_found])
        .launch();
}
