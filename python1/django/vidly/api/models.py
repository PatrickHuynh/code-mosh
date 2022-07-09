from django.db import models
from tastypie.resources import ModelResource
from movies.models import Movie


class MovieResource(ModelResource):
    class Meta:  # tastypie looks for this inner class
        queryset = Movie.objects.all()  # tastypie query
        resource_name = 'movies'        # endpoint name i.e. api/movies/
        excludes = ['date_created']
