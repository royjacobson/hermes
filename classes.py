class Location:
    def __init__(self, name, coords):
        self.name = name
        self.coordinates = coords


class Query:
    def __init__(self, **kwargs):
        self.__dict__.update(kwargs)

    def from_json(self, json):
        new = Query(**json)
        return new

    def __json__(self):
        return self.__dict__


class Event:
    def __init__(self, info, location, dates, price, url):
        self.info_text = info
        self.location = location
        self.dates = dates
        self.price = price
        self.url = url

    def __json__(self):
        return self.__dict__


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

    def __json__(self):
        return self.__dict__
