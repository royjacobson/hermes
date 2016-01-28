import eventbrite

class Location:
    def __init__(self, name, coords):
        self.name = name
        self.coordinates = coords

class Query:
    def __init__(self, keywords, location, budget, dates, email, number, category):
        pass

class Event:
    def __init__(self, info, location, dates, url):
        self.info_text = info
        self.location = location
        self.dates = dates
        self.url = url


def get_events(query):
    EB_events = eventbrite.query(query)

    return EB_events


def get_trips(origin, target, date):
    pass


def get_offers(query):

while True:
    pass
