
use serde::{Serialize, Deserialize};

pub type ID = usize;

#[derive(Debug, Serialize, Deserialize, Clone)]
pub struct User {
    pub id: ID,
    name: String,
    email: String,
}
