//mod Study01HelloEs;
// mod study02_lexical_scope;
// mod study03_if_let;
// mod study04_while_let;
#![feature(decl_macro)]

mod domain;
mod api;
mod db;

#[macro_use]
extern crate rocket;


use rocket::{Request, response::status::NotFound};

use std::collections::HashMap;
use rocket_contrib::json::{Json, JsonValue};
use once_cell::sync::Lazy;
use rocket_contrib::json;

use crate::domain::user::{User,ID};
use crate::api::static_rocket_route_info_for_create_user;
use crate::api::static_rocket_route_info_for_get_user;
use crate::api::static_rocket_route_info_for_update_user;
use crate::api::static_rocket_route_info_for_list_users;

use crate::api::static_rocket_catch_info_for_not_found;



fn main() {
   // Study01HelloEs::initData().await
   // study02_lexical_scope::test();
    //study03_if_let::test();
    // study04_while_let::test();
    // study04_while_let::test2();

    rocket::ignite()
        .mount("/", routes![create_user, get_user, update_user,list_users])
        .register(catchers![not_found])
        .launch();
}
