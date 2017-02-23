from selenium import webdriver
from bs4 import BeautifulSoup
import csv

import time
driverpath = '/Users/mariabocanegra/Desktop/chromedriver'
#Install chrome driver and change above path to location on your computer

browser = webdriver.Chrome(executable_path = driverpath)
url = "https://www.buybuybaby.com/store/giftregistry/view_registry_guest.jsp?pwsToken=&eventType=Baby&inventoryCallEnabled=true&registryId=543299378&pwsurl=="
browser.get(url)
time.sleep(5)
html = browser.page_source

soup = BeautifulSoup(html, "lxml")

prices = soup.findAll(class_="itemPrice")
requested = soup.findAll(class_="requested")
# print requested
quantity = []
for q in requested:
    qs = str(q)
    quant = int(qs.split('/span>')[1].split('<')[0])
    # print quant
    quantity.append(quant)

sm = 0
i = 0
item = []
for price in prices:
    prs = str(price)
    pr = float(prs.split('value=\"')[1].split('\"')[0])
    # print pr
    #appends price, quantity, and item quantity value to item list
    item.append([pr, quantity[i], pr*quantity[i]])
    i += 1
#
print item

with open('registry.csv', 'w') as csvfile:
    writer = csv.writer(csvfile, delimiter=',')
    for i in item:
        writer.writerow(i)


# print prices

#For total registry requested value, open CSV file and add last column.
#future revisions: use zip() to sum columns