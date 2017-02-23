import json
import requests
import time as tm
from twython import Twython

#imports data from auth.py -- not included in repository for security reasons
from auth import (
    consumer_key,
    consumer_secret,
    access_token,
    access_token_secret
)

twitter = Twython(
    consumer_key,
    consumer_secret,
    access_token,
    access_token_secret
)

url = 'https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson'

firstRun = True
latestTime=1487734021175

#function to tweet if there is a new item in newQuakes -- retrieves dict of quakes
def tweetNewQuakes(newQuakes):
	for quake in newQuakes[::-1]:
		prop = quake['properties']
		mag = prop['mag']
		time = prop['time']
		place = prop['place']
		geom = quake['geometry']
		coord = geom['coordinates']
		message = "There was a " + str(mag) + " magnitude earthquake " + place + " #earthquake #CAEarthquake"	
		if place[-2:] == 'CA' or place[-10:] == 'California':
			twitter.update_status(status=message)
			print 'TWEETED:'
		print("%s" % message )



while True:

	page = requests.get(url)
	txt = page.content
	newQuakes = []
	quakedat = json.loads(txt)
	times = []
	for feature in quakedat['features']:
		properties = feature['properties']
		time = properties['time']
		times.append(time)

		if time > latestTime and not firstRun:
			newQuakes.append(feature)
		else:
			break

	latestTime = times[0] 
	print(times[0])

	firstRun=False
	
	tweetNewQuakes(newQuakes)

	tm.sleep(300)




# print quakedat[features]

