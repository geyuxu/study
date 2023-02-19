#![feature(decl_macro)]

use rocket_contrib::json::Json;
use crate::models::user::{User, ID};
use crate::db::USER_DB;
use rocket::{post,get,put};



#[post("/user", format = "json", data = "<user>")]
pub fn create_user(user: Json<User>) -> Json<User> {
    let new_user = User::new(user.name.clone(), user.email.clone());
    USER_DB.lock().unwrap().insert(new_user.id.clone(), new_user.clone());
    Json(user.into_inner())
}

#[get("/user/<id>")]
pub fn get_user(id: ID) -> Option<Json<User>> {
    unsafe { USER_DB.get(&id).cloned() }
        .map(|user| Json(user))
}

#[put("/user/<id>", format = "json", data = "<user>")]
pub fn update_user(id: ID, user: Json<User>) -> Option<Json<User>> {
    USER_DB.lock().unwrap().get_mut(&id)
        .map(|existing_user| {
            existing_user.name = user.name.clone();
            existing_user.email = user.email.clone();
            Json(existing_user.clone())
        })
}
