use crate::models::user::{User, ID};
// use lazy_static::lazy_static;
use std::collections::HashMap;
use std::sync::{Arc, Mutex};


pub type Users = Mutex<Vec<User>>;

pub const USER_DB: Users = Users::new(Mutex::new(vec![]));

// lazy_static! {
//     pub static ref USER_DB: UserDB = Arc::new(Mutex::new(HashMap::new()));
// }

pub fn create_user(user: User) -> User {
    USER_DB.lock().unwrap().insert(user.id.clone(), user.clone());
    user
}

pub fn get_user(id: ID) -> Option<User> {
    unsafe { USER_DB.get(&id).cloned() }
}

pub fn update_user(id: ID, user: User) -> Option<User> {
    USER_DB.lock().unwrap().get_mut(&id)
        .map(|existing_user| {
            existing_user.name = user.name.clone();
            existing_user.email = user.email.clone();
            existing_user.clone()
        })
}
