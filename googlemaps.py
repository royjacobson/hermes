import requests
import json


key = "AIzaSyB1HhD7LxPnulvfF6gcDujDlPYKJUbl6JM"
url = "https://maps.googleapis.com/maps/api/directions/json?"


def get_trip(origin, dest, arrival, depart):
    response = requests.get(url +
                            "origin=" + origin +
                            "&destination" + dest +
                            "&arrival_time" + arrival +
                            "&key=" + key).json()



