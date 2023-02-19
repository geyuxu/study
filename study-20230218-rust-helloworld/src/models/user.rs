use serde::{Deserialize, Serialize};
use std::collections::HashMap;
use std::sync::{Arc, Mutex};

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct User {
    pub id: ID,
    pub name: String,
    pub email: String,
}

impl User {
    pub fn new(name: String, email: String) -> Self {
        let id = ID::generate();
        User { id, name, email }
    }
}

#[derive(Debug, Clone, Hash, PartialEq, Eq)]
pub struct ID(String);

impl ID {
    fn generate() -> Self {
        use rand::distributions::Alphanumeric;
        use rand::{thread_rng, Rng};

        let id: String = thread_rng()
            .sample_iter(&Alphanumeric)
            .take(12)
            .map(char::from)
            .collect();
        ID(id)
    }
}
//
// pub type UserDB = Arc<Mutex<HashMap<ID, User>>>;

// lazy_static! {
//     pub static ref USER_DB: UserDB = Arc::new(Mutex::new(HashMap::new()));
// }
