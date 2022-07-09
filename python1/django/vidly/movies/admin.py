from django.contrib import admin
from .models import Genre, Movie


class GenreAdmin(admin.ModelAdmin):  # inherit from admin.ModelAdmin
    list_display = ("id", "name")    # display "id" and "name" in UI


class MovieAdmin(admin.ModelAdmin):
    # don't show "date created" since this is auto
    exclude = ("date_created",)
    list_display = ("title", "number_in_stock", "daily_rate")  # display fields


admin.site.register(Genre, GenreAdmin)  # register model and display classes
admin.site.register(Movie, MovieAdmin)
