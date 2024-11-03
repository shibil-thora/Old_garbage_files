from django.shortcuts import render
from django.http import HttpResponse
from .models import *
from .forms import *
from django.contrib.auth.decorators import login_required
from django.views.decorators.cache import never_cache


@login_required
@never_cache
def index(request):
    return render(request, 'index.html')

@login_required
@never_cache
def about(request):
    return render(request, 'about.html')

@login_required
@never_cache
def doctors(request):
    dict_doc = {
        'docs': Doctors.objects.all()
    }
    return render(request, 'doctors.html' , dict_doc)

@login_required
@never_cache
def booking(request):
    if request.method == "POST":
        form = BookingForm(request.POST)
        if form.is_valid():
            form.save()
            return render(request, 'confirmation.html')

    form = BookingForm()
    dict_form = {
        'form': form
    }
    return render(request, 'booking.html', dict_form)

@login_required
@never_cache
def contact(request):
    return render(request, 'contact.html')

@login_required
@never_cache
def department(request):
    dict_dep = {
        'dept': Departments.objects.all()
    }
    return render(request, 'department.html', dict_dep)








