from django.db import models

class BlogPage(models.Model):
    title = models.CharField(max_length = 200)
    content = models.TextField()
    create_date = models.DateTimeField()
    tags = models.CharField()

    def __str__(self):
        return self.title

class Nav(models.Model):
    content = models.CharField()
    img = models.CharField()
    url = models.CharField()

    


    

