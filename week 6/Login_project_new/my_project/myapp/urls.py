from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='home'),
    path('login_user/', views.login_user, name='login'),
    path('signup_user/', views.signup_user, name='signup'),
    path('admin_setup/', views.admin_setup, name='admin_setup'),
    path('delete/<pk>', views.delete, name='delete'),
    path('add_user/', views.add_user, name='add_user'),
    path('edit_user/<pk>', views.edit_user, name='edit'),
    path('logout_user', views.logout_user, name='logout'),
]