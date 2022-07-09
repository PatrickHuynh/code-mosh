from django.http import HttpResponse, Http404
from django.shortcuts import render, get_object_or_404
from .models import Movie


def index(request):  # django routes reqeusts through the parameters
    movies = Movie.objects.all()  # SELECT * From Movies
    return render(request, 'index.html', {'movies': movies})


def detail(request, movie_id):
    movie = get_object_or_404(Movie, pk=movie_id)
    return render(request, 'detail.html', {'movie': movie})
