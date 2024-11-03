from django.shortcuts import render
from .models import Items


def index(request):
    dict_items = {
        'items': Items.objects.all()
    }
    return render(request, 'index.html', dict_items)
