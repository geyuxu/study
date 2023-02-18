use elasticsearch::{Elasticsearch, BulkOperation, BulkParts,auth::Credentials,
                    http::transport::{TransportBuilder,SingleNodeConnectionPool}};

use serde::{Serialize, Deserialize};
use serde_json::{json, Value};

#[derive(Debug, Serialize, Deserialize)]
struct Document {
    name: String,
    age: u32,
}

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    //let client = Elasticsearch::default();

    let http_auth = Credentials::Basic("ordersearch".to_owned(), "order123".to_owned());

    let transport = TransportBuilder::new(SingleNodeConnectionPool::new("http://sites01.st.iblidc.com:9200".parse().unwrap()))
        .auth(http_auth)
        .build()?;

    let client = Elasticsearch::new(transport);

    let mut documents: Vec<BulkOperation<Value>> = Vec::with_capacity(4);

    documents.push(BulkOperation::index(json!({
        "name": "Alice",
        "age": 25
        }))
        .id("1").into());

    documents.push(BulkOperation::index(json!({
        "name": "Bob",
        "age": 30
        }))
        .id("2").into());


    let response = client
        .bulk(BulkParts::Index("order-search-shopsearch"))
        .body(documents)
        .send()
        .await?;

    println!("{:?}", response);

    Ok(())
}