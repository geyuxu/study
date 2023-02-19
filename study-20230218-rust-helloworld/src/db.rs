use std::collections::HashMap;
use once_cell::sync::Lazy;
use crate::domain::user::{User,ID};

pub static mut USER_DB: Lazy<HashMap<ID, User>> = Lazy::new(||
    HashMap::new()
);
