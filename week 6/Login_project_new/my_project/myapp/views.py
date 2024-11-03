from django.shortcuts import render, redirect
from django.http import HttpResponse
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.decorators import login_required
from django.views.decorators.cache import never_cache,cache_control
from django.contrib import messages
from django.contrib.auth.models import User


@never_cache
def index(request):
    if request.user.is_authenticated:
        if request.user.is_superuser:
            return render(request, 'index.html')
        return render(request, 'index_user.html')
    return redirect('login')


@never_cache
def login_user(request):
    if not request.user.is_authenticated:
        if request.method == 'POST':
            username = request.POST['username']
            password = request.POST['password']
            user = authenticate(username=username, password=password)
            if user is not None:
                login(request, user)
                print('login happened')
                return redirect('home')
            else:
                messages.success(request, 'please re-check your credentials')
                return redirect('login')
        
        return render(request, 'login.html')
    return redirect('home')


@never_cache
def signup_user(request):
    if not request.user.is_authenticated:
        if request.method == 'POST':
            username = request.POST['username']
            email = request.POST['email']
            password1 = request.POST['password1']
            password2 = request.POST['password2']

            if User.objects.filter(username = username).first():
                messages.error(request, "")
            
            elif password1 == password2:
                new_user = User.objects.create_user(username=username, email=email, password=password1)
                new_user.save()
                return redirect('login')
            
            messages.success(request, 'invalid username or password !')

        return render(request, 'signup.html')
    return redirect('home')


@never_cache
def logout_user(request):
    if request.user.is_authenticated:
        logout(request)
        return redirect('login')
    return redirect('login')


@never_cache
def admin_setup(request):
    if request.user.is_authenticated:
        if request.user.is_superuser:
            if request.method == 'GET':
                try:
                    search_key = request.GET['search_key']
                    if not search_key == '':
                        return render(request, 'admin_setup.html', {'users': User.objects.filter(username__icontains=search_key)})
                    else:
                        return render(request, 'admin_setup.html', {'users': User.objects.all()})
                    
                except:
                    return render(request, 'admin_setup.html', {'users': User.objects.all()})
                
            return render(request, 'admin_setup.html', {'users': User.objects.all()})
        return redirect('login')
    return redirect('login')


@never_cache
def delete(request, pk):
    if request.user.is_authenticated:
        if request.user.is_superuser:
            try:
                instance = User.objects.get(pk=pk)
                instance.delete()
                return redirect('admin_setup')
            except:
                return redirect('login')
        return redirect('login')
    return redirect('login')


@never_cache
def add_user(request):
    if request.user.is_authenticated:
        if request.user.is_superuser:
            if request.method == 'POST':
                username = request.POST['username']
                email = request.POST['email']
                password1 = request.POST['password1']
                password2 = request.POST['password2']

                if User.objects.filter(username = username).first():
                    messages.error(request, "")
                    return redirect('admin_setup')
                
                elif password1 == password2:
                    new_user = User.objects.create_user(username=username, email=email, password=password1)
                    new_user.save()
                    return redirect('admin_setup')
                
                messages.success(request, 'invalid entry !')

            return render(request, 'add_user.html')
        return redirect('login')
    return redirect('login')


@never_cache
def edit_user(request, pk):
    if request.user.is_authenticated:
        if request.user.is_superuser:
            try:
                user = User.objects.get(pk=pk)
                if request.method == 'POST':
                    username = request.POST['username']
                    email = request.POST['email']
                    password1 = request.POST['password1']
                    password2 = request.POST['password2']

                    same_user_name = username == user.username
                    same_email = email == user.email

                    if not same_user_name:
                        user.username = username
                        user.save()
                    
                    if not same_email:
                        user.email = email
                        user.save()

                    return redirect('admin_setup')
            except:
                return redirect('login')
            return render(request, 'edit_user.html', {'user': user})   
        return redirect('login')
    return redirect('login')