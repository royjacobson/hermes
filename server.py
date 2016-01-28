import eventbrite
import socketserver
import json


PORT = 425
##Date format: DD

class Location:
    def __init__(self, name, coords):
        self.name = name
        self.coordinates = coords

class Query:
    def __init__(self, keywords, location, budget, dates, email, number, category):
        pass

class Event:
    def __init__(self, info, location, dates, price, url):
        self.info_text = info
        self.location = location
        self.dates = dates
        self.price = price
        self.url = url

class Trip:
    def __init__(self, dates, price, route, url):
        """
        route = (src, dest) which are both Location() instances
        price in $
        """
        self.dates = dates
        self.price = price
        self.route = route
        self.url = url


def get_events(query):
    EB_events = eventbrite.query(query)

    return EB_events


def get_trips(origin, target, date):
    pass


def get_offers(query):
    pass


class MyTCPHandler(socketserver.StreamRequestHandler):

    def handle(self):
        # self.rfile is a file-like object created by the handler;
        # we can now use e.g. readline() instead of raw recv() calls
        query = b''.join(self.rfile.readlines())
        json_query = json.load(query)
        print("{} wrote:".format(self.client_address[0]))
        from pprint import pprint
        pprint(json_query)
        # Likewise, self.wfile is a file-like object used to write back
        # to the client

if __name__ == "__main__":
    HOST, PORT = "", 4356
    server = socketserver.TCPServer((HOST, PORT), MyTCPHandler)
    server.serve_forever()