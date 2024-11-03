from django.contrib import admin
from .models import Items


class MyItems(admin.ModelAdmin):
    list_display = ['item']


admin.site.register(Items, MyItems)



