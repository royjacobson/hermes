import requests

url = "https://www.eventbriteapi.com/v3/"
token = "E6FCHL3GOIZSDPV5JQ4G"
categories = {'Auto, Boat & Air': '118',
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
              'Travel & Outdoor': '109'}


def query(query):
    response = requests.get(
        url + "categories/",
        headers={
            "Authorization": "Bearer " + token,
            #"q": "music"
        },
        verify=True  # SSL
    )
    return response.json()
