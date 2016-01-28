import requests

url = "https://www.eventbriteapi.com/v3/"
token = "E6FCHL3GOIZSDPV5JQ4G"
"""{'Auto, Boat & Air': '118',            # name: id
'Business & Professional': '101',
'Charity & Causes': '111',
'Community & Culture': '113',
'Family & Education': '115',
'Fashion & Beauty': '106',
'Film, Media & Entertainment': '104',
'Food & Drink': '110',
'Government & Politics': '112',
'Health & Wellness': '107',
'Hobbies & Special Interest': '119',
'Home & Lifestyle': '117',
'Music': '103',
'Other': '199',
'Performing & Visual Arts': '105',
'Religion & Spirituality': '114',
'Science & Technology': '102',
'Seasonal & Holiday': '116',
'Sports & Fitness': '108',
'Travel & Outdoor': '109'}"""
categories = {"Music": '103',
              "Sports": '108,109',
              "Art": '105,106,113',
              "Film & Theatre": '104',
              "Festivals":'',
              "Dance":'',
              "Other":'199'}

def category_to_id(category):
    return categories[category]

def query(query):
    page = 1
    response = requests.get(
        url + "events/search/?page=%s" % page,
        headers={
            "Authorization": "Bearer " + token,
            #"q": query.keywords,
            #"start_date.range_end": query.dates[1],
            #"start_date.range_start": query.dates[0],
            #categories: query.category
        },
        verify=True  # SSL
    )
    return response.json()
