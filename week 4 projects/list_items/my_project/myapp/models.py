from django.db import models



class Items(models.Model):
    item = models.CharField(max_length=30)


