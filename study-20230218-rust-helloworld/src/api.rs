#![feature(decl_macro)]

use rocket::{Request, response::status::NotFound};

use std::collections::HashMap;
use rocket_contrib::json::{Json, JsonValue};
use once_cell::sync::Lazy;
use rocket_contrib::json;

use crate::domain::user::{User,ID};
use crate::db::USER_DB;


#[post("/user", format = "json", data = "<user>")]
pub fn create_user(user: Json<User>) -> JsonValue {
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
pub fn get_user(id: ID) -> Option<Json<User>> {
    let user = unsafe { USER_DB.get(&id).cloned() };
    user.map(|user| Json(user))
}

#[put("/user/<id>", format = "json", data = "<user>")]
pub fn update_user(id: ID, user: Json<User>) -> JsonValue {
    let mut user = user.into_inner();
    user.id = id;
    unsafe { USER_DB.insert(id, user.clone()); }
    json!({
        "status": "ok",
        "user": user
    })
}

#[get("/user/list")]
pub fn list_users() -> JsonValue {
    // 从数据库中获取所有用户
    let mut users;
    unsafe {
        users = USER_DB.clone();
    }

    // 将用户列表作为 JSON 返回
    json!({
        "status":"ok",
        "list":users
    })
}


// Handle requests for unknown routes
#[catch(404)]
pub fn not_found(req: &Request) -> NotFound<String> {
    NotFound(format!("I couldn't find '{}'. Try something else?", req.uri()))
}
