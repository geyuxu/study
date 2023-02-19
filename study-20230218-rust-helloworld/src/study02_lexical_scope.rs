pub fn test() {
    let v = "Hello world";
    assert_eq!(v,"Hello world");
    let v = "Hello rust";
    assert_eq!(v,"Hello rust");
    {
        let v = "Hello world";
        assert_eq!(v,"Hello world");
    }
    let v = "Hello rust";
    assert_eq!(v,"Hello rust");
}