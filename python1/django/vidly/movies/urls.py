from django.urls import path
from . import views  # cannot use "import views" - must use relative imports

app_name = 'movies'

urlpatterns = [
    path("", views.index, name="index"),
    path('<int:movie_id>', views.detail, name='detail')
]
