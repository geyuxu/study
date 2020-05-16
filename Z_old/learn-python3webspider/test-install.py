import lxml

from bs4 import BeautifulSoup
soup = BeautifulSoup('<p>bs4 is installed</p>','lxml')
print(soup.p.string)

import pyquery

import tesserocr
from PIL import Image
image = Image.open('image.png')
print(tesserocr.image_to_text(image))

print(tesserocr.file_to_text('image.png'))

import pymysql
print("pymysql:"+pymysql.VERSION.__str__())

import pymongo
print("pymongo:"+pymongo.version.__str__())

import redis
print("redis:"+redis.VERSION.__str__())

