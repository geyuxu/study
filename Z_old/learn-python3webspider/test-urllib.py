from urllib import request, parse

# response = urllib.request.urlopen('https://www.python.org', data=data)
# print(response.read().decode('utf-8'))
# print(type(response))

# print(response.status)
# print(response.getheaders())
# print(response.getheader('Content-Type'))

url = 'http://httpbin.org/post'
headers = {
    'User-Agent': 'Mozilla/4.0 (compatible;MSIE 5.5;Windows NT)',
    'Host': 'httpbin.org'
}
dict = {
    'name': 'Germey'
}
data = bytes(parse.urlencode(dict), encoding='utf8')
req = request.Request(url=url, data=data, headers=headers, method='POST')
response = request.urlopen(req)
print(response.read().decode('utf-8'))
