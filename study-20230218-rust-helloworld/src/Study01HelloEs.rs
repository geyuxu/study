use std::error::Error;
use elasticsearch::{Elasticsearch, BulkOperation, BulkParts, auth::Credentials, http::transport::{TransportBuilder, SingleNodeConnectionPool}, SearchParts};

use serde::{Serialize, Deserialize};
use serde_json::{json, Value};



pub async fn getData() -> Result<(), Box<dyn std::error::Error>> {
    let search_keywords = "乌龙茶";
    let http_auth = Credentials::Basic("geyuxu".to_owned(), "geyuxu".to_owned());
    let transport = TransportBuilder::new(SingleNodeConnectionPool::new("http://localhost:9200".parse().unwrap()))
        .auth(http_auth)
        .build()?;
    let client = Elasticsearch::new(transport);
    let query = json!({
        "query": {
            "bool": {
                "should": [
                    {
                        "match": {
                            "goodsKeyword": search_keywords
                        }
                    },
                    {
                        "match": {
                            "storeKeyword": search_keywords
                        }
                    }
                ]
            }
        }
    });

    let response = client.search(SearchParts::Index(&["my-shop-search"]))
        .body(query)
        .send()
        .await?;

    println!("{:?}", response);

    Ok(())

}

pub async fn initData() -> Result<(), Box<dyn Error>> {
//let client = Elasticsearch::default();

    //let http_auth = Credentials::Basic("ordersearch".to_owned(), "order123".to_owned());

    let transport = TransportBuilder::new(SingleNodeConnectionPool::new("http://localhost:9200".parse().unwrap()))
        // .auth(http_auth)
        .build()?;

    let client = Elasticsearch::new(transport);

    let mut documents: Vec<BulkOperation<Value>> = Vec::with_capacity(4);

    documents.push(BulkOperation::index(json!({
        "goodsCode": "3243091",
        "goodsKeyword": "乌龙茶 中茶 糖 茶 片 糖果 龙 出 机 压 3",
        "hasStock": true,
        "marketOn": true,
        "join_field": {
            "name": "goods",
            "parent": "shop_dj_800001_3110800001001"
        }
    }))
        .id("goods_3243091@shop_dj_800001_3110800001001")
        .routing("shop_dj_800001_3110800001001")
        .into()
    );

    documents.push(BulkOperation::index(json!({
            "shopStoreCode": "800001_3110800001001",
            "shopType":"dj",
            "storeKeyword": "逸 刻 江 桥 万 达 店",
            "location": {
                "type": "multipolygon",
                "coordinates": [
                    [
                        [
                            [
                                121.269995,
                                31.340241
                            ],
                            [
                                121.26433,
                                31.333607
                            ],
                            [
                                121.265446,
                                31.321693
                            ],
                            [
                                121.279608,
                                31.319273
                            ],
                            [
                                121.287461,
                                31.330748
                            ],
                            [
                                121.284586,
                                31.335146
                            ],
                            [
                                121.277591,
                                31.339802
                            ],
                            [
                                121.269995,
                                31.340241
                            ]
                        ]
                    ],
                    [
                        [
                            [
                                121.474341,
                                31.238846
                            ],
                            [
                                121.478289,
                                31.239507
                            ],
                            [
                                121.486014,
                                31.242516
                            ],
                            [
                                121.506356,
                                31.233195
                            ],
                            [
                                121.512536,
                                31.224094
                            ],
                            [
                                121.521462,
                                31.208166
                            ],
                            [
                                121.4864,
                                31.210735
                            ],
                            [
                                121.466187,
                                31.208239
                            ],
                            [
                                121.459321,
                                31.216828
                            ],
                            [
                                121.474341,
                                31.238846
                            ]
                        ]
                    ]
                ]
            },
            "join_field": "shop"
        }
    ))
        .id("shop_dj_800001_3110800001001").into());


    let response = client
        .bulk(BulkParts::Index("my-shop-search"))
        .body(documents)
        .send()
        .await?;

    println!("{:?}", response);

    Ok(())
}