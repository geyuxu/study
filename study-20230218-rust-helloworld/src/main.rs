#![feature(decl_macro)]

mod api;
mod db;
mod models;

use rocket::{ignite, routes};

fn main() {
    ignite()
        .mount("/", routes![
            api::create_user,
            api::get_user,
            api::update_user
        ])
        .launch();
}